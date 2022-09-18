package user;

import card.Deck;
import card.Stack;

import java.util.List;

public class Player {
    int id;
    Deck deck;
    Stack stack;
    int gamesCounter;
    int winCounter;
    int elo;

    public Player(int id, int gamesCounter, int winCounter, int elo) {
        this.id = id;
        this.elo = elo;
        this.gamesCounter = gamesCounter;
        this.winCounter = winCounter;
        this.deck = new Deck();
        this.stack = new Stack();
    }

    public int getID() { return id; }
    public int getElo() { return elo; }
    public int getGamesCounter() { return gamesCounter; }
    public int getWinCounter() { return winCounter; }
    public Deck getDeck() { return deck; }
    public Stack getStack() { return stack; }

    public void changeElo(int eloAmount) { elo += eloAmount; }
    public void endGame(int eloAmount) {
        changeElo(eloAmount);
        gamesCounter++;
    }
    public void endGame(int eloAmount, boolean win) {
        changeElo(eloAmount);
        gamesCounter++;
        winCounter++;
    }
}
