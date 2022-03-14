package BorderControl;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> data = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] input = command.split("[\\s]+");
            Identifiable identifiable;
            String name = input[0];

            if (input.length == 2) {
                String id = input[1];

                identifiable = new Robot(name, id);
            } else {
                int age = Integer.parseInt(input[1]);
                String id = input[2];

                identifiable = new Citizen(name, age, id);
            }
            data.add(identifiable);

            command = scanner.nextLine();
        }

        String fakeDigits = scanner.nextLine();

        System.out.println(data.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeDigits))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}