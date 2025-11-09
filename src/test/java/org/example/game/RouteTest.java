package org.example.game;

import org.example.model.Route;
import org.example.model.Planet;
import org.example.model.Risk;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RouteTest {

    @Test
    public void testFuelCostIsStoredCorrectly() {
        Planet from = new Planet("Astra");
        Planet to = new Planet("Borealis");
        Route route = new Route(from, to, 5, Risk.MEDIUM);
        assertEquals(5, route.getFuelCost());
    }
}
