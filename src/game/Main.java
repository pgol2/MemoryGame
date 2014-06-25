package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pawel on 01/04/14.
 *  TODO:
 *  - logowanie  i rejestracja nowych userow
 *  - zapisywanie wynikow do bazay - czas
 *  - wybor rozmiaru planszy
 *  - (siec Hibernate)
 *  - ( Web Service )
 *  - Dodac frontned webowy i wypisywanie
 */
public class Main {
    public static void main(String[] args) {

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                Game game = new Game(8);
//            }
//        });

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                Game game = new Game(8);

                return null;
            }
        };

        worker.execute();

    }
}
