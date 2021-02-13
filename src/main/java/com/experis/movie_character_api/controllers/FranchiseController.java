package com.experis.movie_character_api.controllers;

import com.experis.movie_character_api.models.Character;
import com.experis.movie_character_api.models.Movie;
import com.experis.movie_character_api.services.FranchiseService;
import com.experis.movie_character_api.models.Franchise;
import com.experis.movie_character_api.repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @GetMapping
    public ResponseEntity<List<Franchise>> getAllFranchises() {
        List<Franchise> franchises = franchiseService.getAllFranchises();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(franchises, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchisesById(@PathVariable Long id) {
        HttpStatus status;
        Franchise returnedFranchise = franchiseService.getFranchiseById(id);

        if (returnedFranchise == null) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }

        status = HttpStatus.OK;
        return new ResponseEntity<>(returnedFranchise, status);
    }

    @PostMapping()
    public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise) {
        HttpStatus status;
        franchise = franchiseService.addFranchise(franchise);
        status = HttpStatus.CREATED;
        return new ResponseEntity<>(franchise, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long id,
                                                     @RequestBody Franchise franchise) {
        HttpStatus status;

        if (!id. equals(franchise.getId())) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(null, status);
        }

        Franchise returnedFranchise = franchiseService.updateFranchise(id, franchise);

        if (returnedFranchise == null) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }

        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(returnedFranchise, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteFranchise(@PathVariable Long id) {
        HttpStatus status;
        boolean isDeleted = franchiseService.deleteFranchise(id);

        if (isDeleted) {
            status = HttpStatus.OK;
        } else{
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(isDeleted,
                status);
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<List<Movie>> getAllMoviesInFranchise(@PathVariable Long id) {
        HttpStatus status;
        List<Movie> moviesInFranchise = franchiseService.getAllMoviesInFranchise(id);

        if (moviesInFranchise == null) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }

        status = HttpStatus.OK;
        return new ResponseEntity<>(moviesInFranchise, status);
    }
}

