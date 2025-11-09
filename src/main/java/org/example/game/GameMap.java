package org.example.game;

import org.example.model.*;

public class GameMap {

    // Naudojamas Factory Method pattern'as planetų kūrimui

    public final Planet A = PlanetFactory.createPlanet("Astra");
    public final Planet B = PlanetFactory.createPlanet("Borealis");
    public final Planet C = PlanetFactory.createPlanet("Cygni");
    public final Planet D = PlanetFactory.createPlanet("Draco");
    public final Planet F = PlanetFactory.createPlanet("Falcon");
    public final Planet E = PlanetFactory.createPlanet("Elysium");
    public final Planet O = PlanetFactory.createPlanet("Orion");
    public final Planet N = PlanetFactory.createPlanet("Nova");



    public final Planet DEST = PlanetFactory.createPlanet("Centauri");

    public final java.util.List<Planet> allPlanets = new java.util.ArrayList<>();


    public GameMap() {
        allPlanets.addAll(java.util.List.of(A,B,C,D,F,E,O,N,DEST));
        // Astra jungtys
        connect(A, B, 4, Risk.LOW);
        connect(A, C, 5, Risk.MEDIUM);
        connect(A, O, 6, Risk.HIGH);

// Borealis jungtys
        //connect(B, F, 1, Risk.HIGH);
        connect(B, D, 4, Risk.MEDIUM);
        connect(B, C, 4, Risk.HIGH);
        connect(B, F, 1, Risk.HIGH);

// Cygni jungtys
        connect(C, D, 4, Risk.LOW);
        connect(C, N, 5, Risk.MEDIUM);
        connect(C, O, 3, Risk.HIGH);
        connect(C, B, 4, Risk.HIGH);
        connect(C, A, 4, Risk.HIGH);

// Draco jungtys
        connect(D, B, 4, Risk.LOW);
      //  connect(D, E, 3, Risk.HIGH);
        connect(D, N, 4, Risk.HIGH);

// Falcon jungtys
        connect(F, B, 1, Risk.HIGH);
        connect(F, A, 3, Risk.LOW);

// Elysium jungtys
        connect(E, D, 4, Risk.MEDIUM);
        connect(E, N, 6, Risk.MEDIUM);

// Orion jungtys
        connect(O, C, 3, Risk.HIGH);
        connect(O, N, 4, Risk.MEDIUM);

// Nova jungtys
        connect(N, D, 5, Risk.MEDIUM);
        connect(N, C, 4, Risk.LOW);
        connect(N, O, 4, Risk.MEDIUM);




    }

    private void connect(Planet p1, Planet p2, int fuel, Risk risk) {
        Route r1 = new Route(p1, p2, fuel, risk);
        Route r2 = new Route(p2, p1, fuel, risk);
        p1.addRoute(r1);
        p2.addRoute(r2);
    }
}
