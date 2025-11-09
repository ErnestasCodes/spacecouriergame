package org.example.game;

import org.example.model.Planet;
import org.example.model.Risk;
import org.example.model.Route;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlanetTest {

    @Test
    public void testPlanetHasCorrectName() {
        Planet p = new Planet("Astra");
        assertEquals("Astra", p.getName(), "Planetos pavadinimas turi būti teisingai nustatytas.");
    }

    @Test
    public void testAddRouteAddsConnection() {
        Planet a = new Planet("Astra");
        Planet b = new Planet("Borealis");
        Route r = new Route(a, b, 5, Risk.LOW);

        a.addRoute(r);
        assertEquals(1, a.getRoutes().size(), "Maršrutas turi būti pridėtas prie planetos.");
        assertEquals(b.getName(), a.getRoutes().get(0).getTo().getName(), "Maršruto paskirties planeta turi sutapti.");
    }
}
