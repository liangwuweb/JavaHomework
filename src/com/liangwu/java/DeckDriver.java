package com.liangwu.java;

public class DeckDriver {
    static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String[] suits = {"C", "S", "H", "D"};
    static String[] allCards = new String[52];

   public static void main(String[] args) {
       Deck myDeck = new Deck();
       //SmartDeck myDeck = new SmartDeck();

       final int cardsPerRow = 8;
       int cardsThisRow = 0;
       int myCard;
       myDeck.initDeck();
       System.out.println("\nHere is a shuffled deck ...\n");
       while (!myDeck.emptyDeck())
       {
           myCard = myDeck.dealCard();
           ++cardsThisRow;
           if (cardsThisRow <= cardsPerRow)
           {
               System.out.print(DeckDriver.cardToString(myCard));
               System.out.print(" ");
           }
           else
           {
               System.out.println("");
               cardsThisRow = 1;
               System.out.print(DeckDriver.cardToString(myCard));
               System.out.print(" ");
           }
       }
       System.out.println('\n');
   }

   // *******************************************************************************************

    // given a card (an int in the range 0 to 51) returns
    // an appropriate String repressentation of this card
    // based on a 1-1 and onto mapping of the set [0, 51]
    // to the cards described above.

    public static String cardToString(int card) {
        // Create all cards with two nested for loop
        int counter = 0;
        for (int i = 0; i < ranks.length; i++) {
            for(int j = 0; j < suits.length; j++) {
                allCards[counter]= ranks[i]+suits[j];
                counter++;
            }
        }
        return allCards[card];
    }
}
