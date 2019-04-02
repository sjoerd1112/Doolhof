package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Barricade extends Vlak{

    private final int[][] locatie = { {3, 0, 300}, {0, 3, 100}, {2, 3, 200}, {2, 1, 200}, {3, 2, 200}, {5, 0, 200}, {7, 0, 300}, {4,1, 300}, {6,1, 300}, {8,1, 300}, {5,2, 300}, {7,2, 200}, {4,3, 200}, {6,3, 200}, {8,3, 300}, {1,4, 100}, {3,4, 100}, {5,4, 200}, {7,4, 200}, {0,5, 200}, {2,5, 200}, {4,5, 100}, {6,5, 300}, {8,5, 300}, {1,6, 100}, {3,6, 100}, {5,6, 200}, {7,6, 300}, {0,7, 100}, {2,7, 200}, {4,7, 200}, {6,7, 200}, {8,7, 200}, {1,8, 100}, {3,8, 100}, {5,8, 100}, {7,8, 100}};

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
