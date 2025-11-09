package org.example.model;

import java.util.*;

public class Planet {
    private final String name;
    private final List<Route> routes = new ArrayList<>();

    public Planet(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Route> getRoutes() {
        return Collections.unmodifiableList(routes);
    }

    public void addRoute(Route r) {
        routes.add(r);
    }

    @Override
    public String toString() {
        return name;
    }
}
