package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] colors = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        List<Light> trafficLights = new ArrayList<>();
        for (String color : colors) {
            Light light = new Light(Color.valueOf(color));
            trafficLights.add(light);
        }

        for (int i = 0; i < n ; i++) {
            trafficLights.forEach(light -> {
                light.changeTheColor();
                System.out.print(light.getColor() + " ");
            });
            System.out.println();
        }


    }
}
