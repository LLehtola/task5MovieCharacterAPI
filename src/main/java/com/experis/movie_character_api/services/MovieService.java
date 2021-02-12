package com.experis.movie_character_api.services;

import com.experis.movie_character_api.models.Movie;
import com.experis.movie_character_api.repositories.CharacterRepository;
import com.experis.movie_character_api.repositories.FranchiseRepository;
import com.experis.movie_character_api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * this service contains the needed logic to implement CRUD
 * requests related to the movie entity
 */
@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    FranchiseRepository franchiseRepository;
    @Autowired
    CharacterRepository characterRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long movieId){

        if (!movieRepository.existsById(movieId))
        return Optional.empty();

        return movieRepository.findById(movieId);
    }

    public boolean addNewMovie(Movie movie){

        if (!checkFranchiseAndCharactersExistence(movie))
            return false;

        movieRepository.save(movie);
        return true;
    }

    public boolean updateMovie(Movie movie, Long id){

        if(id.equals(movie.getId())) {
            if (checkFranchiseAndCharactersExistence(movie)){
                movieRepository.save(movie);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean deleteMovie(Long id){

        if(!movieRepository.existsById(id))
            return false;

        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);
        return true;
    }

    /**
     * checks if movie's franchise and characters ids do exist in the database
     * before adding/ updating the movie entity.
     * @param movie the object to be tested
     * @return true if the object is valid and false otherwise
     */
    private boolean checkFranchiseAndCharactersExistence(Movie movie){

        if (!franchiseRepository.existsById(Objects.requireNonNull(movie.getFranchise().getId())))
            return false;

        for (int i = 0; i < movie.getCharacters().size(); i++) {
            if (!characterRepository.existsById(Objects.requireNonNull(movie.getCharacters().get(i).getId())))
                return false;
        }
        return true;
    }
}