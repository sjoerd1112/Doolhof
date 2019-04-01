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
        JButton nieuwSpel = new JButton("Nieuw\nspel");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nieuwSpel();
            }
        });
        panel.add(nieuwSpel);
        JLabel inventory = new JLabel("inventory:");
        panel.add(inventory);
        JLabel sleutel = new JLabel("leeg");
        panel.add(sleutel);

        restart.setFont(new Font("Arial", Font.PLAIN, 11));
        nieuwSpel.setFont(new Font("Arial", Font.PLAIN, 9));
        inventory.setFont(new Font("Arial", Font.PLAIN, 11));
        sleutel.setFont(new Font("Arial", Font.PLAIN, 11));
        inventory.setHorizontalAlignment(JLabel.CENTER);
        sleutel.setHorizontalAlignment(JLabel.CENTER);


    }

    public void nieuwSpel()    {
        System.out.println("Start een nieuw spel");
    }

    public void opnieuwStarten()    {
        System.out.println("Restart");
    }
}
