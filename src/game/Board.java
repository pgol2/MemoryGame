package game;

import game.helpers.GameEndListener;
import game.helpers.ImageLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.File;


/**
 * Created by pawel on 01/04/14.
 * Class with main board with wrapps card objects
 */
public class Board extends JPanel implements ActionListener {

    private int numberOfCards;
    private int currentNumberOfCards;
    private ArrayList<Card> cards;
    private ArrayList<String> imageNames;
    private Card previousCard;
    private int clickNumber=0;
    private static int totalClicks = 0;

    private GameEndListener gameEndListner;

    public Board(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        currentNumberOfCards = numberOfCards;
        cards = new ArrayList<Card>();

        for (int i = 0; i < numberOfCards; i++) {
            cards.add(new Card());
        }

        addToBoard();
        initListeners();
        initCardsIds();


    }

    //dodaje karty do planszy
    private void addToBoard() {
        for (Card card : cards) {
            add(card);
        }
    }

    private void removeCard(Card toRemove) {
        remove(toRemove);
        repaint();
    }

    //initializes cards with their id numbers
    private void initCardsIds() {
        ArrayList<Integer> listOfIds = generateNums(numberOfCards / 2);
        if (cards.size() == listOfIds.size()) {
            for (int i = 0; i < listOfIds.size(); i++) {
                Card current = cards.get(i);
                current.setId(listOfIds.get(i));
            }
        } else {
            System.out.println("nierowne rozmiary !");
        }
    }


    public void setImageNames(ArrayList<String> imageNames) {

        this.imageNames = imageNames;
    }

    private void initListeners() {
        for (Card card : cards) {
            card.addActionListener(this);
        }
    }

    public ArrayList<Integer> generateNums(int size) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            lista.add(i);
        }

        lista.addAll((ArrayList<Integer>) lista.clone());

        long seed = System.nanoTime();
        Collections.shuffle(lista, new Random(seed));

        System.out.println("generated numbers " + lista.toString());
        return lista;
    }

    private boolean checkCards(Card first, Card second) {
        return second.getId() == first.getId();
    }

    private void flipAllCards() {
        for(Card card : cards) card.setSelected(false);
    }

    private void showResult(double score) {
        int value = (int)score;
        add(new JLabel("Twój wynik to:  " +  value));
        revalidate();
    }

    private double calculateResult() {
        double cards = numberOfCards;
        double clicks = totalClicks;

        return (cards/clicks) * 1000;
    }
    @Override
    //TODO caching previous button that was clicked in checking it
    public void actionPerformed(ActionEvent e) {
        ++totalClicks;
        System.out.println("total clicks " + totalClicks);
        Card cardClicked = (Card) e.getSource();
        clickNumber++;


        if(clickNumber == 1) {
            previousCard = cardClicked;
        } else if(clickNumber == 2) {
            if( (previousCard.getId() == cardClicked.getId()) && (previousCard != cardClicked) ){
                removeCard(previousCard);
                removeCard(cardClicked);
                currentNumberOfCards -= 2;
                if(currentNumberOfCards == 0) {
                    System.out.println("koniec!");
                    double score = calculateResult();
                    showResult(score);
                    repaint();

                    if(gameEndListner != null) {
                        gameEndListner.endGame(score);
                    }
                }
            }
        } else if(clickNumber > 2) {
            flipAllCards();
            clickNumber=0;
        }


        //TODO add better maping for images names to images
        String path = "cardImages/img" + cardClicked.getId() + ".png";
        cardClicked.setSelectedIcon(new ImageIcon(path));


    }

    public void setGameEndListner(GameEndListener listener) {
        this.gameEndListner = listener;
    }

}
