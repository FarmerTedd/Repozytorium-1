import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Farmer on 2017-04-13.
 */
public class Rekord extends JFrame  {

    private FileReader frGracz = null;
    private String nextLineGracz = "";

    private FileReader frRuchy = null;
    private String nextLineRuchy = "";

    public Rekord () throws IOException {
        setLayout(new GridBagLayout());

        JLabel pozycjaTytul = new JLabel("Pozycja  ");
        add(pozycjaTytul, new GBC(0,0));

        JLabel graczTytul = new JLabel("Gracz  ");
        add(graczTytul, new GBC(1,0));

        JLabel ruchyTytul = new JLabel("Liczba strzałów  ");
        add(ruchyTytul, new GBC(2,0));

        for(int i=1; i<11; i++){
            JLabel pozycja = new JLabel(i + ". ");
            add(pozycja, new GBC(0,i));
        }

        try{
            frGracz = new FileReader("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\rekord.txt");
        }catch (FileNotFoundException e){
            System.out.println("Błąd przy otwieraniu pliku");
            System.exit(1);
        }

        BufferedReader bfrGracz = new BufferedReader(frGracz);

        int nrLineGracz = 0;

        try {

            while ((nextLineGracz = bfrGracz.readLine()) != null) {

                nrLineGracz++;

                JLabel gracz = new JLabel(nextLineGracz);
                add(gracz, new GBC(1, nrLineGracz));
            }
        }catch(IOException e){
            System.out.println("Błąd odczytu pliku");
        }

        try{
            frGracz.close();
        }catch (IOException e){
            System.out.println("Błąd przy zamykaniu pliku");
        }

        try{
            frRuchy = new FileReader("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\ruchy.txt");
        }catch (FileNotFoundException e){
            System.out.println("Błąd przy otwieraniu pliku");
            System.exit(1);
        }

        BufferedReader bfrRuchy = new BufferedReader(frRuchy);

        int nrLineRuchy = 0;

        try {

            while ((nextLineRuchy = bfrRuchy.readLine()) != null) {

                nrLineRuchy++;

                JLabel ruchy = new JLabel(nextLineRuchy);
                add(ruchy, new GBC(2, nrLineRuchy));
            }
        }catch (IOException e){
            System.out.println("Błąd odczytu pliku");
        }

        try{
            frRuchy.close();
        }catch (IOException e){
            System.out.println("Błąd przy zamykaniu pliku");
        }


        pack();
    }
}