package Doolhof.Classes;

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
}