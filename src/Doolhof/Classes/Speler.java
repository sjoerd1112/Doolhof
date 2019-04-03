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
        System.out.println("Test " + naam);
    }

    public Speler() { //nieuwe Constructor

    }

    public String getNaam() { return naam; }

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

    public ImageIcon getIcon() {
        return icon;
    }

    public void beweeg(KeyEvent event){
        if (validMovement(event)) {
            JLabel speler;
            JLabel leegVlak;
            Vlak vlak;
            String vlakNaam;

            int keyCode = event.getKeyCode();
            int x = getPositieX();
            int y = getPositieY();
            int index = getPositieX() + (getPositieY() * 10);
            leegVlak = labels.get(index);

            switch (keyCode) {
                case 37: //left
                    vlak = vlakken.get((x - 1 + y*10));
                    vlakNaam = vlak.getNaam();
                    speler = labels.get(index - 1);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieX((x - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index - 1, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        pakSleutel(index-1);
                    } else if(vlakNaam.equals("EindVeld"))  {
                        setPositieX((x - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index - 1, index, speler, leegVlak);
                        showVictoryPopUp();
                    } else if(vlakNaam.equals("Barricade")){
                        Barricade barricade = (Barricade) vlak;
                        if(barricade.getWaarde() == inventory){
                            setPositieX((x - 1));
                            speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                            speler.setIcon(getIcon()); //veranderd foto
                            leegVlak.setIcon(leegvlak.getIcon());
                            speelveld.setLabel(panel, index - 1, index, speler, leegVlak);
                        }
                    }
                    break;
                case 39: //right
                    vlak = vlakken.get((x + 1 + y*10));
                    vlakNaam = vlak.getNaam();
                    speler = labels.get(index + 1);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieX((x + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index + 1, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        pakSleutel(index+1);
                    }else if(vlakNaam.equals("EindVeld"))  {
                        setPositieX((x + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index + 1, index, speler, leegVlak);
                        showVictoryPopUp();
                    }else if(vlakNaam.equals("Barricade")){
                        Barricade barricade = (Barricade) vlak;
                        if(barricade.getWaarde() == inventory) {
                            setPositieX((x + 1));
                            speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                            speler.setIcon(getIcon()); //veranderd foto
                            leegVlak.setIcon(leegvlak.getIcon());
                            speelveld.setLabel(panel, index + 1, index, speler, leegVlak);
                        }
                    }
                    break;
                case 38: //up
                    vlak = vlakken.get(((y - 1)*10 + x));
                    vlakNaam = vlak.getNaam();
                    speler = labels.get(index - 10);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieY((y - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index - 10, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        pakSleutel(index-10);
                    }else if(vlakNaam.equals("EindVeld"))  {
                        setPositieY((y - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index - 10, index, speler, leegVlak);
                        showVictoryPopUp();
                    }else if(vlakNaam.equals("Barricade")){
                        Barricade barricade = (Barricade) vlak;
                        if(barricade.getWaarde() == inventory) {
                            setPositieY((y - 1));
                            speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                            speler.setIcon(getIcon()); //veranderd foto
                            leegVlak.setIcon(leegvlak.getIcon());
                            speelveld.setLabel(panel, index - 10, index, speler, leegVlak);
                        }
                    }
                    break;
                case 40: //down
                    vlak = vlakken.get(((y + 1)*10 + x));
                    vlakNaam = vlak.getNaam();
                    speler = labels.get(index + 10);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieY((y + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon());
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index + 10, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        pakSleutel(index+10);
                    }else if(vlakNaam.equals("EindVeld"))  {
                        setPositieY((y + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon());
                        leegVlak.setIcon(leegvlak.getIcon());
                        speelveld.setLabel(panel, index + 10, index, speler, leegVlak);
                        showVictoryPopUp();
                    }else if(vlakNaam.equals("Barricade")){
                        Barricade barricade = (Barricade) vlak;
                        if(barricade.getWaarde() == inventory) {
                            setPositieY((y + 1));
                            speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                            speler.setIcon(getIcon());
                            leegVlak.setIcon(leegvlak.getIcon());
                            speelveld.setLabel(panel, index + 10, index, speler, leegVlak);
                        }
                    }
                    break;
            }
            System.out.println("Positie x: " + getPositieX());
            System.out.println("Positie y: " + getPositieY());
            System.out.println();
        } else {
            System.out.println("Movement negative");
        }
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
                Vlak naar = speelveld.getVlakken().get(index);

                if(naar.getNaam().equals("Sleutel")){
                    Sleutel sleutel = (Sleutel) speelveld.getVlakken().get(index);
                    inventory = sleutel.getWaarde();
                    GamePanel.setSleutelText(sleutel.getIcon(sleutel.getWaarde()));
                    System.out.println(getInventory());
                }
                speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                JLabel leegVlak = labels.get(index);
                leegVlak.setIcon(leegvlak.getIcon());
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