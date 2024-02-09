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
public class BlackjackCard extends Card {
    private final String rank;
    private final String suit;

    public BlackjackCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int getValue(int currentTotal) {
        if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
            return 10;
        } else if (rank.equals("Ace")) {
           // If adding 11 would cause a bust, treat Ace as 1
            return (currentTotal + 11 > 21) ? 1 : 11;
        } else {
            return Integer.parseInt(rank);
        }
    }
}