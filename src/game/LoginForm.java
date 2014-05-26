package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by pawel on 22/05/14.
 */
public class LoginForm extends JPanel{

    private JFrame dialogs;

    private JLabel loginLabel;
    private JLabel passwordLabel;

    private JTextField loginField;
    private JPasswordField passwordField;

    private JButton submitBtn;

    private boolean isLoggedIn;





    public LoginForm() {
        Dimension dim = getPreferredSize();

        setSize(new Dimension(400,100));

        // lables
        loginLabel = new JLabel("Login: ");
        passwordLabel = new JLabel("Password: ");

        // fields
        loginField = new JTextField(10);
        passwordField = new JPasswordField(10);

        //Button
        submitBtn = new JButton("zaloguj");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                char[] pass = passwordField.getPassword();

                if(isPasswordCorrect(pass)) {
                    System.out.println("correct!");
                } else {
                    System.out.println("incorrect!");
                }


                System.out.println("password: " + login);
                System.out.println("passowrd : " + pass);
            }
        });

        add(loginLabel);
        add(loginField);

        add(passwordLabel);
        add(passwordField);
        add(submitBtn);

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
    //show game board
    public void performLogin(Game game, int nCards) {
        System.out.println("shwoing board");

    }
}
