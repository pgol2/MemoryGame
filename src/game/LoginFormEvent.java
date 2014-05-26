package game;

import java.util.EventObject;

/**
 * Created by pawel on 25/05/14.
 */
public class LoginFormEvent extends EventObject {

    private String login;
    private String passowrd;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public LoginFormEvent(Object source) {
        super(source);

    }

    public LoginFormEvent(Object source, String log, String pass) {
        super(source);
        login = log;
        passowrd = pass;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
