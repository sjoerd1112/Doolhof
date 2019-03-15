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

    private ImageIcon foto = new ImageIcon(("vlak.jpg")); //nieuwe instance

    public Speler(int positieX, int positieY) {
        this.positieX = positieX;
        this.positieY = positieY;
    }

    public Speler() { //nieuwe Constructor

    }

    public void createSpeler(JPanel speler) { //nieuwe methode(NOG NIET GOED)
        Speelveld speelveld = new Speelveld();
        Speelveld.setFoto(new ImageIcon(("vlak.jpg")));
        //speler.add(label);
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