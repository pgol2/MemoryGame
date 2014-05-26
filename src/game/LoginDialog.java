package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pawel on 25/05/14.
 */
public class LoginDialog extends Dialog {


    private JLabel loginLabel;
    private JLabel passwordLabel;

    private JTextField loginField;
    private JPasswordField passwordField;

    private JButton submitBtn;


    public LoginDialog(JFrame parent) {

        super(parent, "Zaloguj sie..", false);
        setSize(250, 250);
        setLocationRelativeTo(parent);

        // lables
        loginLabel = new JLabel("Login: ");
        passwordLabel = new JLabel("Password: ");

        // fields
        loginField = new JTextField(10);
        passwordField = new JPasswordField(10);

        submitBtn = new JButton("submit");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridy = 0;
        gc.gridx = 0;

        // first row
        add(new JLabel("Login: "), gc);
        gc.gridx++;
        add(loginField,gc);

        // second row
        gc.gridy++;
        gc.gridx = 0;
        add(new JLabel("Haslo: "), gc);
        gc.gridx++;
        add(passwordField, gc);

        //third row
        gc.gridy++;
        gc.gridx = 1;
        add(submitBtn, gc);


    }

}
