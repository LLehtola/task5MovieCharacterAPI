package com.experis.movie_character_api.controllers;

import com.experis.movie_character_api.models.Character;
import com.experis.movie_character_api.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> characters = characterRepository.findByIdNotNull();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(characters, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        HttpStatus status;

        if (!characterRepository.existsById(id)) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }

        status = HttpStatus.OK;
        Character returnedCharacter = characterRepository.findById(id).get();

        return new ResponseEntity<>(returnedCharacter, status);
    }

    @PostMapping()
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        HttpStatus status;
        character = characterRepository.save(character);
        status = HttpStatus.CREATED;
        return new ResponseEntity<>(character, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id,
                                                     @RequestBody Character character) {
        HttpStatus status;

        if (!id. equals(character.getId())) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(null, status);
        }

        if (!characterRepository.existsById(id)) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }

        Character returnedCharacter = characterRepository.save(character);
        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(returnedCharacter, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        HttpStatus status;

        if (!characterRepository.existsById(id)) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>("requested resource was not found",
                    status);
        }

        Character character = characterRepository.findById(id).get();
        characterRepository.delete(character);
        status = HttpStatus.OK;
        return new ResponseEntity<>("resource with id " + id + " was deleted",
                status);
    }
}
