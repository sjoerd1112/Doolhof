package Doolhof.Classes;

import Doolhof.interfaces.KeyListener;

import javax.swing.*;
import java.awt.*;

public class main {

    private static JPanel panel; //nieuwe instance
    private static KeyListener listener;

    public static void main (String[] args) { //nieuwe methode
        JFrame frame = new JFrame("Doolhof");
        panel = new JPanel(new GridLayout(11, 10));
        listener = new MyKeyListener();

        new Speelveld(panel);
        new GamePanel(panel);

        panel.addKeyListener(listener);
        panel.setFocusable(true);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JPanel getPanel() { //nieuwe methode
        return panel;
    }

    public static void clearPanel(){
        panel.removeAll();
    }
}