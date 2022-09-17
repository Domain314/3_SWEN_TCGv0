package testing;

import card.Card;
import game.CardGenerator;
import overseer.Overseer;
import user.User;

public class TestEnv {
    int userAmount = 2;
    int cardsPerStack = 20;

    public TestEnv() {
        initTestEnv();
    }

    private void initTestEnv() {
        for (int i = 0; i < userAmount; i++) {
            User newUser = new User(1234 + i, 0, 0, String.format("dom%d", i), "abc123", 420);
            for (int j = 0; j < cardsPerStack; j++) {
                Card newCard = CardGenerator.generateRandomCard();
                Overseer.addCard(newCard);
                newUser.getStack().addCard(newCard);
            }
            Overseer.addUser(newUser);
        }

        System.out.println("done");
    }
}
