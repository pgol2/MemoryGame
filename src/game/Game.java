package game;

import game.helpers.ImageLoader;
import game.helpers.StopWatch;

import javax.swing.*;
import javax.swing.border.Border;
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
    public static  int GAME_WIDTH = 800;
    public static  int GAME_HEIGHT = 600;

    private Board gameBoard;
    private LoginDialog loginDialog;
    private RegisterDialog registerDialog;
    private ScoresDialog scoresDialog;
    private JMenuBar menuBar;
    private StopWatch stopWatch;


    public Game(int numberOfCards) {
        super("Memory game.Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        loginDialog = new LoginDialog(this);
        registerDialog = new RegisterDialog(this);
        scoresDialog = new ScoresDialog(this);

        createMenuBar();

        createBoard(8);



    }

    public void createBoard(int numberOfCards) {
        gameBoard = new Board(numberOfCards);
        gameBoard.setVisible(true);
        add(gameBoard, BorderLayout.CENTER);

        //setting images for cards
        ImageLoader loader = new ImageLoader("cardImages");
        ArrayList<String> imageNames = loader.getImageNames();
        gameBoard.setImageNames(imageNames);

    }

    private void createMenuBar() {
        menuBar = new JMenuBar();



        JMenu fileMenu = new JMenu("Menu");
        JMenuItem exportDataItem = new JMenuItem("Najlepsze wyniki");
        JMenuItem loginMenuItem = new JMenuItem("Zaloguj");
        JMenuItem registerMenuItem = new JMenuItem("Rejestruj");
        JMenuItem exitItem = new JMenuItem("Exit");


        JMenu showMenu = new JMenu("Rozmiar planszy");

        final JCheckBoxMenuItem smallSize = new JCheckBoxMenuItem("8 kart");
        final JCheckBoxMenuItem mediumSize = new JCheckBoxMenuItem("12 kart");
        final JCheckBoxMenuItem bigSize = new JCheckBoxMenuItem("16 kart");
        smallSize.setSelected(true);

        showMenu.add(smallSize);
        showMenu.add(mediumSize);
        showMenu.add(bigSize);
        fileMenu.add(showMenu);


        fileMenu.add(exportDataItem);
        fileMenu.add(loginMenuItem);
        fileMenu.add(registerMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);



        mediumSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
                smallSize.setSelected(false);
                bigSize.setSelected(false);
            }
        });


        // logowanie
        loginMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginDialog.isVisible()) {
                    loginDialog.setVisible(false);
                } else {
                    loginDialog.setVisible(true);
                }
            }
        });

        // rejestracja
        registerMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(registerDialog.isVisible()) {
                    registerDialog.setVisible(false);
                } else {
                    registerDialog.setVisible(true);
                }
            }
        });


        //najlepsze wyniki
        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoresDialog.setVisible(true);
            }
        });


        menuBar.add(fileMenu);


        add(menuBar, BorderLayout.NORTH); // TODO check this
    }



}
