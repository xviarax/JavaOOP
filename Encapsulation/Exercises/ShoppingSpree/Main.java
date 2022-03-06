package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

        String[] peopleInput = scanner.nextLine().split(";");
        String[] productsInput = scanner.nextLine().split(";");

        List<Person> people = readPeopleList(peopleInput);
        List<Product> products = readProductsList(productsInput);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];
            Product forBuying = findProduct(products, productName);

            if (forBuying != null) {
                for (Person person : people) {
                    if (person.getName().equals(personName)) {
                        try {
                            person.buyProduct(forBuying);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }
        printOutput(people);
    }

    private static void printOutput(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
    private static Product findProduct(List<Product> products, String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    private static List<Person> readPeopleList(String[] peopleInput) {
        List<Person> people = new ArrayList<>();
        for (String personInfo : peopleInput) {
            String name = personInfo.split("=")[0];
            double money = Double.parseDouble(personInfo.split("=")[1]);

            try {
                Person person = new Person(name, money);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return people;
    }

    private static List<Product> readProductsList(String[] productsInput) {
        List<Product> products = new ArrayList<>();

        for (String productInfo : productsInput) {
            String name = productInfo.split("=")[0];
            double cost = Double.parseDouble(productInfo.split("=")[1]);

            try {
                Product product = new Product(name, cost);
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return products;
    }
}





