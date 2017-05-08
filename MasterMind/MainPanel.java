import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Farmer on 2017-04-19.
 */
public class MainPanel extends JPanel {

    private JButton start;

    public MainPanel(){
        setLayout(new GridBagLayout());

        start = new JButton("Start");
        start.addActionListener(new ButtonStart());
        start.setPreferredSize(new Dimension(200,100));
        add(start, new GBC(0,0));

    }

    class ButtonStart implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            removeAll();
            GamePanel panelGry = new GamePanel();
            add(panelGry);
            revalidate();
        }
    }
}
