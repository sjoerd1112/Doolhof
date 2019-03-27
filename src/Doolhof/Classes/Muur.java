package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Muur extends Vlak{

    private final int[][] locatie = { {1, 3}, {2, 1}, {5, 7}}; //nieuwe array

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
