package com.experis.movie_character_api.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Franchise {

    private Long id;
    private String name;
    private String description;

    public Franchise(String name, String description){
        this.id+=1;
        this.name=name;
        this.description=description;
    }

}
