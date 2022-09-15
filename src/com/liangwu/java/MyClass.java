package com.liangwu.java;

import java.util.Arrays;
import java.util.Random;

public class MyClass {
    public static void initDeck(boolean[] deck) {
        Arrays.fill(deck, false);
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
        int card = new Random().nextInt(deck.length);
        //TODO:if the card generated before, then regenerate it
        deck[card] = true; // set card to dealt
        return card;
    }

    public static void main(String[] args) {


        boolean[] myDeck = new boolean[52];
        System.out.println(Arrays.toString(myDeck));

        initDeck(myDeck);


        System.out.println(dealCard(myDeck));
        System.out.println(Arrays.toString(myDeck));


    }


}
