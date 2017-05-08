import java.util.ArrayList;

/**
 * Created by Farmer on 2017-04-18.
 */
public class SprawdzaczKolorów {
    private LiczbyLosowe liczbyLosowe;
    private LiczbyWybrane liczbyWybrane;
    private ArrayList<String> losoweKolory;
    private int liczbaBezP;
    private int liczbaNaP;

    public SprawdzaczKolorów(){

        liczbyLosowe = new LiczbyLosowe();

        losoweKolory = liczbyLosowe.getLosoweKolory();

    }

    public int getLiczbaBezP(){
        return liczbaBezP;
    }

    public int getLiczbaNaP(){
        return liczbaNaP;
    }

    public boolean sprawdzenie (ArrayList<String> colorSelected){

        for(int i=0; i<losoweKolory.size(); i++){
            System.out.println(losoweKolory.get(i));
        }

        boolean test = false;

        ArrayList<String> wybraneKolory = colorSelected;

        //sprawdzenie czy wszstkie kolory (i pozycje) wybrane przez gracza zgadzają się z kolorami losowanymi przez komputer
        if(wybraneKolory.equals(losoweKolory)){
            test = true;
            System.out.println("Gratulacje");
        }

        //tworzenie kopii listy kolorów losowych
        ArrayList<String> losoweKoloryKopia = new ArrayList<String>();

        for(int i=0; i<losoweKolory.size(); i++){
            losoweKoloryKopia.add(losoweKolory.get(i));
        }

        //sprawdzenie czy jakieś kolory wybrane przez gracza znajdują się na odpowiednich pozycjach
        liczbaNaP = 0;
        for(int i=0; i<4; i++){
            if(wybraneKolory.get(i).equals(losoweKoloryKopia.get(i))){
                liczbaNaP = liczbaNaP + 1;
                wybraneKolory.remove(i);
                wybraneKolory.add(i, "brak wybranych");
                losoweKoloryKopia.remove(i);
                losoweKoloryKopia.add(i, "brak losowych");
            }
        }

        //sprawdzenie czy kolory wybrne przez gracza są na innych pozycjach

        liczbaBezP = 0;
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if(wybraneKolory.get(i).equals(losoweKoloryKopia.get(j))){
                    liczbaBezP = liczbaBezP + 1;
                    wybraneKolory.remove(i);
                    wybraneKolory.add(i, "brak wybranych");
                    losoweKoloryKopia.remove(j);
                    losoweKoloryKopia.add(j, "brak losowych");
                }
            }
        }

        System.out.println("Trafiłeś: " + liczbaNaP + " kolorów, które znajdują się na swoich pozycjach");
        System.out.println("Trafiłeś: " + liczbaBezP + " kolorów, ale nie są one na swoich pozycjach");

        return test;

    }
}
