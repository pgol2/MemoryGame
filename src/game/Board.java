package game;

import game.helpers.ImageLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.File;


/**
 * Created by pawel on 01/04/14.
 */
public class Board extends JPanel implements ActionListener {

    private int numberOfCards;
    private ArrayList<Card> cards;

    private Card previous;//just temporary solution

    public Board(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        cards = new ArrayList<Card>();
        for(int i=0; i<numberOfCards ;i++) {
            cards.add(new Card());
        }

        addToBoard();
        initListeners();
        initCardsIds();
        initCardsImages();
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
            }
        } else {
            System.out.println("nierowne rozmiary !");
        }
    }
    /*
    ładuje obrazki z folderu
    przypisuje je
     */
    //TODO przypisaie kartom setSelectedIcon na podstawie wczytanych nazw

    private void initCardsImages() {
        ImageLoader loader = new ImageLoader("cardImages");
        ArrayList<String> list = loader.getListOfImageNames();
        System.out.println("rozmiar list obrazko " + list.size());
        System.out.println("rozmiar listy kart " + cards.size());

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

        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));


        System.out.println("lista wygenerowana przez funkcje generateNums " + list);

        return list;
    }

    private boolean checkCards(Card first, Card second) {
        return second.getId() == first.getId();
    }

    @Override
    //TODO caching previous button that was clicked in checking it
    public void actionPerformed(ActionEvent e) {
        Card cardClicked = (Card)e.getSource();
        cardClicked.setSelectedIcon(new ImageIcon("cardImages/img1.png"));
//        if(!cardClicked.isSelected()) {
//            cardClicked.setSelected(true);
//        } else {
//            cardClicked.setSelected(false);
//        }


        System.out.println(cardClicked.getId() + " karta kliknetia");
    }
}
