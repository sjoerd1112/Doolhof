package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speelveld {

    private int level;

    private final static ArrayList<Vlak> vlakken = new ArrayList<>(100);; //nieuwe instance

    private Sleutel sleutel = new Sleutel(); //nieuwe instance
    private Barricade barricade = new Barricade(); //nieuwe instance
    private Muur muur = new Muur(); //nieuwe instance

    public Speelveld(JPanel panel) { //nieuwe constructor
        startDoolHof(panel, 1);
    }

    public Speelveld() { //nieuwe instance

    }

    public void startOpnieuw(int level) { }

    public void setVlak(int index, Vlak vlak) { //nieuwe methode
        vlakken.set(index, vlak);
    }

    public ArrayList getVlakken() {
        return vlakken;
    }

    public void startDoolHof(JPanel panel, int level) { //nieuwe methode
        Vlak vlak;

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Point point = new Point(x, y);
                if (vlakken.size() <= 100) {
                    vlak = new leegVlak(point, "LeegVlak");
                    vlakken.add(vlak);
                } else {
                    System.out.println("Vlakken zijn al aangemaakt!");
                    break;
                }
            }
        }
        initializeSpeler();
        initializeBarricades();
        initializeSleutels();
        initializeMuren();
        initializeEindVeld();
        loadImages(panel);
        System.out.println("Size: " + vlakken.size());
    }

    public void initializeSpeler() { //nieuwe methode
        new Speler(vlakken.get(0).getPoint(), "Speler"); //0 = start positie, correcte code --> Associatie met Speelveld.
        //Speler is GEEN statisch object van het superklasse Vlak.
        //setVlak(0, new leegVlak(vlakken.get(0).getPoint(), "Speler")); //tijdelijk gebruikt voor test doeleinden
        System.out.println("coordinates Player: " + vlakken.get(0).getPoint());
    }

    public void initializeBarricades() { //nieuwe methode
        int index;

        for (int i = 0; i < barricade.getLocatie().length; i++) {
            index = (barricade.getLocatie()[i][1] * 10) + (barricade.getLocatie()[i][0]);
            setVlak(index, new Barricade(vlakken.get(index).getPoint(), "Barricade"));
        }
    }

    public void initializeSleutels() { //nieuwe methode
        int index;

        for (int i = 0; i < sleutel.getLocatie().length; i++) {
            index = (sleutel.getLocatie()[i][1] * 10) + (sleutel.getLocatie()[i][0]);
            setVlak(index, new Sleutel(vlakken.get(index).getPoint(), "Sleutel")); //
        }
    }

    public void initializeMuren() { //nieuwe methode
        int index;

        for (int i = 0; i < muur.getLocatie().length; i++) {
            index = (muur.getLocatie()[i][1] * 10) + (muur.getLocatie()[i][0]);
            setVlak(index, new Muur(vlakken.get(index).getPoint(), "Muur"));
        }
    }

    public void initializeEindVeld() { //nieuwe methode
        setVlak(99, new Eindveld(vlakken.get(99).getPoint(), "EindVeld"));
    }

    public void loadImages(JPanel panel) { //nieuwe methode
        int index_barricade = 0;
        int index_sleutel = 0;
        for (int i = 0; i < vlakken.size(); i++) {
            String naam = vlakken.get(i).getNaam();
            switch(naam) {
                case "LeegVlak":
                    panel.add(new JButton("X: " + vlakken.get(i).getPoint().getX() + " Y: " + vlakken.get(i).getPoint().getY()));
                    break;
                case "Speler":
                    panel.add(new JButton("Speler"));

                    break;
                case "Barricade":
                    //panel.add(new JButton("Barricade, " + barricade.getWaarde(index_barricade)));

                    JLabel label = new JLabel(String.valueOf(barricade.getWaarde(index_barricade)));
                    label.setIcon(barricade.getIcon());
                    panel.add(label);

                    index_barricade++;
                    break;
                case "Sleutel":
                    label = new JLabel(String.valueOf(sleutel.getWaarde(index_sleutel)));
                    label.setIcon(sleutel.getIcon());
                    panel.add(label);
                    //panel.add(new JButton("Sleutel, " + sleutel.getWaarde(index_sleutel) + ""));
                    index_sleutel++;
                    break;
                case "Muur":
                    label = new JLabel();
                    label.setIcon(muur.getIcon());
                    panel.add(label);

                    //panel.add(new JButton("Muur"));
                    break;
                case "EindVeld":
                    panel.add(new JButton("EindVeld"));
                    break;
            }
            //panel.add(new JLabel(vlak.getFoto()));
        }
    }
}
