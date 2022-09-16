package com.liangwu.java;

import java.util.Arrays;
import java.util.Random;

public class MyClass {
    static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String[] suits = {"C", "S", "H", "D"};
    static String[] allCards = new String[52];


    public static void main(String[] args) {

        // Create all combinations
        int counter = 0;
        for (int i = 0; i < ranks.length; i++) {
            for(int j = 0; j < suits.length; j++) {
                allCards[counter]= ranks[i]+suits[j];
                counter++;
            }
        }

        boolean[] myDeck = new boolean[52];
        System.out.println(Arrays.toString(myDeck));

        final int cardsPerRow = 8;
        int cardsThisRow = 0;
        int myCard;
        initDeck(myDeck);
        //printCard(1);
        System.out.println(Arrays.toString(allCards));
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


//        System.out.println(dealCard(myDeck));
//        System.out.println(Arrays.toString(myDeck));


    }


    public static void initDeck(boolean[] deck) {
        for (int i = 0; i < deck.length; i++) {
            deck[i] = false;
        }
    }

    public static  boolean emptyDeck(boolean[] deck) {
        for (int i = 0; i < deck.length; i++) {
            if (!deck[i]) {
                return false;
            }
        }
        return true;
    }

    public static int dealCard(boolean[] deck) {
        int cardIndex = new Random().nextInt(deck.length);

        // avoid dealt card
        while(deck[cardIndex] == true) {
            cardIndex = new Random().nextInt(deck.length);
        }

        deck[cardIndex] = true; // set card to dealt
        return cardIndex;
    }

    public static void printCard(int card) {
        System.out.print(allCards[card]);
    }
}
