package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Eindveld extends Vlak{

    private static int[] locatie = {9,9};

    private ImageIcon icon = new ImageIcon(("flag.jpg")); //nieuwe instance

    public Eindveld(Point point, String naam) {
        super(point, naam);
    }

    public Eindveld() { }

    public ImageIcon getIcon() {
        return icon;
    }

    public static int[] getLocatie() {
        return locatie;
    }

    public static void setLocatie(int[] loc) {
        locatie = loc;
    }
}