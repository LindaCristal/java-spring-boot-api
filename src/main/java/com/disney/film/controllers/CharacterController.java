package com.disney.film.controllers;

import com.disney.film.models.CharacterModel;
import com.disney.film.models.dto.CharacterDTO;
import com.disney.film.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping(path = "/{name}")
    public CharacterDTO getCharacterByName(@PathVariable("name") String name) {
        return this.characterService.getCharacterByName(name);
    }

    @GetMapping(path = "/{age}")
    public CharacterDTO getCharacterByAge(@PathVariable("age") Integer age) {
        return this.characterService.getCharacterByAge(age);
    }

    @GetMapping(path = "/{movies}")
    public CharacterDTO getCharacterByMovies(@PathVariable("movies") Long id) {
        return this.characterService.getCharacterByIdFilm(id);
    }

    @PostMapping()
    public CharacterModel saveCharacter(@RequestBody CharacterModel characterModel) {
        return this.characterService.saveCharacter(characterModel);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.characterService.deleteCharacter(id);
        if (ok) {
            return "Deleted character by id:" + id;
        } else {
            return "Could not delete character with id:" + id;
        }
    }

}
