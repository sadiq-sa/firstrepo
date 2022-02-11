package com.sadiq.tennis;

import java.util.Scanner;

/**
 * Created by sadiq.
 */

public class Main {

    public static void main(String[] args) {

        DisplayInformation displayScoresImplSystemOut = new DisplayInformationImpl();

        Scanner scannerInPlayer1 = new Scanner(System.in);
        System.out.print("Please enter player1: ");
        String player1Username = scannerInPlayer1.nextLine();
        Player player1 = new Player(player1Username);

        Scanner scannerInPlayer2 = new Scanner(System.in);
        System.out.print("Please enter player2: ");
        String player2Username = scannerInPlayer2.nextLine();
        Player player2 = new Player(player2Username);

        Match match = new Match(player1, player2);
        match.play(displayScoresImplSystemOut);

    }
}
