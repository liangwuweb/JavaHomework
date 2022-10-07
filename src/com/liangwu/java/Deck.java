package com.liangwu.java;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Deck {

    private Card[] deck = new Card[52];
    public static final String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
    private int cardsDealt;

    public Deck() {
        // Fill the deck with the 52 unique playing cards (in any order).
        Card myCard = new Card();
        // counter for allCards array
        int k = 0;

        for (int i = 0; i < Deck.ranks.length; i++ ) {
            String rank = Deck.ranks[i];
            for (int j = 0; j < Deck.suits.length; j++) {
                String suit = Deck.suits[j];

                getDeck()[k] = myCard.clone(rank, suit);

                k++;
            }
        }
        setCardsDealt(0);
    }

    public Card[] getDeck() {
        return this.deck;
    }

    public int getCardsDealt() {
        return this.cardsDealt;
    }

    public void setCardsDealt(int cardsDealt) {
        this.cardsDealt = cardsDealt;
    }

    public boolean isEmptyDeck() {
        return this.getCardsDealt() == 52;
    }

    public void collectAllCards() {
        setCardsDealt(0);
    }

    public Card dealCard() {
        if (!this.isEmptyDeck()) {
            // Hold cardsDealt before increment.
            int temp = getCardsDealt();
            this.setCardsDealt(getCardsDealt() + 1);
            return getDeck()[temp];
        } else {
            return null;
        }
    }

    public void shuffleDeck() {
        shuffleDeck(100);
    }

    public void shuffleDeck(int swapCnt) {
        for (int i = 0; i < swapCnt; i++){
            // Generate two different random number between 0-51 inclusive
            Set<Integer> set = new HashSet<Integer>();

            while (set.size() < 2) {
                set.add(new Random().nextInt(getDeck().length));
            }

            // Convert HashSet to Array
            Integer[] indices = set.toArray(new Integer[set.size()]);

            // Assign the two indices
            int cardOneIndex = indices[0];
            int cardTwoIndex = indices[1];


            // Get two different random cards from the allCards deck(52 cards)
            Card cardOne = getDeck()[cardOneIndex];
            Card cardTwo = getDeck()[cardTwoIndex];

            // Swap two cards
            cardOne.swapCard(cardTwo);
        }
    }
}
