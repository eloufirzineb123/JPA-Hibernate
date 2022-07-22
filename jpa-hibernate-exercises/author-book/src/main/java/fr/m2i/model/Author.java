package fr.m2i.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * todo:
 * - Implémenter un constructeur sans arguments
 * - Implémenter les getter et les setter
 * - Implementer equals() qui vérifie si l'instance est valide et vérifie uniquement le champs id
 * - Implementer hashCode() qui retourne la valeur 31 (hard codé)
 * - Initialiser le champs {@link Author#books} avec une nouvel instance de {@link HashSet}
 * - Implémenter la méthode utilitaire {@link Author#addBook(Book)} qui établie la relation des deux cotés
 * - Implémenter la méthode utilitaire {@link Author#removeBook(Book)} qui supprime la relation des deux cotés
 * 
 * - Configurer l'entité JPA
 * - Specifier le nom de la table: "author"
 * - Configurer un id auto généré
 * - Configurer la colonne "first_name" pour la rendre obligatoire {@link Author#firstName}
 * - Configurer la colonne "last_name" pour la rendre obligatoire {@link Author#lastName}
 * 
 * - Configurer la relation many-to-many entre {@link Author} et {@link Book}
 * - Configurer les cascades pour cette relation avec {@link CascadeType#PERSIST} and {@link CascadeType#MERGE}
 * - Configurer la table de jointure (JoinTable) avec le nom "author_book"
 * - Configurer la clé étrangère (foreign key)"book_id" qui réference la table book
 * - Configurer la clé étrangère (foreign key)"author_id" qui référence la table author
 */
@NoArgsConstructor
@Getter
@Setter
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> books;

    public void addBook(Book book) {
        throw new UnsupportedOperationException("Are you kidding me?");
    }

    public void removeBook(Book book) {
        throw new UnsupportedOperationException("Are you kidding me?");
    }
}

