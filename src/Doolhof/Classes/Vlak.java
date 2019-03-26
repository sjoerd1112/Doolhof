package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Vlak {
    private Point point;
    private String naam;

    public Vlak(Point point, String naam) {
        if (naam.equals("Speler")) {
            new Speler(point, naam);
        }
        this.point = point;
        this.naam = naam;
    }

    public Vlak () { // nieuwe Constructor
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getNaam() {
        return naam;
    }

    public String setNaam(String name) { return naam = name; } //nieuwe methode

}
