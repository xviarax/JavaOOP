package CardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuits suits;
    private int power;

    public Card(CardRank rank, CardSuits suits) {
        this.rank = rank;
        this.suits = suits;
        this.power = this.rank.getCardPower() + this.suits.getSuitPower();
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuits getSuits() {
        return suits;
    }

    public int getPower() {
        return power;
    }


}
