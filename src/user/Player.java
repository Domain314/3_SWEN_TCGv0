package user;

import card.Deck;

import java.util.List;

public class Player {
    int id;
    Deck deck;
    int gamesCounter;
    int winCounter;

    public Player(int id, int gamesCounter, int winCounter) {
        this.id = id;
        this.gamesCounter = gamesCounter;
        this.winCounter = winCounter;
    }

    public int getID() { return id; }
    public int getGamesCounter() { return gamesCounter; }
    public int getWinCounter() { return winCounter; }
    public Deck getDeck() { return deck; }

    public void addCounter() {
        gamesCounter++;
    }
    public void addCounter(boolean win) {
        gamesCounter++;
        winCounter++;
    }
}
