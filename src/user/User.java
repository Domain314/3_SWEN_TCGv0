package user;

import card.Stack;

public class User extends Player implements Comparable<User>{
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

//    return false, if not enough credits, to subtract.
    public boolean changeCredits(int amount) {
        if (credits + amount < 0) { return false; }
        credits += amount;
        return true;
    }

    @Override
    public int compareTo(User user) {
        return user.getElo() - this.getElo();
    }
}
