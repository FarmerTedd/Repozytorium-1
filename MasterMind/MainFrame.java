import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Farmer on 2017-04-19.
 */
public class MainFrame extends JFrame {

    public MainFrame(){
        JMenu optionMenu = new JMenu("Opcje");
        Action rekordAction = new RecordAction("Rekord");
        optionMenu.add(rekordAction);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(optionMenu);

        MainPanel panel = new MainPanel();
        add(panel, BorderLayout.CENTER);
        pack();
    }

    class RecordAction extends AbstractAction{
        public RecordAction(String name){
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Rekord rekord = new Rekord();
                rekord.setVisible(true);
            }catch (Exception ex){};
        }
    }
}
