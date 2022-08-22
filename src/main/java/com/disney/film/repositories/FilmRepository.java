package com.disney.film.repositories;

import com.disney.film.models.FilmModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FilmRepository extends CrudRepository<FilmModel, Long> {
    public ArrayList<FilmModel> findByIdCharacter(Long id);
}
