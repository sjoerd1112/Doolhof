package Doolhof.Classes;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

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

    public void pakSleutel(){

    }

    public ImageIcon getIcon() {
        //icon = new ImageIcon(icon.getImage().getScaledInstance(60, 60, BufferedImage.SCALE_SMOOTH));
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
                    //System.out.println(vlakNaam);
                    //System.out.println(index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieX((x - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index - 1, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        showPopUp(index-1);
                    } else if(vlakNaam.equals("EindVeld"))  {
                        showVictoryPopUp();
                    }

                    break;
                case 39: //right
                    vlak = vlakken.get((x + 1 + y*10));
                    vlakNaam = vlak.getNaam();
                    //System.out.println(vlakNaam);
                    speler = labels.get(index + 1);
                    //System.out.println("index: " + index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieX((x + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index + 1, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                        showPopUp(index+1);
                    }else if(vlakNaam.equals("EindVeld"))  {
                        showVictoryPopUp();
                    }
                    break;
                case 38: //up
                    vlak = vlakken.get(((y - 1)*10 + x));
                    vlakNaam = vlak.getNaam();
                    //System.out.println(vlakNaam);
                    speler = labels.get(index - 10);
                    //System.out.println("index: " + index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieY((y - 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        speler.setIcon(getIcon()); //veranderd foto
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index - 10, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                            showPopUp(index-10);
                    }else if(vlakNaam.equals("EindVeld"))  {
                        showVictoryPopUp();
                    }
                    break;
                case 40: //down
                    vlak = vlakken.get(((y + 1)*10 + x));
                    vlakNaam = vlak.getNaam();
                    //System.out.println(vlakNaam);
                    speler = labels.get(index + 10);
                    //System.out.println("index: " + index);
                    if (vlakNaam.equals("LeegVlak")) {
                        setPositieY((y + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                        speler.setIcon(getIcon());
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index + 10, index, speler, leegVlak);
                    } else if(vlakNaam.equals("Sleutel")){
                            showPopUp(index+10);
                    }else if(vlakNaam.equals("EindVeld"))  {
                        showVictoryPopUp();
                        setPositieY((y + 1));
                        speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));

                        speler.setIcon(getIcon());
                        leegVlak.setIcon(leegvlak.getIcon());

                        speelveld.setLabel(panel, index + 10, index, speler, leegVlak);
                    }
                    break;
            }
            System.out.println("Positie x: " + getPositieX());
            System.out.println("Positie y: " + getPositieY());
            System.out.println("Movement positive");
            System.out.println();
        } else {
            System.out.println("Movement negative");
        }
    }

    private boolean validMovement(KeyEvent event) { //nieuwe methode (werkt naar behoren)
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

    public void showPopUp(final int ind){
        final JFrame sleutel = new JFrame("Sleutel");
        JPanel sPanel = new JPanel();
        JLabel sLabel = new JLabel("Wilt u de sleutel oppaken?");
        JButton sButton = new JButton("Ja");
        JButton sButton2 = new JButton("Nee");
        main.removeKeyListener();
        main.setFrameState(false);
        sPanel.add(sLabel);
        sPanel.add(sButton);
        sPanel.add(sButton2);
        sleutel.add(sPanel);
        sleutel.setSize(175,150);
        sleutel.pack();
        sleutel.setResizable(false);
        sleutel.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        sleutel.setLocationRelativeTo(null);
        sleutel.setVisible(true);

        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sleutel.dispose();
                main.setFrameState(true);
                main.setKeyListener();
                int index = ind;
                Vlak naar = speelveld.getVlakken().get(index);
                if(naar.getNaam().equals("Sleutel")){
                    Sleutel sleutel = (Sleutel) speelveld.getVlakken().get(index);
                    int sleutelWaarde = sleutel.getWaarde();
                    /*int x = index%10;
                    int newIndex = index - (index%10);
                    int y = newIndex/10;

                    int sleutelWaarde = 0;
                    int[][] locatie = Sleutel.getLocatie();
                    for(int i = 0; i<locatie.length;i++){
                        if(locatie[i][0]==x && locatie[i][1] == y){
                            sleutelWaarde = locatie[i][2];
                        }
                    }*/
                    inventory = sleutelWaarde;
                    System.out.println(getInventory());
                }
                speelveld.setVlak(index, new leegVlak(vlakken.get(index).getPoint(), "LeegVlak"));
                JLabel leegVlak = labels.get(index);
                leegVlak.setIcon(leegvlak.getIcon());
            }
        });

        sButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sleutel.dispose();
                main.setFrameState(true);
                main.setKeyListener();
            }
        });
    }

    public static void showVictoryPopUp()   {
        final JFrame victory = new JFrame("Victory");
        JPanel vPanel = new JPanel();
        JButton vButton = new JButton("Je hebt gewonnen!");
        vButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                victory.dispose();
            }
        });
        victory.add(vPanel);
        vPanel.add(vButton);
        victory.setVisible(true);
        victory.setSize(250, 100);
    }

}