package com.liangwu.java;

import java.util.Random;

public class Deck {
    private boolean[] deck = new boolean[52];


    public void initDeck() {
        for (int i = 0; i < this.deck.length; i++) {
            this.deck[i] = false;
        }
    }

    public boolean[] getDeck() {
        return this.deck;
    }
    // set the values of deck to indicate that they are all
// pressent - not delt yet.

    public boolean emptyDeck() {
        for (int i = 0; i < this.deck.length; i++) {
            if (!this.deck[i]) {
                return false;
            }
        }
        return true;
    }

    // returns wheather or not all the cards in the deck
// have already been delt.
    public int dealCard() {
        int cardIndex = new Random().nextInt(this.deck.length);

        while(this.deck[cardIndex]) { // avoid dealt card
            cardIndex = new Random().nextInt(this.deck.length);
        }

        this.deck[cardIndex] = true; // set card to dealt
        return cardIndex;
    }
    // returns a card (an int in the range 0 to 51) at random
// that has not been delt since the deck was initialize
// via intDeck. Also notes (in deck) that this card is
// no longer available.


// given a card (an int in the range 0 to 51) returns
// an appropriate String repressentation of this card
// based on a 1-1 and onto mapping of the set [0, 51]
// to the cards described above.
}
