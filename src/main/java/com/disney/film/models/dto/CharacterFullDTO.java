package com.disney.film.models.dto;

import java.sql.Blob;
import java.util.ArrayList;

public class CharacterFullDTO {
    private Long id;
    private Blob image;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public ArrayList<Long> getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(ArrayList<Long> idFilm) {
        this.idFilm = idFilm;
    }

    private Integer age;
    private String story;
    private ArrayList<Long> idFilm;
}
