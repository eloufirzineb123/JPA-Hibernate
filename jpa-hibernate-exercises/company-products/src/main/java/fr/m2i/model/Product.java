package fr.m2i.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * todo:
 * - Implémenter un constructeur sans arguments
 * - Implémenter les getter et les setter
 * - Implémenter equals() et hashCode() en se basant sur le champs {@link Product#id} (@EqualsAndHashCode)
 * 
 * - Configurer l'entité JPA
 * - Spécifier le nom de la table: "company"
 * - Configurer un id auto généré
 * - Configure la colonne "name" pour la rendre obligatoire {@link Product#name}
 * 
 * - Configurer la relation many-to-one en LAZY entre {@link Product} et {@link Company}
 * - Configurer la clé étrangère (foreign key) "company_id" qui réference la table company
 */
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Company company;
}
