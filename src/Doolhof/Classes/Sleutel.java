package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


/**
 * Created by sjoer on 13-3-2019.
 */
public class Sleutel extends Vlak{

    private static final int[][] locatie = { {1, 4, 300}, {2, 2, 200}, {5, 8, 100}}; //nieuwe array

    private ImageIcon icon;



    private ImageIcon icon100 = new ImageIcon("key_100.png");
    private ImageIcon icon200 = new ImageIcon("key_200.png");
    private ImageIcon icon300 = new ImageIcon("key_300.png");

    public Sleutel(Point point, String naam) {
        super(point, naam);
    }

    public Sleutel() { } //nieuwe instance

    public static int[][] getLocatie() { //nieuwe methode
        return locatie;
    }

    public static int getWaarde(int index) { //nieuwe methode
        return locatie[index][2];
    }

    public ImageIcon getIcon100() {
        return icon100;
    }

    public ImageIcon getIcon200() {
        return icon200;
    }

    public ImageIcon getIcon300() {
        return icon300;
    }
}
