package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> collection = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] split = input.split("[\\s]+");

            String type = split[0];
            switch (type) {
                case "Citizen":
                    addCitizen(split, collection);
                    break;

                case "Pet":
                    addPet(split, collection);
                    break;

                case "Robot":
                    createRobot(split);
                    break;
            }
            input = scanner.nextLine();
        }

        String year = scanner.nextLine();
        for (Birthable element : collection) {
            if (element.getBirthDate().endsWith(year)) {
                System.out.println(element.getBirthDate());
            }
        }
    }

    private static void addCitizen(String[] tokens, List<Birthable> collection) {
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String id = tokens[3];
        String birthdate = tokens[4];

        Citizen citizen = new Citizen(name, age, id, birthdate);
        collection.add(citizen);
    }

    private static void addPet(String[] tokens, List<Birthable> collection) {
        String name = tokens[1];
        String birthdate = tokens[2];

        Pet pet = new Pet(name, birthdate);
        collection.add(pet);
    }

    private static void createRobot(String[] tokens) {
        String model = tokens[1];
        String id = tokens[2];

        Robot robot = new Robot(id, model);
    }
}
