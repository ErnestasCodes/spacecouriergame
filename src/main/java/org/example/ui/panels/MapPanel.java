package org.example.ui.panels;

import org.example.game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapPanel extends JPanel {
    private String currentPlanet = null;                 // kur yra laivas
    public final Set<String> visitedPlanets = new HashSet<>(); // aplankytos
    private final Map<String, Point> planetPositions = new HashMap<>();



    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public MapPanel() {

        planetPositions.put("Astra",    new Point(100, 100));
        planetPositions.put("Borealis", new Point(250,  80));
        planetPositions.put("Cygni",    new Point(200, 200));
        planetPositions.put("Draco",    new Point(400, 150));
        planetPositions.put("Elysium",  new Point(550, 100));
        planetPositions.put("Falcon",   new Point(250,  30));


        planetPositions.put("Orion",    new Point(100, 300));
        planetPositions.put("Nova",     new Point(350, 250));


    }

    public void setCurrentPlanet(String planetName) {
        this.currentPlanet = planetName;
        repaint();
    }


    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (var entry : planetPositions.entrySet()) {
            String name = entry.getKey();
            Point p = entry.getValue();


            if (game != null && name.equals(game.getDestination().getName())) {
                g.setColor(Color.RED);
            }
            // Jei aplankyta – tamsiai pilka
            else if (visitedPlanets.contains(name)) {
                g.setColor(Color.blue);
            }

            else {
                g.setColor(Color.GRAY);
            }

            g.fillOval(p.x, p.y, 20, 20);

            g.setColor(Color.BLACK);
            g.drawString(name, p.x - 10, p.y - 5);
        }


        if (currentPlanet != null && planetPositions.containsKey(currentPlanet)) {
            Point p = planetPositions.get(currentPlanet);
            g.setColor(Color.RED);
            g.drawString(">", p.x + 25, p.y + 15);
        }


    }
    public Point getPlanetPosition(String planetName) {
        return planetPositions.get(planetName);
    }




}
