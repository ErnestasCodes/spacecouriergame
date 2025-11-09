package org.example.game.event;

import org.example.model.EventType;
import org.example.model.Risk;

import java.util.Random;

public class EventManager {
    private final Random rng = new Random();

    public EventType rollEvent(Risk risk) {
        int x = rng.nextInt(100);

        if (risk == Risk.LOW) {
            if (x < 70) return EventType.NONE;         // 70% tikimybė
            else if (x < 85) return EventType.FUEL_LEAK; // 15%
            else return EventType.NAV_ERROR;             // 15%
        }

        else if (risk == Risk.MEDIUM) {
            if (x < 55) return EventType.NONE;          // 55%
            else if (x < 75) return EventType.FUEL_LEAK;  // 20%
            else return EventType.SOLAR_STORM;            // 25%
        }

        else if (risk == Risk.HIGH) {
            if (x < 30) return EventType.NONE;          // 40%
            else if (x < 70) return EventType.SOLAR_STORM; // 30%
            else return EventType.PIRATE_ATTACK;          // 30%
        }


        return EventType.NONE;
    }
}
