package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
                //nieuwSpel();
                Speelveld.nieuwSpel(-1);
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
        Speelveld.startDoolHof(main.getPanel(),-1);
        ArrayList<Vlak> vlakken = Speelveld.getVlakken();
        System.out.println(vlakken.get(100));
    }

    public void opnieuwStarten()    {
        levels.getLevel(Speelveld.getLevel());
    }
}
