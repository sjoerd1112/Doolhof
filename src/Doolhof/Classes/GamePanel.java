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
        for(int i = 0;i<19;i++){
            panel.add(new JLabel());
        }
    }

    public void startSpel()    {
        //hoi
    }

    public void opnieuwStarten()    {
        System.out.println("restart");
    }
}
