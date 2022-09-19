package testing;

import card.Card;
import game.CardGenerator;
import game.Game;
import overseer.Overseer;
import user.Player;
import user.User;
import util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestEnv {
    private int userAmount = 10;
    private int cardsPerStack = 20;
    private int testGamesMax = 1;
    private int simulationsAmount = 1000;

    private static String[] playerNamesPrefixes = {
            "Frog", "Dr", "Th3", "MindOf", "Kev", "Captain", "Edge", "Kohlrabi", "Alcohol", "Master", "Angel", "Killer",
            "Milf", "Clumsy", "Lucky", "Wild", "Warped", "Sniper", "Liquid", "Thanos", "Enko", "Crimson", "Weed", "Greedy",
            "Last", "Imaginary", "Manic", "Kendal", "RickN", "Edgy", "Drogo", "Atom", "Snap", "Web", "The", "Lost"};
    private static String[] playerNamesSuffixes = {
            "Milk", "Caring", "Th30d0r3", "Kevin", "K3v1n", "Smart", "Carmin", "Scare", "Squirrel", "Tolkien",
            "Diet", "Offensively", "Wild", "Sheriff", "German", "Kiyoshi", "Thanos", "Destroyer", "Maniac",
            "Life", "Image", "Flux", "NMorty", "Morty", "Karen", "Doggo", "A", "B", "Master", "Slayer"};
    private static String[] playerNums = {
            "420", "80", "81", "82", "83", "84", "85", "86", "87","88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99",
            "123", "314", "3060", "360", "720", "1080", "007", "001", "1", "2", "3", "666", "999", "69", "6969",
            "2020", "2021", "2022", "3000", "4000", "5000", "6000", "9000", "2050"};

//    Generate random NPC name, out of prefix, suffix and a number.
    private String randomName() {
        return playerNamesPrefixes[Constants.RANDOM.nextInt(playerNamesPrefixes.length)] +
                playerNamesSuffixes[Constants.RANDOM.nextInt(playerNamesSuffixes.length)] +
                playerNums[Constants.RANDOM.nextInt(playerNums.length)];
    }

//    Initialize TestEnv,run n-simulations and display result.
    public TestEnv() {
        initTestEnv();
        for (int i = 0; i < simulationsAmount; i++) {
            simulateGames();
        }
        displayResults();
    }

//    Initialize TestEnv
    private void initTestEnv() {
        genUsers();
        System.out.println("User generation done");
    }

//    Generate Users and generate Cards for their stack
    private void genUsers() {
        for (int i = 0; i < userAmount; i++) {
            User newUser = new User(1234 + i, 0, 0, 1500, randomName(), "abc123", 200);
            for (int j = 0; j < cardsPerStack; j++) {
                Card newCard = CardGenerator.generateRandomCard();
                Overseer.addCard(newCard);
                newUser.getStack().addCard(newCard);
            }
            Overseer.addUser(newUser);
        }
    }

//    get 2 random Player, prepare their Decks (take 4 Cards from Stack) and run the game.
    private void simulateGames() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            players.add(getRandomPlayer());
        }
        for (int i = 0; i < testGamesMax; i++) {
            preparePlayers(players);
            Game newGame = new Game(players);
            Overseer.addGame(newGame);
            runGame(newGame);
        }
    }

//    Choose a random player
    private Player getRandomPlayer() {
        return Overseer.getAllUsers().get(Constants.RANDOM.nextInt(Overseer.getAllUsers().size()));
    }

//    prepare Decks for both players
    private void preparePlayers(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getDeck().getCards().size() != Constants.CARDS_PER_DECK) {
                chooseBestCardsForDeck(players.get(i));
            }
        }
    }

//    Check all cards in stack and choose only the best for the deck
    private void chooseBestCardsForDeck(Player player) {
        List<Card> deck = player.getDeck().getCards();
        List<Card> stack = player.getStack().getCards();

        if (deck.size() > Constants.CARDS_PER_DECK) {
            for (int i = deck.size() - 1 ; i >= 0 ; i--) {
                stack.add(deck.remove(i));
            }
        }

        if (stack.size() < Constants.CARDS_PER_DECK) {
            player.getStack().addCard(CardGenerator.generatePackage());
        }

        while (deck.size() < Constants.CARDS_PER_DECK) {
            int highestIndex = -1, highestDamage = Integer.MIN_VALUE;
            for (int i = 0; i < stack.size(); i++) {
                Card card = stack.get(i);
                if (card.getDamage() > highestDamage) {
                    highestIndex = i;
                    highestDamage = card.getDamage();
                }
            }
            if (highestIndex == -1) {
                System.out.println("something went wrong. abort choosing cards");
                return;
            }
            deck.add(stack.remove(highestIndex));
        }
    }

//    Make Rounds, until the game is over.
    private void runGame(Game newGame) {
        while(newGame.getIsActive()) {
            newGame.makeRound();
        }
    }

//    Log all results
    private void displayResults() {
        Collections.sort(Overseer.getAllUsers());
        List<User> users = Overseer.getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(String.format(
                    "%d. %d - %d/%d - %s",
                    i+1,
                    users.get(i).getElo(),
                    users.get(i).getWinCounter(),
                    users.get(i).getGamesCounter(),
                    users.get(i).getUserName())
            );
        }
    }
}
