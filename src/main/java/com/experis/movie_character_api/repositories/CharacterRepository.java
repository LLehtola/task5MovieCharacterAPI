package com.experis.movie_character_api.repositories;

import com.experis.movie_character_api.models.Character;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    // avoid N+1 query problem when fetching all characters
    @EntityGraph(attributePaths = {"movies"})
    List<Character> findByIdNotNull();

    @Query(
            value = "SELECT c.id, c.alias, c.full_name, c.gender, c.picture_url " +
                    "FROM character c " +
                    "LEFT JOIN movie_character mc ON c.id = mc.character_id " +
                    "LEFT JOIN movie m ON mc.movie_id = m.id " +
                    "LEFT JOIN franchise f ON m.franchise_id = f.id " +
                    "WHERE f.id = ?1",
            nativeQuery = true)
    List<Character> getCharactersByFranchiseId(Long id);
}