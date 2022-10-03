package com.liangwu.java;


public class Card {

    private String rank;
    private String suit;

    public Card() {
        this.suit = "Clubs";
        this.rank = "Ace";
    }

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;

    }

    public String[] getCard() {
        String[] card = new String[2];

        card[0] = this.rank;
        card[1] = this.suit;

        return card;
    }

    private void setCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // ***********************************************************************************

    // Make a copy of Card

    public Card clone(String rank, String suit) {
        Card card = new Card();

        card.setCard(rank, suit);
        return card;
    }

    // ***********************************************************************************

    // Test if two cards equals to each other

    public boolean equals(Card guest) {
        String[] card = this.getCard();
        String rank = card[0];
        String suit = card[1];

        String[] guestCard = guest.getCard();
        String guestRank = guestCard[0];
        String guestSuit = guestCard[1];

        return rank.equals(guestRank) &&
                suit.equals(guestSuit);
    }

    // ***********************************************************************************

    // Swap two cards' value

    public void swapCard(Card otherCard) {
        String[] otherCardData = otherCard.getCard();
        String otherCardRank = otherCardData[0];
        String otherCardSuit = otherCardData[1];

        String[] card = this.getCard();
        String rank = card[0];
        String suit = card[1];

        otherCard.setCard(rank, suit);
        this.setCard(otherCardRank, otherCardSuit);
    }

    // ***********************************************************************************

    // Return String representation of the calling Card object's suit and rank

    public String toString() {
        String[] card = this.getCard();
        return card[0] + " of " + card[1];
    }
}
