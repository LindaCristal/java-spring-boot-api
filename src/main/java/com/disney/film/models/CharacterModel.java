package com.disney.film.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;

@Entity
@Table(name = "character")
public class CharacterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Blob image;
    private String name;
    private Integer age;
    private String story;
    private ArrayList<Long> idFilm;

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
}
