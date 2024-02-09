/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author saraswathi
 */
public class BlackjackGroupOfCards extends GroupOfCards {
    public BlackjackGroupOfCards(int size) {
        super(size);
    }
      public  ArrayList<Card> getCardsAll() {
        return cards;
    }
    

    public void initializeDeck() {
        for (String suit : new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) {
            for (String rank : new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}) {
                this.getCardsAll().add(new BlackjackCard(rank, suit));
            }
        }
    }

    public BlackjackCard drawCard() {
        return (BlackjackCard) getCardsAll().remove(0);
    }
}


