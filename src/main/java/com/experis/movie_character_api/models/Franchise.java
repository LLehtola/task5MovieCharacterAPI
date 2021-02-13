package com.experis.movie_character_api.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data // encapsulate getters and setters
@Entity
@JsonIgnoreProperties({ "new" })
public class Franchise extends AbstractPersistable<Long>{

    private String name;
    private String description;

    @JsonProperty("movies")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "franchises")
    private List<Movie> movies = new ArrayList<>();

    @JsonGetter("movies")
    public List<String> moviesGetter() {
        return movies.stream()
                .map(movie -> "/api/v1/movies/" + movie.getId())
                .collect(Collectors.toList());
    }
}
