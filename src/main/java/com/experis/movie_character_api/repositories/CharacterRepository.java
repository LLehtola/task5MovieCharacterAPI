package com.experis.movie_character_api.repositories;

import com.experis.movie_character_api.models.Character;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    // avoid N+1 query problem when fetching all characters
    @EntityGraph(attributePaths = {"movies"})
    List<Character> findByIdNotNull();
}
