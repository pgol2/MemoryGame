package game;

import game.helpers.LoginListener;
import game.helpers.RegisterListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pawel on 27/05/14.
 */
public class RegisterDialog extends Dialog {

    private JTextField username;
    private JTextField usermail;
    private JPasswordField userpassword;

    private JButton registerBtn;
    private JButton closeBtn;

    private RegisterListener registerListener;

    private GridBagConstraints  gc;

    private JLabel userPrompt;


    public RegisterDialog(JFrame parent) {
        super(parent, "Zarejestruj sie..", false);
        setSize(400, 400);
        setLocationRelativeTo(parent);

        username = new JTextField(20);
        usermail = new JTextField(20);
        userpassword = new JPasswordField(20);

        registerBtn = new JButton("Rejestruj");
        closeBtn = new JButton("Zamknij");

        setLayout(new GridBagLayout());

        gc = new GridBagConstraints();


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
        add(closeBtn, gc);

        //fifth - user prompt
        gc.gridy++;
        gc.gridx = 0;
        userPrompt = new JLabel();
        add(userPrompt, gc);

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = username.getText();
                String email = usermail.getText();
                String pass = new String(userpassword.getPassword());

                // if register listener is set
                if( registerListener != null ) {
                    System.out.println("login : " + login + " email: " + pass);
                    registerListener.register(login, email, pass);
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

    public void promptUser(String message) {
        userPrompt.setText(message);

    }
    public void setRegisterListener(RegisterListener registerListener) {
        this.registerListener = registerListener;
    }


}
