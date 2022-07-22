package fr.m2i.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * todo:
 * - Implémenter un constructeur sans arguments
 * - Implémenter les getter et les setter
 * - Implémenter equals() et hashCode() en se basant sur le champs {@link Book#isbn} (@EqualsAndHashCode)
 *
 * - Configurer l'entité JPA
 * - Specifier le nom de la table: "photo"
 * - Configurer un id auto généré
 * - Configurer la colonne url pour qu'elle soit "not nullable" et "unique"
 * 
 *
 * - Initialiser le champs comments
 * - Mapper la relation entre Photo et PhotoComment coté enfant {@link PhotoComment}
 * - Implémenter les méthodes utilitaires {@link Photo#addComment(PhotoComment)} and {@link Photo#removeComment(PhotoComment)}
 * - Mettre place le type de cascade {@link javax.persistence.CascadeType#ALL} pour le champs {@link Photo#comments}
 * - Mettre en place la suppresion des orphelin (orphanRemoval = true)
 */

@Getter
@Setter
public class Photo {
    private Long id;
    private String url;
    private String description;
    private List<PhotoComment> comments;

    public void addComment(PhotoComment comment) {
        throw new UnsupportedOperationException("Make me work!");
    }

    public void removeComment(PhotoComment comment) {
        throw new UnsupportedOperationException("Make me work!");
    }

}