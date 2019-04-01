package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sjoer on 13-3-2019.
 */
public class leegVlak extends Vlak{

    private ImageIcon icon = new ImageIcon(("wit_vlak.jpg")); //nieuwe instance

    public leegVlak(Point point, String naam) { super(point, naam);
    }

    public leegVlak() { } //nieuwe constructor

    public ImageIcon getIcon() {
        return icon;
    }
}
