package com.example.demo.model;

public class Card {

  private Rank rank;
  private Suit suit;
  private boolean markedCard;

  public Card(Rank rank, Suit suit, boolean markedCard) {
    this.rank = rank;
    this.suit = suit;
    this.markedCard = markedCard;
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public void setSuit(Suit suit) {
    this.suit = suit;
  }

  public boolean isMarkedCard() {
    return this.markedCard;
  }

  public void setMarkedCard(boolean markedCard) {
    this.markedCard = markedCard;
  }

}