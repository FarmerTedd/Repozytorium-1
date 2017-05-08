import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Farmer on 2017-04-18.
 */
public class LiczbyWybrane {

    private ArrayList<String> wybraneKolory = new ArrayList<String>();

    public ArrayList<String> getWybraneKolory(){return wybraneKolory;}

    public LiczbyWybrane(){
        Scanner scanner = new Scanner(System.in);

        boolean test = false;
        String kolor1;

        //Wybór pierwszego koloru
        while(test != true) {
            kolor1 = scanner.next();
            if(kolor1.equals("czarny")|| kolor1.equals("biały") || kolor1.equals("czerwony") || kolor1.equals("zielony") || kolor1.equals("żółty") || kolor1.equals("niebieski")) {
                wybraneKolory.add(kolor1);
                test = true;
            }else{System.out.println("Nieznany kolor, wpisz ponownie");}
        }
        test = false;
        String kolor2;

        //Wybór drugiego koloru
        while(test != true) {
            kolor2 = scanner.next();
            if(kolor2.equals("czarny")|| kolor2.equals("biały") || kolor2.equals("czerwony") || kolor2.equals("zielony") || kolor2.equals("żółty") || kolor2.equals("niebieski")) {
                wybraneKolory.add(kolor2);
                test = true;
            }else{System.out.println("Nieznany kolor, wpisz ponownie");}
        }
        test = false;
        String kolor3;

        //Wybór trzeciego koloru
        while(test != true) {
            kolor3 = scanner.next();
            if(kolor3.equals("czarny")|| kolor3.equals("biały") || kolor3.equals("czerwony") || kolor3.equals("zielony") || kolor3.equals("żółty") || kolor3.equals("niebieski")) {
                wybraneKolory.add(kolor3);
                test = true;
            }else{System.out.println("Nieznany kolor, wpisz ponownie");}
        }
        test = false;
        String kolor4;

        //Wybór czwartego koloru
        while(test != true) {
            kolor4 = scanner.next();
            if(kolor4.equals("czarny")|| kolor4.equals("biały") || kolor4.equals("czerwony") || kolor4.equals("zielony") || kolor4.equals("żółty") || kolor4.equals("niebieski")) {
                wybraneKolory.add(kolor4);
                test = true;
            }else{System.out.println("Nieznany kolor, wpisz ponownie");}
        }
        test = false;
    }
}
