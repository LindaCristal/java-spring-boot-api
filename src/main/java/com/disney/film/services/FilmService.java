package com.disney.film.services;

import com.disney.film.models.FilmModel;

import java.util.ArrayList;

public class FilmService {
    public ArrayList<Long> getIdsFilmsOfCharacter(ArrayList<FilmModel> films) {
        ArrayList<Long> idsFilms = new ArrayList<Long>();
        for (FilmModel film: films) {
            Long id = film.getId();
            idsFilms.add(id);
        }
        return idsFilms;
    }
}
