package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pawel on 27/05/14.
 */
public class ScoresDialog extends Dialog {

    public ScoresDialog(JFrame parent) {
        super(parent, "Najlepsz wyniki", false);

        setSize(300, 400);
        setLocationRelativeTo(parent);


    }
}
