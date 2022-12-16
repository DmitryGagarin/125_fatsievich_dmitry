package bunker;

import java.util.ArrayList;

public class PersonChoice extends Utils {

    public static ArrayList<String> gameCharacters = new ArrayList<>();
    public static ArrayList<String> myCharacter = new ArrayList<>();
    public static ArrayList<String> peopleInBunker = new ArrayList<>();
    public static ArrayList<String> myAllNeighbours = new ArrayList<>();
    public static String[] allPersonList = new String[26];
    public static ArrayList<String> myNeighbour1 = new ArrayList<>();
    public static ArrayList<String > myNeighbour2 = new ArrayList<>();


    public static void fillingListOfCharacters() {
    allPersonList = new String[] {"Акушер", "Бизнесмен", "Вирусолог", "Географ",
            "Геолог", "Грузчик", "Грузчик", "Депутат", "Дровосек",
            "Инженер", "Инструктор По Выживанию", "Инфекционист",
            "Охранник", "Плотник", "Повар", "Пожарный", "Полицейский",
            "Сантехник", "Спасатель", "Строитель", "Телохранитель",
            "Фармацевт", "Фельдшер", "Фермер", "Хирург", "Электрик"
    };
}

    public static void makingGameCharacterList(){
        fillingListOfCharacters();
        int j=(int) (Math.random() * allPersonList.length);
        gameCharacters.add(allPersonList[j]);
        for (int i = 1; i < 11; i++) {
           int index = (int) (Math.random() * allPersonList.length);
           if (!gameCharacters.contains(allPersonList[index]))
           gameCharacters.add(allPersonList[index]);
           else i--;
        }
    }

    public static void choosingPlayerCharacter(){
        makingGameCharacterList();
        //выбираем персонажа себе
        Utils.clearConsole();
        Utils.drowLine();
        Utils.showProfList(gameCharacters);
        System.out.println(" ");
        System.out.println("Выберите себе персонажа, набрав номер персонажа");
        int myPersonNumber = Utils.getNum(1, 10);
        String myCharacter;
        myCharacter = gameCharacters.get(myPersonNumber);
        gameCharacters.remove(myPersonNumber);
        System.out.println(ANSI_PURPLE + "Ваш персонаж: " + myCharacter + ANSI_RESET);
        //конец выбора своего персонажа
    }

    public static void choosingTheFirstNeighbour(){
        //выбор первого соседа
        System.out.println(" ");
        Utils.showProfList(gameCharacters);
        System.out.println(" ");
        System.out.println("Выберите себе первого соседа, набрав его номер");
        myNeighbour1 = new ArrayList<>(); //лист, куда запишется персонаж
        int myNeighbourNumber1 = Utils.getNum(1, 10);
        String myNeighbour1;
        myNeighbour1 = gameCharacters.get(myNeighbourNumber1);
        peopleInBunker.add(myNeighbour1);
        myAllNeighbours.add(myNeighbour1);
        gameCharacters.remove(myNeighbourNumber1);
        System.out.println(ANSI_PURPLE + "Ваш первый сосед: " + myNeighbour1 + ANSI_RESET);
        //конец выбора первого соседа
    }

    public static void choosingTheSecondNeighbour(){
        //выбор второго соседа
        System.out.println(" ");
        Utils.showProfList(gameCharacters);
        System.out.println(" ");
        System.out.println("Выберите себе второго соседа, набрав его номер");
        myNeighbour2 = new ArrayList<>(); //лист, куда запишется персонаж
        int myNeighbourNumber2 = Utils.getNum(1, 10);
        myNeighbour2.add(gameCharacters.get(myNeighbourNumber2));
        peopleInBunker.add(gameCharacters.get(myNeighbourNumber2));
        myAllNeighbours.add(gameCharacters.get(myNeighbourNumber2));
        gameCharacters.remove(myNeighbourNumber2);
        System.out.println(ANSI_PURPLE + "Ваш второй сосед: " + myNeighbour2 + ANSI_RESET);
        System.out.println(" ");
        //конец выбора второго соседа
    }
}
        /*
        //СПИСОК ВСЕХ ВОЗМОЖНЫХ МЕДИКОВ
        Акушер +
        Вирусолог +
        Инфекционист +
        Фармацевт +
        Фельдшер +
        Хирург +

        //СПИСОК ВСЕХ ВОЗМОЖНЫХ СОЛДАТ
        Телохранитель +
        Спасатель +
        Полицейский +
        Инструктор по выживанию +

        //СПИСОК ВСЕХ ВОЗМОЖНЫХ ИНЖЕНЕРОВ
        Строитель +
        Сантехник +
        Дровосек +
        Инженер +
        Плотник +
        Электрик +
        Бизнесмен +

        //СПИСОК ПРОСТО ЛЮДЕЙ
        Географ +
        Геолог +
        Грузчик +
        Охранник +
        Повар +
        Фермер +
        Депутат +
        Пожарный +
*/
