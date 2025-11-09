package org.example.model;

public class PlanetFactory {


    public static Planet createPlanet(String name) {
        return new Planet(name);
    }
}
