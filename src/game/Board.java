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

    public Board(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        cards = new ArrayList<Card>();
        for(int i=0; i<numberOfCards ;i++) {
            cards.add(new Card());
        }

        addToBoard();
        initListeners();
        initCardsIds();
    }
    private void addToBoard() {
        for(Card card: cards) {
            add(card);
        }
    }
    private void initCardsIds() {
        ArrayList<Integer> listOfIds = generateNums(numberOfCards/2);
        if(cards.size() == listOfIds.size()) {
            for(int i = 0 ;i<listOfIds.size(); i++) {
                Card current = cards.get(i);
                current.setId(listOfIds.get(i));

                System.out.println(current.getId());
            }
        } else {
            System.out.println("nierowne rozmiary !");
        }
    }
    private void initListeners() {
        for(Card card: cards) {
            card.addActionListener(this);
        }
    }

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
        System.out.println("lista wygenerowana przez funkcje generateNums " + list);
        return list;
    }

    private boolean checkCards(Card first, Card second) {
        return second.getId() == first.getId();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Card cardClicked = (Card)e.getSource();
        System.out.println(cardClicked.getId() + " karta kliknetia");
    }
}
