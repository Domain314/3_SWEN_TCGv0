package card;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

public class Deck extends Collection implements IPlayable{
    @Override
    public Card drawCard() {
        int rnd = Constants.RANDOM.nextInt(this.getCards().size());
        return this.getCards().remove(rnd);
    }

    @Override
    public void shuffleCards() {
        System.out.println("shuffle...");
    }

}
