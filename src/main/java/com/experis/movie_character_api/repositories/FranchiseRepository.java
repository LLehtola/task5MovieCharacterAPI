package com.experis.movie_character_api.repositories;

import com.experis.movie_character_api.models.Character;
import com.experis.movie_character_api.models.Franchise;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long>{

    @EntityGraph(attributePaths = {"movies"})
    List<Franchise> findByIdNotNull();
}
