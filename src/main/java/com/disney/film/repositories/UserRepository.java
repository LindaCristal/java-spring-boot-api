package com.disney.film.repositories;

import com.disney.film.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPriority(Integer priority);
    public UserModel findByName(String name);

}
