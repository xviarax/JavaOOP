package GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> itemAndQuantity = new LinkedHashMap<>();
        long gold = 0;
        long gem = 0;
        long cash = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            int quantity = Integer.parseInt(safe[i + 1]);

            String itemName = "";
            if (name.length() == 3) {
                itemName = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                itemName = "Gem";
            } else if (name.equalsIgnoreCase("gold")) {
                itemName = "Gold";
            }

            if (itemName.equals("")) {
                continue;
            } else if (bagCapacity < itemAndQuantity.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (itemName) {
                case "Gem":
                    if (!itemAndQuantity.containsKey(itemName)) {
                        if (itemAndQuantity.containsKey("Gold")) {
                            if (quantity > itemAndQuantity.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (itemAndQuantity.get(itemName).values().stream().mapToLong(e -> e).sum() + quantity > itemAndQuantity.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!itemAndQuantity.containsKey(itemName)) {
                        if (itemAndQuantity.containsKey("Gem")) {
                            if (quantity > itemAndQuantity.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (itemAndQuantity.get(itemName).values().stream().mapToLong(e -> e).sum() + quantity > itemAndQuantity.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!itemAndQuantity.containsKey(itemName)) {
                itemAndQuantity.put((itemName), new LinkedHashMap<>());
            }

            if (!itemAndQuantity.get(itemName).containsKey(name)) {
                itemAndQuantity.get(itemName).put(name, 0L);
            }


            itemAndQuantity.get(itemName).put(name, itemAndQuantity.get(itemName).get(name) + quantity);
            if (itemName.equals("Gold")) {
                gold += quantity;
            } else if (itemName.equals("Gem")) {
                gem += quantity;
            } else if (itemName.equals("Cash")) {
                cash += quantity;
            }
        }

        itemAndQuantity.entrySet().forEach(x -> {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));
            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        });
    }
}

