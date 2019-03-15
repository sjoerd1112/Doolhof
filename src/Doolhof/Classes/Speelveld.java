package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speelveld {
    private int level;

    private static ArrayList<Vlak> vlakken = new ArrayList<>(100);

    private static ArrayList<JLabel> label = new ArrayList<>(100); //nieuwe instance



    private ImageIcon foto; //nieuwe instance

    public Speelveld() { //nieuwe constructor

    }

    public void startOpnieuw(int level){

    }

    public ImageIcon setFoto(ImageIcon picture) { //nieuwe methode
        return foto = picture;
    }

    public ImageIcon getFoto() { //nieuwe methode
        return foto;
    }

    public void addJLabel(int index, JLabel jlabel) { //nieuwe methode
        label.add(index, jlabel);
    }

    public void addVlak(Vlak vlak) { //nieuwe methode
        vlakken.add(vlak);
    }

    public void startDoolHof(JPanel panel, int level) { //nieuwe methode
        setFoto(new ImageIcon(("vlak.jpg")));
        for (int i = 1; i < 100; i++) {
                label.add(i, new JLabel(getFoto()));
                panel.add(label.get(i));
        }
        System.out.println("size: " + label.size());

        Vlak vlak;
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
                /*if (vlakken.get(0).getNaam() == "Speler") {
                    System.out.println("Found..");
                    continue;
                }*/
                Point point = new Point(x, y);
                vlak = new Vlak(point, "Leegvlak");
                addVlak(vlak);
                System.out.println("Location: " + point.getLocation());
                System.out.println("size: " + vlakken.size());
                System.out.println("Naam:" + vlak.getNaam());
            }
        }
        System.out.println("Naam vlak: " + vlakken.get(0).getNaam());
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
        Speler speler = new Speler();

        speler.createSpeler(panel);
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
