package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

/**
 * Created by bugrahansahin on 13/07/16.
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public User() {
        int i;
        String[] names = {"ali", "ahmet", "ayse", "zubcuk", "john", "belediyeotobusu", "kuruyemis", "mahmut", "black", "luck"};
        Random rn = new Random();
        this.name = names[(Math.abs(rn.nextInt()) % 10)];
    }
    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "name is: " + name + " and the id is: " + id;
    }
}
