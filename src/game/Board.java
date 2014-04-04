package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pawel on 01/04/14.
 */
public class Board extends JPanel implements ActionListener {

    private int numberOfCards;
    private ArrayList<Card> cards;

    //dodac losowanie id
    //jesli id sie zgadza to trafilismy
    public Board(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        cards = new ArrayList<Card>();
        for(int i=0; i<numberOfCards ;i++) {
            cards.add(new Card());
        }

        addToBoard();
        initListeners();
    }
    private void addToBoard() {
        for(Card card: cards) {
            add(card);
        }
    }
    private void initCardsIds() {
        ArrayList<Integer> listOfIds = generateNums(numberOfCards);
        for(int i = 0 ;i<listOfIds.size(); i++) {
            Card current = cards.get(i);
            current.setId(listOfIds.get(i));

        }
    }
    private void initListeners() {
        for(Card card: cards) {
            card.addActionListener(this);
        }
    }
    //generuje wartosci id dla kart
    //jesli karty maja takie same id to pasuja do siebie
    public  ArrayList<Integer> generateNums(int count) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random generator = new Random();
        int val;
        boolean exists;

        for(int i=0; i<count; i++) {
            exists = false;
            while(!exists) {
                val = generator.nextInt(count);
                if(!list.contains(val)) {
                    list.add(val);
                    exists = true;
                }
            }
        }
        ArrayList<Integer> list2 = (ArrayList<Integer>)list.clone();
        list.addAll(list2);
        System.out.println(list);
        return list;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
    }
}
