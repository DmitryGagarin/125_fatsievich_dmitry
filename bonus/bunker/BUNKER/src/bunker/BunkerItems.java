package bunker;

import java.util.ArrayList;

public class BunkerItems extends Utils{

    public static ArrayList<String> inventory = new ArrayList<>();
    public static String[] possibleItemsInBunker = new String[25];

    public static void possibleItemsInBunker() {
        possibleItemsInBunker = new String[]{"Консервы", "Консервы", "Консервы", "Консервы", "Консервы",
                "Бутылка воды", "Бутылка воды", "Бутылка воды", "Бутылка воды", "Бутылка воды",
                "Бинт", "Бинт", "Бинт", "Бинт", "Бинт", "Зеленка", "Пластырь", "Шприц", "Набор ампул",
                "Пистолет макарова с патронами", "Ржавый автомат Калашникова с патронами", "Резиновый тапок 46 размера",
                "Топор", "Армейский нож", "Кастет", "Кухонный нож"
        };
    }

    public static void addRandomItemsToBunker() {
        possibleItemsInBunker();
        //создаю счетчик выдачи рандомных предметов
        int j =  (int) (Math.random() * possibleItemsInBunker.length);
        int x = 2 + (int) (Math.random() * 12);
        inventory.add(possibleItemsInBunker[j]);
        for (int i = 1; i <= x; i++) {
            int index = (int) (Math.random() * possibleItemsInBunker.length);
            if (!inventory.contains(possibleItemsInBunker[index]))
                InventoryMethods.inventoryAdder(possibleItemsInBunker[index]);
                else i--;
        }
        inventory.add("Фонарик");
    }
}

