package game;

import game.helpers.ImageLoader;
import game.helpers.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by pawel on 01/04/14.
 * Main window with game
 * We start our game here
 * and we keep Board object here
 */
public class Game extends JFrame {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private Board gameBoard;
    public Game(int numberOfCards) {
        super("Memory game.Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        //Stopwatch
        //Container watchPanel = getContentPane();
        StopWatch stopWatch = new StopWatch();
        stopWatch.lunchStopWatch();
        add(stopWatch, BorderLayout.SOUTH);

        //setJMenuBar(createMenuBar());
        add(createMenuBar(), BorderLayout.NORTH); // TODO check this

       createBoard(numberOfCards);




    }
    private void createBoard(int numberOfCards) {
        gameBoard = new Board(numberOfCards);
        add(gameBoard, BorderLayout.CENTER);

        //setting images for cards
        ImageLoader loader = new ImageLoader("cardImages");
        ArrayList<String> imageNames = loader.getImageNames();
        gameBoard.setImageNames(imageNames);

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();



        JMenu fileMenu = new JMenu("Menu");
        JMenuItem exportDataItem = new JMenuItem("Najlepsze wyniki");
        JMenuItem importDataItem = new JMenuItem("Zmień nick");
        JMenuItem exitItem = new JMenuItem("Exit");


        JMenu showMenu = new JMenu("Rozmiar planszy");
        JCheckBoxMenuItem smallSize = new JCheckBoxMenuItem("8 kart");
        smallSize.setSelected(true);
        showMenu.add(smallSize);
        fileMenu.add(showMenu);


        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        smallSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
                System.out.println("works");
            }
        });

        menuBar.add(fileMenu);
        return menuBar;
    }



}
