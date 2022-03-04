package HotelReservation;

public class PriceCalculator {

    public static double calculateFinalPrice(double pricePerDay, int days,Season season, DiscountType discountType){
        double price = pricePerDay * days;
        price = price * season.getMultiplier();
        price = price * (100 - discountType.getDiscount()) / 100.0;
        return price;

    }




}
