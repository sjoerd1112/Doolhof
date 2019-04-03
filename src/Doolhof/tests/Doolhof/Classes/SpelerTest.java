package Doolhof.Classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Timothy
 */
class SpelerTest {

    /*
     * Decision/Branch coverage bereikt van 88% op klasse Speler. Ons doel is hierdoor bereikt, omdat
     * wij alle mogelijke beslissingen (true, false) bij alle if condities en switch statements minimaal één keer
     * hebben laten uitvoeren door middel van diverse testen die hieronder staan beschreven en geprogrammeerd.
     */

    private static JPanel panel = new JPanel();
    private Speler speler = new Speler();

    @BeforeAll
    static void start() {
        new Speelveld(panel);
    }

    @Test
    void getPositieX() {
        /* In deze test wordt er gecontroleerd of de setter en getter van de x-coordinaat naar behoren functioneert */
        System.out.println("Running test case: retrieving X-coordinate");

        speler.setPositieX(4); // invoer
        // verwachte uitvoer == 4
        assertEquals(4, speler.getPositieX()); // werkelijke uitvoer == 4
    }

    @Test
    void getPositieY() {
        /* In deze test wordt er gecontroleerd of de setter en getter van de y-coordinaat naar behoren functioneert */
        System.out.println("Running test case: retrieving Y-coordinate");

        speler.setPositieY(5); // invoer
        // verwachte uitvoer == 5
        assertEquals(5, speler.getPositieY()); // werkelijke uitvoer == 5
    }

    @Test
    void pakSleutel() {
        /* In deze test wordt er gecontroleerd of de methode voor het oppaken van een sleutel naar behoren functioneert
         * en of de juiste sleutel waarde in het inventory van de speler wordt toegevoegd */
        System.out.println("Running test case: sleutel pakken");

        speler.pakSleutel(22); //invoer - pakt sleutel op index 22
        // verwachte uitvoer == sleutel waarde van 300
        assertEquals(300, speler.getInventory()); // Werkelijke uitvoer == sleutel waarde van 300
    }

    @Test
    void validMovementLeft() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging maakt naar links.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: valid movement left");

        speler.setPositieX(1); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 37, '<'); // invoer
        //verwachte uitvoer == true
        assertTrue(speler.validMovement(key)); // Werkelijke uitvoer == true
    }

    @Test
    void invalidMovementLeft() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging maakt naar links.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: invalid movement left");

        speler.setPositieX(0); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 37, '<'); // invoer
        // Verwachte uitvoer == false
        assertFalse(speler.validMovement(key)); // Werkelijke uitvoer == false
    }

    @Test
    void validMovementRight() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging maakt naar rechts.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: valid movement right");

        speler.setPositieX(8); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 39, '>'); // invoer
        //verwachte uitvoer == true
        assertTrue(speler.validMovement(key)); // Werkelijke uitvoer == true
    }

    @Test
    void invalidMovementRight() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging maakt naar rechts.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: invalid movement right");

        speler.setPositieX(9); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 39, '>'); // invoer
        //verwachte uitvoer == false
        assertFalse(speler.validMovement(key)); // Werkelijke uitvoer == true
    }

    @Test
    void validMovementUp() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging omhoog maakt.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: valid movement up");

        speler.setPositieY(1); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 38, '>'); // invoer
        //verwachte uitvoer == true
        assertTrue(speler.validMovement(key)); // Werkelijke uitvoer == true
    }

    @Test
    void invalidMovementUp() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging omhoog maakt.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: invalid movement up");

        speler.setPositieY(0); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 38, '>'); // invoer
        // Verwachte uitvoer == false
        assertFalse(speler.validMovement(key)); // Werkelijke uitvoer == false
    }

    @Test
    void validMovementDown() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging omlaag maakt.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: valid movement down");

        speler.setPositieY(8); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 40, '<'); // invoer
        // Verwachte uitvoer == true
        assertTrue(speler.validMovement(key)); // Werkelijke uitvoer == true
    }

    @Test
    void invalidMovementDown() {
        /* in deze test wordt er gecontroleerd of de speler een 'geldige' beweging omlaag maakt.
         * De speler mag niet buiten het veld lopen. */
        System.out.println("Running test case: invalid movement down");

        speler.setPositieY(9); // invoer
        KeyEvent key = new KeyEvent(panel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 40, '<'); // invoer
        // Verwachte uitvoer == false
        assertFalse(speler.validMovement(key)); // Werkelijke uitvoer == false
    }


    @Test
    void controleerWaarde() {
        /* In deze test wordt er een controle uitgevoerd om te achterhalen of de waarde van de barricade overeenkomt met de
         * sleutel waarde in de inventory van de speler. */
        System.out.println("Running test case: controle waarde van barricade");

        Barricade barricade = new Barricade();
        speler.setInventory(300); // invoer
        barricade.setWaarde(300); // invoer
        // verwachte uitvoer == true
        assertTrue(speler.controleerWaarde(barricade)); // Werkelijke uitvoer == true

    }

    @Test
    void showVictoryPopUp() {
        /* Er wordt hier een test uitgevoerd om te achterhalen of het pop up scherm verschijnt. */
        System.out.println("Running test case: show pop up scherm eindveld");
        speler.showVictoryPopUp(); //uitvoer
    }
}