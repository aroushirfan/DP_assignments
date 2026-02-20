package template;

import java.util.Random;
import java.util.Scanner;

public class CoinFlipGame extends Game {
    private int winner = -1;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Starting Coin Flip Game with " + numberOfPlayers + " players.");
        System.out.println("First player to flip HEADS wins.");
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

    @Override
    public void playSingleTurn(int player) {
        int displayPlayer = player + 1;
        System.out.println("Player " + displayPlayer + " flips the coin...");
        boolean heads = random.nextBoolean();
        if (heads) {
            System.out.println("HEADS!");
            winner = displayPlayer;
        } else {
            System.out.println("TAILS.");
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Player " + winner + " wins the game!");
    }
}