package CardSuit;

public class Main {
    public static void main(String[] args) {
        CardSuits[] cardsSuit = CardSuits.values();
        System.out.println("Card Suits:");
        for (CardSuits cardSuits : cardsSuit) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuits.ordinal(), cardSuits.toString());
        }

    }
}
