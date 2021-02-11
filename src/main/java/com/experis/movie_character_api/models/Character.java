package com.experis.movie_character_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Character extends AbstractPersistable<Long> {

    private String fullName;
    private String alias; // if applicable

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    private String pictureUrl;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "characters")
    private List<Movie> movies = new ArrayList<>();
}

// Hibernate maps Gender enum to its ordinal value in the enum class,
// so do not change the order of genders in the class
enum Gender {
    male,
    female,
    other
}
