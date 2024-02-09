/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author saraswathi
 */
public class BlackjackGame extends Game {

    private BlackjackGroupOfCards deck;

    public BlackjackGame(String name) {
        super(name);
        deck = new BlackjackGroupOfCards(52);
    }

    /**
     *
     * @param scanner
     */
    @Override
    public void play(Scanner scanner) {
        System.out.println("Welcome to the Blackjack game!");
        System.out.println("Let's get started...\n");
        // Initialize the deck and shuffle
        deck.initializeDeck();
        deck.shuffle();

        // Deal cards to players
        for (Player player : getPlayers()) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            blackjackPlayer.addCard(deck.drawCard());
            blackjackPlayer.addCard(deck.drawCard());
        }

        // Check for natural Blackjack
        for (Player player : getPlayers()) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            if (blackjackPlayer.getTotalValue() == 21) {
                System.out.println(player.getName() + " has a natural Blackjack!");
                declareWinner();
                return;
            }
        }

        // Check if the dealer has a natural Blackjack
        if (((BlackjackPlayer) getPlayers().get(0)).getTotalValue() == 21) {
            System.out.println("Dealer has a natural Blackjack!");
            declareWinner();
            return;
        }

        // Player's turn
        for (int i = 1; i < getPlayers().size(); i++) {
            BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
            System.out.println(player.getName() + "'s turn:");

            while (player.wantToHit(scanner)) {
                BlackjackCard newCard = deck.drawCard();
                player.addCard(newCard);
                System.out.println(player.getName() + " draws a card: " + newCard);
                System.out.println("New hand: " + player.getHand() + " (Total: " + player.getTotalValue() + ")");

                if (player.getTotalValue() > 21) {
                    System.out.println(player.getName() + " busts!");
                    break;
                }
            }

            System.out.println(player.getName() + " stands with a total of " + player.getTotalValue());
            System.out.println();
        }

        // Dealer's turn
        BlackjackPlayer dealer = (BlackjackPlayer) getPlayers().get(0);
        System.out.println("Dealer's turn:");
        System.out.println("Dealer's face-up card: " + dealer.getHand().get(1));

        while (dealer.getTotalValue() < 17) {
            BlackjackCard newCard = deck.drawCard();
            dealer.addCard(newCard);
            System.out.println("Dealer draws a card: " + newCard);
            System.out.println("Dealer's hand: " + dealer.getHand() + " (Total: " + dealer.getTotalValue() + ")");
        }

        System.out.println("Dealer stands with a total of " + dealer.getTotalValue());

        // Declare the winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        System.out.println("\nGame Over!");

        // Get the total value of the dealer's hand
        int dealerTotal = ((BlackjackPlayer) getPlayers().get(0)).getTotalValue();

        // Check each player against the dealer
        for (int i = 1; i < getPlayers().size(); i++) {
            BlackjackPlayer player = (BlackjackPlayer) getPlayers().get(i);
            int playerTotal = player.getTotalValue();

            if (playerTotal > 21) {
                System.out.println(player.getName() + " busts! Dealer wins!");
            } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
                System.out.println(player.getName() + " wins!");
            } else if (playerTotal == dealerTotal) {
                System.out.println(player.getName() + " ties with the dealer. It's a push!");
            } else {
                System.out.println(player.getName() + " loses to the dealer.");
            }
        }
    }

}
