package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pawel on 01/04/14.
 */
public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game game = new Game(8);
            }
        });


    }
}
