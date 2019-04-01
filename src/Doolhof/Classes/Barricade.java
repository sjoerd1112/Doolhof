package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Barricade extends Vlak{

    private final int[][] locatie = { {2, 4, 300}, {3, 2, 200}, {6, 8, 100}}; //nieuwe array

    private int waarde;

    private ImageIcon icon100 = new ImageIcon(("barricade_100.png")); //nieuwe instance
    private ImageIcon icon200 = new ImageIcon(("barricade_200.png"));
    private ImageIcon icon300 = new ImageIcon(("barricade_300.png"));
    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public Barricade(Point point, String naam) {
        super(point, naam);
    }

    public Barricade() { } //nieuwe constructor

    public int[][] getLocatie() { //nieuwe methode
        return locatie;
    }

    public ImageIcon getIcon(int waarde) {
        if (waarde == 100) {
            return icon100;
        } else if (waarde == 200) {
            return icon200;
        } else  {
            return icon300;
        }
    }
}
