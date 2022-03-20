package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {
            // read animal and food data
            String[] animalData = input.split("\\s+");
            String[] foodData = scan.nextLine().split("\\s+");

            // create animal and food
            Animal animal = createAnimal(animalData);
            Food food = createFood(foodData);

            // invoke sound method
            animal.makeSound();
            // invoke eat method -> eat or print error message
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // add the animal to the list
            animals.add(animal);

            input = scan.nextLine();
        }

        // print animals info
        animals.forEach(System.out::println);

    }

    private static Food createFood(String[] foodData) {
        String foodType = foodData[0];
        int foodQuantity = Integer.parseInt(foodData[1]);

        if (foodType.equals("Vegetable")) {
            return new Vegetable(foodQuantity);
        } else {
            return new Meat(foodQuantity);
        }
    }

    private static Animal createAnimal(String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        switch (animalType) {
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Cat":
                String animalBreed = animalData[4];

                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalBreed);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);

        }
    }
}
