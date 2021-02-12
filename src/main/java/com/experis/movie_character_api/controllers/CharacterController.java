package com.experis.movie_character_api.controllers;

import com.experis.movie_character_api.models.Character;
import com.experis.movie_character_api.services.CharacterService;
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
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> characters = characterService.getAllCharacters();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(characters, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        HttpStatus status;
        Character returnedCharacter = characterService.getCharacterById(id);

        if (returnedCharacter == null) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }

        status = HttpStatus.OK;
        return new ResponseEntity<>(returnedCharacter, status);
    }

    @PostMapping()
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        HttpStatus status;
        character = characterService.addCharacter(character);
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

        Character returnedCharacter = characterService.updateCharacter(id, character);

        if (returnedCharacter == null) {
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(null, status);
        }

        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(returnedCharacter, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCharacter(@PathVariable Long id) {
        HttpStatus status;
        boolean isDeleted = characterService.deleteCharacter(id);

        if (isDeleted) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        
        return new ResponseEntity<>(isDeleted,
                status);
    }
}
