package game;

import javax.swing.*;

/**
 * Created by pawel on 01/04/14.
 */
public class Card  extends JToggleButton{
    private int id;
    private ImageIcon image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //dodac tutaj wlasciwy obrazek pod karta
    public Card() {


        setIcon(new ImageIcon("back.png"));
    }
}
