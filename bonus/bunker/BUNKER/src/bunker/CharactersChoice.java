package bunker;

import java.util.ArrayList;

public class CharactersChoice extends Utils {

    public static ArrayList<String> gameCharacters = new ArrayList<>();
    public static ArrayList<String> peopleInBunker = new ArrayList<>();
    public static ArrayList<String> myAllNeighbours = new ArrayList<>();
    public static String[] allPersonList = new String[26];


    public static void fillingListOfCharacters() {
    allPersonList = new String[] { "Акушер", "Бизнесмен", "Вирусолог", "Географ",
            "Геолог", "Грузчик", "Депутат", "Дровосек",
            "Инженер", "Инструктор По Выживанию", "Инфекционист",
            "Охранник", "Плотник", "Повар", "Пожарный", "Полицейский",
            "Сантехник", "Спасатель", "Строитель", "Телохранитель",
            "Фармацевт", "Фельдшер", "Фермер", "Хирург", "Электрик"
    };
}

    public static void makingGameCharacterList(){
        fillingListOfCharacters();
        int j = (int) (Math.random() * allPersonList.length);
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
        Utils.drawLine();
        System.out.println(ANSI_YELLOW + "Выберите себе персонажа, набрав номер персонажа" + ANSI_RESET);
        Utils.showProfList(gameCharacters);
        System.out.println(" ");
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
        System.out.println(ANSI_YELLOW + "Выберите себе первого соседа, набрав его номер" + ANSI_RESET);
        Utils.showProfList(gameCharacters);
        System.out.println(" ");
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
        System.out.println(ANSI_YELLOW + "Выберите себе первого соседа, набрав его номер" + ANSI_RESET);
        Utils.showProfList(gameCharacters);
        System.out.println(" ");
        int myNeighbourNumber2 = Utils.getNum(1, 10);
        String myNeighbour2;
        myNeighbour2 = gameCharacters.get(myNeighbourNumber2);
        peopleInBunker.add(gameCharacters.get(myNeighbourNumber2));
        myAllNeighbours.add(gameCharacters.get(myNeighbourNumber2));
        gameCharacters.remove(myNeighbourNumber2);
        System.out.println(ANSI_PURPLE + "Ваш второй сосед: " + myNeighbour2 + ANSI_RESET);
        System.out.println(" ");
        //конец выбора второго соседа
    }
}