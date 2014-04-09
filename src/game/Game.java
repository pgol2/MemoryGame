package game;

import game.helpers.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pawel on 01/04/14.
 */
public class Game extends JFrame {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private Board board;
    public Game(int numberOfCards) {
        super("Memory game.Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        board = new Board(numberOfCards);
        add(board, BorderLayout.CENTER);

        ImageLoader loader = new ImageLoader("cardImages");
        ArrayList<String> imageNames = loader.getImageNames();
        board.setImageNames(imageNames);
    }
}
