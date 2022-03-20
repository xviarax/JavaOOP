package Vehicles;

import java.text.DecimalFormat;
import java.util.Locale;

public class Car extends BaseVehicle {
    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = this.fuelConsumption + ADDITIONAL_AC_CONSUMPTION;
    }




//
//    public void  refuel(double liters) {
//        if (liters <= 0) {
//            System.out.println("Fuel must be a positive number");
//            return;
//        }
//        if (liters > this.tankCapacity - this.fuelQuantity) {
//            System.out.println("Cannot fit fuel in tank");
//            return;
//        }
//
//    }




}

