package com.experis.movie_character_api.services;

import com.experis.movie_character_api.models.Character;
import com.experis.movie_character_api.models.Movie;
import com.experis.movie_character_api.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public List<Character> getAllCharacters() {
        return characterRepository.findByIdNotNull();
    }

    public Character getCharacterById(Long id) {
        if (!characterRepository.existsById(id)) {
            return null;
        }

        return characterRepository.findById(id).get();
    }

    public Character addCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character updateCharacter(Long id, Character character) {
        if (!characterRepository.existsById(id)) {
            return null;
        }

        return characterRepository.save(character);
    }

    @Transactional
    // save() calls are not needed in transactional methods
    public boolean deleteCharacter(Long id) {
        if (!characterRepository.existsById(id)) {
            return false;
        }

        Character character = characterRepository.findById(id).get();

        for (Movie movie : character.getMovies()) {
            movie.getCharacters().remove(character);
        }

        characterRepository.delete(character);

        return true;
    }
}
