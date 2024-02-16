package org.gloriavilla.model;
import jakarta.persistence.*;
import jakarta.transaction.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data // slide 15 305.6 project lombak
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    int userId;

    String firstName;
    String lastName;
    @ManyToMany(targetEntity = Recipe.class)
    private Set<Recipe> recipes = new HashSet<>();
    String userName;


}
