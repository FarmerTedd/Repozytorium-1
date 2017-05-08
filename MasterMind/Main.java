import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Farmer on 2017-04-18.
 */
public class Main {


    public static void main(String[] args){

        // odczytanie wielkości ekranu
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        EventQueue.invokeLater(()->{
            MainFrame frame = new MainFrame();
            frame.setSize(screenWidth,screenHeight);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }
}
