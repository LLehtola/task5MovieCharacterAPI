package com.experis.movie_character_api.controllers;

import com.experis.movie_character_api.models.Movie;
import com.experis.movie_character_api.repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * this class controls the /movies endpoint
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        HttpStatus status;
        status = (movies.isEmpty())? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(movies, status);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);

        HttpStatus status;
        status = (movie.isEmpty())? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(movie, status);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

        Movie returnMovie = movieRepository.save(movie);

        HttpStatus status;
        status = (returnMovie == null)? HttpStatus.NOT_ACCEPTABLE : HttpStatus.CREATED; //TODO check what status should be returned if movie failed to be created

        return new ResponseEntity<>(returnMovie, status);
    }
}