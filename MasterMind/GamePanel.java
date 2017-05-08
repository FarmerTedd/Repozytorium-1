import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Farmer on 2017-04-19.
 */
public class GamePanel extends JPanel {

    private JComboBox<String> colorList1;
    private JComboBox<String> colorList2;
    private JComboBox<String> colorList3;
    private JComboBox<String> colorList4;
    private JButton check;
    private SprawdzaczKolorów sprawdzaczKolorów;
    private int licznik;

    private Toolkit kit;
    private Dimension screenSize;
    private int screenWidth ;
    private int screenHeight ;

    public int getLicznik(){
        return licznik;
    }

    public GamePanel(){

        kit = Toolkit.getDefaultToolkit();

        setLayout(new GridBagLayout());
        screenSize = kit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;

        //ustawienie licznika na 0
        licznik = 0;

        //dodanie nagłowka z nazwą gry
        Font headFont = new Font("Helvetica", Font.BOLD, screenHeight/23);
        JLabel head = new JLabel("Master Mind - Pokaż, że potrafisz");
        head.setFont(headFont);
        head.setOpaque(true);
        head.setBackground(Color.MAGENTA);
        Dimension headSize = new Dimension(screenWidth,screenHeight/14);
        head.setPreferredSize(headSize);
        head.setHorizontalAlignment(SwingConstants.CENTER);
        add(head, new GBC(0,0,10,1));

        //dodanie przycisku, który będzie zatwierdzał wybórm kolorów
        check = new JButton("Sprawdź");
        check.addActionListener(new CheckButton());
        Dimension checkSize = new Dimension(screenWidth,screenHeight/23);
        check.setPreferredSize(checkSize);
        add(check, new GBC(0,1,10,1));

        //dodanie rozmiaru poszczegolnych pól
        Dimension colorListSize = new Dimension(screenWidth/5,screenHeight/23);
        Dimension positionSize = new Dimension(50,screenHeight/(26));

        //dodanie pierwszej listy rozwijalnej z wyborem kolorów
        colorList1 = new JComboBox<>();
        colorList1.addItem("czarny");
        colorList1.addItem("biały");
        colorList1.addItem("czerwony");
        colorList1.addItem("zielony");
        colorList1.addItem("żółty");
        colorList1.addItem("niebieski");

        add(colorList1,new GBC(1,2).setInsets(2));

        //dodanie drugiej listy rozwijalnej z wyborem kolorów
        colorList2 = new JComboBox<>();
        colorList2.addItem("czarny");
        colorList2.addItem("biały");
        colorList2.addItem("czerwony");
        colorList2.addItem("zielony");
        colorList2.addItem("żółty");
        colorList2.addItem("niebieski");

        add(colorList2,new GBC(2,2).setInsets(2));

        //dodanie trzeciej listy rozwijalnej z wyborem kolorów
        colorList3 = new JComboBox<>();
        colorList3.addItem("czarny");
        colorList3.addItem("biały");
        colorList3.addItem("czerwony");
        colorList3.addItem("zielony");
        colorList3.addItem("żółty");
        colorList3.addItem("niebieski");

        add(colorList3,new GBC(3,2).setInsets(2));

        //dodanie czwartej listy rozwijalnej z wyborem kolorów
        colorList4 = new JComboBox<>();
        colorList4.addItem("czarny");
        colorList4.addItem("biały");
        colorList4.addItem("czerwony");
        colorList4.addItem("zielony");
        colorList4.addItem("żółty");
        colorList4.addItem("niebieski");

        //ustawienie rozmiarów
        colorList1.setPreferredSize(colorListSize);
        colorList2.setPreferredSize(colorListSize);
        colorList3.setPreferredSize(colorListSize);
        colorList4.setPreferredSize(colorListSize);

        add(colorList4,new GBC(4,2).setInsets(2));

        //dodanie pol numerujących próby

        for(int i=1; i<21; i++){
            JLabel position = new JLabel(String.valueOf(i));
            position.setPreferredSize(positionSize);
            position.setHorizontalAlignment(SwingConstants.CENTER);
            position.setForeground(Color.RED);
            position.setFont(new Font("",Font.BOLD,screenHeight/30));
            add(position, new GBC(0,i+3,1,1));
        }

        // stowrzenie obiektu z listą losowych kolorów i z metodą sprawdzającą
        sprawdzaczKolorów = new SprawdzaczKolorów();

    }

    class CheckButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //licznik o jeden do przodu
            licznik++;

            //lista kolorów wybranych przez gracza
            ArrayList<String> colorsSelected = new ArrayList<>();

            //z czytanie i konwersja na Stringa kolorów wybranych przez gracza
            String color1 = String.valueOf(colorList1.getSelectedItem());
            String color2 = String.valueOf(colorList2.getSelectedItem());
            String color3 = String.valueOf(colorList3.getSelectedItem());
            String color4 = String.valueOf(colorList4.getSelectedItem());

            //dodanie kolorów do listy
            colorsSelected.add(color1);
            colorsSelected.add(color2);
            colorsSelected.add(color3);
            colorsSelected.add(color4);

            //lista kolorów typu Color wybranych przez gracza
            ArrayList<Color> colorsList = colorColor(colorsSelected);
            Color background1 = colorsList.get(0);
            Color background2 = colorsList.get(1);
            Color background3 = colorsList.get(2);
            Color background4 = colorsList.get(3);

            //rozmiar label'a pokazującego wybrany kolor przez gracza
            Dimension labelSize = new Dimension(colorList1.getWidth(),screenHeight/30);

            //dodanie lebel'ów pokazujących wybrane kolory przez gracza
            JLabel label1 = new JLabel();
            JLabel label2 = new JLabel();
            JLabel label3 = new JLabel();
            JLabel label4 = new JLabel();

            //ustawienie wymirów
            label1.setPreferredSize(labelSize);
            label2.setPreferredSize(labelSize);
            label3.setPreferredSize(labelSize);
            label4.setPreferredSize(labelSize);

            // ustawienie widoczności tła
            label1.setOpaque(true);
            label2.setOpaque(true);
            label3.setOpaque(true);
            label4.setOpaque(true);

            //dodanie koloró tła
            label1.setBackground(background1);
            label2.setBackground(background2);
            label3.setBackground(background3);
            label4.setBackground(background4);

            //dodanie labal'ów do panelu
            add(label1,new GBC(1,licznik+3).setInsets(2));
            add(label2,new GBC(2,licznik+3).setInsets(2));
            add(label3,new GBC(3,licznik+3).setInsets(2));
            add(label4,new GBC(4,licznik+3).setInsets(2));

            //dodanie lebel'ów informujących ile gracz trafił kolorów

            boolean isSolve = sprawdzaczKolorów.sprawdzenie(colorsSelected);
            int iloscNaP = sprawdzaczKolorów.getLiczbaNaP();

            int positionX=0;

            for(int i=0; i<iloscNaP; i++){
                JLabel wynikNaP = new JLabel();
                wynikNaP.setOpaque(true);
                wynikNaP.setBackground(Color.BLACK);
                wynikNaP.setPreferredSize(new Dimension(screenWidth/100,screenHeight/100));
                add(wynikNaP, new GBC(5+i,licznik+3).setInsets(15,30,15,30));
                positionX = i+1;
            }

            int iloscBP = sprawdzaczKolorów.getLiczbaBezP();

            for(int i=0; i<iloscBP; i++){
                JLabel wynikBP = new JLabel();
                wynikBP.setOpaque(true);
                wynikBP.setBackground(Color.WHITE);
                wynikBP.setPreferredSize(new Dimension(screenWidth/100,screenHeight/100));
                add(wynikBP, new GBC(5+positionX+i,licznik+3).setInsets(15,30,15,30));
            }



            //sprawdzenie czy gracz odgadł układ komputera
            if(isSolve == true) {
                System.out.println("Gratulacje");
                check.setEnabled(false);

                FileReader frRuchy = null;
                String nextLineRuchy = "";

                try {

                    frRuchy = new FileReader("C:\\Users\\Farmer\\Desktop\\grafikaDoStatków\\ruchy.txt");

                }catch (Exception ev){
                    System.out.println("Błąd przy otwieraniu pliku");
                    System.exit(1);
                }

                BufferedReader bfrRuchy = new BufferedReader(frRuchy);

                //int nrLineRuchy = 0;

                try {
                    int nextLineRuchyInt;


                    while ((nextLineRuchy = bfrRuchy.readLine()) != null) {

                        nextLineRuchyInt = Integer.valueOf(nextLineRuchy);

                        if (licznik < nextLineRuchyInt) {
                            ZapisWyniku najlepszyWynik = new ZapisWyniku(licznik);
                            najlepszyWynik.setLocation(800, 500);
                            najlepszyWynik.setVisible(true);


                            break;
                        }
                    }


                }catch (Exception ev){
                    System.out.println("Błąd odczytu pliku");
                }

                try{
                    frRuchy.close();
                }catch (Exception ev){
                    System.out.println("Błąd zamknięcia pliku");
                }
            }

            if(licznik==20) check.setEnabled(false);

            revalidate();
        }
    }

    //metoda pobierająca listę Stringów(opisójących kolory) i zwraca listę Colorów.
    private ArrayList<Color> colorColor(ArrayList<String> colorselected){

        ArrayList<Color> colorList = new ArrayList<>();

        Color color1 = null;
        Color color2 = null;
        Color color3 = null;
        Color color4 = null;

        switch (colorselected.get(0)){
            case("czarny"):
                color1 = Color.BLACK;
                break;
            case("biały"):
                color1 = Color.WHITE;
                break;
            case("czerwony"):
                color1 = Color.RED;
                break;
            case("zielony"):
                color1 = Color.GREEN;
                break;
            case("żółty"):
                color1 = Color.YELLOW;
                break;
            case("niebieski"):
                color1 = Color.BLUE;
                break;
        }
        colorList.add(color1);

        switch (colorselected.get(1)){
            case("czarny"):
                color2 = Color.BLACK;
                break;
            case("biały"):
                color2 = Color.WHITE;
                break;
            case("czerwony"):
                color2 = Color.RED;
                break;
            case("zielony"):
                color2 = Color.GREEN;
                break;
            case("żółty"):
                color2 = Color.YELLOW;
                break;
            case("niebieski"):
                color2 = Color.BLUE;
                break;
        }
        colorList.add(color2);

        switch (colorselected.get(2)){
            case("czarny"):
                color3 = Color.BLACK;
                break;
            case("biały"):
                color3 = Color.WHITE;
                break;
            case("czerwony"):
                color3 = Color.RED;
                break;
            case("zielony"):
                color3 = Color.GREEN;
                break;
            case("żółty"):
                color3 = Color.YELLOW;
                break;
            case("niebieski"):
                color3 = Color.BLUE;
                break;
        }
        colorList.add(color3);

        switch (colorselected.get(3)){
            case("czarny"):
                color4 = Color.BLACK;
                break;
            case("biały"):
                color4 = Color.WHITE;
                break;
            case("czerwony"):
                color4 = Color.RED;
                break;
            case("zielony"):
                color4 = Color.GREEN;
                break;
            case("żółty"):
                color4 = Color.YELLOW;
                break;
            case("niebieski"):
                color4 = Color.BLUE;
                break;
        }
        colorList.add(color4);

        return colorList;
    }
}
