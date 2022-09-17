package game;

import user.Player;
import util.Constants;

import java.util.List;

public class Game {
     List<Player> players;
     int round = 0;

    public List<Player> getPlayers() { return players; }
    public int getRound() { return round; }

    public boolean addRound() {
        if (round+1 >= Constants.MAX_ROUNDS_PER_GAME) { return false; }
        round++;
        return true;
    }

    public void makeRound() {
        if (!addRound()) {
            System.out.println("Limit of rounds reached! \nDraw.");
            return;
        }
        System.out.println("make round.." + round);
     }
}
