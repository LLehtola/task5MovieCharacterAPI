package com.experis.movie_character_api.models;

// Lombok
public class Character {

    Long id; // auto-incremented, AbstractPersistable<Long>?
    String fullName;
    String alias; // if applicable
    String gender; // or enum?
    String pictureUrl;

    // relationships
}
