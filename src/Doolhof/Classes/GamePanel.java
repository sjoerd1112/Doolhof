package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;

public class GamePanel {

    public GamePanel(JPanel panel)  {
        panel.add(new JButton("Restart"));
        for(int i = 0;i<19;i++){
            panel.add(new JLabel());
        }
    }

    public void startSpel()    {
        //hoi
    }

    public void opnieuwStarten()    {

    }
}
