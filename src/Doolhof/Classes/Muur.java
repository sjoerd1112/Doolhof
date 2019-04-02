package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Muur extends Vlak{

    private final int[][] locatie = { {1, 1}, {1, 3}, {1, 5}, {1, 7}, {1, 9}, {3, 1}, {3, 3}, {3, 5}, {3, 7}, {3, 9}, {5, 1}, {5, 3}, {5, 5}, {5, 7}, {5, 9}, {7, 1}, {7, 3}, {7, 5}, {7, 7}, {7, 9}, {9, 1}, {9, 3}, {9, 5}, {9, 7}, {9, 9}}; //nieuwe array

    private ImageIcon icon = new ImageIcon(("wall.jpg")); //nieuwe instance

    public Muur(Point point, String naam) {
        super(point, naam);
    }

    public Muur() { } //nieuwe Constructor

    public int[][] getLocatie() { //nieuwe methode
        return locatie;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
