package bunker;

public class InventoryMethods extends BunkerItems{

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
