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

    private ImageIcon icon = new ImageIcon(("barricade.jpg")); //nieuwe instance

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Barricade(Point point, String naam) {
        super(point, naam);
    }

    public Barricade() { } //nieuwe constructor

    public int[][] getLocatie() { //nieuwe methode
        return locatie;
    }

    public int getWaarde(int index) { //nieuwe methode
        return locatie[index][2];
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
