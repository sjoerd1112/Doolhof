package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel {

    public GamePanel(JPanel panel)  {
        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opnieuwStarten();
            }
        });
        panel.add(restart);
        JButton nieuwSpel = new JButton("Nieuw spel");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nieuwSpel();
            }
        });
        panel.add(nieuwSpel);
    }

    public void nieuwSpel()    {
        System.out.println("Start een nieuw spel");
    }

    public void opnieuwStarten()    {
        System.out.println("Restart");
    }
}
