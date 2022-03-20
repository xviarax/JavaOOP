package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split(" ");
        double carFuelQuan = Double.parseDouble(carInfo[1]);
        double carLitersPerKm = Double.parseDouble(carInfo[2]);
        double tankCapacity = Double.parseDouble(carInfo[3]);
        BaseVehicle car = new Car(carFuelQuan, carLitersPerKm, tankCapacity);

        String[] truckInfo = scanner.nextLine().split(" ");
        double truckFuelQuan = Double.parseDouble(truckInfo[1]);
        double truckLitersPerKm = Double.parseDouble(truckInfo[2]);
        double tankCapacity1 = Double.parseDouble(truckInfo[3]);
        BaseVehicle truck = new Truck(truckFuelQuan, truckLitersPerKm,tankCapacity1);

        String[] busInfo = scanner.nextLine().split(" ");
        double busFuelQuan = Double.parseDouble(busInfo[1]);
        double busLitersPerKm = Double.parseDouble(busInfo[2]);
        double busCapacity2 = Double.parseDouble(busInfo[3]);
        BaseVehicle bus = new Bus(busFuelQuan, busLitersPerKm,busCapacity2);

        Map<String, BaseVehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
             switch (command[0]){

                 case "Drive":
                     double distance = Double.parseDouble(command[2]);
                     BaseVehicle vehicle = vehicles.get(command[1]);
                     if (vehicle instanceof Bus){
                         bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                         System.out.println(bus.drive(distance));
                         bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                        continue;
                     }

                     System.out.println(vehicles.get(command[1]).drive(distance));

                     break;
                 case "Refuel":
                     double fuelAmount = Double.parseDouble(command[2]);
                     vehicles.get(command[1]).refuel(fuelAmount);
                     break;
                 case "DriveEmpty":
                     double driveEmDistance = Double.parseDouble(command[2]);
                     String message = bus.drive(driveEmDistance);
                     System.out.println(message);
                     break;
             }
        }

        vehicles.values().forEach(System.out::println);




    }
}
