package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Barricade extends Vlak{
    private int waarde;
    private ImageIcon foto_barricade = new ImageIcon(("barricade.jpg")); //nieuwe instance

    public Barricade(Point point, String naam) {
        super(point, naam);
    }

    public void createBarricade(JPanel vlak) { //nieuwe methode (NIET GOED)
        JLabel label;
        for (int i = 2; i <= 100; i++) {
            label = new JLabel(foto_barricade);
            vlak.add(label);
        }
    }
}
