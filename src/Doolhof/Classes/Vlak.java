package Doolhof.Classes;

import java.awt.*;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Vlak {
    private Point point;
    private String naam;

    public Vlak(Point point, String naam) {
        this.point = point;
        this.naam = naam;

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
}
