package com.experis.movie_character_api.repositories;

import com.experis.movie_character_api.models.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @EntityGraph(attributePaths = {"characters"})
    List<Movie> findByIdNotNull();

    @EntityGraph(attributePaths = {"characters"})
    List<Movie> findAllByFranchiseId(Long franchiseId);
}