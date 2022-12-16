package bunker;

import java.util.ArrayList;
import java.util.Scanner;

import static bunker.PersonChoice.myAllNeighbours;

public class Utils {

    private static String inventory;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW =  "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static int reputation;
    public static int resultOfDay1;

    public static void showRules () {
        System.out.println(" ");
        System.out.println(ANSI_RED + "Добро пожаловать в игру 'Бункер' " + ANSI_RESET);
        //Thread.sleep(1000);
        System.out.println("Правила: ");
        System.out.println("В этой игре вам нужно прожить 1.5 дня, а затем сразиться с мародерами.");
        System.out.println("Каждый день с вами и вашими персонажами будет случаться какая-то неожиданность.");
        System.out.println("В начале игры вы cможете выбрать своего персонажа и персонажей, которые будут находиться в бункере вместе с вами");
        System.out.println("Подходите в выбору персонажей с особой осторожность.");
        System.out.println("Удачи!");
        System.out.println(" ");
        System.out.println(ANSI_GREEN +"Если вы готовы начать игру, нажмите 1" + ANSI_RESET);
    }

    static void gameStarter() {
        Scanner sc1 = new Scanner(System.in);
        int startGame = 0;
        while (startGame != 1) {
            startGame = sc1.nextInt();
            if (startGame != 1) System.out.println(ANSI_RED + "Введите верное число" + ANSI_RESET);
        }
    }

    static void clearConsole() {
        for (int i = 0; i <= 50; i++) {
            System.out.println(" ");
        }
    }

    static void drowLine() {
        System.out.print("___________________________________________________________________________________");
        System.out.println("___________________________________________________________________________________");
    }

    static void showProfList (ArrayList <String > gameCharacters){
        for (int num = 1;num <= 10; num++) {
            System.out.print("[" + num + "]" + gameCharacters.get(num) + "   ");
        }
    }

    //события каждого дня
	public static void day(int i, ArrayList<String> myAllNeighbours) {
        // TODO Auto-generated method stub
		if(i == 1){
			System.out.println("Вы с тяжестью открываете металлическую дверь, заглядываете внутрь и видите просторный холл.");
	        System.out.println("Делаете пару шагов и замечаете, что из комнаты выходит два коридора.");
	        System.out.println("Вы подергали рубильник около входа - света нет. Вы нашли свечку, зажгли ее и поставили на стол.");
	        System.out.println("На столе вы нашли фонарик, тратить его заряд пока что не стоит.");
	        System.out.println("Вы понимаете, что хорошо было бы провести разведку. Но сначала надо со всеми познакомиться и решить, кто будет главным.");
            System.out.println("Запасов немного, а кстати о запасах... есть ли они вообще?");
	        System.out.println("Вы садитесь за стол, и начинаете знакомиться...");
	        System.out.println("...20 минут спустя...");
	        System.out.println(" ");
            //myAllNeighbours.get(0) - первый сосед
            //myAllNeighbours.get(1) - второй сосед

            System.out.println("Немного пообщавшись, все единогласно пришли к выводу, что лидером будете вы");
            System.out.println("Первое ваше поручение: разведать остальные комнаты бункера. " + myAllNeighbours.get(0) + "а отправляете налево. " + myAllNeighbours.get(1) + " идет направо");
            System.out.println("Вы же забираете себе фонарик, а им даете по половинке свечки");
            System.out.println(" ");
		}
		
	}

	public static int getNum(int i, int j) {
		// TODO Auto-generated method stub
		Scanner myPersonScanner = new Scanner(System.in);
		int decision = myPersonScanner.nextInt();
		while(decision > j || decision < i){
            decision = myPersonScanner.nextInt();
		}
		return decision;
	}

    public static void stopGameLost(){
        clearConsole();
        drowLine();
        System.out.println(ANSI_RED + "Вы проиграли" + ANSI_RESET);
        System.exit(0);
    }

    public static void stopGameWin(){
        clearConsole();
        drowLine();
        System.out.println(ANSI_GREEN + "День 1 пройден" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Ваша репутация: " + reputation + ANSI_RESET);
        System.exit(0);
    }



    public static void showTextPart1(){
        System.out.println("Вы понимаете, что нельзя тратить время, нужно максимально исследовать бункер, возможно, что тут осталось что-то полезное, не стоит забывать о возможной опасности.");
        System.out.println(myAllNeighbours.get(1) + " ведет вас вдоль этого коридора и показывает закрытую на кодовый замок дверь, возможно, там что-то есть.");
        System.out.println("Вы задаетесь логичным вопросом: кто будет делать в бункере кодовый замок? Но " + myAllNeighbours.get(1) + " хотел показать вам не это.");
        System.out.println("Вы идете дальше и находите комнату, которая полностью разукрашена различными словами и цифрами");
        System.out.println("Вспомнив кинематограф, вы понимаете, что нечто подобное видели в фильмах 'Пила', неужели надо перебрать все комбинации, чтобы попасть в ту комнату?");
        System.out.println("Времени пробовать все комбинации у вас нет.");
        System.out.println("Тем не менее нужно все-таки потратить некоторое время, силы и заряд фонарика, чтобы обыскать эту комнату, ведь пустая комната в бункере - редкое удовольствие.");
        System.out.println("Спустя несколько часов поисков вы находите радио, карту города и немного прочего мусора.");
        System.out.println("Тем не менее у вас есть целая комната, возможно тут есть нечто спрятанное, но вы сильно устали и решаетесь пойти в главную комнату отдыхать.");
        BunkerItems.inventoryAdder("Радио");
        BunkerItems.inventoryAdder("Карта города");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Придя в главную комнату вы осматриваете радио, замечаете, что оно работает от батареек. Повезло - батарейки были внутри.");
        System.out.println("Несколько минут вы крутите ползунок с частотами и находите одну работающую станцию. По ней вы крутится одно и тоже сообщение:");
        System.out.println(ANSI_RED + "\"Вас приветствует клан мародеров 'Белый Воин'. У нас для всех, кто нас слушает, важное объявление!\"" + ANSI_RESET);
        System.out.println(ANSI_RED + "\"У нас есть карта всех бункеров в нашем регионе!\"" + ANSI_RESET);
        System.out.println(ANSI_RED + "\"Однажды мы придем и к вам. Готовьте провиант, медикаменты и мебель, если не хотите быть убитыми!\"" + ANSI_RESET);
        System.out.println(ANSI_RED + "\"Возможно вы станете нашими рабами, посмотрим по ситуации *злобный смех*.\"" + ANSI_RESET);
        System.out.println("Вы понимаете, что нужно как-то защищаться, но сил работать уже нет. Перед сном вы проверяете свои нажитки и продумываете план на завташний день");
        BunkerItems.showInventory();
        System.out.println(" ");
        System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
    }

    public static void showTextPart2(){
        System.out.println(" ");
        System.out.println("Вы оставляете ранненого отдыхать на кресле");
        System.out.println("Вам надо сделать выбор, чем заниматься далее:");
        System.out.println("Пойти исследовать правый коридор (1); пойти исследовать левый коридор (2).");

        int decision1Result = Utils.getNum(1, 3);
        //левый коридор или правый коридор
        if (decision1Result == 1 || decision1Result == 2) {
            System.out.println("Выбор сделан, вы пойдете вдвоем. В фонаре еще остался заряд, но это не значит, что опастность минует");
            System.out.println("Вы аккуратно заходите в коридор, держась максимально близко друг к другу. Где-то вдали вы видите нечто похожее на рубильник. Аккуратно идете в его сторону");
            System.out.println("Хотите ли вы его дернуть его? Да - (1); Нет - (2) ");

            int decision2Result = Utils.getNum(1, 2);
            //дернуть рубильник
            if (decision2Result == 1) {
                reputation = reputation + 1;
                System.out.println("Была ни была. Команда будет восхищена вашей храбростью. Вы дергаете рычаг иии...");

                double chanceThatSomethingHappen = Math.random() * 100;
                double badVariant = Math.random() * 100;

                if (chanceThatSomethingHappen <= 50 && chanceThatSomethingHappen % 3 != 0 && chanceThatSomethingHappen % 5 != 0) {
                    if (badVariant <= 50) {
                        System.out.println("Проходит минута. Вы думаете, что ничего не произойдет, но вдруг в одной из комнат дальше по коридору включается свет");
                        System.out.println("Без задней мысли вы идете на свет. Почему свет загорелся только в одной комнате остается загадкой.");
                        System.out.println("Аккуратно заглянув туда вы обнаруживаете, что комната абсолютно пустая, в ней есть всего пару шкафов и стенд с противогазом");
                        BunkerItems.inventoryAdder("Противогаз");
                        BunkerItems.inventoryAdder("Автомат калашникова с патронами");
                        BunkerItems.inventoryAdder("Радио");
                        System.out.println("Вы все это забираете. Возвращаетесь в главную комнату, проверяете здоровье раненного товарища и начинаете разбирать находки.");
                        System.out.println("Одной из находок было современное радио, работающее от батареек. Долго пытаетсь найти волну и вот наконец-то успех!");
                        System.out.println("По этой волне вы слышите сообщение: ");
                        System.out.println(ANSI_RED + " \" Джони, я нашел их! Джони, наша секретная разработка сработала! Але-але, вы нас слышите? Мы знаем где вы находитесь! \"");
                        System.out.println(" \" Через сутки мы будем у вас, готовьте все свои припасы, оружие и тела, ваш дом - наш дом!!! \"" + ANSI_RESET);
                        System.out.println("На этом моменте сообщение обрывается. Сил уже нет. Было принято решение переехать в комнату, которую только что нашли, закрыть в ней дверь и переночивать");
                        BunkerItems.showInventory();
                        System.out.println(ANSI_GREEN + "День 1 пройден!" + ANSI_RESET);
                        resultOfDay1 = 17;
                        Utils.stopGameWin();
                    }
                    if (badVariant > 50 && badVariant < 70) {
                        System.out.println("Проходит минута. Вы уже думаете, что ничего не произойдет, но вдруг в одной из комнат дальше по коридору включается свет");
                        System.out.println("Без задней мысли вы идете на свет. Почему свет загорелся только в одной комнате остается загадкой.");
                        System.out.println("Аккуратно заглянув туда вы обнаруживаете, что комната набита каким-то огромными зелеными жуками");
                        System.out.println("Они на вас нападают, вы пытаесь отбиться. Их целая туча, от них уже невозможно сбежать, к сожалению, ваша группа оказалась мертва.");
                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                        Utils.stopGameLost();
                        resultOfDay1 = 18;
                        stopGameLost();
                    } else {
                        System.out.println("Моментально включается свет во всем бункере; вы понимаете по крику своего раненного товарища, что кто-то включил свет.");
                        System.out.println("Начинает орать сирена, а спустя полминуты - зацикленное сообщение: ");
                        System.out.println(ANSI_RED + " \" Мы вас нашли, готовьтесь' 'Мы вас нашли, готовьтесь' 'Мы вас нашли, готовьтесь \"" + ANSI_RESET);
                        System.out.println("Вы слышите какой-то жуткий звук, похожий на стук во входную дверь. Бежите в главную комнату.");
                        System.out.println(ANSI_BLUE + "**Пару минут спустя**" + ANSI_RESET);
                        System.out.println("Ваш товарищ мертв, а рядом с ним стоит целый отряд из рейдеров-мародеров.");
                        System.out.println(" \" Мы вас нашли, а вы не подготовились \" - сказал их лидер, направил на вас пистолет и выстрелил");
                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                        resultOfDay1 = 19;
                        stopGameLost();
                    }
                }
                if (chanceThatSomethingHappen % 3 == 0) {
                    System.out.println("Проходит пару секунд. Проходит минута. Ничего не происходит. Возможно что-то включилось в другом месте.");
                    System.out.println("В течении нескольких часов вы бродите по бункеру и не замечаете никаких изменений. Усталось дает о себе");
                    System.out.println("Вы возвращаетесь в главную комнату, проверяете самочувствие раненного, а заодно припасы");
                    BunkerItems.showInventory();
                    System.out.println("Садитесь в кресло и засыпаете, к сожалению день прошел не так радостно, как хотелось бы");
                    System.out.println(ANSI_GREEN + "День 1 пройден!" + ANSI_RESET);
                    resultOfDay1 = 20;
                    stopGameWin();
                }
                if (chanceThatSomethingHappen % 5 == 0) {
                    System.out.println("Через пару секунд вы слышите звук открывающейся двери. Звук относится откуда-то спереди. Без лишних раздумий вы идете туда. ");
                    System.out.println(myAllNeighbours.get(1) + " пытается вас остановить, но вы устремлены к двери.");
                    System.out.println("Это безрассудство портит вашу репутацию");
                    reputation = reputation - 1;
                    System.out.println("Вы подходите к двери, ее толчища вас поражает, аккуратно заглядываете туда иии...");
                    if (badVariant <= 50 && badVariant % 2 != 0 && badVariant % 5 != 0) {
                        System.out.println("В этой огромной современной комнате сидит группа людей. Вы успеваете заметить, что все это время за вами кто-то следил.");
                        System.out.println("Невозможно объяснить как так получилось. Вы проходите чуть дальше.");
                        System.out.println("Лидер банды встает со своего места, наводит на вас пистолет и стреляет.");
                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                        resultOfDay1 = 21;
                        stopGameLost();
                    }
                    if (badVariant % 7 == 0) {
                        System.out.println("В этой огромной современной комнате сидит группа людей в деловый костюмах. Вы успеваете заметить, что все это время за вами кто-то следил.");
                        System.out.println("Невозможно объяснить как так получилось. Вы проходите чуть дальше.");
                        System.out.println("Люди продолжают смотреть в монитор. Вы проходите еще дальше. Центральный смотрящий разворачивается на кресле.");
                        System.out.println("В нем вы узнаете популярного политика, которого часто крутили по ТВ");
                        System.out.println("Он встает со своего места, дергает другого человека за плечо, а тот наводит на вас пистолет и стреляет.");
                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                        resultOfDay1 = 22;
                        stopGameLost();
                    }
                    if (badVariant > 50 && badVariant % 2 != 0 && badVariant % 5 != 0) {
                        System.out.println("Из двери идет пар, как в фильмах про космос. Вы заходите в нее. Внутри комнаты сидят непонятные человекоподобные существа.");
                        System.out.println("Вы ловите их взгляд и чувствуете, как ваше тело превращается в жижу.");
                        System.out.println("Вы смотрите на свои руки и видите, что они буквально текут на пол. Спустя полминуты вы умираете. ");
                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                        resultOfDay1 = 23;
                        stopGameLost();
                    }
                    else {
                        System.out.println("Вы заходи вовнутрь. Там вы видите старый заброшенный командный пункт. Видимо этот бункер строился во времена холодной войны.");
                        System.out.println("Вы обыскиваете эту комнату и находите немного ценностей: противогаз, аптечку с истекшим сроком годности и пистолет макарова с двумя обоймами.");
                        BunkerItems.inventoryAdder("Противогаз");
                        BunkerItems.inventoryAdder("Аптечка");
                        BunkerItems.inventoryAdder("Пистолет макарова с патронами");
                        System.out.println("Вы забираете их и несете их в главную комнату");
                        System.out.println("День подходит к концу, хотя вы не знаете этого наверняка, но биологические часы говорят вам, что пора спать.");
                        System.out.println("Перед сном вы проверяете инвентарь, проверяете состояние раненного товарища и ложитесь спать");
                        BunkerItems.showInventory();
                        System.out.println(ANSI_GREEN + "День 1 пройден" + ANSI_RESET);
                        resultOfDay1 = 24;
                        stopGameWin();
                    }
                }
            }
            // не дернуть рычаг
            if (decision2Result == 2) {
                System.out.println("Никто не знает, что этот рубильник включает, может быть он лишит нас кислорода или откроет входную дверь.");
                System.out.println("Вы не решаетесь воспользоваться шансом. " + myAllNeighbours.get(1) + " слегка разочарован вашей трусостью.");
                reputation = reputation - 1;
                System.out.println("Остаток дня вы не знаете чем себя занять. Вы проверяете состояние раненного, ложитесь на кресло и думаете, что же с вами будет дальше");
                System.out.println("Примерно так вы и закончили ваш день, предварительно проверив свои запасы");
                BunkerItems.showInventory();
                System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                resultOfDay1 = 25;
                stopGameWin();
            }
        }
    }
}
