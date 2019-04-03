package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speelveld {

    private static int level;

    private final static ArrayList<JLabel> labels = new ArrayList<>(100);
    private final static ArrayList<Vlak> vlakken = new ArrayList<>(100);

    private static Sleutel sleutel = new Sleutel(); //nieuwe instance
    private static Barricade barricade = new Barricade(); //nieuwe instance
    private static Muur muur = new Muur(); //nieuwe instance
    private static Eindveld eindveld = new Eindveld(); //nieuwe instance
    private static leegVlak leegvlak = new leegVlak(); //nieuwe instance
    private static Speler speler; //nieuwe instance


    public Speelveld(JPanel panel) { //nieuwe constructor
        startDoolHof(panel, -1);
    }

    public Speelveld() { //nieuwe instance

    }

    public static void startOpnieuw(int level) {
        startDoolHof(main.getPanel(), level);
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int lvl){
        level = lvl;
    }

    public static void setVlak(int index, Vlak vlak) { //nieuwe methode
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

    public static void startDoolHof(JPanel panel, int level) { //nieuwe methode
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
        if(level == -1){
            levels.getLevel();
        }
        else {
            levels.getLevel(level);
        }
        initializeSpeler(panel);
        initializeBarricades();
        initializeSleutels();
        initializeMuren();
        initializeEindVeld();
        loadImages(panel);
        System.out.println("Vlakken size: " + vlakken.size());
    }

    private static void initializeSpeler(JPanel panel) { //nieuwe methode
        int index = (Speler.getLocatie()[0])+(Speler.getLocatie()[1]*10);
        speler = new Speler(vlakken.get(index).getPoint(), "Speler"); //0 = start positie, correcte code --> Associatie met Speelveld.
        setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "Speler")); //leegVlak, want speler 'staat' op leegVlak
        //Speler is GEEN statisch object van het superklasse Vlak.
        //setVlak(0, new leegVlak(vlakken.get(0).getPoint(), "Speler")); //tijdelijk gebruikt voor test doeleinden
    }

    private static void initializeBarricades() { //nieuwe methode
        int index;

        for (int i = 0; i < barricade.getLocatie().length; i++) {
            index = (barricade.getLocatie()[i][1] * 10) + (barricade.getLocatie()[i][0]);
            Barricade barricade = new Barricade(vlakken.get(index).getPoint(), "Barricade");
            barricade.setWaarde(barricade.getLocatie()[i][2]);
            setVlak(index, barricade);
        }
    }

    private static void initializeSleutels() { //nieuwe methode
        int index;

        for (int i = 0; i < sleutel.getLocatie().length; i++) {
            index = (sleutel.getLocatie()[i][1] * 10) + (sleutel.getLocatie()[i][0]);
            Sleutel sleutel = new Sleutel(vlakken.get(index).getPoint(), "Sleutel");
            sleutel.setWaarde(sleutel.getLocatie()[i][2]);
            setVlak(index, sleutel);
        }
    }

    private static void initializeMuren() { //nieuwe methode
        int index;

        for (int i = 0; i < muur.getLocatie().length; i++) {
            index = (muur.getLocatie()[i][1] * 10) + (muur.getLocatie()[i][0]);
            setVlak(index, new Muur(vlakken.get(index).getPoint(), "Muur"));
        }
    }

    private static void initializeEindVeld() { //nieuwe methode
        int index = (Eindveld.getLocatie()[0])+(Eindveld.getLocatie()[1]*10);
        setVlak(index, new Eindveld(vlakken.get(index).getPoint(), "EindVeld"));
    }

    private static void loadImages(JPanel panel) { //nieuwe methode
        JLabel label;

        for (int i = 0; i < vlakken.size(); i++) {
            String naam = vlakken.get(i).getNaam();
            switch(naam) {
                case "LeegVlak":
                    label = new JLabel(leegvlak.getIcon());
                    panel.add(label);
                    labels.add(i, label);
                    break;
                case "Speler":
                    label = new JLabel(speler.getIcon());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index speler: " + i);
                    break;
                case "Barricade":
                    label = new JLabel();
                    Barricade barricade = (Barricade) vlakken.get(i);
                    if (barricade.getWaarde() == 100) {
                        label = new JLabel(barricade.getIcon(100));
                    } else if (barricade.getWaarde() == 200) {
                        label = new JLabel(barricade.getIcon(200));
                    } else if (barricade.getWaarde() == 300) {
                        label = new JLabel(barricade.getIcon(300));
                    }
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index barricade: " + i);
                    break;
                case "Sleutel":
                    label = new JLabel();
                    Sleutel sleutel = (Sleutel) vlakken.get(i);
                    if (sleutel.getWaarde() == 100) {
                        label = new JLabel(sleutel.getIcon(100));
                    } else if (sleutel.getWaarde() == 200) {
                        label = new JLabel(sleutel.getIcon(200));
                    } else if (sleutel.getWaarde() == 300) {
                        label = new JLabel(sleutel.getIcon(300));
                    }
                    System.out.println("Waarde sleutel: "+sleutel.getWaarde());
                    panel.add(label);
                    labels.add(i, label);
                    System.out.println("Index sleutel: " + i);
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
    }


}