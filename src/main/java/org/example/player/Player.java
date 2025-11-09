package org.example.player;

import org.example.model.Planet;

public class Player {
    private Planet location;
    private int fuel;
    private boolean cargoIntact = true;

    public Player(Planet start, int fuel) {
        this.location = start;
        this.fuel = fuel;
    }

    public Planet getLocation() { return location; }
    public int getFuel() { return fuel; }
    public boolean isCargoIntact() { return cargoIntact; }

    public void moveTo(Planet p, int fuelCost) {
        fuel -= fuelCost;
        location = p;
    }

    public void loseCargo() { cargoIntact = false; }
    public boolean hasFuel() { return fuel > 0; }
    public void addFuel(int amount) { fuel += amount; }
}
