package com.liangwu.java;

public class DeckDriver {
    public static void main(String[] args) {

        // Create a deck
        Deck myDeck = new Deck();
        // Shuffle Card
        myDeck.shuffleDeck();

        // display all the cards in the deck
        final int cardsPerRow = 8;
        int cardsThisRow = 0;

        while(!myDeck.isEmptyDeck()) {
            ++cardsThisRow;
            if (cardsThisRow <= cardsPerRow)
            {
                System.out.print(myDeck.dealCard().toString());
                System.out.print(", ");
            }
            else
            {
                System.out.println("");
                cardsThisRow = 1;
                System.out.print(myDeck.dealCard().toString());
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }
}
