package com.example.demo;

import java.io.Serializable;

public class Cat implements Serializable {
    private String catchPhrase;
    private String name;


    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getName() {
        return name;
    }

    public Cat() {
    }
}
