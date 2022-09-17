package user;

import card.Stack;

public class User extends Player{
    String userName;
    String sessionID;
    int credits;
    Stack stack;

    public User(int id, int gamesCounter, int winCounter, String userName, String sessionID, int credits) {
        super(id, gamesCounter, winCounter);
        this.userName = userName;
        this.sessionID = sessionID;
        this.credits = credits;
        this.stack = new Stack();
    }

    public String getUserName() { return userName; }
    public String getSessionID() { return sessionID; }
    public int getCredits() { return credits; }
    public Stack getStack() { return stack; }

    public boolean changeCredits(int amount) {
        if (amount > credits) { return false; }
        credits -= amount;
        return true;
    }
}
