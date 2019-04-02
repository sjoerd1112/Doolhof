package Doolhof.Classes;

import Doolhof.interfaces.KeyListener;

import java.awt.event.KeyEvent;

/**
 * Created by sjoer on 14-3-2019.
 */
public class MyKeyListener implements KeyListener {

    private Speler speler = new Speler(); //nieuwe instance

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        int code = event.getKeyCode();
        switch (code) {
            case 37: //left
            case 38: //up
            case 39: //right
            case 40: //down
                speler.beweeg(event);
                break;
        }
    }
}
