package fr.m2i.dao;

import fr.m2i.model.Company;

public interface CompanyDao {
    /**
     * Renvoi une {@link Company} avec tout ses produits en recherchant par l'id de la company
     *
     * @param id company id
     * @return company with all its products
     */
    Company findByIdFetchProducts(Long id);
}
