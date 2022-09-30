package com.liangwu.java;

import java.util.Arrays;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class CardDriver {
    // Declare and create an array of Card, of size 52 (A deck).
    static Card[] allCards = new Card[52];
    static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    static String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};

    public static void main(String[] args) {
        // ***********************************************************************************

        // Fill the deck with the 52 unique playing cards (in any order).

        Card myCard = new Card();
        int location = 0;
        // counter for allCards array
        int k = 0;

        for (int i = 0; i < ranks.length; i++ ) {
            String rank = ranks[i];
            for (int j = 0; j < suits.length; j++) {
                String suit = suits[j];

                    //System.out.println(k);
                    allCards[k] = myCard.clone(rank, suit);

                    //System.out.println(allCards[k].getCard());
                    k++;
            }
        }

        // ************************************************************************************

        // Apply 100 random transpositions of cards to the deck.

        for (int i = 0; i < 100; i++){
            // Generate two different random number between 0-51 inclusive
            Set<Integer> set = new HashSet<Integer>();

            while (set.size() < 2) {
                set.add(new Random().nextInt(allCards.length));
            }

            // Convert HashSet to Array
            Integer[] indices = set.toArray(new Integer[set.size()]);

            // Assign the two indices
            int cardOneIndex = indices[0];
            int cardTwoIndex = indices[1];


            // Get two different random cards from the allCards deck(52 cards)
            Card cardOne = allCards[cardOneIndex];
            Card cardTwo = allCards[cardTwoIndex];

            // Swap two cards
            cardOne.swapCard(cardTwo);
        }

        // ****************************************************************************************

        // display all the cards in the deck
        final int cardsPerRow = 8;
        int cardsThisRow = 0;

        for(int i = 0; i < allCards.length; i++) {
            ++cardsThisRow;
            if (cardsThisRow <= cardsPerRow)
            {
                System.out.print(allCards[i].toString());
                System.out.print(", ");
            }
            else
            {
                System.out.println("");
                cardsThisRow = 1;
                System.out.print(allCards[i].toString());
                System.out.print(", ");
            }
        }

        System.out.println("\n");

        // ****************************************************************************************

        // Find the location of Queen of Clubs
        Card target = myCard.clone("Queen", "Clubs");
        for (int i = 0; i < allCards.length; i++) {
            if(allCards[i].equals(target)) {
                location = i;
            }
        }
        
        System.out.println("> The Queen of clubs was found at location " + location);

        Card demo = new Card("Queen", "Diamonds");
        //System.out.println(Arrays.toString(demo.getCard()));

    }
}
