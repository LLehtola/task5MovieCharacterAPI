package com.experis.movie_character_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Character extends AbstractPersistable<Long> {

    private String fullName;
    private String alias; // if applicable
    private Gender gender;
    private String pictureUrl;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "characters")
    private List<Movie> movies = new ArrayList<>();
}

enum Gender {
    male,
    female,
    other
}
