package com.experis.movie_character_api.controllers;

import com.experis.movie_character_api.models.Character;
import com.experis.movie_character_api.models.Movie;
import com.experis.movie_character_api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * this class controls the /movies endpoint
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        HttpStatus status;
        status = (movies.isEmpty()) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(movies, status);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long movieId) {
        Optional<Movie> movie = movieService.getMovieById(movieId);

        HttpStatus status;
        status = (movie.isEmpty()) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(movie, status);
    }

    @GetMapping("/{movieId}/characters")
    public ResponseEntity<List<Character>> getAllCharactersInMovieById(@PathVariable Long movieId) {
        List<Character> characters = movieService.getAllCharactersInMovieById(movieId);

        HttpStatus status;
        status = (characters.isEmpty()) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(characters, status);
    }

    @PostMapping
    public ResponseEntity<Boolean> addMovie(@RequestBody Movie movie) {
        boolean isCreated = movieService.addNewMovie(movie);

        HttpStatus status;
        status = (!isCreated) ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED;

        return new ResponseEntity<>(isCreated, status);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Boolean> updateMovie(@PathVariable Long movieId, @RequestBody Movie movie) {
        boolean isUpdated = movieService.updateMovie(movie, movieId);
        HttpStatus status;

        status = (isUpdated) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(isUpdated, status);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable Long movieId) {
        boolean isDeleted = movieService.deleteMovie(movieId);

        HttpStatus status;
        status = (isDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(isDeleted, status);
    }
}