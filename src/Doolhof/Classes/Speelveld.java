package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speelveld {
    private int level;

    private static ArrayList<Point> posities = new ArrayList<>(100);
    private static ArrayList<Vlak> vlakken = new ArrayList<>(100);

    private ImageIcon foto = new ImageIcon(("vlak.jpg"));

    public void startOpnieuw(int level){

    }

    public void startDoolHof(JPanel panel, int level) { //nieuwe methode
        JLabel label;
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
                label = new JLabel(foto);
                panel.add(label);
                Point point = new Point(x, y);
                System.out.println("Index: " + posities.size());
                Vlak vlak = new Vlak(point, "Leegvlak");
                vlakken.add(vlak);
                posities.add(posities.size(), point);
                System.out.println("Location: " + point.getLocation());
                System.out.println("size:" + posities.size());
                System.out.println("Naam:" + vlak.getNaam());
            }
        }
    }

    public static void main (String[] args) { //nieuwe methode
        JFrame frame = new JFrame("Doolhof");
        JPanel panel = new JPanel();
        setup(panel);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setup(JPanel panel) { //nieuwe methode
        Speelveld doolhof= new Speelveld();
        Speler speler = new Speler();

        panel.setLayout(new GridLayout(10, 10));
        doolhof.startDoolHof(panel, 1);
        speler.createSpeler(panel);
    }

    /*public static void setup(){
        for(int i = 0;i<10;i++){
            for(int x = 0;x<10;x++){
                Point point = new Point(i,x);
                posities.add(point);
                String xString = String.valueOf(x);
                String iString = String.valueOf(i);
                String naam = iString+xString;
                //vlakken.add(new Vlak(point, naam));
            }
        }
    }

    public static void main(String[] args) {
        setup();
        for(int i = 0;i<posities.size();i++){
            System.out.println(posities.get(i));
            System.out.println(vlakken.get(i).getNaam());
        }
    }*/

    public void initializeBarricades() {

    }
}
