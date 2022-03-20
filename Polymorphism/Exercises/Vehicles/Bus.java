package Vehicles;

public class Bus extends BaseVehicle {
    public static final double AC_INCREASE = 1.4;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = true;
    }

    public void setEmpty(boolean empty) {
        if (this.isEmpty == empty) {
            return;
        }

        if (this.isEmpty) {
            super.setFuelConsumption(super.getFuelConsumption() + AC_INCREASE);
        }

        if (!this.isEmpty && empty) {
            super.setFuelConsumption(super.getFuelConsumption() - AC_INCREASE);
        }

        this.isEmpty = empty;
    }
}



