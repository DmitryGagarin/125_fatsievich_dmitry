package bunker;

public class Fight extends Utils2{

    public static String myCharacter;
    public static int teamHealth = 0;
    public static int teamDamage = 0;
    public static int enemyTeamHealth = 130 + (int) (Math.random() * 200);
    public static int enemyTeamDamage = 30 + (int) (Math.random() * 100);
    public static int myHealth;
    public static int neighbour1Health;
    public static int neighbour2Health;

    public static int giveMyCharacterHealth(String myCharacter) {
        if (myCharacter.equals("Акушер") || myCharacter.equals("Вирусолог") || myCharacter.equals("Инженер") ||
                myCharacter.equals("Инфекционист") || myCharacter.equals("Плотник") || myCharacter.equals("Повар") ||
                myCharacter.equals("Сантехник") || myCharacter.equals("Фермер") || myCharacter.equals("Хирург"))
                myHealth = 70;
            if (myCharacter.equals("Бизнесмен") || myCharacter.equals("Дровосек") || myCharacter.equals("Строитель") ||
                myCharacter.equals("Фармацевт") || myCharacter.equals("Фельдшер") || myCharacter.equals("Охранник"))
                myHealth = 80;
            if (myCharacter.equals("Географ") || myCharacter.equals("Геолог") || myCharacter.equals("Электрик"))
                myHealth = 60;
            if (myCharacter.equals("Грузчик") || myCharacter.equals("Депутат"))
                myHealth = 90;
            if (myCharacter.equals("Инструктор По Выживанию") || myCharacter.equals("Пожарный") ||
                myCharacter.equals("Полицейский") || myCharacter.equals("Спасатель") || myCharacter.equals("Телохранитель"))
                myHealth = 100;
            return myHealth;
    }

    public static int giveMyTheFirstNeighbourHealth(String myNeighbour1) {
            if (myNeighbour1.equals("Акушер") || myNeighbour1.equals("Вирусолог") || myNeighbour1.equals("Инженер") ||
                myNeighbour1.equals("Инфекционист") || myNeighbour1.equals("Плотник") || myNeighbour1.equals("Повар") ||
                myNeighbour1.equals("Сантехник") || myNeighbour1.equals("Фермер") || myNeighbour1.equals("Хирург"))
                neighbour1Health = 70;
            if (myNeighbour1.equals("Бизнесмен") || myNeighbour1.equals("Дровосек") || myNeighbour1.equals("Строитель") ||
                myNeighbour1.equals("Фармацевт") || myNeighbour1.equals("Фельдшер") || myNeighbour1.equals("Охранник"))
                neighbour1Health = 80;
            if (myNeighbour1.equals("Географ") || myNeighbour1.equals("Геолог") || myNeighbour1.equals("Электрик"))
                neighbour1Health = 60;
            if (myNeighbour1.equals("Грузчик") || myNeighbour1.equals("Депутат"))
                neighbour1Health = 90;
            if (myNeighbour1.equals("Инструктор По Выживанию") || myNeighbour1.equals("Пожарный") ||
                myNeighbour1.equals("Полицейский") || myNeighbour1.equals("Спасатель") || myNeighbour1.equals("Телохранитель"))
                neighbour1Health = 100;
            return neighbour1Health;
    }
    public static int giveMyTheSecondNeighbourHealth(String myNeighbour2) {
            if (myNeighbour2.equals("Акушер") || myNeighbour2.equals("Вирусолог") || myNeighbour2.equals("Инженер") ||
                myNeighbour2.equals("Инфекционист") || myNeighbour2.equals("Плотник") || myNeighbour2.equals("Повар") ||
                myNeighbour2.equals("Сантехник") || myNeighbour2.equals("Фермер") || myNeighbour2.equals("Хирург"))
                neighbour2Health = 70;
            if (myNeighbour2.equals("Бизнесмен") || myNeighbour2.equals("Дровосек") || myNeighbour2.equals("Строитель") ||
                myNeighbour2.equals("Фармацевт") || myNeighbour2.equals("Фельдшер") || myNeighbour2.equals("Охранник"))
                neighbour2Health = 80;
            if (myNeighbour2.equals("Географ") || myNeighbour2.equals("Геолог") || myNeighbour2.equals("Электрик"))
                neighbour2Health = 60;
            if (myNeighbour2.equals("Грузчик") || myNeighbour2.equals("Депутат"))
                neighbour2Health = 90;
            if (myNeighbour2.equals("Инструктор По Выживанию") || myNeighbour2.equals("Пожарный") ||
                myNeighbour2.equals("Полицейский") || myNeighbour2.equals("Спасатель") || myNeighbour2.equals("Телохранитель"))
                neighbour2Health = 100;
            return neighbour2Health;
    }

    public static int setTeamHealth(int myHealth, int neighbour1Health, int neighbour2Health){
        teamHealth = myHealth + neighbour1Health + neighbour2Health;
        return teamHealth;
    }

    public static void giveTeamDamage(){
        if (InventoryMethods.inventoryChecker("Пистолет макарова с патронами"))
            setTeamDamage(30);
        if (InventoryMethods.inventoryChecker("Ржавый автомат Калашникова с патронами"))
            setTeamDamage(60);
        if (InventoryMethods.inventoryChecker("Топор"))
            setTeamDamage(15);
        if (InventoryMethods.inventoryChecker("Армейский нож"))
            setTeamDamage(10);
        if (InventoryMethods.inventoryChecker("Кастет"))
            setTeamDamage(10);
        if (InventoryMethods.inventoryChecker("Кухонный нож"))
            setTeamDamage(10);
    }

    public static void setTeamDamage(int damage) {
        teamDamage = teamDamage + damage;
    }

    public static void finalFight(int reputation, int teamDamage, int teamHealth, int enemyTeamDamage, int enemyTeamHealth){
        if (1.1 * reputation * teamDamage + teamHealth < 1.1 * enemyTeamDamage + enemyTeamHealth ) {
            System.out.println(ANSI_RED + "К сожалению, вы проиграли. Вам не хватило " + ((1.1 * enemyTeamDamage + enemyTeamHealth) - (1.1 * reputation * teamDamage + teamHealth)) + " урона.");
            System.out.println("Вам лично не хватило репутации, а команде оружия");
            System.out.println("В следующий раз относитель к выбору команде и действий внимательнее" + ANSI_RESET);
            System.exit(0);
        }
        else {
            System.out.println(ANSI_GREEN + "Ура победа - победа ура. Вам хватило удачи и навыков, чтобы защитить себя и бункер." + ANSI_RESET);
            System.exit(0);
        }
    }
}
