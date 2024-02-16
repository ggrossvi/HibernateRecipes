package org.gloriavilla;

import org.gloriavilla.model.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gloriavilla.model.User;

/**
 * Create -- Creates entire database again good for testing
 * Update -- will create duplicates
 */
public class App 
{
    public static void main( String[] args )
    {
        //Build Factory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //Open Session
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();


        User user = new User();
        user.setFirstName("John");
        user.setLastName("Will");
        user.setUserName("jwill");

        User user1 = new User();
        user1.setFirstName("Johnny");
        user1.setLastName("Williams");
        user1.setUserName("jwilliams");

        // create set to hold ingredients
        Set<String> tiramisu = new HashSet<>();

        // add ingredients to ingredients container
        tiramisu.add("cream");
        tiramisu.add("coffee");
        tiramisu.add("ladyfingers");

        //create recipe -- name and ingredients
        Recipe recipe1 = new Recipe("tiramisu", tiramisu);

        Set<String> pasta = new HashSet<>();
        pasta.add("noodles");
        pasta.add("tomatoes");
        pasta.add("garlic");
        pasta.add("basil");

        Recipe recipe2 = new Recipe("pasta", pasta);

        Set<Recipe> r = user.getRecipes();
        r.add(recipe1);
        r.add(recipe2);

        session.persist(recipe1);
        session.persist(recipe2);
        session.persist(user);
        session.persist(user1);


        transaction.commit();


        //factory.close();
        //session.close();


    }
/*
    private static void createRecipe(Transaction transaction) {
        transaction.commit();
    }
*/
}
