package com.disney.film.repositories;

import com.disney.film.models.CharacterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel, Long> {
    public CharacterModel findByName(String name);
    public CharacterModel findByAge(Integer age);
    public CharacterModel findByFilm(Long idFilm);
}
