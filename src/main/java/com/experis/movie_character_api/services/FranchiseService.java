package com.experis.movie_character_api.services;

import com.experis.movie_character_api.services.MovieService;
import com.experis.movie_character_api.models.Character;
import com.experis.movie_character_api.models.Franchise;
import com.experis.movie_character_api.models.Movie;
import com.experis.movie_character_api.repositories.CharacterRepository;
import com.experis.movie_character_api.repositories.FranchiseRepository;
import com.experis.movie_character_api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FranchiseService {

        @Autowired
        MovieRepository movieRepository;

        @Autowired
        FranchiseRepository franchiseRepository;

        @Autowired
        CharacterRepository characterRepository;

        public List<Franchise> getAllFranchises() {
            return franchiseRepository.findByIdNotNull();
        }

        public Franchise getFranchiseById(Long id) {
            if (!franchiseRepository.existsById(id)) {
                return null;
            }

            return franchiseRepository.findById(id).get();
        }

        public Franchise addFranchise(Franchise franchise) {
            return franchiseRepository.save(franchise);
        }

        public Franchise updateFranchise(Long id, Franchise franchise) {
            if (!franchiseRepository.existsById(id)) {
                return null;
            }

            return franchiseRepository.save(franchise);
        }

        @Transactional
        // save() calls are not needed in transactional methods
        public boolean deleteFranchise(Long id) {
            if (!franchiseRepository.existsById(id)) {
                return false;
            }
            Franchise franchise = franchiseRepository.findById(id).get();

            for (Movie movie : franchise.getMovies()) {
                movieRepository.delete(movie);
            }

            franchiseRepository.delete(franchise);

            return true;
        }


}
