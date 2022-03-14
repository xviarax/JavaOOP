package CarShop;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double minPricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double minPricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.minPricePerDay = minPricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.minPricePerDay;
    }
}
