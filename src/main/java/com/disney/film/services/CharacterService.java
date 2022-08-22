package com.disney.film.services;

import com.disney.film.models.CharacterModel;
import com.disney.film.models.FilmModel;
import com.disney.film.repositories.CharacterRepository;
import com.disney.film.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    FilmRepository filmRepository;
    FilmService filmService;

    public CharacterModel saveCharacter(CharacterModel character) {
        return characterRepository.save(character);
    }

    public Boolean deleteCharacter(Long id) {
        try {
            characterRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Optional<CharacterModel> getFullCharacter(Long id) {

        Optional<CharacterModel> character = characterRepository.findById(id);
        ArrayList<Long> filmList = new ArrayList<Long>();

        if (character.get().getIdFilm() == null) {
            ArrayList<FilmModel> filmModelList = filmRepository.findByIdCharacter(id);
            if (!filmModelList.isEmpty()) {
                filmList = filmService.getIdsFilmsOfCharacter(filmModelList);
            } else {
                filmList.add(0L); // zero is added if there is no film assignment
            }
            CharacterModel characterDTO = new CharacterModel();
            characterDTO.setIdFilm(filmList);
            characterDTO.setAge(character.get().getAge());
            characterDTO.setImage(character.get().getImage());
            characterDTO.setName(character.get().getName());
            characterDTO.setStory(character.get().getStory());

            return Optional.of(characterDTO);
        } else {
            return character;
        }

    }

    public ArrayList<CharacterModel> getCharacters() {
        return (ArrayList<CharacterModel>) characterRepository.findAll();
    }

    public Optional<CharacterModel> getCharacterDetail(Long id) {
        return characterRepository.findById(id);
    }

    public CharacterModel getCharacterByName(String name) {
        return characterRepository.findByName(name);
    }

    public CharacterModel getCharacterByAge(Integer age) {
        return characterRepository.findByAge(age);
    }

    public CharacterModel getCharacterByIdFilm(Long idFilm) {
        return characterRepository.findByFilm(idFilm);
    }
}
