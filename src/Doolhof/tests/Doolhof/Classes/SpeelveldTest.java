/*package Doolhof.Classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.util.ArrayList;


class SpeelveldTest {

    private static Speelveld speelveld;
    private ArrayList<Vlak> vlakken = speelveld.getVlakken();

    @BeforeAll
    static void start() {
        speelveld = new Speelveld(new JPanel());
    }

    @Test
    void getVlakken() {
        assertEquals(100, vlakken.size());
    }

    @Test
    void aantalSleutels() {
        int sleutels = 0;
        String naam;

        for (int i = 0; i < vlakken.size(); i++) {
            naam = vlakken.get(i).getNaam();
            if (naam.equals("Sleutel")) {
                sleutels++;
            }
        }
        assertEquals(3, sleutels);
    }

    @Test
    void aantalMuren() {
        int muren = 0;
        String naam;

        for (int i = 0; i < vlakken.size(); i++) {
            naam = vlakken.get(i).getNaam();
            if (naam.equals("Muur")) {
                muren++;
            }
        }
        assertEquals(3, muren);
    }

    @Test
    void aantalBarricades() {
        int barricades = 0;
        String naam;

        for (int i = 0; i < vlakken.size(); i++) {
            naam = vlakken.get(i).getNaam();
            if (naam.equals("Barricade")) {
                barricades++;
            }
        }
        assertEquals(3, barricades);
    }
}*/