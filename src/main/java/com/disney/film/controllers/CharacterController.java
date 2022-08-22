package com.disney.film.controllers;

import com.disney.film.models.CharacterModel;
import com.disney.film.models.UserModel;
import com.disney.film.models.dto.CharacterDTO;
import com.disney.film.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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


}
