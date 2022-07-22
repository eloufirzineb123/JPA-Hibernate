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
 * - Specifier le nom de la table: "employee_profile"
 * - Configurer un id auto généré
 * - Configurer les colonnes suivantes en not nullable : position, department
 *
 * - Mappé la relation entre {@link Employee} et {@link EmployeeProfile} en définissant la clé étrangère (foreign_key) avec le nom: "employee_id"
 * - Configurer une clé primaire partagée. E.g. La colonne mappé (par la relation) "employee_id" doit aussi être la clé primaire (id) pour cette entité (Voir: @MapsId)
 */
@NoArgsConstructor
@Getter
@Setter
public class EmployeeProfile {
    private Long id;
    private Employee employee;
    private String position;
    private String department;
}
