package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static Doolhof.Classes.main.showPopUp;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speler {

    private int positieX;
    private int positieY;

    private String naam; //nieuwe instance
    private String inventory;

    private Speelveld speelveld = new Speelveld(); //nieuwe constructor
    private ArrayList<Vlak> vlakken = speelveld.getVlakken(); //nieuwe instance
    private ArrayList<JLabel> labels = speelveld.getLabels();
    private JPanel panel = main.getPanel();
    private leegVlak leegvlak = new leegVlak(); //nieuwe instance

    private ImageIcon icon = new ImageIcon(("speler neutraal.jpg")); //nieuwe instance

    public Speler(Point point, String naam) { //nieuwe paramwter String naam
        positieX = (int) point.getX();
        positieY = (int) point.getY();
        this.naam = naam;
        System.out.println("Test " + naam);
    }

    public Speler() { //nieuwe Constructor

    }

    public int getPositieX() {
        return positieX;
    }

    public void setPositieX(int positieX) {
        this.positieX = positieX;
    }

    public int getPositieY() {
        return positieY;
    }

    public void setPositieY(int positieY) {
        this.positieY = positieY;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public void pakSleutel(){

    }

    public ImageIcon getIcon() {
        //icon = new ImageIcon(icon.getImage().getScaledInstance(60, 60, BufferedImage.SCALE_SMOOTH));
        return icon;
    }

    public void beweeg(KeyEvent event){
        if (validMovement(event)) {
            JLabel speler;
            JLabel leegVlak;
            Vlak vlak;
            String vlakNaam;

            int keyCode = event.getKeyCode();
            int x = getPositieX();
            int y = getPositieY();
            int index = getPositieX() + (getPositieY() * 10);
            leegVlak = labels.get(index);

            switch (keyCode) {
                case 37: //left
                    vlak = vlakken.get((x - 1 + y*10));
                    vlakNaam = vlak.getNaam();
                    speler = labels.get(index - 1);
                    //System.out.println(vlakNaam);
                    //System.out.println(index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieX((x - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index - 1, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        showPopUp();
                    } else if(vlakNaam.equals("Eindveld"))  {

                    }

                    break;
                case 39: //right
                    vlak = vlakken.get((x + 1 + y*10));
                    vlakNaam = vlak.getNaam();
                    //System.out.println(vlakNaam);
                    speler = labels.get(index + 1);
                    //System.out.println("index: " + index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieX((x + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index + 1, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        showPopUp();
                    }
                    break;
                case 38: //up
                    vlak = vlakken.get(((y - 1)*10 + x));
                    vlakNaam = vlak.getNaam();
                    //System.out.println(vlakNaam);
                    speler = labels.get(index - 10);
                    //System.out.println("index: " + index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieY((y - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index - 10, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                            showPopUp();
                    }
                    break;
                case 40: //down
                    vlak = vlakken.get(((y + 1)*10 + x));
                    vlakNaam = vlak.getNaam();
                    //System.out.println(vlakNaam);
                    speler = labels.get(index + 10);
                    //System.out.println("index: " + index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieY((y + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        System.out.println("index: " + (index + 10));

                        speler.setIcon(getIcon());
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index + 10, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                            showPopUp();
                    }
                    break;
            }
            System.out.println("Positie x: " + getPositieX());
            System.out.println("Positie y: " + getPositieY());
            System.out.println("Movement positive");
            System.out.println();
        } else {
            System.out.println("Movement negative");
        }
    }

    private boolean validMovement(KeyEvent event) { //nieuwe methode (werkt naar behoren)
        int code = event.getKeyCode();
        int x = getPositieX();
        int y = getPositieY();
        switch(code) {
            case 37: //left
                if ((x - 1) < 0) {
                    System.out.println("Kan niet meer naar links!");
                    return false;
                }
                return true;
            case 39: //right
                if ((x + 1) > 9) {
                    System.out.println("Kan niet meer naar rechts!");
                    return false;
                }
                return true;
            case 38: //up
                if ((y - 1) < 0) {
                    System.out.println("Kan niet meer omhoog!");
                    return false;
                }
                return true;
            case 40: //down
                if ((y + 1) > 9) {
                    System.out.println("Kan niet meer omlaag!");
                    return false;
                }
                return true;
        }
        return false;
    }

    private boolean pickup(){
        showPopUp();
        return true;
    }
}