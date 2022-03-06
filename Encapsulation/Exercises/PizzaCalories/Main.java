package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");

        try {
            String pizzaName = parts[1];
            int toppingsCount = Integer.parseInt(parts[2]);
            Pizza pizza = new Pizza(pizzaName, toppingsCount);
            parts = scanner.nextLine().split("\\s+");

            String flourType = parts[1];
            String bakingTechnique = parts[2];
            double weight = Double.parseDouble(parts[3]);

            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);
            input = scanner.nextLine();

            while (!input.equals("END")) {
                parts = input.split("\\s+");

                String toppingType = parts[1];
                double weightInGrams = Double.parseDouble(parts[2]);

                Topping topping = new Topping(toppingType, weightInGrams);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }
            System.out.println(pizza);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

