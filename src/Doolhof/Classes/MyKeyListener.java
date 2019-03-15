package Doolhof.Classes;

import Doolhof.interfaces.KeyListener;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by sjoer on 14-3-2019.
 */
public class MyKeyListener implements KeyListener {


    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getKeyCode()==37){
            System.out.println("left");
        }
        else{
            if(event.getKeyCode()==38){
                System.out.println("up");
            }
            else{
                if(event.getKeyCode()==39){
                    System.out.println("right");
                }
                else{
                    if(event.getKeyCode()==40){
                        System.out.println("down");
                    }
                    else{
                        if(event.getKeyCode()==32){
                            System.out.println("space");
                        }
                        else{
                            System.out.println(event.getKeyChar());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        KeyListener listener = new MyKeyListener();
        JFrame frame = new JFrame();
        JLabel label = new JLabel("text");
        frame.add(label);
        frame.addKeyListener(listener);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
