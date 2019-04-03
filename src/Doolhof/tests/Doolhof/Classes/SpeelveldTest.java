package Doolhof.Classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Timothy
 */
class SpeelveldTest {

    /*
     *  Ons doel voor code coverage is bereikt met een hoogtepunt van 100%
     *  voor class en method. Daarnaast wordt er 97% line code geexecuted
     *  gedurende de vier testjes. Uit deze cijfers kunnen wij concluderen dat
     *  ons code kwaliteit voor klasse Speelveld op niveau zit en er weinig
     *  ruimte is voor toekomstige bugs.
     */

    private static Speelveld speelveld;
    private ArrayList<Vlak> vlakken = speelveld.getVlakken();

    @BeforeAll
    static void start() {
        speelveld = new Speelveld(new JPanel()); // invoer
    }

    @Test
    void getVlakken() {
        /*
         * In deze test wordt er gekeken of er 100 vlakken zijn aangemaakt in het spel.
         */
        // verwachte uitvoer == 100
        assertEquals(100, vlakken.size()); // werkelijke uitvoer == 100
    }

    @Test
    void aantalSleutels() {
        /*
         * In deze test wordt er gekeken of alle sleutels correct zijn geladen.
         */
        int sleutels = 0;
        String naam;

        for (int i = 0; i < vlakken.size(); i++) {
            naam = vlakken.get(i).getNaam();
            if (naam.equals("Sleutel")) {
                sleutels++; // invoer
            }
        }
        // verwachte uitvoer == 4
        assertEquals(4, sleutels); // werkelijke uitvoer == 4
    }

    @Test
    void aantalMuren() {
        /*
         * In deze test wordt er gekeken of alle muren correct zijn geladen.
         */
        int muren = 0;
        String naam;

        for (int i = 0; i < vlakken.size(); i++) {
            naam = vlakken.get(i).getNaam();
            if (naam.equals("Muur")) {
                muren++; // invoer
            }
        }
        // verwachte uitvoer == 24
        assertEquals(24, muren); // werkelijke uitvoer == 24
    }

    @Test
    void aantalBarricades() {
        /*
         * In deze test wordt er gekeken of alle barricades correct zijn geladen.
         */
        int barricades = 0;
        String naam;

        for (int i = 0; i < vlakken.size(); i++) {
            naam = vlakken.get(i).getNaam();
            if (naam.equals("Barricade")) {
                barricades++; // invoer
            }
        }
        // verwachte uitvoer == 37
        assertEquals(37, barricades); // werkelijke uitvoer == 37
    }
}