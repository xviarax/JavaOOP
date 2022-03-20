package Vehicles;

import java.text.DecimalFormat;
import java.util.Locale;

public  class BaseVehicle implements Vehicle{
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;


    public BaseVehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }
    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        if (fuelNeeded > this.fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        this.fuelQuantity = this.fuelQuantity - fuelNeeded;

        String.format("%s",distance).replaceAll("\\.0+$", "");
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }


    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        if (liters > this.tankCapacity - this.fuelQuantity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        this.fuelQuantity = this.fuelQuantity + liters;

    }

    @Override
    public String toString() {
        return String.format(Locale.US,"%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
