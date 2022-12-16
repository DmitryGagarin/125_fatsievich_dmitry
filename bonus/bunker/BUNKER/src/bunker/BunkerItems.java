package bunker;

import java.util.ArrayList;

public class BunkerItems extends Utils{

    public static ArrayList<String> inventory = new ArrayList<>();
    private static String[] possibleItemsInBunker = new String[25];

    public static void possibleItemsInBunker() {
        possibleItemsInBunker = new String[]{"Консервы", "Консервы", "Консервы", "Консервы", "Консервы",
                "Бутылка воды", "Бутылка воды", "Бутылка воды", "Бутылка воды", "Бутылка воды",
                "Бинт", "Бинт", "Бинт", "Бинт", "Бинт", "Зеленка", "Пластырь", "Шприц", "Набор ампул",
                "Пистолет макарова с патронами", "Ржавый автомат Калашникова с патронами", "Рязиновый тапок 46 размера",
                "Топор", "Армейский нож", "Кастет", "Кухонный нож"
        };
    }

    public static void addRandomOfBunkerItems() {
        possibleItemsInBunker();
        //создаю счетчик выдачи рандомных предметов
        int j = (int) (Math.random() * possibleItemsInBunker.length);
        int x = (int) (Math.random() * 15);
        inventory.add(possibleItemsInBunker[j]);
        for (int i = 1; i <= x; i++) {
            int index = (int) (Math.random() * possibleItemsInBunker.length);
            if (!inventory.contains(possibleItemsInBunker[index]))
                inventory.add(possibleItemsInBunker[index]);
                else i--;
        }
        inventory.add("Фонарик");
    }

    public static void showInventory(){
        System.out.println(ANSI_PURPLE + "Ваш инвентарь: " + inventory + ANSI_RESET);
        System.out.println(" ");
    }
    public static boolean inventoryChecker(String item){
        return inventory.contains(item);
    }
    public static boolean inventoryCheckerNot (String item){
        return !inventory.contains(item);
    }
    public static void inventoryRemover (String item){
        inventory.remove(item);
    }
    public static void inventoryAdder (String item){
        inventory.add(item);
    }
}

