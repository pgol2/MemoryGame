package game;

/**
 * Created by pawel on 06/05/14.
 */
public class Player {
    private int id;
    private static int numberOfPlayers = 0;
    private String name;

    public Player(String name) {
        numberOfPlayers++;
        this.id = numberOfPlayers;
        this.name = name;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public String getName() {

        return name;
    }
}
