package Doolhof.Classes;

import java.awt.*;
import javax.swing.*;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speler {
    private int positieX;
    private int positieY;
    private String inventory;

    public Speler(int positieX, int positieY) {
        this.positieX = positieX;
        this.positieY = positieY;
    }

    public Speler() { //nieuwe Constructor

    }

    public void createSpeler(JPanel speler) { //nieuwe methode(NOG NIET GOED)
        Speelveld speelveld = new Speelveld();
        speelveld.setFoto(new ImageIcon(("speler neutraal.jpg")));
        JLabel label = new JLabel(speelveld.getFoto());

        speelveld.addJLabel(0, label);
        speler.add(label);
        Point point = new Point(1, 1);
        Vlak vlak = new Vlak(point, "Speler");
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

    public void beweeg(){

    }

    public void checkMovement() {

    }
}