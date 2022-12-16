package bunker;

//TODO СДЕЛАТЬ, ЧТО ЕСЛИ ДЕНЬ ПРОЙДЕН, ТО ПОЯВЛЯЕТСЯ ЭТА НАДПИСАСЬ, ДАЛЬШЕ КОД НЕ ИГРАЕТСЯ, А РЕЗУЛЬТАТ ПЕРЕХОДИТ В ДРУГОЙ ДЕНЬ
//todo ДРУГОЙ ДЕНЬ = ДРУГОЙ УНИВЕРСАЛЬНЫЙ КЛАСС, В КОТОРЫЙ ПРИДУТ ПОЧТИ ВСЕ ВАРИАЦИИ
//TODO ДОДЕЛАТЬ ЛУП, ЧТОБЫ ЕСЛИ ЧЕЛОВЕК ПРОИГРЫВАЛ, ТО ИГРА ПРЕКРАЩАЛАСЬ, ЕСЛИ ВЫИГРЫВАЛ, ТО ПЕРЕХОДИЛ НА НОВЫЙ УРОВЕНЬ
//TODO СДЕЛАТЬ СИСТЕМУ БОЕВКИ (ДОМАШКИ)
//TODO ПРИЙДТИ К ЛОГИЧНОМУ ВЫВОДУ - БИТВЕ С МАРОДЕРАМИ

import java.util.ArrayList;

public class Main extends PersonChoice {

    private static ArrayList<String> inventory;

    public static void main(String[] args) {

        int reputation = 0;
        int resultOfDay1 = 0;

        //правила
        Utils.showRules();

        //запуск игры
        Utils.gameStarter();

        //создание персонажей
        PersonChoice.makingGameCharacterList();
        PersonChoice.choosingPlayerCharacter();
        PersonChoice.choosingTheFirstNeighbour();
        PersonChoice.choosingTheSecondNeighbour();

        //выпадение шмоток
        BunkerItems.addRandomOfBunkerItems();
        BunkerItems.showInventory();

        //Цикл дней
        for (int day = 1; day <= 10; day++) {

            //ДЕНЬ 1
            Utils.day(1, myAllNeighbours);

            //начало травм
            //double injuryChance1Day1 = (int) (Math.random() * 100); //Шанс на  ранение
            double chanceThatSomebodyDie = (int) (Math.random() * 100); //Шанс на тип ранения или смерть

            //if (injuryChance1Day1 > 40) { //будет ли кто-то ранен в первый день
                System.out.println("Спустя некоторое время вы слышите крик в правом коридоре. Бросив все, бежите смотреть, что там произошло...");

                //КОГО ТО УДАРИТ КИРПИЧОМ
                if (chanceThatSomebodyDie <= 47) {
                    System.out.println("Вы забегаете в коридор и видите облако пыли. Прибегает ваш второй сосед, вместе вы идете в сторону облака.");
                    System.out.println("Где-то вдали стонет " + myAllNeighbours.get(0) + ".");
                    System.out.println("Подойдя поближе замечаете, что он живой, хотя из его головы течет кровь - кусок потолка обвалился ему на голову. ");
                    System.out.println("Ничего серьезного, возможно, вам придется потратить некоторые медикаменты, если они у вас есть.");
                    System.out.println("Вы берете его под руки и тащите в главную комнату.");
                    System.out.println("Кровотечение не такое сильное, возможно, вы сможете ему чем-то помочь. Нужно проверить припасы");

                    if (BunkerItems.inventoryChecker("Бутылка воды") && BunkerItems.inventoryChecker("Бинт")) {
                        System.out.println("У вас есть все необходимое для оказания первой помощи, что вы хотите пожертвовать?");
                        System.out.println(ANSI_BLUE + "(1) - потратить воду и бинт; (2) - потратить только воду; (3) - потратить только бинт; (4) - ничего не тратить." + ANSI_RESET);

                        int decisionResult = Utils.getNum(1, 4);

                        if (decisionResult == 1) {
                            BunkerItems.inventoryRemover("Бинт");
                            BunkerItems.inventoryRemover("Бутылка воды");
                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("Вы аккуратно промываете рану, после перевязываете его голову, кладете его на кресло и отдаете ему оставшуюся бутылку воды.");
                            System.out.println("Вся комнада очень вам признательна.");
                            System.out.println("Вот что у вас осталось: ");
                            BunkerItems.showInventory();
                            reputation = reputation + 2;
                        }
                        if (decisionResult == 2) {
                            BunkerItems.inventoryRemover("Бутылка воды");
                            System.out.println("Вы решаете, что травма не настолько серьезная, чтобы тратить на нее целый бинт. Вы перевязываете его голову куском ткани, промываете рану и отдаете остаток воды.");
                            System.out.println("Команда не настолько вам признательна, как могла бы быть");
                            System.out.println("Вот что у вас осталось: ");
                            BunkerItems.showInventory();
                            reputation = reputation + 1;
                        }
                        if (decisionResult == 3) {
                            BunkerItems.inventoryRemover("Бинт");
                            System.out.println("Вы решаете, что травма головы - вещь серьезная, при этом вы не верите в то, что вода может помочь.");
                            System.out.println("Вы накладываете бинт поверх раны и приказываете раненному отдыхать.");
                            System.out.println("Вот что у вас осталось: ");
                            BunkerItems.showInventory();
                            reputation = reputation + 1;
                        }
                        if (decisionResult == 4) {
                            System.out.println("Вы оцениваете травму своим лидерским взглядом и приходите к выводу, что не нужно ему помогать вообще.");
                            System.out.println("Вы перевязали ему голову лоскутом его же футболки и оставили отдыхать. Команда крайне вами недовольна ");
                            reputation = reputation - 2;
                        }

                        System.out.println("После этого вы решаете немного отдохнуть, ложитесь в кресло и засыпаете");
                        System.out.println("Через пару часов ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до того как на " + myAllNeighbours.get(0) + "а упал кирпич он нашел кое-что в своем коридоре");
                        System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1); или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2). У вас до сих пор есть фонарик." + ANSI_RESET);

                        int decision1Result = Utils.getNum(1, 2);

                        //вести разведку вдвоем
                        if (decision1Result == 1) {
                            Utils.showTextPart1();
                            resultOfDay1 = 1;
                            Utils.stopGameWin();
                        }
                        //вести разведку втроем, но на следующий день
                        if (decisionResult == 2) {
                            System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                            System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                            BunkerItems.showInventory();
                            System.out.println(" ");
                            System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                            resultOfDay1 = 2;
                            Utils.stopGameWin();
                        }
                    }

                    if (BunkerItems.inventoryChecker("Бутылка воды") || BunkerItems.inventoryChecker("Бинт")) {
                        if (BunkerItems.inventoryChecker("Бутылка воды")) {
                            System.out.println("Вы понимаете, долго вам не протянуть - здесь даже бинта обычного нет. Вы перевязываете голову ранненого его же футболкой.");
                            System.out.println(ANSI_BLUE + "Перед вам стоит выбор: оставить ему бутылку воды на день (1) или лучше поэкономить (2)" + ANSI_RESET);

                            int decisionResult = Utils.getNum(1, 2);
                            if (decisionResult == 1) {
                                System.out.println("На здоровье не экономят, тем более, вы слышали, что большое количество воды способствует заживлению всех травм. Команда вам признательна.");
                                reputation = reputation + 1;
                            }
                            if (decisionResult == 2) {
                                System.out.println("Вы верите, что травма не такая сильная, она сможет зажить за пару дней максимум. Группа не совсем поддерживает ваше решение");
                                reputation = reputation - 1;
                            }
                            System.out.println("После этого вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                            System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до того как на " + myAllNeighbours.get(1) + "а упал кирпич " + myAllNeighbours.get(0) + "нашел кое-что в своем коридоре");
                            System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1) или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2). У вас до сих пор есть фонарик." + ANSI_RESET);

                            int decision1Result = Utils.getNum(1, 2);

                            //вести разведку вдвоем
                            if (decision1Result == 1) {
                                Utils.showTextPart1();
                                resultOfDay1 = 3;
                                Utils.stopGameWin();
                            }
                            //вести разведку втроем, но на следующий день
                            if (decisionResult == 2) {
                                System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                                System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                                BunkerItems.showInventory();
                                System.out.println(" ");
                                System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                                resultOfDay1 = 4;
                                Utils.stopGameWin();
                            }
                        }

                        if (BunkerItems.inventoryChecker("Бинт")) {
                            System.out.println("Неужели в бункере совсем нет воды?! Резкое осознание, что без воды вы тут не протянете застваляет вас задуматься о дальнейших действия группы, но сперва нужно помочь товарищу!");
                            System.out.println(ANSI_BLUE + "Потратить целый бинт (1) или лучше поэкономить (2)?" + ANSI_RESET);

                            int decisionResult = Utils.getNum(1, 2);
                            if (decisionResult == 1) {
                                System.out.println("Бинт универсальная вещь. Вы аккуратными движениями накладываете бинт. Группа признательна, что вы не пожалели бинт");
                                reputation = reputation + 1;
                            }
                            if (decisionResult == 2) {
                                System.out.println("В чем отличие бинта от ткани? По вашему мнению эти предметы эквиваленты. Не все в группе считают также, но вы настаиваете на своем. Команда вас осуждает");
                                reputation = reputation - 1;
                            }
                            System.out.println("После этого вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                            System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до того как на " + myAllNeighbours.get(1) + "а упал кирпич " + myAllNeighbours.get(0) + "нашел кое-что в своем коридоре");
                            System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1) или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2). У вас до сих пор есть фонарик." + ANSI_RESET);

                            int decision1Result = Utils.getNum(1, 2);

                            //вести разведку вдвоем
                            if (decision1Result == 1) {
                                Utils.showTextPart1();
                                resultOfDay1 = 5;
                                Utils.stopGameWin();
                            }
                            //вести разведку втроем, но на следующий день
                            if (decisionResult == 2) {
                                System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                                System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                                BunkerItems.showInventory();
                                System.out.println(" ");
                                System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                                resultOfDay1 = 6;
                                Utils.stopGameWin();
                            }
                        }
                    }

                    if (BunkerItems.inventoryCheckerNot("Бутылка воды") && BunkerItems.inventoryCheckerNot("Бинт")) {
                        System.out.println("Все что вы можете предложить ранненому это слабую перевязку из ткани, больше вам нечем ему помочь.");
                        System.out.println("В этом бункере выжить невозможно: тут нет ни воды, ни бинтов.");
                        System.out.println(ANSI_BLUE + "Стоит ли об этом говорить остальным? (1) - да   (2) - нет" + ANSI_RESET);

                        int decisionResult = Utils.getNum(1, 2);
                        if (decisionResult == 1) {
                            System.out.println("Команда в шоке. Вы чувствуете нарастающую панику. Нужно собраться с духом и продолжить выживание, тем более половина комнат еще не разведована.");
                            reputation = reputation - 2;
                        }
                        if (decisionResult == 2) {
                            System.out.println("Уж лучше команда думает, что вы жмот, чем осознает, что шансы на выживание малы...");
                            reputation = reputation - 1;
                        }
                        System.out.println("Надо бороться дальше.");
                        System.out.println("Вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                        System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что до того как на " + myAllNeighbours.get(1) + "а упал кирпич " + myAllNeighbours.get(0) + " нашел кое-что интересное в своем коридоре");
                        System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1) или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2). У вас до сих пор есть фонарик." + ANSI_RESET);

                        int decision1Result = Utils.getNum(1, 2);

                        //вести разведку вдвоем
                        if (decision1Result == 1) {
                            Utils.showTextPart1();
                            resultOfDay1 = 7;
                            Utils.stopGameWin();
                        }
                        //вести разведку втроем, но на следующий день
                        if (decisionResult == 2) {
                            System.out.println("Ваше решение закон для команды, остаток дня вы желаете просто поспать, слишком сложный получился день, возможно, что следующий день принесет что-то новое.");
                            System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                            BunkerItems.showInventory();
                            System.out.println(" ");
                            System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                            resultOfDay1 = 8;
                            Utils.stopGameWin();
                        }
                    }
                }
                //КТО ТО НАСТУПИТ НА ГВОЗДЬ
                if ((chanceThatSomebodyDie > 47) && (chanceThatSomebodyDie <= 80)) {
                    System.out.println("Вы заглядываете в коридор и видите, что " + myAllNeighbours.get(0) + " лежит на полу.");
                    System.out.println("К вам прибегает ваш второй сосед, вместе вы бежите к раненному.");
                    System.out.println("Подойдя поближе вы видите, что он живой и пытается встать.");
                    System.out.println("По своей невнимательности ваш товарищ наступил на огромный ржавый гвоздь. От такого гвоздя ни одна подошва не спасет?");
                    System.out.println("Вы берете его под руки и тащите в главную комнату. Понимаете, что кровотечение не такое сильное.");
                    System.out.println("возможно, вы сможете ему чем-то помочь, нужно проверить припасы");
                    System.out.println("Вы начинаете открывать шкафы в поисках чего-то, что может помочь вашему товарищу.");

                    if (BunkerItems.inventoryChecker("Бинт") && BunkerItems.inventoryChecker("Бутылка воды")) {
                        System.out.println("Вы нашли все необходимое для его лечения: чистую воду и бинт, но вам нужно решить стоит ли их тратить");
                        System.out.println(ANSI_BLUE + "Потратить бинт и воду (1); потратить только бинт (2); потратить только воду (3); ничего не тратить (4)" + ANSI_RESET);

                        int decisionResult = Utils.getNum(1, 4);
                        if (decisionResult == 1) {
                            BunkerItems.inventoryRemover("Бутылка воды");
                            BunkerItems.inventoryRemover("Бинт");
                            System.out.println("Вы обрабатываете его рану водой, аккуратно удаляете пыль и прочую грязь, перематываете рану бинтов.");
                            System.out.println("По вашему мнению воды и бинтов еще много. Команда вам очень признательна");
                            System.out.println("Будем надеяться, что дня на восстановление ему хватит. Заражения крови быть не должно");
                            reputation = reputation + 2;
                        }
                        if (decisionResult == 2) {
                            BunkerItems.inventoryRemover("Бинт");
                            System.out.println("По вашему лидерскому мнению команда испытывает дефецит воды, потому вы разрешаете использовать только одну упаковку бинта");
                            System.out.println("Вы перематываете пятку раненного. Пыль и прочий мусор не были удалены должным образом. ");
                            System.out.println(myAllNeighbours.get(0) + " издает ужасный вой. Команда вами разочарована");
                            System.out.println("По мнению команды, вода была бы немного полезней в данной ситуации нежели бинт.");
                            reputation = reputation - 2;
                        }
                        if (decisionResult == 3) {
                            BunkerItems.inventoryRemover("Бутылка воды");
                            System.out.println("В таких ситуациях главное не допустить заражение крови, вы аккуратно проливаете рану водой, удаляя лишнюю пыль, позже вы прикрываете рану куском футболки.");
                            System.out.println("Команда рада, но тем не менее не довольна вашей жадностью. Команда вас немного осуждает");
                            reputation = reputation - 1;
                        }
                        if (decisionResult == 4) {
                            System.out.println("Ресурсы не могут быть потрачены просто так, это всего лишь небольшая дырка в пятке, ну и что, что это был ржавый гвоздь в старом бункере, до свадьбы заживет.");
                            System.out.println("Вы перевязываете рану куском футболки и оставляете его отдыхать. Команда критически расстроена вашим действиями.");
                            reputation = reputation - 3;
                        }

                        System.out.println("Вы оставляете ранненого отдыхать на кресле");
                        System.out.println("Вам надо сделать выбор, чем заниматься далее:");
                        System.out.println(ANSI_BLUE + "Пойти исследовать правый коридор (1); пойти исследовать левый коридор (2)." + ANSI_RESET);

                        int decision1Result = Utils.getNum(1, 3);
                        //левый коридор или правый коридор
                        if (decision1Result == 1 || decision1Result == 2) {
                            System.out.println("Выбор сделан, вы пойдете вдвоем. В фонаре еще остался заряд, но это не значит, что опастность минует");
                            System.out.println("Вы аккуратно заходите в коридор, держась максимально близко друг к другу. Где-то вдали вы видите нечто похожее на рубильник. Аккуратно идете в его сторону");
                            System.out.println(ANSI_BLUE + "Хотите ли вы его дернуть его? Да - (1); Нет - (2)" + ANSI_RESET);

                            int decision2Result = Utils.getNum(1, 2);
                            //дернуть рубильник
                            if (decision2Result == 1) {
                                double chanceThatSomethingHappen = Math.random() * 100;
                                double badVariant = Math.random() * 100;
                                reputation = reputation + 1;
                                System.out.println("Была ни была. Команда будет восхищена вашей храбростью. Вы дергаете рычаг иии...");

                                if (chanceThatSomethingHappen % 3 != 0 && chanceThatSomethingHappen % 5 != 0) {
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
                                        resultOfDay1 = 9;
                                        Utils.stopGameWin();
                                    }
                                    if (badVariant > 50 && badVariant < 70) {
                                        System.out.println("Проходит минута. Вы уже думаете, что ничего не произойдет, но вдруг в одной из комнат дальше по коридору включается свет");
                                        System.out.println("Без задней м1ысли вы идете на свет. Почему свет загорелся только в одной комнате остается загадкой.");
                                        System.out.println("Аккуратно заглянув туда вы обнаруживаете, что комната набита каким-то огромными зелеными жуками");
                                        System.out.println("Они на вас нападают, вы пытаесь отбиться. Их целая туча, от них уже невозможно сбежать, к сожалению, ваша группа оказалась мертва.");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        Utils.stopGameLost();
                                        resultOfDay1 = 10;
                                    }
                                    else {
                                        System.out.println("Моментально включается свет во всем бункере; вы понимаете по крику своего раненного товарища, что кто-то включил свет.");
                                        System.out.println("Начинает орать сирена, а спустя полминуты - зацикленное сообщение: ");
                                        System.out.println(ANSI_RED + " \" Мы вас нашли, готовьтесь' 'Мы вас нашли, готовьтесь' 'Мы вас нашли, готовьтесь \"" + ANSI_RESET);
                                        System.out.println("Вы слышите какой-то жуткий звук, похожий на стук во входную дверь. Бежите в главную комнату.");
                                        System.out.println(ANSI_BLUE + "**Пару минут спустя**" + ANSI_RESET);
                                        System.out.println("Ваш товарищ мертв, а рядом с ним стоит целый отряд из рейдеров-мародеров.");
                                        System.out.println(" \" Мы вас нашли, а вы не подготовились \" - сказал их лидер, направил на вас пистолет и выстрелил");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        resultOfDay1 = 11;
                                        Utils.stopGameLost();
                                    }
                                }
                                if (chanceThatSomethingHappen % 3 == 0) {
                                    System.out.println("Проходит пару секунд. Проходит минута. Ничего не происходит. Возможно что-то включилось в другом месте.");
                                    System.out.println("В течении нескольких часов вы бродите по бункеру и не замечаете никаких изменений. Усталось дает о себе");
                                    System.out.println("Вы возвращаетесь в главную комнату, проверяете самочувствие раненного, а заодно припасы");
                                    BunkerItems.showInventory();
                                    System.out.println("Садитесь в кресло и засыпаете, к сожалению день прошел не так радостно, как хотелось бы");
                                    System.out.println(ANSI_GREEN + "День 1 пройден!" + ANSI_RESET);
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
                                        resultOfDay1 = 12;
                                        stopGameLost();
                                    }
                                    if (badVariant % 7 == 0) {
                                        System.out.println("В этой огромной современной комнате сидит группа людей в деловый костюмах. Вы успеваете заметить, что все это время за вами кто-то следил.");
                                        System.out.println("Невозможно объяснить как так получилось. Вы проходите чуть дальше.");
                                        System.out.println("Люди продолжают смотреть в монитор. Вы проходите еще дальше. Центральный смотрящий разворачивается на кресле.");
                                        System.out.println("В нем вы узнаете популярного политика, которого часто крутили по ТВ");
                                        System.out.println("Он встает со своего места, дергает другого человека за плечо, а тот наводит на вас пистолет и стреляет.");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        resultOfDay1 = 13;
                                        stopGameLost();
                                    }
                                    if (badVariant > 50 && badVariant % 2 != 0 && badVariant % 5 != 0) {
                                        System.out.println("Из двери идет пар, как в фильмах про космос. Вы заходите в нее. Внутри комнаты сидят непонятные человекоподобные существа.");
                                        System.out.println("Вы ловите их взгляд и чувствуете, как ваше тело превращается в жижу.");
                                        System.out.println("Вы смотрите на свои руки и видите, что они буквально текут на пол. Спустя полминуты вы умираете. ");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        resultOfDay1 = 14;
                                        stopGameLost();
                                    } else {
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
                                        resultOfDay1 = 15;
                                        Utils.stopGameWin();
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
                                resultOfDay1 = 16;
                                Utils.stopGameWin();
                            }
                        }
                    }
                    if (BunkerItems.inventoryChecker("Бинт") || BunkerItems.inventoryChecker("Бутылка воды")) {
                        if (BunkerItems.inventoryChecker("Бинт")) {
                            System.out.println("Все что у вас есть для оказания помощи - только бинт.");
                            System.out.println("Потратить его (1) или нет (2)?");
                            int decision = Utils.getNum(1, 2);
                            if (decision == 1) {
                                System.out.println("Вы аккуратно перевязываете ногу раннего бинтом, предварительно сдув пылинки мусора и протирев рану рукой. ");
                                System.out.println("Вы надеетесь, что это должно помочь");
                                System.out.println("Команда рада, что вы согласились ему помочь.");
                                reputation = reputation + 1;
                            }
                            if (decision == 2) {
                                System.out.println("Количество медикаментов ограничено, стоит поэкономить. Вы решаете помочь ему подручными средствами.");
                                System.out.println("Вы аккуратно перевязываете ногу раннего его же футболкой, предварительно сдув пылинки мусора и протирев рану рукой. ");
                                System.out.println("Вы надеетесь, что это должно помочь. Команда немного осуждает ваше решение.");
                                reputation = reputation - 1;
                            }
                        } else {
                            System.out.println("Все что у вас есть для оказания помощи - только бутылка воды.");
                            System.out.println(ANSI_BLUE + "Потратить ее (1) или нет (2)?" + ANSI_RESET);
                            int decision = Utils.getNum(1, 2);
                            if (decision == 1) {
                                System.out.println("Вы аккуратно промываете ногу раннего бинтом, после чего перевязываете травму его футболкой.");
                                System.out.println("Вы надеетесь, что это должно помочь.");
                                System.out.println("Команда рада, что вы согласились ему помочь.");
                                reputation = reputation + 1;
                            }
                            if (decision == 2) {
                                System.out.println("Количество воды ограничено, стоит поэкономить. Вы решаете помочь ему подручными средствами");
                                System.out.println("Вы аккуратно перевязываете ногу раннего его же футболкой, предварительно сдув пылинки мусора и протирев рану рукой. ");
                                System.out.println("Вы надеетесь, что это должно помочь. Команда немного осуждает ваше решение");
                                reputation = reputation - 1;
                            }
                        }
                        Utils.showTextPart2();
                    }
                }

                //КОГО-ТО ЗАКГРЫЗУТ ТАРАКАНЫ И ОН УМРЕТ
                if (chanceThatSomebodyDie > 80) { //
                    System.out.println("Вы слышите страшные вои, визги, крики. Человек из левого коридора прибегает к вам и вы вместе идете в правый коридор.");
                    System.out.println("Шум унялся. В дали вы видите тусклое пламя свечи и ускоряете свой шаг.");
                    System.out.println("Вам кажется, что кто-то издает звуки, похожие на стрекот.");
                    System.out.println(ANSI_BLUE + "Побежать помогать своему товарищу (1), вернуться к главную комнату, попробовать найти оружие и вернуться (2)" + ANSI_RESET);

                    int decision1Result = Utils.getNum(1, 2);

                    //ВЫ БУДЕТЕ РАЗВЕДОВАТЬ ТЕРРИТОРИЮ С ЖУКАМИ БЕЗ ОРУЖИЯ
                    if (decision1Result == 2) {
                        System.out.println("Вы тихо подходите к свече и видете лужу крови, гадая, кто это мог быть: мародеры, монстры или наркоманы, которые живут здесь уже 20 лет.");
                        System.out.println("Там есть комната, кажется, что именно оттуда идет странный стрекот. Решаете туда заглянуть.");
                        System.out.println("Там вы видите рой огромных тараканов, которые уже доедают труп вашего бывшего соседа.");
                        System.out.println("По своей глупости вы посветели фонариком прямо в их глаза...");
                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                        resultOfDay1 = 26;
                        Utils.stopGameLost();
                    }

                    //ВЫ БУДЕТЕ РАЗВЕДОВАТЬ ТЕРРИТОРИЮ, НО СПЕРВА ПОИЩЕТЕ ОРУЖИЕ
                    if (decision1Result == 1) {
                        String weapon = null;
                        if (BunkerItems.inventoryChecker("Пистолет макарова с патронами") ||
                                BunkerItems.inventoryChecker("Ржавый автомат Калашникова с патронами") ||
                                BunkerItems.inventoryChecker("Топор") || BunkerItems.inventoryChecker("Армейский нож") ||
                                BunkerItems.inventoryChecker("Кастет") || BunkerItems.inventoryChecker("Кухонный нож")) {
                            if (BunkerItems.inventoryChecker("Пистолет макарова с патронами"))
                                weapon = "Пистолет макарова с патронами";
                            if (BunkerItems.inventoryChecker("Ржавый автомат Калашникова с патронами"))
                                weapon = "Ржавый автомат Калашникова с патронами";
                            if (BunkerItems.inventoryChecker("Топор"))
                                weapon = "Топор";
                            if (BunkerItems.inventoryChecker("Армейский нож"))
                                weapon = "Армейский нож";
                            if (BunkerItems.inventoryChecker("Кастет"))
                                weapon = "Кастет";
                            if (BunkerItems.inventoryChecker("Кухонный нож"))
                                weapon = "Кухонный нож";

                            ArrayList<String> whatWasInClassroom = new ArrayList<>();
                            whatWasInClassroom.add("Шоколадное ассорти");
                            whatWasInClassroom.add("Хирургический набор");
                            whatWasInClassroom.add("Карта города");
                            whatWasInClassroom.add("Два набора раций");
                            BunkerItems.inventoryAdder("Шоколадное ассорти");
                            BunkerItems.inventoryAdder("Хирургический набор");
                            BunkerItems.inventoryAdder("Карта города");
                            BunkerItems.inventoryAdder("Два набора раций");

                            System.out.println("Вы решаете вернуться в главную комнату, взять что-то из оружия. Там вы находите " + weapon + ".");
                            System.out.println("Вы бредете через этот темный коридор, примерно находите комнату, из которой шел шум и начинается освещать ее фонариком.");
                            System.out.println("Вы видите, что в этой комнате сидит куча огромных тараканов, которые жадно додедают труп вашего, уже бывшего, соседа");
                            System.out.println("При виде света они накидываются на вас, вы отбиваете их атаку с помощью " + weapon + ". Перебив всех, вы аккуратно заходите в комнату.");
                            System.out.println("От " + myAllNeighbours.get(1) + "а практически ничего не осталось. Вы понимаете, что его уже не воскресить.");
                            System.out.println("Вы начинаете обыскивать комнату, оказывается, что это был какой-то учебный класс.");
                            System.out.println("Вы открываете все ящики и шкафы. Вот, что вы нашли: " + whatWasInClassroom + ". Вы забираете эти вещи с собой.");
                            System.out.println("Вы не знаете, откуда там появились эти жуки, поэтому по возвращении, вы решаетесь закрыть эту дверь до лучших времен.");
                            System.out.println(" \"Если бы была бы возможность восстановить электричество во всем бункере...\"");
                            System.out.println("Перед сном вы решили проверить свои запасы, ставите все ровным рядом на полу, возле входа и смотрите на них.");
                            System.out.println("К каждому предмету вы уже придумали применение.");
                            System.out.println("Итого, в вашем распоряжении имеются: ");
                            BunkerItems.showInventory();
                            System.out.println("Этот день был тяжелым, бег до бункера, попытка спасения товарища, бойня с тараканами. Откинувшись на стул, вы решаете, что пора бы поспать... ");
                            System.out.println(ANSI_GREEN + "День 1 пройден!" + ANSI_RESET);
                            resultOfDay1 = 27;
                            Utils.stopGameWin();
                        }

                        //ЕСЛИ НЕТ ОРУЖИЯ
                        if (BunkerItems.inventoryCheckerNot("Пистолет макарова с патронами") ||
                                BunkerItems.inventoryCheckerNot("Ржавый автомат Калашникова с патронами") ||
                                BunkerItems.inventoryCheckerNot("Топор") || BunkerItems.inventoryCheckerNot("Армейский нож") ||
                                BunkerItems.inventoryCheckerNot("Кастет") || BunkerItems.inventoryCheckerNot("Кухонный нож")) {
                            System.out.println("К сожалению, ничего, что могло бы помочь вам в самозащите, не нашлось.");
                            System.out.println(ANSI_BLUE + "Ваш сосед предлагает вам вариант замуровать эту дверь и забыть про " + myAllNeighbours.get(0) + " (1) или пойти посмотреть, что там произошло (2)" + ANSI_RESET);

                            //ПОЙТИ БЕЗ ОРУЖИЯ ИЛИ ЗАБИТЬ 1-ЗАБИТЬ  2-ПОЙТИ ПОМИРЕТЬ
                            int decision2Result = Utils.getNum(1, 2);
                            if (decision2Result == 1) {
                                System.out.println("Инстинкт самосохранения выше, чем желание помочь. \" Закрываем \" - говорите вы. " + myAllNeighbours.get(1) + " закрывает дверь. Вы садитесь за стол и понимаете, что вы в бункере всего полдня, а вы уже потеряли своего соседа. 'Чем нас меньше - тем нам сложнее...'");
                                System.out.println("Вы без понятия чем заниматься дальше. Не прошло и дня, как вы потеряли соседа.");
                                System.out.println("Надо немного отдохнуть, вы ложитесь в кресла в главной комнате, закрываете глаза и засыпаете.");
                                System.out.println("Проснулись вы оттого, что где-то в близи вы слышите знакомый стрекот, точно такой же как был в том коридоре.");
                                System.out.println("Вы открываете глаза, берете фонарик и идете в незакрытый коридор. Светите вдали и видите... Бегущую на вас толпу этих жуков.");
                                System.out.println("Видимо в той комнате была только маленькая часть от их роя. Вы отбегаете, будете соседа...");
                                System.out.println("Но прежде, чем вы закрыли дверь, почти сотня этих тварей успела забежать вам в комнату...");
                                System.out.println(ANSI_RED + "Игра окончена" + ANSI_RESET);
                                resultOfDay1 = 28;
                                Utils.stopGameLost();
                            }

                            if (decision2Result == 2) {
                                System.out.println("Несмотря на страх и возможность быть убитым, вы решаетесь идти в бой с тем, что есть.");
                                System.out.println("Вы проходите 5 метров, 10, 15. Вы видите комнату, из которой, как вам казалось, доносились возгласы.");
                                System.out.println("По своей невнимательности вы освещаете это помещение фонариком.");
                                System.out.println("Видете группу огромных тараканов, которые жадно доедают " + myAllNeighbours.get(0) + ".");
                                System.out.println("Они вас замечают и набрасываются. Ваша группа пытаетесь от них отбиться, но все тчетно...");
                                System.out.println(ANSI_RED + "Игра окончена" + ANSI_RESET);
                                resultOfDay1 = 29;
                                Utils.stopGameLost();
                            }
                        }
                    }
                }
            }
        }
    }
