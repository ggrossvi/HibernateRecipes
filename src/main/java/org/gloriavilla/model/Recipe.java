package org.gloriavilla.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data // slide 15 305.6 project lombak

public class Recipe {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private int recipeId;
    private String recipeName;
    @ElementCollection
    private Set<String> ingredients = new HashSet<>();
    int numIngredients;
    //int count;
    //@ManyToMany(targetEntity = User.class)
    //private Set<User> listUsers;


    public Recipe(String name, Set<String> ingredients) {
        super();
        this.recipeName=name;
        this.ingredients = ingredients;
    }

    public Recipe() {

    }
}
