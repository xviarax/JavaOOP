package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String ranking = scanner.nextLine(); // two
    String suiting = scanner.nextLine(); // clubs

    Card card = new Card(CardRank.valueOf(ranking), CardSuits.valueOf(suiting));
        System.out.printf("Card name: %s of %s; Card power: %d", ranking, suiting,card.getPower());

    }
}
