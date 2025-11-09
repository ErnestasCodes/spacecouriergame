package org.example.model;

public class Route {
    private final Planet from;
    private final Planet to;
    private final int fuelCost;
    private final Risk risk;

    public Route(Planet from, Planet to, int fuelCost, Risk risk) {
        this.from = from; this.to = to; this.fuelCost = fuelCost; this.risk = risk;
    }

    public Planet getFrom() {
        return from;
    }
    public Planet getTo() {
        return to;
    }
    public int getFuelCost() {
        return fuelCost;
    }
    public Risk getRisk() {
        return risk;
    }
}
