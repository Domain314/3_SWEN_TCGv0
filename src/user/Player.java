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

    public Player(int id, int gamesCounter, int winCounter) {
        this.id = id;
        this.gamesCounter = gamesCounter;
        this.winCounter = winCounter;
        this.deck = new Deck();
        this.stack = new Stack();
    }

    public int getID() { return id; }
    public int getGamesCounter() { return gamesCounter; }
    public int getWinCounter() { return winCounter; }
    public Deck getDeck() { return deck; }
    public Stack getStack() { return stack; }

    public void addCounter() {
        gamesCounter++;
    }
    public void addCounter(boolean win) {
        gamesCounter++;
        winCounter++;
    }
}
