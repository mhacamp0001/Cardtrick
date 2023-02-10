package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.Deck;
import com.example.demo.service.CardTrickService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CardTrickController {

  private CardTrickService cardTrickService;
 	private Deck deck;


  public CardTrickController(CardTrickService cardTrickService) {
    this.cardTrickService = cardTrickService;
    deck = new Deck();
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/deck")
  public ModelAndView deck() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("cardtrick");
    deck = cardTrickService.buildDeck();
    mv.addObject("deck", deck.getDeck());

    return mv;
  }

  @GetMapping("/shuffle")
  public ModelAndView shuffle() {
   ModelAndView mv = new ModelAndView();
   mv.setViewName("cardtrick");
   Deck shuffledDeck = cardTrickService.shuffleDeck(deck);
   mv.addObject("shuffledDeck", deck.getDeck());
   return mv;
  }

  @GetMapping("/draw")
  public ModelAndView drawCard() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("cardtrick");
    Card selectedCard = cardTrickService.drawCard(deck);
    mv.addObject("selectedCard", selectedCard);
    return mv;
  }

  @PostMapping("/return")
  public ModelAndView generateReport(String rank, String suit) {
    ModelAndView mv = new ModelAndView();
    System.out.println("RANK: " + rank + "SUIT: " + suit);
    mv.setViewName("cardtrick");
    mv.addObject("deck", deck.getDeck());
    return mv;

  }

  @RequestMapping("/")
  public ModelAndView setup() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("cardtrick");
    return mv;
  }

}
