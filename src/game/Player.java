package game;

/**
 * Created by pawel on 06/05/14.
 */
public class Player {
    private int id;
    private String login;
    private String email;
    private String password;
    private double score;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private static int numberOfPlayers = 1;


}
