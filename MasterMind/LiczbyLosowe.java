import java.util.ArrayList;

/**
 * Created by Farmer on 2017-04-18.
 */
public class LiczbyLosowe {

    private ArrayList<String> losoweKolory = new ArrayList<String>();
    private String kolor1;
    private String kolor2;
    private String kolor3;
    private String kolor4;

    public ArrayList<String> getLosoweKolory(){return losoweKolory;}

    public LiczbyLosowe () {

        int losowa1 = (int)(Math.random()*6);
        int losowa2 = (int)(Math.random()*6);
        int losowa3 = (int)(Math.random()*6);
        int losowa4 = (int)(Math.random()*6);

        //losowanie kolorów przez komputer

        switch (losowa1){
            case(0):
                kolor1 = "czarny";
                break;
            case(1):
                kolor1 = "biały";
                break;
            case(2):
                kolor1 = "czerwony";
                break;
            case(3):
                kolor1 = "zielony";
                break;
            case(4):
                kolor1 = "żółty";
                break;
            case(5):
                kolor1 = "niebieski";
                break;
        }

        switch (losowa2){
            case(0):
                kolor2 = "czarny";
                break;
            case(1):
                kolor2 = "biały";
                break;
            case(2):
                kolor2 = "czerwony";
                break;
            case(3):
                kolor2 = "zielony";
                break;
            case(4):
                kolor2 = "żółty";
                break;
            case(5):
                kolor2 = "niebieski";
                break;
        }

        switch (losowa3){
            case(0):
                kolor3 = "czarny";
                break;
            case(1):
                kolor3 = "biały";
                break;
            case(2):
                kolor3 = "czerwony";
                break;
            case(3):
                kolor3 = "zielony";
                break;
            case(4):
                kolor3 = "żółty";
                break;
            case(5):
                kolor3 = "niebieski";
                break;
        }

        switch (losowa4){
            case(0):
                kolor4 = "czarny";
                break;
            case(1):
                kolor4 = "biały";
                break;
            case(2):
                kolor4 = "czerwony";
                break;
            case(3):
                kolor4 = "zielony";
                break;
            case(4):
                kolor4 = "żółty";
                break;
            case(5):
                kolor4 = "niebieski";
                break;
        }

        losoweKolory.add(kolor1);
        losoweKolory.add(kolor2);
        losoweKolory.add(kolor3);
        losoweKolory.add(kolor4);

    }

}
