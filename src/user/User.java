package user;

import card.Stack;

public class User extends Player{
    String userName;
    String sessionID;
    int credits;

    public User(int id, int gamesCounter, int winCounter, int elo, String userName, String sessionID, int credits) {
        super(id, gamesCounter, winCounter, elo);
        this.userName = userName;
        this.sessionID = sessionID;
        this.credits = credits;

    }

    public String getUserName() { return userName; }
    public String getSessionID() { return sessionID; }
    public int getCredits() { return credits; }

    public boolean changeCredits(int amount) {
        if (amount > credits) { return false; }
        credits -= amount;
        return true;
    }
}
