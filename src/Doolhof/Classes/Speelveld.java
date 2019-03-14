package Doolhof.Classes;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speelveld {
    private int level;
    private static ArrayList<Point> posities = new ArrayList<>(100);
    private static ArrayList<Vlak> vlakken = new ArrayList<>(100);

    public void startOpnieuw(int level){

    }

    public static void setup(){
        for(int i = 0;i<10;i++){
            for(int x = 0;x<10;x++){
                Point point = new Point(i,x);
                posities.add(point);
                String xString = String.valueOf(x);
                String iString = String.valueOf(i);
                String naam = iString+xString;
                vlakken.add(new Vlak(point, naam));
            }
        }
    }

    public static void main(String[] args) {
        setup();
        for(int i = 0;i<posities.size();i++){
            System.out.println(posities.get(i));
            System.out.println(vlakken.get(i).getNaam());
        }
    }
}
