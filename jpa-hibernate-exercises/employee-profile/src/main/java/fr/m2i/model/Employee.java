package fr.m2i.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * todo:
 * - Implémenter un constructeur sans arguments
 * - Implémenter les getter et les setter
 *
 * - Configurer l'entité JPA
 * - Specifier le nom de la table: "employee"
 * - Configurer un id auto généré
 * - Configurer les colonnes suivantes en not nullable : email, firstName, lastName
 *
 * - Mappé la relation unidirectionnelle entre {@link Employee} et {@link EmployeeProfile} du côté de l'enfant
 */
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private Long id;
    private String email;
    private String fistName;
    private String lastName;
}

