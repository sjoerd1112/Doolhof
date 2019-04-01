package Doolhof.Classes;

import Doolhof.interfaces.KeyListener;

import java.awt.event.KeyEvent;

/**
 * Created by sjoer on 14-3-2019.
 */
public class MyKeyListener implements KeyListener {

    Speler speler = new Speler(); //nieuwe instance

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getKeyCode()==37){
            speler.beweeg(event);
        }
        else{
            if(event.getKeyCode()==38){
                speler.beweeg(event);
            }
            else{
                if(event.getKeyCode()==39){
                    speler.beweeg(event);
                }
                else{
                    if(event.getKeyCode()==40){
                        speler.beweeg(event);
                    }
                    else{
                        if(event.getKeyCode()==32){
                        }
                        else{
                            //System.out.println(event.getKeyChar());
                        }
                    }
                }
            }
        }
    }
}
