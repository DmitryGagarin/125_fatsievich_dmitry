package bunker;

//TODO РАЗБИТЬ НА КЛАССЫ И МЕТОДЫ
//TODO ШКАЛА РЕПУТАЦИИ - НУЖНА БУДЕТ ПРИ БОЕВКЕ, ЕСЛИ МОРАЛЬ = -5, СОСЕДИ ПЕРЕХОДЯТ НА СТОРОНУ МАРОДЕРОВ, ЕСЛИ НЕТ, ТО ДЕРУТСЯ
//TODO ТЕСТЫ НА ДУРАКА ВЕЗДЕ СДЕЛАТЬ (ВЕЗДЕ ГДЕ ЕСТЬ ВЫБОР, ЧТОБЫ НЕ ПОЛУЧИЛОСЬ, ЧТО ИГРОК МОЖЕТ НАЖАТЬ 74839240 И ПРОИГРАТЬ КАКОЙ ТО КОД)
//TODO СДЕЛАТЬ СИСТЕМУ БОЕВКИ (ДОМАШКИ)
//TODO ДОДЕЛАТЬ СПИСКИ И ПЕРЕДЕЛАТЬ ИХ В КЛАССЫ
//TODO ПРОПИСАТЬ БИОГРАФИЮ КАЖДОГО ПЕРСОНАЖА
//TODO ПРИЙДТИ К ЛОГИЧНОМУ ВЫВОДУ - БИТВЕ С МАРОДЕРАМИ
//TODO ДОБАВИТЬ /HELP  /INV  /MYBIO  /BIO1  /BIO2
//TODO КАК ЛУЧШЕ ПРОПИСАТЬ БИОГРАФИИ ПЕРСОНАЖЕЙ? ОТДЕЛЬНО СОЗДАТЬ TXT С БИОГРАФИЕЙ КАЖДОГО, НО ПОТОМ СДЕЛАТЬ КАКОЕ-ТО ОПРЕДЕЛЕНИЕ ПЕРСОНАЖА, ЧТОБЫ БИОГРФИЯ СООТВЕТСТВОВАЛА ИЛИ НА КАЖДОГО ОТДЕЛЬНЫЙ КЛАСС, КОТОРЫЙ БУДЕТ ОПРЕДЕЛЯТЬ ПЕРСОНАЖА?
//TODO СОЗДАТЬ МЕТОД. ЕСЛИ НАПИСАНО "ИГРА ОКОНЧЕНА", ТО ДАЛЬНЕЙШИЙ КОД НЕ ПРОИГРЫВАЕТСЯ, ВЫВОДИТСЯ ЭТО СООБЩЕНИЕ
//TODO СОЗДАТЬ МЕТОД. ЕСЛИ НАПИСАНО "ДЕНЬ 1 ПРОЙДЕН", ТО CLEARCONSOLE + DRAWLINES, ПОТОМ ВТОРОЙ ДЕНЬ
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Bunker {
    public static void main(String[] args) {

        //СОЗДАЕМ РАЗМЕР БУНКЕРА
        double bunkerSize = Math.random() * 100;
        int reputation = 0;
        int resultOfDay1 = 0;

        //правила
        showRules();

        //запуск игры
        gameStarter();


        //ВЫБОР ПЕРСОНАЖЕЙ
        ArrayList<String> charactersAllList = new ArrayList<>();
        charactersAllList.add("Акушер");
        charactersAllList.add("Альпинист");
        charactersAllList.add("Бизнесмен");
        charactersAllList.add("Боксёр");
        charactersAllList.add("Вирусолог");
        charactersAllList.add("Географ");
        charactersAllList.add("Геолог");
        charactersAllList.add("Грузчик");
        charactersAllList.add("Депутат");
        charactersAllList.add("Дровосек");
        charactersAllList.add("Инженер");
        charactersAllList.add("Инструктор По Выживанию");
        charactersAllList.add("Инфекционист");
        charactersAllList.add("Онколог");
        charactersAllList.add("Охранник");
        charactersAllList.add("Переводчик");
        charactersAllList.add("Плотник");
        charactersAllList.add("Повар");
        charactersAllList.add("Пожарный");
        charactersAllList.add("Полицейский");
        charactersAllList.add("Программист");
        charactersAllList.add("Радист");
        charactersAllList.add("Сантехник");
        charactersAllList.add("Сварщик");
        charactersAllList.add("Спасатель");
        charactersAllList.add("Стоматолог");
        charactersAllList.add("Строитель");
        charactersAllList.add("Телохранитель");
        charactersAllList.add("Фармацевт");
        charactersAllList.add("Фельдшер");
        charactersAllList.add("Фермер");
        charactersAllList.add("Хирург");
        charactersAllList.add("Электрик");

        /*
        //СПИСОК ВСЕХ ВОЗМОЖНЫХ МЕДИКОВ
        Акушер
        Вирусолог
        Инфекционист
        Онколог
        Стоматолог
        Фармацевт
        Фельдшер
        Хирург

        //СПИСОК ВСЕХ ВОЗМОЖНЫХ СОЛДАТ
        Телохранитель
        Спасатель
        Полицейский
        Инструктор по выживанию

        //СПИСОК ВСЕХ ВОЗМОЖНЫХ ИНЖЕНЕРОВ
        Строитель
        Сварщик
        Сантехник
        Программист
        Радист
        Дровосек
        Инженер
        Плотник
        Электрик
        Бизнесмен

        //СПИСОК ПРОСТО ЛЮДЕЙ
        Географ
        Геолог
        Грузчик
        Охранник
        Переводчик
        Повар
        Фермер
        Депутат
        Пожарный
        Альпинист
*/

        clearConsole();
        drowLine();

        //заполняем список игровых персонажей
        HashMap<Integer, String> gameCharacters = new HashMap<>();
        for (int i = 1; i < 11; i++) {
            int index = (int) (Math.random() * charactersAllList.size());
            if (!gameCharacters.containsValue(charactersAllList.get(index)))
                gameCharacters.put(i, charactersAllList.get(index));
            else i--;
        }


        //выбираем персонажа себе
        //todo сделать проверку, чтобы если <1 или >10 то "введите верное значение"
        showProfList(gameCharacters);
        ArrayList<String> peopleInBunker = new ArrayList<>(); //лист со всеми персонажами в бункере
        ArrayList<String> myCharacter = new ArrayList<>(); //лист с персонажем игрока
        System.out.println(" ");
        System.out.println("Выберите себе персонажа, набрав номер персонажа");
        Scanner myPersonScanner = new Scanner(System.in);
        int myPersonNumber = myPersonScanner.nextInt();
        myCharacter.add(gameCharacters.get(myPersonNumber));
        gameCharacters.remove(myPersonNumber);
        System.out.println("Ваш персонаж: " + myCharacter);
        //конец выбора своего персонажа

        ArrayList<String> myAllNeighbours = new ArrayList<>(); //лист всех соседей

        //выбор первого соседа
        //todo сделать проверку, чтобы если <1 или >10 то "введите верное значение"
        System.out.println(" ");
        showProfList(gameCharacters);
        System.out.println(" ");
        System.out.println("Выберите себе первого соседа, набрав его номер");
        ArrayList<String> myNeighbour1 = new ArrayList<>(); //лист, куда запишется персонаж
        Scanner myNeighbourScanner = new Scanner(System.in);
        int myNeighbourNumber1 = myNeighbourScanner.nextInt();
        myNeighbour1.add(gameCharacters.get(myNeighbourNumber1));
        peopleInBunker.add(gameCharacters.get(myNeighbourNumber1));
        myAllNeighbours.add(gameCharacters.get(myNeighbourNumber1));
        gameCharacters.remove(myNeighbourNumber1);
        System.out.println("Ваш первый сосед: " + myNeighbour1);
        //конец выбора первого соседа

        //выбор второго соседа
        //todo сделать проверку, чтобы если <1 или >10 то "введите верное значение"
        System.out.println(" ");
        showProfList(gameCharacters);
        System.out.println(" ");
        System.out.println("Выберите себе второго соседа, набрав его номер");
        ArrayList<String> myNeighbour2 = new ArrayList<>(); //лист, куда запишется персонаж
        Scanner myNeighbourScanner1 = new Scanner(System.in);
        int myNeighbourNumber2 = myNeighbourScanner1.nextInt();
        myNeighbour2.add(gameCharacters.get(myNeighbourNumber2));
        peopleInBunker.add(gameCharacters.get(myNeighbourNumber2));
        myAllNeighbours.add(gameCharacters.get(myNeighbourNumber2));
        gameCharacters.remove(myNeighbourNumber2);
        System.out.println("Ваш второй сосед: " + myNeighbour2);
        System.out.println(" ");
        //конец выбора второго соседа

        ArrayList<String> bunkerItemsAllList = new ArrayList<>();
        //еда
        bunkerItemsAllList.add("Кило картошки");
        bunkerItemsAllList.add("Консервы");
        bunkerItemsAllList.add("Консервы");
        bunkerItemsAllList.add("Консервы");
        bunkerItemsAllList.add("Консервы");
        bunkerItemsAllList.add("Три литра самогона");
        bunkerItemsAllList.add("Армейский сухпай");
        bunkerItemsAllList.add("Пакет ирисок");
        bunkerItemsAllList.add("Плитка шоколада");
        bunkerItemsAllList.add("Банка кофе");
        bunkerItemsAllList.add("Пачка чайных пакетиков");
        bunkerItemsAllList.add("Бутылка воды");
        bunkerItemsAllList.add("Бутылка воды");
        bunkerItemsAllList.add("Бутылка воды");
        bunkerItemsAllList.add("Бутылка воды");

        //медикаменты
        bunkerItemsAllList.add("Автоаптечка с истекшим сроком годности");
        bunkerItemsAllList.add("Бинт");
        bunkerItemsAllList.add("Бинт");
        bunkerItemsAllList.add("Бинт");
        bunkerItemsAllList.add("Бинт");
        bunkerItemsAllList.add("Бинт");
        bunkerItemsAllList.add("Зеленка");
        bunkerItemsAllList.add("Пластырь");
        bunkerItemsAllList.add("Жгут");
        bunkerItemsAllList.add("Шприц");
        bunkerItemsAllList.add("Набор ампул");
        bunkerItemsAllList.add("Непонятные таблетки");
        bunkerItemsAllList.add("Хирургический набор");

        //Оружие
        bunkerItemsAllList.add("Пистолет макарова с патронами");
        bunkerItemsAllList.add("Пистолет макарова");
        bunkerItemsAllList.add("Ржавый автомат Калашникова");
        bunkerItemsAllList.add("Патроны на Калашников");
        bunkerItemsAllList.add("Рязиновый тапок 46 размера");
        bunkerItemsAllList.add("Топор");
        bunkerItemsAllList.add("Армейский нож");
        bunkerItemsAllList.add("Кастет");
        bunkerItemsAllList.add("Кухонный нож");

        //Нужные вещи
        bunkerItemsAllList.add("Спрей от комаров");
        bunkerItemsAllList.add("Набор раций");
        bunkerItemsAllList.add("Карта мира");
        bunkerItemsAllList.add("Карта города");
        bunkerItemsAllList.add("Атлас");
        bunkerItemsAllList.add("Телефонная книга");
        bunkerItemsAllList.add("Противогаз");
        bunkerItemsAllList.add("Радио");
        bunkerItemsAllList.add("Фляга");
        bunkerItemsAllList.add("Набор инструментов");
        bunkerItemsAllList.add("Дрель");
        bunkerItemsAllList.add("Набор семян");
        bunkerItemsAllList.add("Баллон с кислородом");
        bunkerItemsAllList.add("Пила");
        bunkerItemsAllList.add("Швейный набор");
        bunkerItemsAllList.add("Библия");
        bunkerItemsAllList.add("Пустые пробирки");
        bunkerItemsAllList.add("Гвозди");
        bunkerItemsAllList.add("Молоток");

        ArrayList<String> inventory = new ArrayList<>();

        inventory.add("Фонарик");
        //создаю счетчик выдачи рандомных предметов
            for (int i = 1; i <= 4; i++) {
                int index = (int) (Math.random() * bunkerItemsAllList.size());
                if (!inventory.contains(bunkerItemsAllList.get(index)))
                    inventory.add(bunkerItemsAllList.get(index));
                else i--;
            }

        //ДЕНЬ 1
            System.out.println("Вы с тяжестью открываете металлическую дверь, заглядываете внутрь и видите просторный холл.");
            System.out.println("Вы делаете пару шагов и замечаете, что из главной комнаты выходит два коридора.");
            System.out.println("Вы подергали рубильник около входа - света нет. Вы нашли свечку, зажгли ее спичкой, валявшейся на полу и поставили на стол.");
            System.out.println("На столе вы нашли фонарик, тратить его заряд пока что не стоит.");
            System.out.println("Вы понимаете, что надо бы провести разведку. Но сначала надо со всеми познакомиться и решить, кто будет главным, ведь запасов немного, а кстати о запасах... есть ли они вообще?");
            System.out.println("а значит кто-то должен ими распоряжаться. Вы садитесь за стол, и начинаете знакомиться...");
            System.out.println("...20 минут спустя...");
            System.out.println(" ");

            //myAllNeighbours.get(0) - первый сосед
            //myAllNeighbours.get(1) - второй сосед

            System.out.println("Немного пообщавшись, все единогласно пришли к выводу, что лидером будете вы");
            System.out.println("И первым вашим поручением будет: разведать остальные комнаты бункера. " + myAllNeighbours.get(0) + "а вы отправляете налево. " + myAllNeighbours.get(1) + " идет направо");
            System.out.println("Вы решили остаться в главной комнате в попытках найти еще что-нибудь. Ваши соседи делят свечку надвое и отправляются на разведку, вы же забираете себе фонарик");


            //ДОПОЛНИТЕЛЬНЫЕ ПОИСКИ ВНУТРИ ГЛАВНОЙ КОМНАТЫ БУНКЕРА
            int x = (int) (Math.random() * 5);
            for (int i = 0; i <= x; i++) { //слов должно быть меньше или равно 4
                int index = (int) (Math.random() * bunkerItemsAllList.size()); //индекс - номер элемента, который будет ан рандомной профессии
                if (!inventory.contains(bunkerItemsAllList.get(index)))
                    inventory.add(bunkerItemsAllList.get(index));
            }

            //начало травм
            double injuryChance1Day1 = (int) (Math.random() * 100); //Шанс на  ранение
            double chanceThatSomebodyDie = (int) (Math.random() * 100); //Шанс на тип ранения или смерть

            if (injuryChance1Day1 > 40) { //будет ли кто-то ранен в первый день
                System.out.println("Спустя некоторое время вы слышите крик в правом коридоре, вы не понимаете, что произошло, бросаете все и бежите смотреть, что же там произошло...");

                //КОГО ТО УДАРИТ КИРПИЧОМ
                if (chanceThatSomebodyDie <= 47) {
                    System.out.println("Вы заглядываете в коридор и видите облако пыли. К вам на помощь прибегает ваш второй сосед, вместе вы идете в сторону облако.");
                    System.out.println("Где-то вдали стонет " + myAllNeighbours.get(1) + ".");
                    System.out.println("Подойдя поближе вы видите, что он живой, хотя из его головы идет кровь - кусок потолка обвалился ему на голову. ");
                    System.out.println("Ничего серьезного, но возможно, что вам придется потратить некоторые медикаменты, если они у вас есть конечно");
                    System.out.println("Вы берете его под руки и тащите в главную комнату. Первый день и первые же потери.");
                    System.out.println("Кровотечение не такое сильное, возможно, вы сможете ему чем-то помочь. Нужно проверить припасы");

                    if (inventory.contains("Вода") && inventory.contains("Бинт")) {
                        System.out.println("У вас есть все необходимое для оказания первой помощи, но что вы хотите пожертвовать?");
                        System.out.println("(1) - потратить воду и бинт; (2) - потратить только воду; (3) - потратить только бинт; (4) - ничего не тратить, у него не такая уж и серьезная травма ");

                        Scanner decision = new Scanner(System.in);
                        int decisionResult = decision.nextInt();

                        if (decisionResult == 1) {
                            inventory.remove("Бинт");
                            inventory.remove("Вода");
                            System.out.println("Вы аккуратно перевязываете голову раненного, кладете его на кресло, промываете рану и отдаете ему оставшуюся бутылку воды. Вся комнада очень вам признательна.");
                            System.out.println("Вот что у вас осталось: " + inventory);
                            reputation = reputation + 2;
                        }
                        if (decisionResult == 2) {
                            inventory.remove("Вода");
                            System.out.println("Вы решаете, что травма головы не настолько серьезная, чтобы тратить на нее целый бинт. Вы перевязываете его голову куском от футболки, промываете рану и отдаете остаток воды. ");
                            System.out.println("Команда не настолько вам признательна как могла бы быть");
                            System.out.println("Вот что у вас осталось: " + inventory);
                            reputation = reputation + 1;
                        }
                        if (decisionResult == 3) {
                            inventory.remove("Бинт");
                            System.out.println("Вы решаете, что травма головы - вещь серьезная, но при этом вы не верите в то, что вода может спасти от любых болезней.");
                            System.out.println(" Вы накладываете бинт поверх раны и приказываете раненному отдыхать.");
                            System.out.println("Вот что у вас осталось: " + inventory);
                            reputation = reputation + 1;
                        }
                        if (decisionResult == 4) {
                            System.out.println("Вы оцениваете травму своим профессиональным лидерским взглядом и приходите к выводу, что не нужно ему помогать вообще.");
                            System.out.println("Вы перевязали ему голову лоскутом его же футболки и оставили отдыхать. Команда крайне вами недовольна ");
                            reputation = reputation - 2;
                        }

                        System.out.println("После этого вы решаете немного отдохнуть, ложитесь в кресло и засыпаете");
                        System.out.println("Через пару часов ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до момента пока на " + myAllNeighbours.get(0) + " а не упал кирпич " + myAllNeighbours.get(1) + "нашел кое-что интересное в своем коридоре");
                        System.out.println("Вы должны принять решение: пойти исследовать этот коридор вдвоем (1); или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2). У вас до сих пор есть фонарик.");

                        Scanner decision1 = new Scanner(System.in);
                        int decision1Result = decision1.nextInt();

                        //вести разведку вдвоем
                        if (decision1Result == 1) {
                            System.out.println("Вы понимаете, что нельзя тратить ни секунды, нужно максимально завладеть контролем над бункером, возможно, что тут осталось что-то полезное, но не стоит забывать о возможной опасности.");
                            System.out.println(myAllNeighbours.get(1) + " ведет вас вдоль этого коридора и показывает закрытую на кодовый замок дверь, возможно, там что-то есть.");
                            System.out.println("Вы задаетсь логичным вопросом: кто будет делать в бункере кодовый замок? Но " + myAllNeighbours.get(1) + " хотел показать вам не это.");
                            System.out.println("Вы идете дальше и находите комнату, которая полностью разукрашена различными словами и цифрами");
                            System.out.println("Вспомнив кинематограф, вы осознаете, что нечто подобное видели в фильмах 'Пила', неужели надо перебрать все комбинации, чтобы попасть в ту комнату?");
                            System.out.println("Нужно все-таки потратить время, силы и заряд фонарика, чтобы обыскать эту комнату, ведь пустая комната в бункере - редкое удовольствие.");
                            System.out.println("Спустя несколько часов поисков вы находите радио, карту города и немного прочего мусора.");
                            System.out.println("Тем не менее у вас есть целая комната, возможно тут есть нечто спрятанное, но вы сильно устали и решаетесь пойти в главную комнату отдыхать.");
                            inventory.add("Радио");
                            inventory.add("Карта города");
                            System.out.println("Придя в главную комнату вы осматриваете радио, замечаете, что оно работает от батареек, вам повезло - батарейки были внутри.");
                            System.out.println("Несколько минут вы крутите ползунок с частотами и находите одну работающую станцию. По ней вы крутится одно и тоже сообщение:");
                            System.out.println("Вам приветствует клан мародеров 'Белый Воин'. У нас для всех, кто нас слушает, важное объявление. У нас есть карта всех бункеров в нашем регионе.");
                            System.out.println("Однажды мы придем и к вам. Готовьте провиант, медикаменты и мебель, если не хотите быть убитыми. ");
                            System.out.println("Возможно вы станете нашими рабами, посмотрим по ситуации *злобный смех*.");
                            System.out.println("Вы понимаете, что нужно как-то защищаться, но сил работать уже нет. Перед сном вы проверяете свои нажитки и продумываете план на завташний день");
                            System.out.println(inventory);
                            System.out.println(" ");
                            System.out.println("День 1 пройден!!!");
                            resultOfDay1 = 1;
                        }
                        //вести разведку втроем, но на следующий день
                        if (decisionResult == 2) {
                            System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                            System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                            System.out.println(inventory);
                            System.out.println(" ");
                            System.out.println("День 1 пройден!!!");
                            resultOfDay1 = 2;
                        }
                    }

                    if (inventory.contains("Вода") || inventory.contains("Бинт")) {
                        if (inventory.contains("Вода")) {
                            System.out.println("Вы понимаете, что в этом бункере долго вам не протянуть - здесь даже бинта обычного нет. Вы перевязываете голову ранненого его же футболкой.");
                            System.out.println("Перед вам стоит выбор: оставить ему воды на день (1) или лучше поэкономить (2)");
                            Scanner decision = new Scanner(System.in);
                            int decisionResult = decision.nextInt();
                            if (decisionResult == 1) {
                                System.out.println("На здоровье не экономят, тем более, что вы слышали, что большое количество воды способствует заживлению всез травм. Команда вам признательна.");
                                reputation = reputation + 1;
                            }
                            if (decisionResult == 2) {
                                System.out.println("Вы верите, что травма не такая уж и сильная, она сможет зажить за день - пару дней максимум. Группа не совсем поддерживает ваше решение");
                                reputation = reputation - 1;
                            }
                            System.out.println("После этого вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                            System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до момента пока на " + myAllNeighbours.get(1) + "а не упал кирпич " + myAllNeighbours.get(0) + "нашел кое-что интересное в своем коридоре");
                            System.out.println("Вы должны принять решение: пойти исследовать этот коридор вдвоем(1) или подождать пока " + myAllNeighbours.get(1) + "у полегчает (2). У вас до сих пор есть фонарик.");

                            Scanner decision1 = new Scanner(System.in);
                            int decision1Result = decision1.nextInt();

                            //вести разведку вдвоем
                            if (decision1Result == 1) {
                                System.out.println("Вы понимаете, что нельзя тратить ни секунды, нужно максимально завладеть контролем над бункером, возможно, что тут осталось что-то полезное, но не стоит забывать о возможной опасности.");
                                System.out.println(myAllNeighbours.get(0) + " ведет вас вдоль этого коридора и показывает закрытую на кодовый замок дверь, возможно, там что-то есть.");
                                System.out.println("Вы задаетсь логичным вопросом: кто будет делать в бункере кодовый замок? Но " + myAllNeighbours.get(0) + " хотел показать вам не это. Вы идете дальше и находите комнату, которая полностью разукрашена различными словами и цифрами");
                                System.out.println("Вспомнив кинематограф, вы осознаете, что нечто подобное видели в фильмах 'Пила', неужели надо перебрать все комбинации, чтобы попасть в ту комнату?");
                                System.out.println("Нужно все-таки потратить время, силы и заряд фонарика, чтобы обыскать эту комнату, ведь пустая комната в бункере - редкое удовольствие.");
                                System.out.println("Спустя несколько часов поисков вы находите радио, карту города и немного прочего мусора. Тем не менее у вас есть целая комната, возможно тут есть нечто спрятанное, но вы сильно устали и решаетесь пойти в главную комнату отдыхать.");
                                inventory.add("Радио");
                                inventory.add("Карта города");
                                System.out.println("Придя в главную комнату вы осматриваете радио, замечаете, что оно работает от батареек, вам повезло - батарейки были внутри. Несколько минут вы крутите ползунок с частотами и находите одну работающую станцию. По ней вы крутится одно и тоже сообщение:");
                                System.out.println("Вам приветствует клан мародеров 'Белый Воин'. У нас для всех, кто нас слушает, важное объявление. У нас есть карта всех бункеров в нашем регионе. Однажды мы придем и к вам. Готовьте провиант, медикаменты и мебель, если не хотите быть убитыми. ");
                                System.out.println("Возможно вы станете нашими рабами, посмотрим по ситуации *злобный смех*.");
                                System.out.println("Вы понимаете, что нужно как-то защищаться, но сил работать уже нет. Перед сном вы проверяете свои нажитки и продумываете план на завташний день");
                                System.out.println(inventory);
                                System.out.println(" ");
                                System.out.println("День 1 пройден!!!");
                                resultOfDay1 = 3;
                            }
                            //вести разведку втроем, но на следующий день
                            if (decisionResult == 2) {
                                System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                                System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                                System.out.println(inventory);
                                System.out.println(" ");
                                System.out.println("День 1 пройден!!!");
                                resultOfDay1 = 4;
                            }
                        }

                        if (inventory.contains("Бинт")) {
                            System.out.println("Неужели в бункере совсем нет воды?! Резкое осознание, что без воды вы тут не протянете застваляет вас задуматься о дальнейших действия группы, но сперва нужно помочь товарищу!");
                            System.out.println("Перед вам стоит выбор: потратить целый бинт (1) или лучше поэкономить (2)");
                            Scanner decision = new Scanner(System.in);
                            int decisionResult = decision.nextInt();
                            if (decisionResult == 1) {
                                System.out.println("Бинт пожалуй универсальная вещь. Вы развязываете футболку и аккуратными движениями накладываете бинт, медицинский опыт вам в этом помогает. Группа признательна, что вы не пожалели бинт");
                                reputation = reputation + 1;
                            }
                            if (decisionResult == 2) {
                                System.out.println("В чем отличие бинта от ткани? По вашему мнению эти предметы эквиваленты. Не сказать, что все в группе считают также, но вы настаиваете на своем. А вдруг именно этого бинта не хватит чтобы спасти жизнь? Команда вас осуждает");
                                reputation = reputation - 1;
                            }
                            System.out.println("После этого вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                            System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до момента пока на " + myAllNeighbours.get(1) + "а не упал кирпич " + myAllNeighbours.get(0) + "нашел кое-что интересное в своем коридоре");
                            System.out.println("Вы должны принять решение: пойти исследовать этот коридор вдвоем(1) или подождать пока " + myAllNeighbours.get(1) + "у полегчает (2). У вас до сих пор есть фонарик.");

                            Scanner decision1 = new Scanner(System.in);
                            int decision1Result = decision1.nextInt();

                            //вести разведку вдвоем
                            if (decision1Result == 1) {
                                System.out.println("Вы понимаете, что нельзя тратить ни секунды, нужно максимально завладеть контролем над бункером, возможно, что тут осталось что-то полезное, но не стоит забывать о возможной опасности.");
                                System.out.println(myAllNeighbours.get(0) + " ведет вас вдоль этого коридора и показывает закрытую на кодовый замок дверь, возможно, там что-то есть.");
                                System.out.println("Вы задаетсь логичным вопросом: кто будет делать в бункере кодовый замок? Но " + myAllNeighbours.get(0) + " хотел показать вам не это. Вы идете дальше и находите комнату, которая полностью разукрашена различными словами и цифрами");
                                System.out.println("Вспомнив кинематограф, вы осознаете, что нечто подобное видели в фильмах 'Пила', неужели надо перебрать все комбинации, чтобы попасть в ту комнату?");
                                System.out.println("Нужно все-таки потратить время, силы и заряд фонарика, чтобы обыскать эту комнату, ведь пустая комната в бункере - редкое удовольствие.");
                                System.out.println("Спустя несколько часов поисков вы находите радио, карту города и немного прочего мусора. Тем не менее у вас есть целая комната, возможно тут есть нечто спрятанное, но вы сильно устали и решаетесь пойти в главную комнату отдыхать.");
                                inventory.add("Радио");
                                inventory.add("Карта города");
                                System.out.println("Придя в главную комнату вы осматриваете радио, замечаете, что оно работает от батареек, вам повезло - батарейки были внутри. Несколько минут вы крутите ползунок с частотами и находите одну работающую станцию. По ней вы крутится одно и тоже сообщение:");
                                System.out.println("Вам приветствует клан мародеров 'Белый Воин'. У нас для всех, кто нас слушает, важное объявление. У нас есть карта всех бункеров в нашем регионе. Однажды мы придем и к вам. Готовьте провиант, медикаменты и мебель, если не хотите быть убитыми. ");
                                System.out.println("Возможно вы станете нашими рабами, посмотрим по ситуации *злобный смех*.");
                                System.out.println("Вы понимаете, что нужно как-то защищаться, но сил работать уже нет. Перед сном вы проверяете свои нажитки и продумываете план на завташний день");
                                System.out.println(inventory);
                                System.out.println(" ");
                                System.out.println("День 1 пройден!!!");
                                resultOfDay1 = 5;
                            }
                            //вести разведку втроем, но на следующий день
                            if (decisionResult == 2) {
                                System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                                System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                                System.out.println(inventory);
                                System.out.println(" ");
                                System.out.println("День 1 пройден!!!");
                                resultOfDay1 = 6;
                            }
                        }
                    }

                    if (!inventory.contains("Вода") && !inventory.contains("Бинт")) {
                        System.out.println("Все что вы можете предложить ранненому это слабую перевязку из ткани его же футболки, больше вам нечем ему помочь.");
                        System.out.println("В этом бункере выжить невозможно: тут нет ни воды, ни бинтов. Стоит ли об этом говорить остальным? (1) - да   (2) - нет");
                        Scanner decision = new Scanner(System.in);
                        int decisionResult = decision.nextInt();
                        if (decisionResult == 1) {
                            System.out.println("Команда в шоке. Вы чувствуете нарастающую панику в остальных. Нужно собраться с духом и продолжить выживание, тем более половина комнат еще не разведована.");
                            reputation = reputation - 2;
                        }
                        if (decisionResult == 2) {
                            System.out.println("Уж лучше команда думает, что вы жмот, чем осознает, что шансы на выживание малы, возможно это ложь во благо, кто знает...");
                            reputation = reputation - 1;
                        }
                        System.out.println("Тем не менее надо бороться дальше.");
                        System.out.println("Вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                        System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до момента пока на " + myAllNeighbours.get(1) + "а не упал кирпич " + myAllNeighbours.get(0) + "нашел кое-что интересное в своем коридоре");
                        System.out.println("Вы должны принять решение: пойти исследовать этот коридор вдвоем(1) или подождать пока " + myAllNeighbours.get(1) + "у полегчает (2). У вас до сих пор есть фонарик.");

                        Scanner decision1 = new Scanner(System.in);
                        int decision1Result = decision1.nextInt();

                        //вести разведку вдвоем
                        if (decision1Result == 1) {
                            System.out.println("Вы понимаете, что нельзя тратить ни секунды, нужно максимально завладеть контролем над бункером, возможно, что тут осталось что-то полезное, но не стоит забывать о возможной опасности.");
                            System.out.println(myAllNeighbours.get(0) + " ведет вас вдоль этого коридора и показывает закрытую на кодовый замок дверь, возможно, там что-то есть.");
                            System.out.println("Вы задаетсь логичным вопросом: кто будет делать в бункере кодовый замок? Но " + myAllNeighbours.get(0) + " хотел показать вам не это. Вы идете дальше и находите комнату, которая полностью разукрашена различными словами и цифрами");
                            System.out.println("Вспомнив кинематограф, вы осознаете, что нечто подобное видели в фильмах 'Пила', неужели надо перебрать все комбинации, чтобы попасть в ту комнату?");
                            System.out.println("Нужно все-таки потратить время, силы и заряд фонарика, чтобы обыскать эту комнату, ведь пустая комната в бункере - редкое удовольствие.");
                            System.out.println("Спустя несколько часов поисков вы находите радио, карту города и немного прочего мусора. Тем не менее у вас есть целая комната, возможно тут есть нечто спрятанное, но вы сильно устали и решаетесь пойти в главную комнату отдыхать.");
                            inventory.add("Радио");
                            inventory.add("Карта города");
                            System.out.println("Придя в главную комнату вы осматриваете радио, замечаете, что оно работает от батареек, вам повезло - батарейки были внутри. Несколько минут вы крутите ползунок с частотами и находите одну работающую станцию. По ней вы крутится одно и тоже сообщение:");
                            System.out.println("Вам приветствует клан мародеров 'Белый Воин'. У нас для всех, кто нас слушает, важное объявление. У нас есть карта всех бункеров в нашем регионе. Однажды мы придем и к вам. Готовьте провиант, медикаменты и мебель, если не хотите быть убитыми. ");
                            System.out.println("Возможно вы станете нашими рабами, посмотрим по ситуации *злобный смех*.");
                            System.out.println("Вы понимаете, что нужно как-то защищаться, но сил работать уже нет. Перед сном вы проверяете свои нажитки и продумываете план на завташний день");
                            System.out.println(inventory);
                            System.out.println(" ");
                            System.out.println("День 1 пройден!!!");
                            resultOfDay1 = 7;
                        }
                        //вести разведку втроем, но на следующий день
                        if (decisionResult == 2) {
                            System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                            System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                            System.out.println(inventory);
                            System.out.println(" ");
                            System.out.println("День 1 пройден!!!");
                            resultOfDay1 = 8;
                        }
                    }
                }

                //КТО ТО НАСТУПИТ НА ГВОЗДЬ
                if (chanceThatSomebodyDie > 47 && chanceThatSomebodyDie <= 80) {
                    System.out.println("Вы заглядываете в коридор и видите, что " + myAllNeighbours.get(1) + " лежит на полу. К вам на помощь прибегает ваш второй сосед, вместе вы бежите к раненному.");
                    System.out.println("Подойдя поближе вы видите, что он живой, пытается встать. По своей невнимательности ваш товарищ наступил на огромный ржавый гвоздь. От такого гвоздя ни одна подошва не спасет?");
                    System.out.println("Вы берете его под руки и тащите в главную комнату. Первый день и первые же травмы. Понимаете, что кровотечение не такое сильное, возможно, вы сможете ему чем-то помочь, нужно проверить припасы");
                    System.out.println("Вы начинаете открывать шкафы в поисках чего-то, что может помочь вашему товарищу.");
                    if (inventory.contains("Бинт") && inventory.contains("Вода")) {
                        System.out.println("Вы нашли все необходимое для его лечения: чистую воду и бинт, но вам нужно решить стоит ли их тратить");
                        System.out.println("Потратить и бинт, и воду (1); потратить только бинт (2); потратить только воду (3); ничего не тратить (4)");
                        Scanner decision = new Scanner(System.in);
                        int decisionResult = decision.nextInt();
                        if (decisionResult == 1) {
                            inventory.remove("Вода");
                            inventory.remove("Бинт");
                            System.out.println("Вы обрабатываете рану соседа водой, аккуратно удаляете пыль и прочую грязь, перематываете рану бинтов.");
                            System.out.println("Вы решаете оказать товарищу максимальную помощь. По вашему мнению воды и бинтов еще много. Команда вам очент признательна");
                            System.out.println("Будем надеяться, что дня на восстановление ему хватит. Заражения крови быть не должно");
                            reputation = reputation + 2;
                        }
                        if (decisionResult == 2) {
                            inventory.remove("Бинт");
                            System.out.println("По вашему лидерскому мнению команда испытывает дефецит воды, потому вы разрешаете использовать только одну упаковку бинта");
                            System.out.println("Резким движением руки вы перематываете пятку раненного, так как пыль и прочий мусор не были удалены должным образом. ");
                            System.out.println(myAllNeighbours.get(1) + "а пробивает резкая дрожь, раздается ужасный вой. Команда вами разочарована");
                            System.out.println("По мнению команды, вода была бы немного полезней в данной ситуации нежели бинт.");
                            reputation = reputation - 2;
                        }
                        if (decisionResult == 3) {
                            inventory.remove("Вода");
                            System.out.println("В таких ситуациях главное не допустить заражение крови, вы аккуратно проливаете рану водой, удаляя лишнюю пыль, позже вы прикрываете рану куском футболки.");
                            System.out.println("Команда рада, но тем не менее не довольна вашей жадностью, могли бы потратить еще и бинтик. Команда вас немного осуждает");
                            reputation = reputation - 1;
                        }
                        if (decisionResult == 4) {
                            System.out.println("Ресурсы не могут быть потрачены просто так, это всего лишь небольшая дырка в пятке, ну и что, что это был ржавый гвоздь в старом бункере, до свадьбы заживет.");
                            System.out.println("Вы перевязываете рану куском футболки и оставляете его отдыхать. Команда критически расстроена вашим действиями.");
                            reputation = reputation - 3;
                        }

                        System.out.println("Вы понимаете, что опастность подстеригает вас на каждом углу. Вам надо сделать выбор, чем заниматься далее:");
                        System.out.println("Пойти исследовать правый коридор (1); пойти исследовать левый коридо (2); оставаться в центральной комнате и ждать помощи (3)");
                        Scanner decision1 = new Scanner(System.in);
                        int decision1Result = decision1.nextInt();
                        //левый коридор или правый коридор
                        if (decision1Result == 1 || decision1Result == 2) {
                            System.out.println("Выбор сделан, но вы пойдете вдвоем. В фонарике еще остался заряд, но это не значит, что не нужно считать, что опастность минует");
                            System.out.println("Вы аккуратно заходите в коридор, держась максимально близко друг к другу. Где-то вдали вы видите нечто похожее на рубильник. Аккуратно идете в его сторону");
                            System.out.println("Хотите ли вы его дернуть его? Да - (1); Нет - (2) ");
                            Scanner decision2 = new Scanner(System.in);
                            int decision2Result = decision2.nextInt();
                            if (decision2Result == 1) {
                                reputation = reputation + 1;
                                System.out.println("Была ни была. Команда будет восхищена вашей храбростью, ведь вы берете на себя отвественность. Вы дергаете рычаг иии...");
                                double chanceThatSomethingHappen = Math.random() * 100;
                                double badVariant = Math.random() * 100;
                                if (chanceThatSomethingHappen <= 50 && chanceThatSomethingHappen % 3 != 0 && chanceThatSomethingHappen % 5 != 0) {
                                    if (badVariant <= 50) {
                                        System.out.println("Проходит минута. Вы уже думаете, что ничего не произойдет, но вдруг в одной из комнат дальше по коридору включается свет");
                                        System.out.println("Без задней мысли вы идете на свет. Почему свет загорелся только в одной комнате остается загадкой.");
                                        System.out.println("Аккуратно заглянув туда вы обнаруживаете, что комната абсолютно пустая, в ней есть всего пару шкафов и стенд с противогазом");
                                        inventory.add("Противогаз");
                                        inventory.add("Автомат калашникова с патронами");
                                        inventory.add("Радио");
                                        System.out.println("Вы забираете все, что можете найти. Возвращаетесь в главную комнату, проверяете здоровье раненного товарища и начинаете разбирать находки.");
                                        System.out.println("Одной из находок было современное радио, работающее от батареек. Долго пытаетсь найти волну и вот наконец-то успех. По этой волне вы слышите сообщение: ");
                                        System.out.println("Джони, я нашел их! Джони, наша секретная разработка сработала! Але-але, вы нас слышите? Мы знаем где вы находитесь!");
                                        System.out.println("Через сутки мы будем у вас, готовьте все свои припасы, оружие и тела, ваш дом - наш дом!!!");
                                        System.out.println("На этом моменте сообщение обрывается. Сил уже нету, было принято решение переехать в комнату, которую только что нашли, закрыть в ней дверь и переночивать, продумав план на следующий день.");
                                        System.out.println(inventory);
                                        System.out.println("День 1 пройден!");
                                        resultOfDay1 = 9;
                                    }
                                    if (badVariant > 50 && badVariant < 70) {
                                        System.out.println("Проходит минута. Вы уже думаете, что ничего не произойдет, но вдруг в одной из комнат дальше по коридору включается свет");
                                        System.out.println("Без задней мысли вы идете на свет. Почему свет загорелся только в одной комнате остается загадкой.");
                                        System.out.println("Аккуратно заглянув туда вы обнаруживаете, что комната буквально набита каким-то огромными жуками");
                                        System.out.println("Они на вас нападают, но вы пытаесь отбиться. Их целая туча, от них уже невозможно сбежать, к сожалению, ваша группа оказалась мертва.");
                                        System.out.println("Игра окончена!");
                                        resultOfDay1 = 10;
                                    } else {
                                        System.out.println("Моментально включается свет во всем бункере - это вы понимаете по крику своего раненного товарища, что кто-то включил свет.");
                                        System.out.println("Начинает орать сирена, а спястя полминуты - зацикленное сообщение: 'Мы вас нашли, готовьтесь' 'Мы вас нашли, готовьтесь' 'Мы вас нашли, готовьтесь'");
                                        System.out.println("Вы слышите какой-то жуткий звук, похожий на стук во входную дверь. Бежите в главную комнату.");
                                        System.out.println("Ваш товарищ мертв, а рядом с ним стоит целый отряд из рейдеров-мародеров.");
                                        System.out.println("'Мы вас нашли, а вы не подготовились' - сказал их лидер, направил на вас пистолет и выстрелил");
                                        System.out.println("Игра окончена!");
                                        resultOfDay1 = 11;
                                    }
                                }
                                if (chanceThatSomethingHappen % 3 == 0) {
                                    System.out.println("Проходит пару секунд. Проходит минута. Ничего не происходит. Возможно что-то включилось в другом месте.");
                                    System.out.println("В течении нескольких часов вы бродите по бункеру и не замечаете никаких изменений. Усталось дает о себе");
                                    System.out.println("Вы возвращаетесь в главную комнату, проверяете самочувствие раненного, а заодно припасы");
                                    System.out.println(inventory);
                                    System.out.println("Садитесь в кресло и засыпаете, к сожалению день прошел не так радостно, как хотелось бы");
                                    System.out.println("День 1 пройден!");
                                }
                                if (chanceThatSomethingHappen % 5 == 0) {
                                    System.out.println("Через пару секунд вы слышите звук открывающейся двери. Звук относится откуда-то спереди. Без лишних раздумий вы идете туда. ");
                                    System.out.println(myAllNeighbours.get(2) + " пытается вас остановить, но вы устремлены к двери.");
                                    reputation = reputation - 1;
                                    System.out.println("Вы подходите к двери, ее толчища вас поражает, аккуратно заглядываете туда иии...");
                                    if (badVariant <= 50 && badVariant % 2 != 0 && badVariant % 5 != 0) {
                                        System.out.println("В этой огромной современной комнате сидит группа людей. Вы успеваете заметить, что все это время за вами кто-то следил.");
                                        System.out.println("Невозможно описать как так получилось. Вы проходите чуть дальше.");
                                        System.out.println("Лидер банды встает со своего места, наводит на вас пистолет и стреляет.");
                                        System.out.println("Игра окончена!");
                                    }
                                    if (badVariant % 7 == 0) {
                                        System.out.println("В этой огромной современной комнате сидит группа людей в деловый костюмах. Вы успеваете заметить, что все это время за вами кто-то следил.");
                                        System.out.println("Невозможно описать как так получилось. Вы проходите чуть дальше.");
                                        System.out.println("Люди продолжают смотреть в монитор. Вы проходите немного дальше. Центральный смотрящий разворачивается на кресле.");
                                        System.out.println("В нем вы узнаете какого-то популярного политика, которого часто крутили по ТВ");
                                        System.out.println("Он встает со своего места, дергает другого человека за плечо, а тот наводит на вас пистолет и стреляет.");
                                        System.out.println("Игра окончена!");
                                    }
                                    if (badVariant > 50 && badVariant % 2 != 0 && badVariant % 5 != 0) {
                                        System.out.println("Из двери идет пар, как в фильмах про космос. Вы заходите в нее. Внутри комнаты сидят непонятные человекоподобные существа.");
                                        System.out.println("Вы ловите их взгляд и чувствуете, как ваше тело превращается в жижу.");
                                        System.out.println("Вы смотрите на ваши руки и видите, что они буквально текут на пол. Спустя полминуты вы умираете. ");
                                        System.out.println("Игра окончена!");
                                    } else {
                                        System.out.println("Вы заходи вовнутрь. Там вы видите старый заброшенный командный пункт. Видимо этот бункер строился во времена холодной войны.");
                                        System.out.println("Вы обыскиваете эту комнату и находите немного ценностей: противогаз, аптечку с истекшим сроком годности и пистолет макарова с двумя обоймами.");
                                        inventory.add("Противогаз");
                                        inventory.add("Аптечка с истекшим сроков годности");
                                        inventory.add("Пистолет макарова с патронами");
                                        System.out.println("Вы забираете эти вещи и несете их в главную комнату");
                                        System.out.println("День подходит к концу, хотя вы не знаете этого наверняка, но биологические часы говорят вам, что пора спать.");
                                        System.out.println("Перед сном вы проверяете инвентарь, проверяете состояние раненного товарища и ложитесь спать");
                                        System.out.println("День 1 пройден");
                                        resultOfDay1 = 12;
                                    }
                                }
                            }
                            if (decision2Result == 2) {
                                System.out.println("Никто не знает, что это рубильник включает, может быть он лешит нас кислорода или откроет входную дверь. В очщем вы не решаетесь воспользоваться шансом. " + myAllNeighbours.get(2) + " слегка разочарован вами.");
                                reputation = reputation - 1;
                            }
                        }
                        if (decision1Result == 3) {
//todo МОМЕНТ ОСТАНОВКИ. ТУТ ОНИ РЕШАЮТ ОСТАТЬСЯ В БУНКЕРЕ
                        }
                    }
                }

                //КОГО-ТО ЗАКГРЫЗУТ ТАРАКАНЫ И ОН УМРЕТ
                if (chanceThatSomebodyDie > 80) { //
                    System.out.println("Вы слышите страшные вои, визги, крики. Человек из левого коридора прибегает к вам и вы вместе идете в правый коридор. Шум унялся. В дали вы видите тусклое пламя свечи и ускоряете свой шаг.");
                    System.out.println("Вам кажется, что кто-то издает какие-то звуки, похожие на стрекот. Вы как лидер должны принять решение: побежать помогать своему товарищу (1), вернуться к главную комнату, найти оружие и вернуться (2)");

                    Scanner decision1 = new Scanner(System.in);
                    int decision1Result = decision1.nextInt();

                    //ВЫ БУДЕТЕ РАЗВЕДОВАТЬ ТЕРРИТОРИЮ С ЖУКАМИ БЕЗ ОРУЖИЯ
                    if (decision1Result == 2) {
                        System.out.println("Вы тихо подходите к свечи и видете лужу крови. В голове вы гадаете, кто это мог быть: мародеры, монстры или наркоманы, которые живут здесь уже 20 лет.");
                        System.out.println("Вы видите комнату, кажется, что именно оттуда идет странный стрекот, заглядываете туда и видите рой огромных метровых тараканов, которые уже доедают труп вашего бывшего соседа. По своей глупости вы посветели фонариком прямо в их глаза...");
                        System.out.println("Игра окончена. Вы были съедены тараканами. Вы прожили всего 1 день.");
                        //TODO РАЗНООБРАЗИТЬ, БОЛЬШЕ ЭКШЕНА
                    }

                    //ВЫ БУДЕТЕ РАЗВЕДОВАТЬ ТЕРРИТОРИЮ, НО СПЕРВА ПОИЩЕТЕ ОРУЖИЕ
                    if (decision1Result == 1) {
                        if (inventory.contains("Ржавый автомат Калашникова") && inventory.contains("Две пачки патронов на Калашников") || inventory.contains("Топор") || inventory.contains("Кухонный нож") || inventory.contains("Армейский нож")) {
                            String weapon = null;
                            if (inventory.contains("Ржавый автомат Калашникова") && inventory.contains("Две пачки патронов на Калашников"))
                                weapon = "Ржавый автомат Калашникова";
                            if (inventory.contains("Топор"))
                                weapon = "Топор";
                            if (inventory.contains("Кухонный нож"))
                                weapon = "Кухонный нож";
                            if (inventory.contains("Армейский нож"))
                                weapon = "Армейский нож";

                            ArrayList<String> whatWasInClassroom = new ArrayList<>();
                            whatWasInClassroom.add("Шоколадное ассорти");
                            whatWasInClassroom.add("Хирургический набор");
                            whatWasInClassroom.add("Карта города");
                            whatWasInClassroom.add("Два набора раций");
                            inventory.add("Шоколадное ассорти");
                            inventory.add("Хирургический набор");
                            inventory.add("Карта города");
                            inventory.add("Два набора раций");

                            System.out.println("Вы решаете вернуться в главную комнату, взять что-то из оружия. К вашему счастью, вы находите " + weapon + ". Возможно это вам поможет. Вы возвращаетесь в коридор и верите, что " + weapon + " поможет вам спасти вашего товарища.");
                            System.out.println("Вы бродите через этот темный коридор, примерно находите комнату, из которой шел шум и начинается освещать ее фонариком. Вы видите, что в этой комнате сидит куча огромных тараканов, которые жадно додедают труп вашего, уже бывшего, соседа");
                            System.out.println("При виде света они накидываются на вас, но вы отбиваете их атаку с помощью " + weapon + ". Перебив всех, вы аккуратно заходите в комнату. От" + myAllNeighbours.get(1) + "а практически ничего не осталось. Вы понимаете, что его уже не воскресить.");
                            System.out.println("Со слезами на глазах вы начинаете обыскивать комнату, оказывается, что это был какой-то учебный класс. Вы открываете все ящики и шкафы и вот, что вы нашли: " + whatWasInClassroom + ". Вы забираете эти вещи с собой.");
                            System.out.println("Вы не знаете, откуда там появились эти жуки, поэтому по возвращении, вы решаетесь закрыть эту дверь до лучших времен. 'Если бы была бы возможность восстановить электричество во всем бункере...'");
                            System.out.println("Перед сном вы решили проверить свои запасы, ставите все ровным рядом на полу, возле входа и смотрите на них. К каждому предмету вы уже придумали применение.");
                            System.out.println("Итого, в вашем распоряжении имеются: " + inventory);
                            System.out.println("Этот день был тяжелым, бег до бункера, попытка спасения товарища, бойня с тараканами. Откинувшись на стул, вы решаете, что пора бы поспать... ");
                            System.out.println("День 1 - окончен! Поздравляем");
                        }
                        //ЕСЛИ НЕТ ОРУЖИЯ
                        if (!inventory.contains("Ржавый автомат Калашникова") && !inventory.contains("Две пачки патронов на Калашников") && !inventory.contains("Топор") && !inventory.contains("Кухонный нож") && inventory.contains("Армейский нож")) {
                            System.out.println("К сожалению, ничего, что могло бы помочь вам в самозащите вы не нашли. Вам сосед предлагает вам вариант замуровать эту дверь и забыть про " + myAllNeighbours.get(1) + " (1). Вы же в свою очередь хотите пойти хотя бы посмотреть, что же там произошло (2)");

                            //ПОЙТИ БЕЗ ОРУЖИЯ ИЛИ ЗАБИТЬ 1-ЗАБИТЬ  2-ПОЙТИ ПОМИРЕТЬ
                            Scanner decision2 = new Scanner(System.in);
                            int decision2Result = decision2.nextInt();
                            if (decision2Result == 1) {
                                System.out.println("Инстинкт самосохранения больше, чем желание помочь. 'Закрываем' - говорите вы, " + myAllNeighbours.get(0) + " закрывает дверь. Вы садитесь за стол и понимаете, что вы в бункере всего полдня, а вы уже потеряли своего соседа. 'Чем нас меньше - тем нам сложнее...'");
                            } //TODO ДОДЕЛАТЬ ЦЕПОЧКУ, ЧТО БУДЕТ ДАЛЬШЕ

                            if (decision2Result == 2) { //TODO РАЗНООБРАЗИТЬ, БОЛЬШЕ ЭКШЕНА
                                System.out.println("Несмотря на страх и возможность быть убитым, вы решаетесь идти в бой с тем, что есть. Вы проходите 5 метров, 10, 15, свеча уже погасла. Вы видите комнату, из которой, как вам казалось, доносились возгласы.");
                                System.out.println("По своей невнимательности вы освещаете это помещение фонариком и видите группы огромных тараканов, которые жадно доедают " + myAllNeighbours.get(0) + ". Они вас замечают, набрасываются, вы пытаетесь от них отбиться, но все тчетно...");
                                System.out.println("Игра окончена. Вы были съедены тараканами. Вы прожили всего 1 день.");
                            }
                        }
                    }
                }
            }

            if (injuryChance1Day1 <= 40) {//никто не будет ранен, будет найдено две комнаты в левом коридоре: спальни и учебная комната, вы их лутаете и наступает день 2
                System.out.println("Вы открываете шкаф и находите там и находите там " + x + " инструментов. Возможно это вам пригодиться");
                System.out.println("Из левого коридора раздается шум, похожий на падение. Вы бежите туда и видите, что " + myAllNeighbours.get(0) + " лежит на полу на входе в комнату. ");
                System.out.println("Осветив комнату фонариком, вы понимаете, что это какое-то подобие спальни, которая рассчитана человек на 10. К вам прибегает ваш второй сосед и вы вместе исследуете комнату.");
                System.out.println("Открыв одну из тумбочек вы находите противогаз, в другой была фляга для воды, а в третьей - швейный набор. На вешалке весел зимний тулуп, под ним стояли валинке. Видимо у этого бункера был какой-то хранитель.");
                inventory.add("Противогаз");
                inventory.add("Фляга");
                inventory.add("Тулуп");
                inventory.add("Валенки");
                inventory.add("Швейный набор");
                System.out.println("Вам как лидеру группы нужно решить, где жить: в главной комнате, откуда можно контролировать все тоннели (1) или переехать сюда, все-таки на кроватях удобней, чем на стульях (2)");

                Scanner decision3 = new Scanner(System.in);
                int decision3Result = decision3.nextInt();

                // 1 - В ГЛАВНОЙ КОМНАТЕ    2 - В НОВОЙ КОМНАТЕ
                if (decision3Result == 1) {
                    System.out.println("Ваши соседи не совсем согласны с вашим решением, но они же сами избрали вас лидером. Вы забираете все вещи из этой комнаты, отправляете " + myAllNeighbours.get(0) + "а на продолжение разведки, а сами думаете, можно ли как-то перенести кровати в главную комнату.");
                    System.out.println("Человек, который разведовал другой коридор рад вам сообщить, что он нашел Радио. Теперь ваши скучные подземные дни будут приукрашены музыкой. Вот только вопрос: остались ли какие-нибудь радиостанции после аппокалипсиса?");

                    System.out.println("Вы включаете радио и пытаетесь поймать что-то кроме помех. 'Внимание всем выжившим, вас приветсвует банда 'Рейдеры Манчестера', у нас есть карта всех укрытий города, каждый день, начиная со следующего,");
                    System.out.println("исследовать ваши укрытия. Мы хотим, чтобы вы нас встретили и дали половину своих вещей, только при таком условии мы вас не УБЬЕМ'. Вы выключаете радио, смотрите на испуганные лица своих соседей и понимаете, что надо что-то делать.");
                    System.out.println("Вы можете забаррикадировать вход в бункер, но потеряете большую часть мебели (1), а потом уйти в другую комнату; или переместиться в другое крыло бункера и делать вид, что тут никого нет (2).");

                    Scanner decision4 = new Scanner(System.in);
                    int decision4Result = decision4.nextInt();

                    //1 - СТРОИТЬ УКРЕПЛЕНИЯ     2 - УЙТИ В ДРУГУЮ ЧАСТЬ БУНКЕРА
                    if (decision4Result == 1) {
                        System.out.println("Вы решаете стоить укрепления, встроем вы передвигаете тяжелый шкаф ближе к двери, пытаетесь его как то закрепить, тем что находите");
                        int strengthOfDoor;
                        if (myCharacter.contains("Автомеханик") || myCharacter.contains("Дровосек") || myCharacter.contains("Плотник") || myCharacter.contains("Строитель") && inventory.contains("Молоток") && inventory.contains("Гвозди")) {
                            System.out.println("Передвинув шкаф и разломав немного прочей мебели вы видите, что укрепление получилось довольно неплохим, вот только вместе с осознанием вашей защищенности к вам приходит понимание, что вы тоже не сможете выбраться отсюда, неужели этот бункер станет вашей могилой? ");
                            if (inventory.contains("Молоток") && inventory.contains("Гвозди")) {
                                inventory.remove("Молоток");
                                inventory.remove("Гвозди");
                                strengthOfDoor = 90;
                            }
                        }
                        if (myCharacter.contains("Автомеханик") || myCharacter.contains("Дровосек") || myCharacter.contains("Плотник") || myCharacter.contains("Строитель")) {
                            System.out.println("Среди вас оказались люди, которые умеют работать с деревом, но у вас нет нужных иснтрументов, что сделать максимум защиты. Все что вы можете - это передвинуть шкаф поближе к двери и вставит ножку стула в круговой механизм открытия двери. Возможно, вам повезет и рейдеры не нападут на вас.");
                            strengthOfDoor = 60;
                        }
                        if (!myCharacter.contains("Автомеханик") && !myCharacter.contains("Дровосек") && !myCharacter.contains("Плотник") && !myCharacter.contains("Строитель")) {
                            System.out.println("Среди вас нету ни специально обученных людей, ни иснтрументов, все, что вы можете - накидать всю мебель с главной комнаты перед дверью и надеяться");
                            strengthOfDoor = 30;
                        }
                    }

                    if (decision4Result == 2) {
                        System.out.println("Ваше решение простое - переезд. Одного из вас вы отправили в комнату, чтобы он там немного прибрался, вдвоем вы переносите вещи. Желая переехать как можно быстрее, мы вешаете на себя огромную кучу вещей.");
                        System.out.println("По вашей неосторожности " + inventory.indexOf(6) + " цепляется за дверной проем, за гвоздь, и ломается.");
                        inventory.remove(6);
                    }
                }
            }
        // ТУТ ЗАКАНЧИВАЕТСЯ 1 ДЕНЬ


        if (bunkerSize < 50) {
            System.out.println("Вам повезло, бункер оказался маленький. Вряд ли тут есть кто-то еще, но надо оставаться начеку.");
        }
    }
        private static void gameStarter() {
            Scanner sc1 = new Scanner(System.in);
            int startGame = 0;
            while (startGame != 1) {
                startGame = sc1.nextInt();
                if (startGame != 1) System.out.println("Введите верное число");
            }
        }

        private static void clearConsole() {
            for (int i = 0; i <= 50; i++) {
                System.out.println(" ");
            }
        }

        private static void drowLine() {
            System.out.print("___________________________________________________________________________________");
            System.out.println("___________________________________________________________________________________");
        }

        private static void showProfList (HashMap < Integer, String > gameCharacters){
            for (int num : gameCharacters.keySet()) {
                System.out.print("[" + num + "]" + gameCharacters.get(num) + "   ");
            }
        }

        private static void showRules () {
            System.out.println(" ");
            System.out.println("Добро пожаловать в игру 'Бункер' ");
            //Thread.sleep(1000);
            System.out.println("Правила: ");
            System.out.println("В этой игре вам нужно прожить 1.5 дня, а затем сразиться с мародерами.");
            System.out.println("Каждый день с вами и вашими персонажами будет случаться какая-то неожиданность.");
            System.out.println("В начале игры вы cможете выбрать своего персонажа и персонажей, которые будут находиться в бункере вместе с вами");
            System.out.println("Подходите в выбору персонажей с особой осторожность.");
            System.out.println("Чтобы посмотреть свой инвентарь введите /inv ; если хотите помощи наберите /help ; также есть возможность посмотреть биографии людей - /bio[номер персонажа]");
            System.out.println("Удачи!");
            System.out.println(" ");
            System.out.println("Если вы готовы начать игру, нажмите 1");
        }
    }
