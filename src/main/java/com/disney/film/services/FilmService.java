package com.disney.film.services;

import com.disney.film.models.FilmModel;
import com.disney.film.repositories.FilmRepository;

import java.util.ArrayList;
import java.util.Optional;

public class FilmService {

    FilmRepository filmRepository;
    public ArrayList<Long> getIdsFilmsOfCharacter(ArrayList<FilmModel> films) {
        ArrayList<Long> idsFilms = new ArrayList<Long>();

        for (FilmModel film : films) {
            Long id = film.getId();
            idsFilms.add(id);
        }
        return idsFilms;
    }

    public Optional<FilmModel> getById(Long id) {
        Optional<FilmModel> film = filmRepository.findById(id);
        return film;
    }
}
