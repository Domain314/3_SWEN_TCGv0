package card;

public class Card {
    private int id;
    private String cardName;
    private String description;
    private int damage;
    private Type type;
    private Element element;

    public int getID() { return id; }
    public String getCardName() { return cardName; }
    public String getDescription() { return description; }
    public int getDamage() { return damage; }
    public Type getType() { return type; }
    public Element getElement() { return element; }

    public Card(int id, String cardName, String description, int damage, Type type, Element element) {
        this.id = id;
        this.cardName = cardName;
        this.description = description;
        this.damage = damage;
        this.type = type;
        this.element = element;
    }
}
