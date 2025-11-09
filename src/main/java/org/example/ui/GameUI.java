package org.example.ui;

import org.example.game.Game;
import org.example.model.Route;
import org.example.ui.panels.MapPanel;


import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GameUI extends JFrame  {
    private final JTextArea output = new JTextArea();
    private final JPanel buttonPanel = new JPanel();
    private final Map<String, Point> planetPositions = new HashMap<>();

    public final MapPanel mapPanel = new MapPanel();
    private Game game;




    public GameUI() {
        setTitle("Kosminis kurjeris");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(mapPanel, BorderLayout.CENTER);



        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(output), mapPanel);
        splitPane.setDividerLocation(250);
        add(splitPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);



        output.setEditable(false);
        output.setFont(new Font("Consolas", Font.PLAIN, 14));


       startGame(); // čia paleidžiam žaidimą


        SwingUtilities.invokeLater(() -> {
            if (game != null && game.getPlayer() != null) {
                updateShipPosition(game.getPlayer().getLocation().getName());
            }
        });



    }


    private void startGame() {

        game = new Game(this);

        // išvalom senus duomenis
        mapPanel.visitedPlanets.clear();


        String startPlanet = game.getPlayer().getLocation().getName();
        updateShipPosition(startPlanet);
        mapPanel.visitedPlanets.add(startPlanet);

        // paleidžiam žaidimo eigą
        game.nextTurn();

    }


    public void showStatus(String text, List<Route> routes) {
        output.append("\n" + text + "\n");
        buttonPanel.removeAll();
        for (Route r : routes) {
            JButton b = new JButton(r.getTo().getName() + " (" + r.getFuelCost() + " kuro, " + r.getRisk() + ")");
            b.addActionListener(e -> game.chooseRoute(r));
            buttonPanel.add(b);
        }
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    public void showMessage(String msg) {
        output.append(msg + "\n");
    }

    public void showGameOver(String msg) {
        output.append("\n=== " + msg + " ===\n");
        buttonPanel.removeAll();
        JButton restart = new JButton("Žaisti iš naujo");
        restart.addActionListener(e -> startGame());
        buttonPanel.add(restart);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    public void updateShipPosition(String planetName) {
        mapPanel.setCurrentPlanet(planetName);
        mapPanel.repaint();
    }





    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameUI().setVisible(true));
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }


}
