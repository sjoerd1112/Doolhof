package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Sleutel extends Vlak{

    private final int[][] locatie = { {1, 4, 300}, {2, 2, 200}, {5, 8, 100}}; //nieuwe array

    private ImageIcon icon = new ImageIcon(("key.jpg")); //nieuwe instance

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

    public ImageIcon getIcon() {
        icon = new ImageIcon(icon.getImage().getScaledInstance(102, 60, BufferedImage.SCALE_SMOOTH));
        return icon;
    }
}
