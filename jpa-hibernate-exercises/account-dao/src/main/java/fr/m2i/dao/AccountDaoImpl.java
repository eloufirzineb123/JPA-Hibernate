package fr.m2i.dao;

import fr.m2i.exception.AccountDaoException;
import fr.m2i.model.Account;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AccountDaoImpl implements AccountDao {
    private EntityManagerFactory emf;

    public AccountDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Account account) {
        
        
        EntityManager entityManager = emf.createEntityManager();
            
            
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(account);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            if (tx != null) {
               
                tx.rollback();
            }throw new AccountDaoException("", e);
        }
    }

    @Override
    public Account findById(Long id) {
          
        EntityManager entityManager = emf.createEntityManager();
        Account accountFounded = entityManager.find(Account.class, id);

        if (accountFounded == null) {
            System.out.println("Attention account avec l'id: " + id + " n'existe pas !");
        }

        return accountFounded ;
    }

    @Override
    public Account findByEmail(String email) {
         EntityManager entityManager = emf.createEntityManager();
        Query finQuery = entityManager.createQuery("select a from Account a where a.email=?1");
       finQuery.setParameter(1, email);
         return  (Account) finQuery.getSingleResult();
    }

    @Override
    public List<Account> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query findAllQuery = entityManager.createQuery("select a from Account a");
        return findAllQuery.getResultList();
    }

    @Override
    public void update(Account account) {
        EntityManager entityManager = emf.createEntityManager();
        Account accUpdate = entityManager.find(Account.class, account.getId());

        // Si le adresse n'existe pas on ne fait pas d'update
        if (accUpdate  == null) {
            System.out.println("Account n'existe pas");
            return;
        }

        // on set les données uniquement si elle ne sont pas null
        accUpdate.copy(account);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(accUpdate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    

    @Override
    public void remove(Account account) {
         if (account == null) return;
        EntityManager entityManager = emf.createEntityManager();
        
        Account acc =  entityManager.merge(findById(account.getId()));
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(acc);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
        
        /*
         if (account == null) return;
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = null;
        try {
            trans = em.getTransaction();
            trans.begin();
            Account newAcc = em.merge(this.findById(account.getId()));
            em.remove(newAcc);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) trans.rollback();
        }
        */
    }
}


