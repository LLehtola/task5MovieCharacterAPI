package com.experis.movie_character_api.repositories;

import com.experis.movie_character_api.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}