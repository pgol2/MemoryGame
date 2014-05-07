package game.helpers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;


/**
 * Created by pawel on 07/05/14.
 */
public class StopWatch extends JPanel{
    private Timer myTimer;
    public static final int ONE_SEC = 1000; //time step in miliseconds
    public static final int TENTH_SEC = 100;

    private  Font myTimerFont;

    private JButton startBtn, stopBtn, resetBtn;
    private JLabel timeLbl;
    private JPanel topPanel, bottomPanel;

    private int clockTick;      //time of clock tick
    private double clockTime;   //time in seconts
    private String clockTimeString;

    public StopWatch() {
        clockTick = 0;      //initial clock tick
        clockTime = ((double)clockTick)/10.0;

        clockTimeString = new Double(clockTime).toString();
        myTimerFont = new Font("Serif", Font.PLAIN, 50);

        timeLbl = new JLabel();
        timeLbl.setFont(myTimerFont);
        timeLbl.setText(clockTimeString);

        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");

        myTimer = new Timer(TENTH_SEC,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clockTick++;
                clockTime = ((double) clockTick) / 10.0;
                clockTimeString = new Double(clockTime).toString();
                timeLbl.setText(clockTimeString);
                System.out.println(clockTime);
            }
        });

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTimer.start();
            }
        });

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTimer.stop();
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTimer.stop();
            }
        });
    } //end of stop watch constructor

    public void lunchStopWatch() {
        topPanel = new JPanel();
        topPanel.setBackground(Color.orange);
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.yellow);
        topPanel.add(timeLbl);
        bottomPanel.add(startBtn);
        bottomPanel.add(stopBtn);
        bottomPanel.add(resetBtn);

        this.setLayout(new BorderLayout());

        add(topPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.SOUTH);

        setSize(300, 200);
        setBackground(Color.orange);

    } // end of lunchStopWatch
} // public class


