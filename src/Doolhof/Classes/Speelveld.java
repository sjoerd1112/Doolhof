package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speelveld {

    private int level;

    private final static ArrayList<JLabel> labels = new ArrayList<>(100);
    private final static ArrayList<Vlak> vlakken = new ArrayList<>(100);

    private Sleutel sleutel = new Sleutel(); //nieuwe instance
    private Barricade barricade = new Barricade(); //nieuwe instance
    private Muur muur = new Muur(); //nieuwe instance
    private Eindveld eindveld = new Eindveld(); //nieuwe instance
    private leegVlak leegvlak = new leegVlak(); //nieuwe instance
    private Speler speler; //nieuwe instance


    public Speelveld(JPanel panel) { //nieuwe constructor
        startDoolHof(panel, 1);
    }

    public Speelveld() { //nieuwe instance

    }

    public void startOpnieuw(int level) {
    }

    public void setVlak(int index, Vlak vlak) { //nieuwe methode
        vlakken.set(index, vlak);
    }

    public void setLabel(JPanel panel, int index_van, int index_naar, JLabel van, JLabel naar) {
        labels.set(index_van, van);
        labels.set(index_naar, naar);

        panel.revalidate();
        panel.repaint();
    }

    public ArrayList<Vlak> getVlakken() {
        return vlakken;
    }

    public ArrayList getLabels() { return labels; }

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
        initializeSpeler(panel);
        initializeBarricades();
        initializeSleutels();
        initializeMuren();
        initializeEindVeld();
        loadImages(panel);
        System.out.println("Vlakken size: " + vlakken.size());
    }

    private void initializeSpeler(JPanel panel) { //nieuwe methode
        speler = new Speler(vlakken.get(0).getPoint(), "Speler"); //0 = start positie, correcte code --> Associatie met Speelveld.
        setVlak(0, new leegVlak(vlakken.get(0).getPoint(), "Speler")); //leegVlak, want speler 'staat' op leegVlak
        //Speler is GEEN statisch object van het superklasse Vlak.
        //setVlak(0, new leegVlak(vlakken.get(0).getPoint(), "Speler")); //tijdelijk gebruikt voor test doeleinden
        System.out.println(speler);
        System.out.println("coordinates Player: " + vlakken.get(0).getPoint());
    }

    private void initializeBarricades() { //nieuwe methode
        int index;

        for (int i = 0; i < barricade.getLocatie().length; i++) {
            index = (barricade.getLocatie()[i][1] * 10) + (barricade.getLocatie()[i][0]);
            Barricade barricade = new Barricade(vlakken.get(index).getPoint(), "Barricade");
            barricade.setWaarde(barricade.getLocatie()[i][2]);
            setVlak(index, barricade);
        }
    }

    private void initializeSleutels() { //nieuwe methode
        int index;

        for (int i = 0; i < sleutel.getLocatie().length; i++) {
            index = (sleutel.getLocatie()[i][1] * 10) + (sleutel.getLocatie()[i][0]);
            Sleutel sleutel = new Sleutel(vlakken.get(index).getPoint(), "Sleutel");
            sleutel.setWaarde(sleutel.getLocatie()[i][2]);
            setVlak(index, sleutel);
        }
    }

    private void initializeMuren() { //nieuwe methode
        int index;

        for (int i = 0; i < muur.getLocatie().length; i++) {
            index = (muur.getLocatie()[i][1] * 10) + (muur.getLocatie()[i][0]);
            setVlak(index, new Muur(vlakken.get(index).getPoint(), "Muur"));
        }
    }

    private void initializeEindVeld() { //nieuwe methode
        setVlak(99, new Eindveld(vlakken.get(99).getPoint(), "EindVeld"));
    }

    private void loadImages(JPanel panel) { //nieuwe methode
        int index_barricade = 0;
        int index_sleutel = 0;
        JLabel label;
        for (int i = 0; i < vlakken.size(); i++) {
            String naam = vlakken.get(i).getNaam();
            switch(naam) {
                case "LeegVlak":
                    label = new JLabel(leegvlak.getIcon());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index leegvlak: " + i);
                    break;
                case "Speler":
                    label = new JLabel(speler.getIcon());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index speler: " + i);
                    break;
                case "Barricade":
                    label = new JLabel(barricade.getIcon());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index barricade: " + i);

                    index_barricade++;
                    break;
                case "Sleutel":
                    label = new JLabel();
                    Sleutel sleutel = (Sleutel) vlakken.get(i);
                    if (sleutel.getWaarde() == 100) {
                        label = new JLabel(sleutel.getIcon100());
                    } else if (sleutel.getWaarde() == 200) {
                        label = new JLabel(sleutel.getIcon200());
                    } else if (sleutel.getWaarde() == 300) {
                        label = new JLabel(sleutel.getIcon300());
                    }
                    System.out.println("Waarde sleutel: "+sleutel.getWaarde());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index sleutel: " + i);
                    index_sleutel++;
                    break;
                case "Muur":
                    label = new JLabel(muur.getIcon());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index muur: " + i);
                    break;
                case "EindVeld":
                    label = new JLabel(eindveld.getIcon());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index eindveld: " + i);
                    break;
            }
        }
        System.out.println("Labels size: " + labels.size());
    }


}