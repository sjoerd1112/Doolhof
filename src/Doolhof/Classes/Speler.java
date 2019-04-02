package Doolhof.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by sjoer on 13-3-2019.
 */
public class Speler {

    private int positieX;
    private int positieY;

    private String naam; //nieuwe instance
    private int inventory;

    private Speelveld speelveld = new Speelveld(); //nieuwe constructor
    private ArrayList<Vlak> vlakken = speelveld.getVlakken(); //nieuwe instance
    private ArrayList<JLabel> labels = speelveld.getLabels();
    private JPanel panel = main.getPanel();
    private leegVlak leegvlak = new leegVlak(); //nieuwe instance

    private ImageIcon icon = new ImageIcon(("speler neutraal.jpg")); //nieuwe instance

    public Speler(Point point, String naam) { //nieuwe paramwter String naam
        positieX = (int) point.getX();
        positieY = (int) point.getY();
        this.naam = naam;
        System.out.println(naam);
    }

    public Speler() { //nieuwe Constructor

    }

    public int getPositieX() {
        return positieX;
    }

    public void setPositieX(int positieX) {
        this.positieX = positieX;
    }

    public int getPositieY() {
        return positieY;
    }

    public void setPositieY(int positieY) {
        this.positieY = positieY;
    }

    public int getInventory() {
        return inventory;
    }

    public int setInventory(int waarde) { return inventory = waarde; }

    public ImageIcon getIcon() {
        return icon;
    }

    public void beweeg(KeyEvent event){
        if (validMovement(event)) {
            JLabel speler;
            JLabel leegVlak;
            Vlak vlak;

            int keyCode = event.getKeyCode();
            int x = getPositieX();
            int y = getPositieY();
            int index = getPositieX() + (getPositieY() * 10);
            leegVlak = labels.get(index);

            switch (keyCode) {
                case 37: //left
                    vlak = vlakken.get(index - 1);
                    speler = labels.get(index - 1);
                    if (vlak.getNaam().equals("LeegVlak")) {
                        setPositieX((x - 1));
                        replace(panel, index, index -1, leegVlak, speler);
                    } else if (vlak.getNaam().equals("Sleutel")) {
                        pakSleutel(index-1);
                    } else if (vlak.getNaam().equals("EindVeld"))  {
                        setPositieX((x - 1));
                        replace(panel, index, index -1, leegVlak, speler);
                        showVictoryPopUp();
                    } else if (vlak.getNaam().equals("Barricade")) {
                        if(controleerWaarde((Barricade) vlak)){
                            setPositieX((x - 1));
                            replace(panel, index, index -1, leegVlak, speler);
                        }
                    }
                    break;
                case 39: //right
                    vlak = vlakken.get(index + 1);
                    speler = labels.get(index + 1);
                    if (vlak.getNaam().equals("LeegVlak")) {
                        setPositieX((x + 1));
                        replace(panel, index, index + 1, leegVlak, speler);
                    } else if (vlak.getNaam().equals("Sleutel")) {
                        pakSleutel(index+1);
                    } else if (vlak.getNaam().equals("EindVeld")) {
                        setPositieX((x + 1));
                        replace(panel, index, index + 1, leegVlak, speler);
                        showVictoryPopUp();
                    } else if (vlak.getNaam().equals("Barricade")) {
                        if (controleerWaarde((Barricade) vlak)) {
                            setPositieX((x + 1));
                            replace(panel, index, index + 1, leegVlak, speler);
                        }
                    }
                    break;
                case 38: //up
                    vlak = vlakken.get(index - 10);
                    speler = labels.get(index - 10);
                    if (vlak.getNaam().equals("LeegVlak")) {
                        setPositieY((y - 1));
                        replace(panel, index, index - 10, leegVlak, speler);
                    } else if(vlak.getNaam().equals("Sleutel")) {
                        pakSleutel(index-10);
                    } else if(vlak.getNaam().equals("EindVeld")) {
                        setPositieY((y - 1));
                        replace(panel, index, index - 10, leegVlak, speler);
                        showVictoryPopUp();
                    } else if(vlak.getNaam().equals("Barricade")) {
                        if (controleerWaarde((Barricade) vlak)) {
                            setPositieY((y - 1));
                            replace(panel, index, index - 10, leegVlak, speler);
                        }
                    }
                    break;
                case 40: //down
                    vlak = vlakken.get(index + 10);
                    speler = labels.get(index + 10);
                    if (vlak.getNaam().equals("LeegVlak")) {
                        setPositieY((y + 1));
                        replace(panel, index, index + 10, leegVlak, speler);
                    } else if (vlak.getNaam().equals("Sleutel")) {
                        pakSleutel(index+10);
                    } else if (vlak.getNaam().equals("EindVeld"))  {
                        setPositieY((y + 1));
                        replace(panel, index, index + 10, leegVlak, speler);
                        showVictoryPopUp();
                    } else if (vlak.getNaam().equals("Barricade")){
                        if (controleerWaarde((Barricade) vlak)) {
                            setPositieY((y + 1));
                            replace(panel, index, index + 10, leegVlak, speler);
                        }
                    }
                    break;
            }
        }
    }

    public boolean controleerWaarde(Barricade barricade) {
        if (barricade.getWaarde() == inventory) {
            return true;
        }
        return false;
    }

    private void replace(JPanel panel, int index_van, int index_naar, JLabel empty_vlak, JLabel speler){
        speelveld.setVlak(index_van, new leegVlak(vlakken.get(index_van).getPoint(), "LeegVlak"));
        empty_vlak.setIcon(leegvlak.getIcon());
        speler.setIcon(getIcon());

        labels.set(index_van, empty_vlak);
        labels.set(index_naar, speler);
        panel.revalidate();
        panel.repaint();
    }

    public boolean validMovement(KeyEvent event) { //nieuwe methode (werkt naar behoren)
        int code = event.getKeyCode();
        int x = getPositieX();
        int y = getPositieY();
        switch(code) {
            case 37: //left
                if ((x - 1) < 0) {
                    System.out.println("Kan niet meer naar links!");
                    return false;
                }
                return true;
            case 39: //right
                if ((x + 1) > 9) {
                    System.out.println("Kan niet meer naar rechts!");
                    return false;
                }
                return true;
            case 38: //up
                if ((y - 1) < 0) {
                    System.out.println("Kan niet meer omhoog!");
                    return false;
                }
                return true;
            case 40: //down
                if ((y + 1) > 9) {
                    System.out.println("Kan niet meer omlaag!");
                    return false;
                }
                return true;
        }
        return false;
    }

    public void pakSleutel(final int index){
        JButton[] button = new JButton[2];
        button[0] = new JButton("Ja");
        button[1] = new JButton("Nee");

        button[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();

                Sleutel sleutel = (Sleutel) speelveld.getVlakken().get(index);
                inventory = sleutel.getWaarde();
                GamePanel.setSleutelText(sleutel.getIcon(sleutel.getWaarde()));

                speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                JLabel leegVlak = labels.get(index);
                leegVlak.setIcon(leegvlak.getIcon());
                labels.set(index, leegVlak);
            }
        });

        button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
            }
        });

        JOptionPane.showOptionDialog(null, "Wilt u de sleutel oppakken?", "Sleutel",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, null);

        //bron: https://stackoverflow.com/questions/13334198/java-custom-buttons-in-showinputdialog
    }

    public void showVictoryPopUp()   {
        JButton[] options = new JButton[2];
        options[0] = new JButton("Ok");
        options[1] = new JButton("Start opnieuw");

        options[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.getRootFrame().dispose();
            }
        });

        JOptionPane.showOptionDialog(null, "Je hebt gewonnen!", "Victory", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, new ImageIcon("victory.jpg"), options, null);

    }
}