package HotelReservation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] input = scanner.nextLine().split(" ");

    double pricePerDay = Double.parseDouble(input[0]);
    int numberOfDays = Integer.parseInt(input[1]);
    Season currSeason = Season.valueOf(input[2]);
    DiscountType discountType = DiscountType.valueOf(input[3]);


    double finalPrice = PriceCalculator.calculateFinalPrice(pricePerDay,numberOfDays,currSeason,discountType);
        System.out.printf(Locale.US,"%.2f",finalPrice);

    }
}
