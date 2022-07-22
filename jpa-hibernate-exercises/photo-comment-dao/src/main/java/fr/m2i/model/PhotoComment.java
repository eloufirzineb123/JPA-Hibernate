package fr.m2i.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * todo:
 * - Implémenter un constructeur sans arguments
 * - Implémenter les getter et les setter
 *
 * - Configurer l'entité JPA
 * - Specifier le nom de la table: "photo_comment"
 * - Configurer un id auto généré
 * - Configurer la colonne text en tant que "not nullable"
 *
 * - Mapper la relation entre Photo et PhotoComment en définissant le nom de la colonne de la foreign_key en: "photo_id"
 * - Configurer la relation pour qu'elle soit obligatoire (not optional)
 */
@Getter
@Setter
public class PhotoComment {
    private Long id;
    private String text;
    private LocalDateTime createdOn;
    private Photo photo;
}