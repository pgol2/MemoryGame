package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

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

//        ArrayList<String> users = new ArrayList<String>();
//        users.add("pgol");
//        users.add("mysiaczkaa");
//        users.add("marcin");
//
//        ArrayList<Integer> scores = new ArrayList<Integer>();
//        scores.add(222);
//        scores.add(3332);
//        scores.add(666);
//
//        ArrayList<String> topScores = new ArrayList<String>();
//        topScores = buildScores(users, scores);
//
//
//        addScores(topScores);



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

    public ArrayList<String> buildScores(ArrayList<String> users, ArrayList<Integer> scores) {

        ArrayList<String> Scores = new ArrayList<String>();

        Iterator it = users.iterator();
        Iterator it2 = scores.iterator();

        while (it.hasNext() && it2.hasNext()) {
            String user = (String) it.next();
            int score = (Integer) it2.next();

            String scoreRow = user + " " + score + " punktow";
            Scores.add(scoreRow);
        }

        return Scores;
    }
}
