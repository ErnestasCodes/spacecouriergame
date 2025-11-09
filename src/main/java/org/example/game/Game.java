package org.example.game;

import org.example.game.event.EventHandler;
import org.example.game.event.EventManager;
import org.example.model.*;
import org.example.player.Player;
import org.example.ui.GameUI;
import org.example.ui.panels.MapPanel;

import java.awt.*;
import java.util.Random;

import java.util.*;

import static java.lang.Math.random;

public class Game {
   // private final Random rng = new Random();
    private final GameMap map = new GameMap();
    private final Player player;
    private final Planet destination;

    private final Random random = new Random();

    private final GameStateManager stateManager;
    private final EventManager eventManager = new EventManager();
    private final EventHandler eventHandler;
    public final MapPanel mapPanel = new MapPanel();

    private final GameUI ui;


    public Game(GameUI ui) {
        //su kiek pradeda
        int x = random.nextInt(15 - 12 + 1)+12;
        this.ui = ui;
        this.eventHandler = new EventHandler(ui);
        this.stateManager = new GameStateManager(ui);

        ui.mapPanel.setGame(this);

        java.util.Random random = new java.util.Random();


        Planet start = map.allPlanets.get(random.nextInt(map.allPlanets.size()));
        Planet dest;
        do {
            dest = map.allPlanets.get(random.nextInt(map.allPlanets.size()));
        } while (dest == start); // kad nebutu ta pati planeta

        this.player = new Player(start, x);
        this.destination = dest;

        // išvedam info į UI
        ui.showMessage("Tikslas: pristatyti krovinį į " + destination.getName() + ".");
        ui.updateShipPosition(start.getName());

    }

    public void nextTurn() {
        if (!stateManager.checkGameState(player, destination)) return;
        stateManager.showStatus(player);
    }

    public void chooseRoute(Route r) {
       player.moveTo(r.getTo(), r.getFuelCost());
       ui.updateShipPosition(r.getTo().getName());
        handleEvent(r);
       nextTurn();

    }

    private void handleEvent(Route r) {
        EventType e = eventManager.rollEvent(r.getRisk());
        eventHandler.handle(e, player);
    }


    public Player getPlayer() {
        return player;
    }

    public Planet getDestination() {
        return destination;
    }



}
