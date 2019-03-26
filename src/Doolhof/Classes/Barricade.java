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

    private ImageIcon icon = new ImageIcon(("barricade.jpg")); //nieuwe instance

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
        icon = new ImageIcon(icon.getImage().getScaledInstance(102, 60, BufferedImage.SCALE_SMOOTH));
        return icon;
    }
}
