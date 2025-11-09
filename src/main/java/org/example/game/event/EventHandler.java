package org.example.game.event;

import org.example.model.EventType;
import org.example.player.Player;
import org.example.ui.GameUI;

import java.util.Random;



public class EventHandler {

    private final GameUI ui;

    public EventHandler(GameUI ui) {
        this.ui = ui;
    }
    private final Random rand = new Random();
    public void handle(EventType e, Player player) {

        int x = rand.nextInt(4-1 + 1)+1;
        switch (e) {
            case PIRATE_ATTACK -> {
                ui.showMessage("Piratų užpuolimas! Krovinys dingo.");
                player.loseCargo();
            }
            case SOLAR_STORM -> {
                ui.showMessage("Kosminė audra! Netenki "+ x + " kuro.");
                player.addFuel(-x);
            }
            case FUEL_LEAK -> {
                ui.showMessage("Kuro nutekis! Netenki "+ x + " kuro.");
                player.addFuel(-x);
            }
            case NAV_ERROR -> ui.showMessage("Navigacijos klaida, bet pasieki planetą.");
            case NONE -> ui.showMessage("Skrydis ramus.");
        }
    }
}
