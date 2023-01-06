package bunker;

import java.util.ArrayList;

public class AllCheckers extends Main{
    public static ArrayList<String> listOfWeaponInInventory = new ArrayList<>();
    public static int numberOfWeapon = 0;

    public static void numberOfWeapon() {
        if (InventoryMethods.inventoryChecker("Пистолет макарова с патронами")){
            Utils2.numberOfWeaponPlus(1);
            listOfWeaponInInventory.add("Пистолет макарова с патронами");
        }
        if (InventoryMethods.inventoryChecker("Ржавый автомат Калашникова с патронами")){
            Utils2.numberOfWeaponPlus(1);
            listOfWeaponInInventory.add("Ржавый автомат Калашникова с патронами");
        }
        if (InventoryMethods.inventoryChecker("Топор")){
            Utils2.numberOfWeaponPlus(1);
            listOfWeaponInInventory.add("Топор");
        }
        if (InventoryMethods.inventoryChecker("Армейский нож")){
            Utils2.numberOfWeaponPlus(1);
            listOfWeaponInInventory.add("Армейский нож");
        }
        if (InventoryMethods.inventoryChecker("Кастет")){
            Utils2.numberOfWeaponPlus(1);
            listOfWeaponInInventory.add("Кастет");
        }
        if (InventoryMethods.inventoryChecker("Кухонный нож")){
            Utils2.numberOfWeaponPlus(1);
            listOfWeaponInInventory.add("Кухонный нож");
        }
        Utils2.howManyWeapon();
    }
    public static void numberOfFood(){
        if (!InventoryMethods.inventoryChecker("Консервы")){
            System.out.println("Вы не смогли накормить свою команду. Ваши соседи разочарованы, что у вас нет запасов");
            Utils.reputation(-1);
        }
        if (InventoryMethods.inventoryChecker("Консервы")){
            System.out.println("Вы нашли всего одну банку консерв. Каждому досталось по чуть-чуть, но тем не менее лучше, чем ничего");
            Utils.reputation(1);
            InventoryMethods.inventoryRemover("Консервы");
        }
        if (InventoryMethods.inventoryChecker("Консервы") && InventoryMethods.inventoryChecker("Консервы")){
            System.out.println("Вы нашли целых две банки консервов. Это конечно меньше привычного рациона, но достаточно неплохо");
            Utils.reputation(2);
            InventoryMethods.inventoryRemover("Консервы");
            InventoryMethods.inventoryRemover("Консервы");
        }
        if (InventoryMethods.inventoryChecker("Консервы") && InventoryMethods.inventoryChecker("Консервы") && InventoryMethods.inventoryChecker("Консервы")){
            System.out.println("Вы нашли целых три банки консервов. Что может быть лучше для лидера, чем накормить свой отряд");
            Utils.reputation(3);
            InventoryMethods.inventoryRemover("Консервы");
            InventoryMethods.inventoryRemover("Консервы");
            InventoryMethods.inventoryRemover("Консервы");
        }
    }

    public static void numberOfWater(){
        if (!InventoryMethods.inventoryChecker("Бутылка воды")){
            System.out.println("Вы не смогли напоить свою команду. Ваши соседи разочарованы, что у вас нет запасов");
            Utils.reputation(-1);
        }
        if (InventoryMethods.inventoryChecker("Бутылка воды")){
            System.out.println("Вы нашли всего одну бутылку воды. Каждому досталось по чуть-чуть, но тем не менее лучше, чем ничего");
            Utils.reputation(1);
            InventoryMethods.inventoryRemover("Бутылка воды");
        }
        if (InventoryMethods.inventoryChecker("Бутылка воды")){
            System.out.println("Вы нашли целых две бутылки воды. Это конечно меньше привычного количества, но достаточно неплохо");
            Utils.reputation(2);
            InventoryMethods.inventoryRemover("Бутылка воды");
        }
        if (InventoryMethods.inventoryChecker("Бутылка воды")){
            System.out.println("Вы нашли целых три бутылки воды. Что может быть лучше для лидера, чем напоить свой отряд");
            Utils.reputation(3);
            InventoryMethods.inventoryRemover("Бутылка воды");
        }
    }
}
