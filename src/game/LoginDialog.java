package game;

import game.helpers.LoginListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by pawel on 25/05/14.
 */
public class LoginDialog extends Dialog {


    private JTextField loginField;
    private JPasswordField passwordField;

    private JButton submitBtn;
    private JButton closeBtn;



    private LoginListener loginListener;

    private JLabel userPrompt;



    public LoginDialog(JFrame parent) {

        super(parent, "Zaloguj sie..", false);
        setSize(250, 250);
        setLocationRelativeTo(parent);



        // fields
        loginField = new JTextField(10);
        passwordField = new JPasswordField(10);

        submitBtn = new JButton("zaloguj");
        closeBtn = new JButton("zamknij");

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
        gc.gridx = 0;
        add(submitBtn, gc);
        gc.gridx++;
        add(closeBtn, gc);

        //forth row - prompt
        gc.gridy++;
        gc.gridx = 0;
        userPrompt = new JLabel();
        add(userPrompt, gc);


        submitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String pass = new String(passwordField.getPassword());

                if(loginListener != null) {
                    loginListener.login(login, pass);

                }
            }
        });

        closeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


    }




    private static boolean isPasswordCorrect(char[] input) {

        String goodPass = "warkamu";
        char[] cgoodPass = goodPass.toCharArray();

        boolean isCorrect = false;
        if(input.length != cgoodPass.length) {
            return false;
        } else {
            isCorrect = Arrays.equals(input, cgoodPass);
        }

        Arrays.fill(cgoodPass, '0');

        return isCorrect;

    }

    public void promptUser(String message) {
        userPrompt.setText(message);

    }


    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

}
