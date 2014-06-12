package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by pawel on 27/05/14.
 */
public class ScoresDialog extends Dialog {

    private JButton closeBtn;

    GridBagConstraints gc;


    public ScoresDialog(JFrame parent) {
        super(parent, "Najlepsz wyniki", false);

        setSize(300, 400);
        setLocationRelativeTo(parent);

        closeBtn = new JButton("zamknij");

        setLayout(new GridBagLayout());

        gc = new GridBagConstraints();


        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridy = 0;
        gc.gridx = 0;

        // last row
        add(closeBtn, gc);


        ArrayList<String> scores = new ArrayList<String>();
        scores.add("Pawel 360 puntkow");
        scores.add("Pawel 400 puntkow");
        scores.add("Pawel 470 puntkow");

        addScores(scores);



        //event handlers
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


    }

    public void addScores(ArrayList<String> scores) {
        for(String score : scores) {
            ++gc.gridy;
            add(new JLabel(score), gc);

        }
    }
}
