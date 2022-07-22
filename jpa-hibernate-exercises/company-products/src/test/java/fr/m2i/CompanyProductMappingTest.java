package fr.m2i;

import fr.m2i.dao.CompanyDao;
import fr.m2i.dao.CompanyDaoImpl;
import fr.m2i.model.Company;
import fr.m2i.model.Product;
import fr.m2i.util.EntityManagerUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.lang.reflect.Field;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

class CompanyProductMappingTest {
    private static EntityManagerUtil emUtil;
    private static EntityManagerFactory entityManagerFactory;
    private static CompanyDao companyDao;

    @BeforeAll
    static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExerciseUnit");
        emUtil = new EntityManagerUtil(entityManagerFactory);
        companyDao = new CompanyDaoImpl(entityManagerFactory);
    }

    @AfterAll
    static void destroy() {
        entityManagerFactory.close();
    }

    @Test
    void testSaveCompany() {
        Company company = createRandomCompany();
        emUtil.performWithinTx(entityManager -> entityManager.persist(company));

        assertThat(company.getId(), notNullValue());
    }

    private Company createRandomCompany() {
        Company company = new Company();
        company.setName(RandomStringUtils.randomAlphabetic(20));
        return company;
    }

    @Test
    void testSaveProduct() {
        Product product = createRandomProduct();

        emUtil.performWithinTx(entityManager -> entityManager.persist(product));
    }

    private Product createRandomProduct() {
        Product product = new Product();
        product.setName(RandomStringUtils.randomAlphabetic(20));
        return product;
    }

    @Test
    void testSaveCompanyWithNullName() {
        Company company = new Company();

        try {
            emUtil.performWithinTx(entityManager -> entityManager.persist(company));
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertThat(e.getClass(), equalTo(PersistenceException.class));
        }
    }

    @Test
    void testSaveProductWithNullName() {
        Product product = new Product();

        try {
            emUtil.performWithinTx(entityManager -> entityManager.persist(product));
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertThat(e.getClass(), equalTo(PersistenceException.class));
        }
    }

    @Test
    void testForeignKeyColumnIsSpecified() throws NoSuchFieldException {
        Field company = Product.class.getDeclaredField("company");
        JoinColumn joinColumn = company.getAnnotation(JoinColumn.class);

        assertThat(joinColumn.name(), equalTo("company_id"));
    }

    @Test
    void testSaveProductAndCompany() {
        Company company = createRandomCompany();
        Product product = createRandomProduct();

        emUtil.performWithinTx(entityManager -> entityManager.persist(company));
        emUtil.performWithinTx(entityManager -> {
            Company companyProxy = entityManager.getReference(Company.class, company.getId());
            product.setCompany(companyProxy);
            entityManager.persist(product);
        });

        emUtil.performWithinTx(entityManager -> {
            Company managedCompany = entityManager.find(Company.class, company.getId());
            Product managedProduct = entityManager.find(Product.class, product.getId());
            assertThat(managedCompany.getProducts(), hasItem(managedProduct));
            assertThat(managedProduct.getCompany(), equalTo(managedCompany));
        });
    }

    @Test
    void testAddNewProductToExistingCompany() {
        Company company = createRandomCompany();
        emUtil.performWithinTx(entityManager -> entityManager.persist(company));

        Product product = createRandomProduct();
        emUtil.performWithinTx(entityManager -> {
            entityManager.persist(product);
            Company managedCompany = entityManager.merge(company);
            managedCompany.addProduct(product);
            assertThat(managedCompany.getProducts(), hasItem(product));
        });

        assertThat(product.getCompany(), equalTo(company));
        emUtil.performWithinTx(entityManager -> {
            Company managedCompany = entityManager.find(Company.class, company.getId());
            assertThat(managedCompany.getProducts(), hasItem(product));

        });
    }

    @Test
    void testRemoveProductFromCompany() {
        Company company = createRandomCompany();
        emUtil.performWithinTx(entityManager -> entityManager.persist(company));

        Product product = createRandomProduct();
        emUtil.performWithinTx(entityManager -> {
            product.setCompany(company);
            entityManager.persist(product);
        });

        emUtil.performWithinTx(entityManager -> {
            Product managedProduct = entityManager.find(Product.class, product.getId());
            Company managedCompany = entityManager.find(Company.class, company.getId());
            managedCompany.removeProduct(managedProduct);
            assertThat(managedCompany.getProducts(), not(hasItem(managedProduct)));
        });

        emUtil.performWithinTx(entityManager -> {
            Company managedCompany = entityManager.find(Company.class, company.getId());
            assertThat(managedCompany.getProducts(), not(hasItem(product)));
        });
    }

    @Test
    void testCompanyToProductsIsLazy() {
        Company company = createRandomCompany();
        emUtil.performWithinTx(entityManager -> entityManager.persist(company));

        Product product = createRandomProduct();
        emUtil.performWithinTx(entityManager -> {
            product.setCompany(company);
            entityManager.persist(product);
        });

        Company loadedCompany = emUtil.performReturningWithinTx(entityManager -> entityManager.find(Company.class, company.getId()));
        try {
            List<Product> products = loadedCompany.getProducts();
            System.out.println(products);
            fail("should throw exception");
        } catch (Exception e) {
            assertThat(e.getClass(), equalTo(LazyInitializationException.class));
        }
    }

    @Test
    void testProductsToCompanyIsLazy() {
        Company company = createRandomCompany();
        emUtil.performWithinTx(entityManager -> entityManager.persist(company));

        Product product = createRandomProduct();
        emUtil.performWithinTx(entityManager -> {
            product.setCompany(company);
            entityManager.persist(product);
        });

        Product loadedProduct = emUtil.performReturningWithinTx(entityManager -> entityManager.find(Product.class, product.getId()));
        try {
            Company loadedCompany = loadedProduct.getCompany();
            System.out.println(loadedCompany);
            fail("should throw exception");
        } catch (Exception e) {
            assertThat(e.getClass(), equalTo(LazyInitializationException.class));
        }
    }

    @Test
    void testFindByIdFetchesProducts() {
        Company company = createRandomCompany();
        emUtil.performWithinTx(entityManager -> entityManager.persist(company));

        Product product = createRandomProduct();
        emUtil.performWithinTx(entityManager -> {
            product.setCompany(company);
            entityManager.persist(product);
        });

        Company foundCompany = companyDao.findByIdFetchProducts(company.getId());
        assertThat(foundCompany, equalTo(company));
        assertThat(foundCompany.getProducts(), hasItem(product));
    }
}
