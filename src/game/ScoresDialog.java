package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pawel on 27/05/14.
 */
public class ScoresDialog extends Dialog {

    private JButton closeBtn;

    public ScoresDialog(JFrame parent) {
        super(parent, "Najlepsz wyniki", false);

        setSize(300, 400);
        setLocationRelativeTo(parent);

        closeBtn = new JButton("zamknij");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridy = 0;
        gc.gridx = 0;

        // first row
        add(closeBtn, gc);

        add(closeBtn);
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


    }
}
