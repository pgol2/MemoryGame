package game;

import javax.swing.*;

/**
 * Created by pawel on 01/04/14.
 * Single card on the Board and in the Game
 * Just enchanced JToggleButton
 */
public class Card  extends JToggleButton{
    private int id;
    private ImageIcon image;

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

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
