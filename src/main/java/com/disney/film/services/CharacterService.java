package com.disney.film.services;

import com.disney.film.models.CharacterModel;
import com.disney.film.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public CharacterModel getFullCharacter() {
        return new CharacterModel();
    }


}
