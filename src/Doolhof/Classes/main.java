package Doolhof.Classes;

import Doolhof.interfaces.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {

    private static JPanel panel; //nieuwe instance

    public static void main (String[] args) { //nieuwe methode
        JFrame frame = new JFrame("Doolhof");
        panel = new JPanel(new GridLayout(11, 10));
        KeyListener listener = new MyKeyListener();


        new Speelveld(panel);
        new GamePanel(panel);

        panel.addKeyListener(listener);
        panel.setFocusable(true);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static JPanel getPanel() { //nieuwe methode
        return panel;
    }

    public static void showPopUp(){

    }
    public static void showVictoryPopUp()   {
        final JFrame victory = new JFrame("Victory");
        JPanel vPanel = new JPanel();
        JButton vButton = new JButton("Je hebt gewonnen!");
        vButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                victory.dispose();
            }
        });
        victory.add(vPanel);
        victory.add(vButton);
    }

}
