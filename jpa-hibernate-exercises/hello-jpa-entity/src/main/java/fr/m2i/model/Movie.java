package fr.m2i.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * TODO: Vous devez implémenter les mapping JPA pour l'entité {@link Movie}
 * - spécifier un id
 * - spécifier le nom de la table: "movie"
 * - configurer id en tant colonne qui s'auto incrémente
 * - spécifier explicitement chaque nom de colonne ("id", "name", "director", "duration")
 * - spécifier une contrainte "not null" pour les champs {@link Movie#name} and {@link Movie#director}
 */

@NoArgsConstructor
@Getter
@Setter
public class Movie {
    private Long id;

    private String name;

    private String director;

    private Integer durationSeconds;
}
