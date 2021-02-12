package com.experis.movie_character_api.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this model define the movies' entity columns in database
 * and the relation it has with other entities
 */
@NoArgsConstructor
@AllArgsConstructor
@Data // encapsulate getters and setters
@Entity
@JsonIgnoreProperties({ "new" })
public class Movie extends AbstractPersistable<Long> {

    private String title;
    private String genre;
    private Date releaseYear;
    private String director;
    private String picture_url;
    private String trailer_url;

    //franchise Entity
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    public Franchise franchise;
    //character Entity
    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    public List<Character> characters;

    @JsonGetter("franchise")
    public String franchise() {
        if (franchise != null) {
            return "/api/v1/franchises/" + franchise.getId();
        } else {
            return null;
        }
    }

    @JsonGetter("characters")
    public List<String> characters() {
        return characters.stream()
                .map(character -> {
                    return "/api/v1/characters/" + character.getId();
                }).collect(Collectors.toList());
    }
}