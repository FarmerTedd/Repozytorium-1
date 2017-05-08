import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Farmer on 2017-04-13.
 */
public class ZapisWyniku extends JFrame {
    private String nameS;
    private JTextField name;
    private ArrayList<Integer> listaStrzalow;
    private ArrayList<String> listaGraczy;
    private int licznik;

    public  ZapisWyniku(int licznik){

        this.licznik = licznik;

        setLayout(new GridBagLayout());
        name = new JTextField("Podaj Imię");
        add(name, new GBC(0,0));

        JButton confirmation = new JButton("Zatwierdź");
        confirmation.addActionListener(new ButtonConfirmationAction());
        add(confirmation, new GBC(0,1));

        pack();
    }

    public class ButtonConfirmationAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {



            nameS = name.getText();

            listaStrzalow = new ArrayList<Integer>();
            listaGraczy = new ArrayList<String>();

            FileReader frRuchy = null;
            String nextLineRuchy = "";

            FileReader frGracze = null;
            String nextLineGracze = "";

            try{
                frRuchy = new FileReader("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\ruchy.txt");
                frGracze = new FileReader("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\rekord.txt");
            }catch (FileNotFoundException ev){
                System.out.println("Błąd przy otwieraniu pliku22");
                System.exit(1);
            }

            BufferedReader bfrRuchy = new BufferedReader(frRuchy);
            BufferedReader bfrGracze = new BufferedReader(frGracze);

            try {
                while ((nextLineRuchy = bfrRuchy.readLine()) != null) {

                    int strzaly = Integer.valueOf(nextLineRuchy);
                    listaStrzalow.add(strzaly);
                }
            }catch (Exception ev){};

            try{
                frRuchy.close();
            }catch (Exception ev){
                System.out.println("Błąd zamknięcia pliku");
            }

            try {
                while ((nextLineGracze = bfrGracze.readLine()) != null) {

                    listaGraczy.add(nextLineGracze);

                }
            }catch (Exception ev){};

            for(int i=0; i<listaStrzalow.size(); i++){
                if(licznik < listaStrzalow.get(i)){
                    listaStrzalow.add(i, licznik);
                    listaStrzalow.remove(10);

                    listaGraczy.add(i, nameS);
                    listaGraczy.remove(10);

                    break;
                }
            }

            try{
                frGracze.close();
            }catch(Exception ev){
                System.out.println("Błąd zamknięcia pliku");
            }

            FileWriter fwRuchy = null;
            String fwNextLineRuchy = "";

            FileWriter fwGracze = null;
            String fwNextLineGracze = "";

            try{
                fwRuchy = new FileWriter("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\ruchy.txt");
                fwGracze = new FileWriter("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\rekord.txt");
            }catch (Exception ev){
                System.out.println("Błąd przy zapisywaniu pliku");
                System.exit(1);
            }

            BufferedWriter bfwRuchy = new BufferedWriter(fwRuchy);
            BufferedWriter bfwGracze = new BufferedWriter(fwGracze);

            try{
                for(int i = 0; i<listaGraczy.size(); i++){
                    bfwGracze.write(listaGraczy.get(i));
                    bfwGracze.newLine();

                }
                bfwGracze.close();
            }catch (Exception ev){}

            try{
                for(int i = 0; i<listaStrzalow.size(); i++){
                    String lineS = String.valueOf(listaStrzalow.get(i));
                    bfwRuchy.write(lineS);
                    bfwRuchy.newLine();

                }
                bfwRuchy.close();
            }catch (Exception ev){};

            setVisible(false);
        }
    }
}
 /*nameS = name.getText();
            try {
                PrintWriter zapisImie = new PrintWriter("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\rekord.txt");
                zapisImie.write(nameS);
                zapisImie.close();

                PrintWriter zapisRuchy = new PrintWriter("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\ruchy.txt");
                int liczbaStrzalow = PanelGry.licznik;
                String liczbaStrzalowS = String.valueOf(liczbaStrzalow);

                zapisRuchy.write(liczbaStrzalowS);
                zapisRuchy.close();

                setVisible(false);

            }catch (Exception ev){};*/