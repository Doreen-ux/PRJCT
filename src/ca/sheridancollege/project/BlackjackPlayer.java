/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackPlayer extends Player {

    private List<BlackjackCard> hand;
    private BlackjackPlayer dealer;

    public BlackjackPlayer(String name, BlackjackPlayer dealer) {
        super(name);
        this.dealer = dealer;
        hand = new ArrayList<>();
    }

    public void setDealer(BlackjackPlayer dealer) {
        this.dealer = dealer;
    }

    public List<BlackjackCard> getHand() {
        return hand;
    }

    public int getDealerUpCardValue() {
        if (dealer != null && dealer.getHand().size() >= 2) {
            return dealer.getHand().get(1).getValue(this.getTotalValue());
        }
        return 0; // Handle the case where the dealer doesn't have enough cards yet
    }

    public int getTotalValue() {
        int total = 0;
        int aceCount = 0;

        for (BlackjackCard card : hand) {
            total += card.getValue(total);
            if (card.getValue(total) == 1) {
                aceCount++;
            }
        }

        // Adjust for Aces
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public boolean wantToHit(Scanner scanner) {
        int totalValue = getTotalValue();
        int dealerUpCardValue = getDealerUpCardValue();

        System.out.println("Current hand: " + getHand() + " (Total: " + totalValue + ")");
        System.out.println("Dealer's face-up card: " + dealer.getHand().get(1));
        System.out.println("Do you want to hit? (yes/no)");

        String userInput = scanner.nextLine().toLowerCase();

        // Validate user input
        while (!userInput.equals("yes") && !userInput.equals("no")) {
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
            userInput = scanner.nextLine().toLowerCase();
        }

        return userInput.equals("yes");
    }

    public void addCard(BlackjackCard card) {
        hand.add(card);
    }

    @Override
    public void play(Scanner scanner) {
        // Implement the specific logic for a player's turn (if needed)
    }
}
