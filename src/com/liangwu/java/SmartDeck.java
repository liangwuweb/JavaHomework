package com.liangwu.java;

import java.util.Random;

public class SmartDeck {
    private boolean[] deck = new boolean[52];
    private int cardsDealt;

    //*************************************************************

    // This method set the values of deck to indicate that they are all
    // present - not dealt yet; also set cardsDealt to 0

    public void initDeck() {
        for (int i = 0; i < this.deck.length; i++) {
            this.deck[i] = false;
        }
        this.cardsDealt = 0;
    }

    //*************************************************************

    // This method returns whether or not all the cards in the deck
    // have already been dealt.

    public boolean emptyDeck() {
        return this.cardsDealt == this.deck.length;
    }

    //*************************************************************

    // This method returns a card (an int in the range 0 to 51) at random
    // that has not been dealt since the deck was initialized
    // via intDeck. Also notes (in deck) that this card is
    // no longer available. Also increment cards number that has been dealt.

    public int dealCard() {
        int cardIndex = new Random().nextInt(this.deck.length);

        while(this.deck[cardIndex]) { // avoid dealt card
            cardIndex = new Random().nextInt(this.deck.length);
        }

        this.deck[cardIndex] = true; // set card to dealt
        this.cardsDealt ++;
        return cardIndex;
    }
}
