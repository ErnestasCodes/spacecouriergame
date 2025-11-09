package org.example.game;

import org.example.model.Risk;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RiskTest {

    @Test
    public void testRiskLevelsExist() {
        assertNotNull(Risk.LOW, "LOW rizikos lygis turi egzistuoti.");
        assertNotNull(Risk.MEDIUM, "MEDIUM rizikos lygis turi egzistuoti.");
        assertNotNull(Risk.HIGH, "HIGH rizikos lygis turi egzistuoti.");
    }

    @Test
    public void testRiskOrder() {

        assertTrue(Risk.LOW.ordinal() < Risk.MEDIUM.ordinal(), "LOW turi būti mažesnis nei MEDIUM.");
        assertTrue(Risk.MEDIUM.ordinal() < Risk.HIGH.ordinal(), "MEDIUM turi būti mažesnis nei HIGH.");
    }

    @Test
    public void testToStringReturnsName() {
        assertEquals("LOW", Risk.LOW.toString(), "LOW rizikos toString() turėtų grąžinti 'LOW'.");
    }
}
