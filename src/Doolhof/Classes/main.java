package Doolhof.Classes;

import Doolhof.interfaces.KeyListener;
import javax.swing.*;
import java.awt.*;

public class main {

    public static void main (String[] args) { //nieuwe methode
        JFrame frame = new JFrame("Doolhof");
        JPanel panel = new JPanel(new GridLayout(12, 10));
        KeyListener listener = new MyKeyListener();

        new GamePanel(panel);
        new Speelveld(panel);

        panel.addKeyListener(listener);
        panel.setFocusable(true);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
