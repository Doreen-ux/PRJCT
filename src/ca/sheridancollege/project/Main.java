/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author saraswathi
 */
import java.util.*;
public class Main {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        // Create a Blackjack game
        BlackjackGame blackjackGame = new BlackjackGame("Blackjack");

        // Add players to the game
        BlackjackPlayer dealer = new BlackjackPlayer("Dealer", null);
        blackjackGame.getPlayers().add(dealer);

        // Create BlackjackPlayers with references to the dealer
        blackjackGame.getPlayers().add(new BlackjackPlayer("Player1", dealer));
//        blackjackGame.getPlayers().add(new BlackjackPlayer("Player2", dealer));

        // Set the dealer reference in the players
        for (Player player : blackjackGame.getPlayers()) {
            if (player instanceof BlackjackPlayer) {
                ((BlackjackPlayer) player).setDealer(dealer);
            }
        }

        // Run the game
        blackjackGame.play(scanner);
        scanner.close();
    }
}


