package bunker;

public class SpecialFeatures extends CharactersChoice {

    public static void characterExtraLootChecker() {
        if (peopleInBunker.contains("Акушер") || peopleInBunker.contains("Вирусолог") || peopleInBunker.contains("Инфекционист") ||
                peopleInBunker.contains("Фармацевт") || peopleInBunker.contains("Фельдшер") || peopleInBunker.contains("Хирург")) {
            addExtraItemsDoctors();
        }
        if (peopleInBunker.contains("Телохранитель") || peopleInBunker.contains("Спасатель") || peopleInBunker.contains("Полицейский") ||
                peopleInBunker.contains("Инструктор по выживанию") || peopleInBunker.contains("Депутат") || peopleInBunker.contains("Охранник") ||
                peopleInBunker.contains("Пожарный")){
            addExtraItemsSoldiers();
        }
        if (peopleInBunker.contains("Строитель") || peopleInBunker.contains("Сантехник") || peopleInBunker.contains("Дровосек") ||
                peopleInBunker.contains("Инженер") || peopleInBunker.contains("Плотник") || peopleInBunker.contains("Электрик")){
            addExtraItemsEngineers();
        }
        if (peopleInBunker.contains("Географ") || peopleInBunker.contains("Геолог") || peopleInBunker.contains("Грузчик") ||
                peopleInBunker.contains("Повар") || peopleInBunker.contains("Фермер") || peopleInBunker.contains("Бизнесмен")){
            addExtraItemsOrdinaryPeople();
        }
    }

    public static void addExtraItemsDoctors(){
        int extraItemChance = 1 + (int) (Math.random() * 50);
        if (extraItemChance % 3 == 0) {
            InventoryMethods.inventoryAdder("Бинт");
        }
        if (extraItemChance % 5 == 0) {
            InventoryMethods.inventoryAdder("Бинт");
            InventoryMethods.inventoryAdder("Бинт");
        }
        if (extraItemChance % 7 == 0) {
            InventoryMethods.inventoryAdder("Бинт");
            InventoryMethods.inventoryAdder("Бинт");
            InventoryMethods.inventoryAdder("Бинт");
        }
    }

    public static void addExtraItemsSoldiers(){
        int extraItemChance = 1 + (int) (Math.random() * 70);
        Utils.setReputation(1);
        if (extraItemChance % 2 == 0){
            InventoryMethods.inventoryAdder("Резиновый тапок 46 размера");
        }
        if (extraItemChance % 5 == 0){
            InventoryMethods.inventoryAdder("Кастет");
        }
        if (extraItemChance % 7 == 0) {
            InventoryMethods.inventoryAdder("Армейский нож");
        }
        if (extraItemChance % 9 == 0) {
            InventoryMethods.inventoryAdder("Пистолет макарова с патронами");
        }
        if (extraItemChance % 11 == 0) {
            InventoryMethods.inventoryAdder("Ржавый автомат Калашникова с патронами");
        }
    }

    public static void addExtraItemsEngineers(){
        int extraItemChance = 1 + (int) (Math.random() * 70);
        if (extraItemChance % 2 == 0){
            InventoryMethods.inventoryAdder("Резиновый тапок 46 размера");
        }
        if (extraItemChance % 10 == 0) {
            InventoryMethods.inventoryAdder("Кастет");
        }
        if (extraItemChance % 15 == 0) {
            InventoryMethods.inventoryAdder("Топор");
        }
        if (extraItemChance % 17 == 0) {
            InventoryMethods.inventoryAdder("Бинт");
            InventoryMethods.inventoryAdder("Бутылка воды");
        }
    }

    public static void addExtraItemsOrdinaryPeople(){
        int extraItemChance = 1 + (int) (Math.random() * 70);
        if (extraItemChance % 2 == 0){
            InventoryMethods.inventoryAdder("Консервы");
        }
        if (extraItemChance % 5 == 0) {
            InventoryMethods.inventoryAdder("Консервы");
            InventoryMethods.inventoryAdder("Консервы");
        }
        if (extraItemChance % 7 == 0) {
            InventoryMethods.inventoryAdder("Топор");
            InventoryMethods.inventoryAdder("Консервы");
            InventoryMethods.inventoryAdder("Консервы");
        }
        if (extraItemChance % 9 == 0){
            InventoryMethods.inventoryAdder("Консервы");
            InventoryMethods.inventoryAdder("Бутылка воды");
            InventoryMethods.inventoryAdder("Бутылка воды");
        }
        if (extraItemChance % 11 == 0) {
            InventoryMethods.inventoryAdder("Консервы");
            InventoryMethods.inventoryAdder("Консервы");
            InventoryMethods.inventoryAdder("Бутылка воды");
            InventoryMethods.inventoryAdder("Бутылка воды");
        }
    }
}
