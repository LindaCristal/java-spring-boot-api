package com.disney.film.repositories;

import com.disney.film.models.FilmModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<FilmModel, Long> {
}
