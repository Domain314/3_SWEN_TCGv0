package card;
import util.Constants;

import java.util.Random;

public class Deck extends Collection implements Playable{
    @Override
    public Card drawCard() {
        int rnd = Constants.RANDOM.nextInt(this.getCards().size());
        return this.getCards().remove(rnd);
//        return new Card(12394, "Goblin", "hates wall of mist", 30, Type.GOBLIN, Element.WIND);
    }

    @Override
    public void shuffleCards() {
        System.out.println("shuffle...");
    }
}
