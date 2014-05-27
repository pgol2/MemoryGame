package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pawel on 27/05/14.
 */
public class RegisterDialog extends Dialog {

    private JTextField username;
    private JTextField usermail;
    private JPasswordField userpassword;

    private JButton registerBtn;
    private JButton clearBtn;



    public RegisterDialog(JFrame parent) {
        super(parent, "Zarejestruj sie..", false);
        setSize(250, 300);
        setLocationRelativeTo(parent);

        username = new JTextField(10);
        usermail = new JTextField(10);
        userpassword = new JPasswordField(10);

        registerBtn = new JButton("Rejestruj");
        clearBtn = new JButton("Wyczysc");

        setLayout(new GridBagLayout());

        GridBagConstraints  gc = new GridBagConstraints();


        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;


        gc.gridy = 0;
        gc.gridx = 0;

        // first row
        add(new JLabel("Login: "), gc);
        gc.gridx++;
        add(username, gc);

        //second row
        gc.gridy++;
        gc.gridx = 0;
        add(new JLabel("Email: "), gc);
        gc.gridx++;
        add(usermail, gc);

        //third row
        gc.gridy++;
        gc.gridx = 0;
        add(new JLabel("Haslo :"), gc);
        gc.gridx++;
        add(userpassword, gc);

        //forth row
        gc.gridy++;
        gc.gridx = 0;
        add(registerBtn, gc);
        gc.gridx++;
        add(clearBtn, gc);

    }
}
