package fr.m2i.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * todo:
 * - Implémenter un constructeur sans arguments
 * - Implémenter les getter et les setter
 * - Implémenter equals() et hashCode() en se basant sur le champs {@link Company#id} (@EqualsAndHashCode)
 *
 * - Initialiser le champs {@link Company#products} avec une nouvelle instance de {@link ArrayList}
 * - Implémenter la méthode utilitaire {@link Company#addProduct(Product)} qui établie la relation des deux cotés
 * - Implémenter la méthode utilitaire {@link Company#removeProduct(Product)} qui supprime la relation des deux cotés
 * 
 * - Configurer l'entité JPA
 * - Spécifier le nom de la table: "company"
 * - Configurer un id auto généré
 * - Configure la colonne "name" pour la rendre obligatoire {@link Company#name}
 * 
 * - Configurer la relation one-to-many qui doit etre mappé du côté de l'enfant {@link Product}
 */
@NoArgsConstructor
@Getter
@Setter
public class Company {
    private Long id;
    private String name;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        throw new UnsupportedOperationException("I'm still not implemented!");
    }

    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("I'm still not implemented!");
    }
}
