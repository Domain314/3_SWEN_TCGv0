package game;

import card.Card;
import card.Element;
import card.Type;
import util.Constants;

public class CardGenerator {
    static String[] cardNamePrefix = {
            "Enhanced", "Ominous", "Vicious", "Diabolic", "Exalted", "Celestial", "Dark", "Radiant", "Chaotic",
            "Glowing", "Elysian", "Misty", "Shapeshifting", "Ethereal", "Barbaric", "Evil", "Prophetic", "Bloody",
            "Poisonous", "Imaginary", "Silvery", "Cryptic", "Glistening", "Molten", "Ghostly", "Luminous", "Stoned"};

    private static String getRandomCardNamePrefix() {
        return cardNamePrefix[Constants.RANDOM.nextInt(cardNamePrefix.length)];
    }

    private static String getElement(Element element) {
        switch (element) {
            case WATER: return "Water-";
            case FIRE: return "Fire-";
            case ICE: return "Ice-";
            case WIND: return "Wind-";
            default: return "";
        }
    }

    private static String getType(Type type) {
        switch (type) {
            case GOBLIN: return "Goblin";
            case WIZARD: return "Wizard";
            case DRAGON: return "Dragon";
            case KNIGHT: return "Knight";
            case KRAKEN: return "Kraken";
            case ELV: return "Elv";
            case SPELL: return "Spell";
            default: return "";
        }
    }

    private static String generateName(Element element, Type type) {
        return String.format("%s %s%s", getRandomCardNamePrefix(), getElement(element), getType(type));
    }

    private static Type getRandomType() {
        int rnd = Constants.RANDOM.nextInt(Constants.RANDOM_TYPE_CHANCE);
        switch (rnd) {
            case 0: return Type.GOBLIN;
            case 1: return Type.WIZARD;
            case 2: return Type.DRAGON;
            case 3: return Type.KNIGHT;
            case 4: return Type.KRAKEN;
            case 5: return Type.ELV;
            default: return Type.SPELL;
        }
    }

    private static Element getRandomElement() {
        int rnd = Constants.RANDOM.nextInt(Constants.RANDOM_ELEMENT_CHANCE);
        switch (rnd) {
            case 0: return Element.WATER;
            case 1: return Element.FIRE;
            case 2: return Element.ICE;
            case 3: return Element.WIND;
            default: return Element.NORMAL;
        }
    }

    private static int getRandomDamage() {
        return Constants.RANDOM.nextInt(Constants.RANDOM_DAMAGE_FROM, Constants.RANDOM_DAMAGE_TO)*10;
    }

    public static Card generateRandomCard() {
        int rndID = Constants.RANDOM.nextInt(Constants.RANDOM_ID_FROM, Constants.RANDOM_ID_TO);
        Element rndElement = getRandomElement();
        Type rndType = getRandomType();
        String rndName = generateName(rndElement, rndType);
        int rndDamage = getRandomDamage();

        return new Card(rndID, rndName, "descr", rndDamage, rndType, rndElement);
    }

}
