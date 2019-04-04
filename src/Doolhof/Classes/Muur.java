package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Muur extends Vlak{

    private static int[][] locatie;

    private ImageIcon icon = new ImageIcon(("wall.jpg")); //nieuwe instance

    public Muur(Point point, String naam) {
        super(point, naam);
    }

    public Muur() { } //nieuwe Constructor

    public int[][] getLocatie() { //nieuwe methode
        return locatie;
    }

    public static void setLocatie(int[][] loc){
        locatie = loc;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}