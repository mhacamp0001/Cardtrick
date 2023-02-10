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
        Card card = new Card(rank, suit);
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

}