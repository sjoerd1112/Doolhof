package Doolhof.Classes;

import java.awt.*;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Sleutel extends Vlak{

    private final int[][] locatie = { {1, 4, 300}, {2, 2, 200}, {5, 8, 100}}; //nieuwe array

    public Sleutel(Point point, String naam) {
        super(point, naam);
    }

    public Sleutel() { } //nieuwe instance

    public int[][] getLocatie() { //nieuwe methode
        return locatie;
    }

    public int getWaarde(int index) { //nieuwe methode
        return locatie[index][2];
    }
}
