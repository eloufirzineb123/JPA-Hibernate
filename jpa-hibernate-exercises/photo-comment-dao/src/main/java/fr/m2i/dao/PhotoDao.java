package fr.m2i.dao;

import fr.m2i.model.Photo;

import java.util.List;

/**
 * {@link PhotoDao} fournit des méthode d'accès aux données de l'entité {@link Photo}.
 */
public interface PhotoDao {

    /**
     * Reçoit une instance de {@link Photo} et la stocke en BDD. Cette méthode va set un id auto généré.
     *
     * @param photo new photo
     */
    void save(Photo photo);

    /**
     * Retourne une instance de l'entité {@link Photo} en recherchant par son id
     *
     * @param id photo id
     * @return photo instance
     */
    Photo findById(long id);

    /**
     * Retourne toutes les {@link Photo} stockés dans la BDD
     *
     * @return list of stored photos
     */
    List<Photo> findAll();

    /**
     * Supprime l'instance de {@link Photo} stockée en BDD mais la garde en mémoire.
     *
     * @param photo an instance of stored photo
     */
    void remove(Photo photo);

    /**
     * Ajoute un nouveau commentaire à une Photo existante.
     * {@link Photo}.
     *
     * @param photoId
     * @param comment
     */
    void addComment(long photoId, String comment);
}
