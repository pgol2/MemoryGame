package game;

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


    public LoginDialog(JFrame parent) {

        super(parent, "Zaloguj sie..", false);
        setSize(250, 250);
        setLocationRelativeTo(parent);



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


}
