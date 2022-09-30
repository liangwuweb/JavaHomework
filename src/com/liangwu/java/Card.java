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

    public Card clone(String rank, String suit) {
        Card card = new Card();

        card.setCard(rank, suit);
        return card;
    }

    public boolean equals(Card guest) {
        return this.rank.equals(guest.rank) &&
                this.suit.equals(guest.suit);
    }

    public void swapCard(Card otherCard) {
        String tempRank;
        String tempSuit;

        tempRank = otherCard.rank;
        tempSuit = otherCard.suit;

        otherCard.rank = this.rank;
        otherCard.suit = this.suit;
        this.rank = tempRank;
        this.suit = tempSuit;
    }

    public String toString() {
//        String[] card = this.getCard();
//        return card[0] + " of " + card[1];
        return this.rank + " of " + this.suit;
    }
}
