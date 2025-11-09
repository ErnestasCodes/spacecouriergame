package org.example.game;

import org.example.player.Player;
import org.example.model.Planet;
import org.example.ui.GameUI;

public class GameStateManager {

    private final GameUI ui;

    public GameStateManager(GameUI ui) {
        this.ui = ui;
    }

    public boolean checkGameState(Player player, Planet destination) {
        if (!player.hasFuel()) {
            ui.showGameOver("Kuras baigėsi. Pralaimėjai.");
            return false;
        }

        if (!player.isCargoIntact()) {
            ui.showGameOver("Krovinys prarastas. Pralaimėjai.");
            return false;
        }

        if (player.getLocation() == destination) {
            ui.showGameOver("Pergalė! Krovinys pristatytas.");
            return false;
        }

        return true;
    }

    public void showStatus(Player player) {
        String status = "Esama planeta: " + player.getLocation().getName() +
                " | Kuras: " + player.getFuel() + "\nGalimi maršrutai:";
        ui.showStatus(status, player.getLocation().getRoutes());
    }
}
