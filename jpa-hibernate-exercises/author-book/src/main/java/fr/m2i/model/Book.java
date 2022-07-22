package fr.m2i.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * todo:
 * - Implémenter un constructeur sans arguments
 * - Implémenter les getter et les setter
 * - Implémenter equals() et hashCode() en se basant sur le champs {@link Book#isbn} (@EqualsAndHashCode)
 * - Initialiser le champs {@link Book#authors} avec une nouvelle instance de {@link HashSet}
 * 
 * - Configurer l'entité JPA
 * - Spécifier le nom de la table: "book"
 * - Configurer un id auto généré
 * - Configurer la colonne "name" pour la rendre obligatoire {@link Book#name}
 * - Configurer la colonne "isbn"  pour la rendre obligatoire {@link Book#isbn}
 * 
 * - Configurer la relation many-to-many mappé du coté de l'entité {@link Author}
 */

@NoArgsConstructor
@Getter
@Setter
public class Book {
    private Long id;
    private String name;
    private String isbn;
    private Set<Author> authors;
}

