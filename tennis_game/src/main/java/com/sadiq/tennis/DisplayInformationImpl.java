package com.sadiq.tennis;

/**
 * Created by sadiq.
 */

public class DisplayInformationImpl implements DisplayInformation {


    public void displayGamePoint(Player player) {
        System.out.println(player.getUsername() + " has won 1 point!");
    }

    public void displayGameScore(String gameScorePlayer1, String gameScorePlayer2) {
        System.out.println("Current Game Score is: ( " + gameScorePlayer1 + " - " + gameScorePlayer2 + " )");
    }

    public void announceDeuceRule() {
        System.out.println("Deuce Rule applied!");
    }

    public void displayGameWinner(Player player) {
        System.out.println("\n\nThe winner of the game is : " + player.getUsername());
    }

    public void displayTieBreakScore(Integer tieBreakScorePlayer1, Integer tieBreakScorePlayer2) {
        System.out.println("Current Tie Break Score is: ( " + tieBreakScorePlayer1 + " - " + tieBreakScorePlayer2 + " )\n\n");
    }

    public void displaySetScore(Integer setScorePlayer1, Integer setScorePlayer2) {
        System.out.println("\n\nCurrent Set Score is: ( " + setScorePlayer1 + " - " + setScorePlayer2 + " )\n\n");
    }

    public void displaySetWinner(Player player) {
        System.out.println("The winner of the Set is : " + player.getUsername() + "\n\n");
    }

    public void displayMatchScore(Integer matchScorePlayer1, Integer matchScorePlayer2) {
        System.out.println("\n\nMatch Score is: ( " + matchScorePlayer1 + " - " + matchScorePlayer2 + " )\n\n");

    }

    public void displayMatchWinner(Player player) {
        System.out.println("The winner of the Match is : " + player.getUsername());
    }

}
