package com.liangwu.java;

import java.util.Random;

public class MyClass {
    static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String[] suits = {"C", "S", "H", "D"};
    static String[] allCards = new String[52];

    public static void main(String[] args) {
        // Create all cards with two nested for loop
        int counter = 0;
        for (int i = 0; i < ranks.length; i++) {
            for(int j = 0; j < suits.length; j++) {
                allCards[counter]= ranks[i]+suits[j];
                counter++;
            }
        }

        boolean[] myDeck = new boolean[52];

        final int cardsPerRow = 8;
        int cardsThisRow = 0;
        int myCard;
        initDeck(myDeck);
        System.out.println("\nHere is a shuffled deck ...\n");
        while (!emptyDeck(myDeck))
        {
            myCard = dealCard(myDeck);
            ++cardsThisRow;
            if (cardsThisRow <= cardsPerRow)
            {
                printCard(myCard);
                System.out.print(" ");
            }
            else
            {
                System.out.println("");
                cardsThisRow = 1;
                printCard(myCard);
                System.out.print(" ");
            }
        }
        System.out.println('\n');
    }

    //*************************************************************

    // This method set the values of deck to indicate that they are all
    // present - not dealt yet.

    public static void initDeck(boolean[] deck) {
        for (int i = 0; i < deck.length; i++) {
            deck[i] = false;
        }
    }

    //*************************************************************

    // This method returns whether or not all the cards in the deck
    // have already been dealt.

    public static  boolean emptyDeck(boolean[] deck) {
        for (int i = 0; i < deck.length; i++) {
            if (!deck[i]) {
                return false;
            }
        }
        return true;
    }

    //*************************************************************

    // This method returns a card (an int in the range 0 to 51) at random
    // that has not been dealt since the deck was initialized
    // via intDeck. Also notes (in deck) that this card is
    // no longer available.

    public static int dealCard(boolean[] deck) {
        int cardIndex = new Random().nextInt(deck.length);

        while(deck[cardIndex] == true) { // avoid dealt card
            cardIndex = new Random().nextInt(deck.length);
        }

        deck[cardIndex] = true; // set card to dealt
        return cardIndex;
    }

    //*************************************************************

    // This method given a card (an int in the range 0 to 51) prints
    // an appropriate representation of this card based
    // on a 1-1 and onto mapping of the set [0, 51] to
    // the cards described above.

    public static void printCard(int card) {
        System.out.print(allCards[card]);
    }
}
