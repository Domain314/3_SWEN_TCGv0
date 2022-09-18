package testing;

import card.Card;
import game.CardGenerator;
import game.Game;
import overseer.Overseer;
import user.Player;
import user.User;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

public class TestEnv {
    int userAmount = 2;
    int cardsPerStack = 20;
    int testGamesMax = 30;

    public TestEnv() {
        initTestEnv();
        simulateGames();
    }

    private void initTestEnv() {
        genUsers();
        System.out.println("User generation done");
    }

    private void genUsers() {
        for (int i = 0; i < userAmount; i++) {
            User newUser = new User(1234 + i, 0, 0, 1500, String.format("Player%d", i), "abc123", 420);
            for (int j = 0; j < cardsPerStack; j++) {
                Card newCard = CardGenerator.generateRandomCard();
                Overseer.addCard(newCard);
                newUser.getStack().addCard(newCard);
            }
            Overseer.addUser(newUser);
        }
    }

    private void simulateGames() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < userAmount; i++) {
            players.add(Overseer.getAllUsers().get(i));
        }
        for (int i = 0; i < testGamesMax; i++) {
            preparePlayers(players);
            Game newGame = new Game(players);
            Overseer.addGame(newGame);
            runGame(newGame);
        }
    }

    private void preparePlayers(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getDeck().getCards().size() != Constants.CARDS_PER_DECK) {
                chooseBestCardsForDeck(players.get(i));
            }
        }
    }

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

    private void runGame(Game newGame) {
        while(newGame.getIsActive()) {
            newGame.makeRound();
        }
    }
}
