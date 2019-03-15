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

    private static ArrayList<JLabel> label = new ArrayList<>(100); //nieuwe instance

    private static ImageIcon foto; //nieuwe instance

    public Speelveld() { //nieuwe constructor

    }

    public void startOpnieuw(int level){

    }

    public static ImageIcon setFoto(ImageIcon picture) { //nieuwe methode
        return foto = picture;
    }

    public static ImageIcon getFoto() { //nieuwe methode
        return foto;
    }

    public static JLabel getJLabel(int index) { //nieuwe methode
        return label.get(index);
    }

    public void startDoolHof(JPanel panel, int level) { //nieuwe methode
        Speler speler = new Speler();
        //speler.createSpeler(panel);

        setFoto(new ImageIcon(("vlak.jpg")));
        for (int i = 0; i < 100; i++) {
                label.add(i, new JLabel(getFoto()));
                panel.add(label.get(i));
        }
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
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
        JPanel panel = new JPanel(new GridLayout(10, 10));
        setup(panel);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setup(JPanel panel) { //nieuwe methode
        Speelveld doolhof= new Speelveld();

        doolhof.startDoolHof(panel, 1);
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
