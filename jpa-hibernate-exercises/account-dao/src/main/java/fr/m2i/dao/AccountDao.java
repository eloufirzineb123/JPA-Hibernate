package fr.m2i.dao;

import fr.m2i.model.Account;

import java.util.List;

/**
 * {@link AccountDao} fournit des méthode d'accès aux données de l'entité {@link Account}.
 */
public interface AccountDao {
    /**
     * Reçoit une instance de {@link Account} et la stocke en BDD. Cette méthode va set un id auto généré.
     *
     * @param account nouvelle instance de l'entité account
     */
    void save(Account account);

    /**
     * Retourne une instance de l'entité {@link Account} en recherchant par son id
     *
     * @param id l'id de {@link Account} en BDD
     * @return account instance de {@link Account}
     */
    Account findById(Long id);

    /**
     * Retourne une instance de {@link Account} en recherchant par son email
     *
     * @param email l'email de {@link Account} à rechercher
     * @return account Instance de {@link Account}
     */
    Account findByEmail(String email);

    /**
     * Retourne tout les {@link Account} stockés dans la BDD
     *
     * @return account list
     */
    List<Account> findAll();

    /**
     * Reçoit une instance {@link Account} déjà stockée en BDD et la met à jour
     *
     * @param account Instance de {@link Account} avec les champs mis à jour
     */
    void update(Account account);

    /**
     * Supprime l'instance de {@link Account} stockée en BDD mais la garde en mémoire.
     *
     * @param account stored account instance
     */
    void remove(Account account);
}
