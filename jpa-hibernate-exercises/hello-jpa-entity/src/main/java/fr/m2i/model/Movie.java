package fr.m2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name= "movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;
    
    @Column (name="name", nullable=false)
    private String name;
    
    @Column (name="director", nullable=false)
    private String director;

    @Column (name="duration")
    private Integer durationSeconds;
}
