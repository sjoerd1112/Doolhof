package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel {

    private static JLabel sleutel = new JLabel("leeg");

    public GamePanel(JPanel panel) {
        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opnieuwStarten();
            }
        });
        panel.add(restart);
        JButton nieuwSpel = new JButton("<html>" + "Nieuw" + "<br>" + "spel" + "</html>");
        nieuwSpel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nieuwSpel();
            }
        });
        panel.add(nieuwSpel);
        JLabel inventoryText = new JLabel("inventory:");
        panel.add(inventoryText);
        panel.add(sleutel);

        restart.setFont(new Font("Arial", Font.PLAIN, 11));
        nieuwSpel.setFont(new Font("Arial", Font.PLAIN, 11));
        inventoryText.setFont(new Font("Arial", Font.PLAIN, 11));
        sleutel.setFont(new Font("Arial", Font.PLAIN, 11));
        inventoryText.setHorizontalAlignment(JLabel.CENTER);
        sleutel.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void setSleutelText(ImageIcon icon) {
        GamePanel.sleutel.setIcon(icon);
    }

    public void nieuwSpel()    {
        System.out.println("Start een nieuw spel");
    }

    public void opnieuwStarten()    {
        System.out.println("Restart");
    }
}
