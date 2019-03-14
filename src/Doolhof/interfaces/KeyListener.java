package Doolhof.interfaces;

import java.awt.event.KeyEvent;

/**
 * Created by sjoer on 14-3-2019.
 */
public interface KeyListener extends java.awt.event.KeyListener {
    void keyTyped(KeyEvent event);
    void keyReleased(KeyEvent event);
    void keyPressed(KeyEvent event);
}
