package org.example.game;

import org.example.model.Planet;
import org.example.model.PlanetFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetFactoryTest {

    @Test
    public void testPlanetCreationNotNull() {
        Planet planet = PlanetFactory.createPlanet("Astra");
        assertNotNull(planet, "PlanetFactory turėtų sukurti planetos objektą, ne null.");
    }

    @Test
    public void testPlanetHasCorrectName() {
        String name = "Borealis";
        Planet planet = PlanetFactory.createPlanet(name);
        assertEquals(name, planet.getName(), "Planetos pavadinimas turėtų sutapti su nurodytu.");
    }
}
