package game;

import game.helpers.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by pawel on 01/04/14.
 * Main window with game
 * We start our game here
 * and we keep Board object here
 */
public class Game extends JFrame {
    public static  int GAME_WIDTH = 1000;
    public static  int GAME_HEIGHT = 800;

    private Board gameBoard;
    private LoginDialog loginDialog;
    private RegisterDialog registerDialog;
    private ScoresDialog scoresDialog;
    private JMenuBar menuBar;
    private StopWatch stopWatch;

    private Player currentPlayer;




    public Game(int numberOfCards) {
        super("Memory game.Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        currentPlayer = new Player();
        loginDialog = new LoginDialog(this);
        registerDialog = new RegisterDialog(this);
        scoresDialog = new ScoresDialog(this);

        createMenuBar();

        createBoard(8);
        gameBoard.setVisible(false);
        loginDialog.setVisible(true);





        // baza danych
        final DatabaseConnector db = new DatabaseConnector();

        try {
            db.connect();
            if(db != null) {
                System.out.println("connected");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        loginDialog.setLoginListener(new LoginListener() {
            @Override
            public void login(String user, String password) {
                System.out.println("user form main frame  " + user);
                System.out.println("passowrd form main frame " + password);

                boolean isLogged = false;
                try {
                    isLogged = db.loginToDB(user, password);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

               if(isLogged) {
                   currentPlayer.setLogin(user);
                   gameBoard.setVisible(true);
                   loginDialog.setVisible(false);

               }
            }
        });

        registerDialog.setRegisterListener(new RegisterListener() {
            @Override
            public void register(String username, String email, String password) {
                boolean registerSuccess = false;
                try {
                    registerSuccess = db.registerToDB(username, email, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(registerSuccess) {
                    System.out.println("zarejestrowano poprawnie");
                    registerDialog.promptUser("sukcess");
                } else {
                    System.out.println("blad rejestracji");
                    registerDialog.promptUser("blad rejestracji");
                }
            }
        });


        gameBoard.setGameEndListner(new GameEndListener() {
            @Override
            public void endGame(double score) {

               try {
                 db.insertScore(currentPlayer.getLogin(), (int)score);
               } catch(SQLException e ) {
                   e.printStackTrace();
               }


            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("window closing");

                dispose();
                System.gc();

            }
        });


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

    public void recreateBoard(int numberOfCards) {

        gameBoard = null;
        gameBoard = new Board(numberOfCards);
        add(gameBoard, BorderLayout.CENTER);

        ImageLoader loader = new ImageLoader("cardImages");
        ArrayList<String> imageNames = loader.getImageNames();
        gameBoard.setImageNames(imageNames);
        revalidate();
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();



        JMenu fileMenu = new JMenu("Menu");
        JMenuItem scoresMenuItem = new JMenuItem("Najlepsze wyniki");
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


        fileMenu.add(scoresMenuItem);
        fileMenu.add(loginMenuItem);
        fileMenu.add(registerMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);



        smallSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
                recreateBoard(8);
                mediumSize.setSelected(false);
                bigSize.setSelected(false);
            }
        });

        mediumSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
                recreateBoard(12);

                smallSize.setSelected(false);
                bigSize.setSelected(false);
            }
        });

        bigSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
                recreateBoard(16);
                smallSize.setSelected(false);
                mediumSize.setSelected(false);
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
        scoresMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoresDialog.setVisible(true);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(gameBoard, "Czy napewno chcesz wyjsc z tej niesamowitej gry", "Wyjdz", JOptionPane.OK_CANCEL_OPTION);

                if(action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }


            }
        });


        menuBar.add(fileMenu);


        add(menuBar, BorderLayout.NORTH); // TODO check this
    }






}
