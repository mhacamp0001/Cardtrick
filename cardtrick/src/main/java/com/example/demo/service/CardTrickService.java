package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.example.demo.model.Card;
import com.example.demo.model.Deck;
import com.example.demo.model.Rank;
import com.example.demo.model.Suit;

import org.springframework.stereotype.Service;

@Service
public class CardTrickService {

  public Deck buildDeck() {
    Deck deck = new Deck();
    List<Card> cardPile = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit, false);
        cardPile.add(card);
      }
    }
    deck.setDeck(cardPile);

    return deck;

  }

  public Deck shuffleDeck(Deck deck) {
    Collections.shuffle(deck.getDeck());

    return deck;

  }

  public Card drawCard(Deck deck) {
    Random random = new Random();
    Card selectedCard = deck.getDeck().get(random.nextInt(52));

    return selectedCard;

  }

  public Deck markCardAndReturnToDeck(Deck deck, String rank, String suit) {
    //     System.out.println("stream on: " 
    //                    + rank + suit);
    //   System.out.println("first card: " 
    //                    + deck.getDeck().get(0).getRank());
    // Card selectedCard = deck.getDeck().stream()
    //         .filter(card -> card.getSuit().toString().equalsIgnoreCase(suit))
    //         .filter(card -> card.getRank().toString().equalsIgnoreCase(rank))
    //   .findFirst().get();

   // deck.getDeck().remove(selectedCard);
   // System.out.println("removed card: " + selectedCard.getSuit());
    Card markedCard = new Card(
      Rank.valueOf(rank), Suit.valueOf(suit), true);
  //  selectedCard.setMarkedCard(true);
    deck.getDeck().add(markedCard);
    System.out.println("added card: " 
                       + markedCard.getRank()
                       + markedCard.getSuit()
                       + markedCard.isMarkedCard());


    return deck;

  }

  public Card findCard(Deck deck) {
    Card finalCard = deck.getDeck().stream()
            .filter(card -> card.isMarkedCard()).findFirst().get();

    System.out.println("final card: " 
                       + finalCard.getRank()
                      + finalCard.getSuit()
                      + finalCard.isMarkedCard());


    return finalCard;

  }

}