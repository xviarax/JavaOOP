package CardRankk;

public class Main {
    public static void main(String[] args) {
        CardRank[] cardRanks = CardRank.values();
        System.out.println("Card Ranks:");
        for (CardRank rank : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.toString());
        }

    }
}
