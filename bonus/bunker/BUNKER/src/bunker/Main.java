package bunker;

//todo necessary:
// 1) свести все победные варианты, что команда ложится спать и чтобы все знали о радио
// 3) переделать первый день, разбив все это на методы
// 5) написать метод, отслеживающий здоровье раненного
// 8) переименовать все переменные на правильные варианты
// 12) проверить все на орфографию
// 14) рефакторинг методов
// 15) все повторяющиеся тексты вынести в отдельный класс
// 17) проверить все переменные на логику

//todo optional
// 1) доделать задержки перед сообщениями
// 3) сделать тесты (разработка через тестирование)
// 4) добавить больше экшена, вариаций в обоих днях
// 6) везде проставить точки в конце предложений
// 7) сделать биографии всех персонажей (через работу с файлами)
// 8) добавить больше оружия, персонажей и абилок
// 9) ввести систему очков, за каждое действие игрок получает очки, которые попадают в таблицу, сделать ввод никнейма (работа с файлами)
// 10) переписать сюжет, чтобы было не так искусствено
// 11) попробовать сделать exceptions, чтобы код не ломался, когда вместо цифры буква
// 12) доделать выход из игры (не крестик, а именно /exit)


import java.util.ArrayList;

public class Main extends SpecialFeatures {

    public static void main(String[] args) {

        Utils.showRules();
        Utils.gameStarter();
        CharactersChoice.makingGameCharacterList();
        CharactersChoice.choosingPlayerCharacter();
        CharactersChoice.choosingTheFirstNeighbour();
        CharactersChoice.choosingTheSecondNeighbour();
        BunkerItems.addRandomItemsToBunker();
        SpecialFeatures.characterExtraLootChecker();
        InventoryMethods.showInventory();

        //Цикл дней
        int day = 1;
        while (day <= 2) {

            //ДЕНЬ 1
            Utils.day(1, myAllNeighbours);

            //начало травм
            int chanceThatSomebodyDie = (int) (Math.random() * 100); //Шанс на тип ранения или смерть

            System.out.println("Спустя некоторое время вы слышите крик в правом коридоре. Вы бежите смотреть, что там произошло...");

                //КОГО ТО УДАРИТ КИРПИЧОМ
                if (chanceThatSomebodyDie <= 33) {
                    System.out.println("Вы забегаете в коридор и видите облако пыли. Прибегает ваш второй сосед, вместе вы идете в сторону облака.");
                    System.out.println("Где-то вдали стонет " + myAllNeighbours.get(0) + ".");
                    System.out.println("Подойдя поближе, замечаете, что он живой. Из его головы течет кровь - кусок потолка обвалился ему на голову. ");
                    System.out.println("Ничего серьезного, возможно, вам придется потратить некоторые медикаменты, если они есть.");
                    System.out.println("Вы берете его под руки и тащите в главную комнату.");
                    System.out.println("Кровотечение не сильное. Нужно проверить припасы");

                    if (InventoryMethods.inventoryChecker("Бутылка воды") && InventoryMethods.inventoryChecker("Бинт")) {
                        System.out.println("У вас есть все необходимое для оказания помощи, что вы хотите пожертвовать?");
                        System.out.println(ANSI_BLUE + "(1) - потратить воду и бинт; (2) - потратить только воду; (3) - потратить только бинт; (4) - ничего не тратить." + ANSI_RESET);

                        int decision= Utils.getNum(1, 4);

                        if (decision== 1) {
                            InventoryMethods.inventoryRemover("Бинт");
                            InventoryMethods.inventoryRemover("Бутылка воды");
                            System.out.println(" ");
                            System.out.println("Вы промываете рану, перевязываете его голову, кладете его на кресло и отдаете ему остаток бутылки воды.");
                            System.out.println("Вся комнада очень вам признательна.");
                            System.out.println("Вот что у вас осталось: ");
                            InventoryMethods.showInventory();
                            Utils.reputation(2);
                        }
                        if (decision == 2) {
                            InventoryMethods.inventoryRemover("Бутылка воды" );
                            System.out.println("Вы решаете, что травма не настолько серьезная, чтобы тратить на нее бинт. Вы перевязываете его голову куском ткани, промываете рану и отдаете остаток воды.");
                            System.out.println("Команда не настолько вам признательна, как могла бы быть");
                            System.out.println("Вот что у вас осталось: ");
                            InventoryMethods.showInventory();
                            Utils.reputation(1);
                        }
                        if (decision == 3) {
                            InventoryMethods.inventoryRemover("Бинт");
                            System.out.println("Вы решаете, что травма головы - вещь серьезная, но вы не верите, что вода может помочь.");
                            System.out.println("Вы накладываете бинт поверх раны и приказываете раненному отдыхать.");
                            System.out.println("Вот что у вас осталось: ");
                            InventoryMethods.showInventory();
                            Utils.reputation(1);
                        }
                        if (decision == 4) {
                            System.out.println("Вы оцениваете травму и приходите к выводу, что помощь ему не требуется.");
                            System.out.println("Вы перевязаваете ему голову лоскутом футболки и оставиляете отдыхать. Команда крайне вами недовольна ");
                            Utils.reputation(-2);
                        }

                        System.out.println("После этого вы решаете немного отдохнуть, ложитесь в кресло и засыпаете");
                        System.out.println(" ");
                        System.out.println("Через пару часов ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что он нашел кое-что в своем коридоре");
                        System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1); или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2)? У вас до сих пор есть фонарик." + ANSI_RESET);

                        int decision1 = Utils.getNum(1, 2);

                        //вести разведку вдвоем
                        if (decision1 == 1) {
                            Utils.showTextPart1();
                            Utils.setResultOfDay1(1);
                            Utils.stopGameWin();
                            day++;
                        }
                        if (decision1 == 2) {
                            System.out.println("Ваше решение закон. Остаток дня вы желаете проспать, сложный получился день, возможно, следующий день будет лучше.");
                            System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                            InventoryMethods.showInventory();
                            System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                            Utils.setResultOfDay1(2);
                            Utils.stopGameWin();
                            day++;
                        }
                    }

                    if (InventoryMethods.inventoryChecker("Бутылка воды") || InventoryMethods.inventoryChecker("Бинт")) {
                        if (InventoryMethods.inventoryChecker("Бутылка воды")) {
                            System.out.println("Вы понимаете, долго вам не протянуть - у вас с собой нет даже бинта. Вы перевязываете голову ранненого футболкой.");
                            System.out.println(ANSI_BLUE + "Перед вам стоит выбор: оставить ему бутылку воды на день (1); или лучше поэкономить (2)" + ANSI_RESET);

                            int decision= Utils.getNum(1, 2);
                            if (decision == 1) {
                                System.out.println("На здоровье не экономят, вы слышали, что большое количество воды способствует заживлению травм. Команда вам признательна.");
                                Utils.reputation(1);
                            }
                            if (decision == 2) {
                                System.out.println("Травма не такая сильная, она сможет зажить самостоятельно. Группа не совсем поддерживает ваше решение");
                                Utils.reputation(-1);
                            }
                            System.out.println("После этого вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                            System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что он нашел кое-что в своем коридоре");
                            System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1) или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2)? У вас до сих пор есть фонарик." + ANSI_RESET);

                            int decision1 = Utils.getNum(1, 2);

                            //вести разведку вдвоем
                            if (decision1 == 1) {
                                Utils.showTextPart1();
                                Utils.setResultOfDay1(3);
                                Utils.stopGameWin();
                                day++;
                            }
                            //вести разведку втроем, но на следующий день
                            if (decision1 == 2) {
                                System.out.println("Ваше решение закон. Остаток дня вы желаете проспать, сложный получился день, следующий должен быть лучше.");
                                System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                                InventoryMethods.showInventory();
                                System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                                Utils.setResultOfDay1(4);
                                Utils.stopGameWin();
                                day++;
                            }
                        }

                        if (InventoryMethods.inventoryChecker("Бинт")) {
                            System.out.println("Неужели в бункере совсем нет воды?! Осознание, что без воды вы не протянете заставляет вас задуматься о дальнейших действия группы, но сперва нужно помочь товарищу!");
                            System.out.println(ANSI_BLUE + "Потратить целый бинт (1) или лучше поэкономить (2)?" + ANSI_RESET);

                            int decision = Utils.getNum(1, 2);
                            if (decision == 1) {
                                System.out.println("Вы аккуратными движениями накладываете бинт. Группа признательна.");
                                Utils.reputation(1);
                            }
                            if (decision == 2) {
                                System.out.println("В чем отличие бинта от ткани? По вашему мнению эти предметы эквиваленты. Команда вас осуждает");
                                Utils.reputation(-1);
                            }
                            System.out.println("После этого вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                            System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что он нашел кое-что в своем коридоре");
                            System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1) или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2)? У вас до сих пор есть фонарик." + ANSI_RESET);

                            int decision1 = Utils.getNum(1, 2);

                            if (decision1 == 1) {
                                Utils.showTextPart1();
                                Utils.setResultOfDay1(5);
                                Utils.stopGameWin();
                                day++;
                            }
                            if (decision1 == 2) {
                                System.out.println("Ваше решение закон. Остаток дня вы желаете проспать, сложный получился день, следующий день принесет что-то новое.");
                                System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                                InventoryMethods.showInventory();
                                System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                                Utils.setResultOfDay1(6);
                                Utils.stopGameWin();
                                day++;
                            }
                        }
                    }

                    if (InventoryMethods.inventoryCheckerNot("Бутылка воды") && InventoryMethods.inventoryCheckerNot("Бинт")) {
                        System.out.println("Все что вы можете предложить ранненому это слабую перевязку из ткани, больше вам нечем ему помочь.");
                        System.out.println("Здесь выжить невозможно: тут нет ни воды, ни бинтов.");
                        System.out.println(ANSI_BLUE + "Стоит ли об этом говорить остальным? (1) - да  (2) - нет" + ANSI_RESET);

                        int decision = Utils.getNum(1, 2);
                        if (decision == 1) {
                            System.out.println("Команда в шоке. Вы чувствуете нарастающую панику. Нужно продолжать выживание, ведь половина комнат еще не разведована.");
                            Utils.reputation(-2);
                        }
                        if (decision == 2) {
                            System.out.println("Пусть лучше команда думает, что вы жмот, чем осознает, что шансы на выживание малы...");
                            Utils.reputation(-1);
                        }
                        System.out.println("Вы решаете немного отдохнуть, ложитесь на кресло и засыпаете");
                        System.out.println("Через пару часов сна ваш второй сосед приходит к вам с хорошей новостью. Оказывается, что он нашел кое-что интересное в своем коридоре");
                        System.out.println(ANSI_BLUE + "Пойти исследовать этот коридор вдвоем (1) или подождать пока " + myAllNeighbours.get(0) + "у полегчает (2)? У вас до сих пор есть фонарик." + ANSI_RESET);
                        int decision1 = Utils.getNum(1, 2);
                        if (decision1 == 1) {
                            Utils.showTextPart1();
                            Utils.setResultOfDay1(7);
                            Utils.stopGameWin();
                            day++;
                        }
                        if (decision1 == 2) {
                            System.out.println("Ваше решение закон. Остаток дня вы желаете проспать, слишком сложный получился день, следующий день принесет что-то новое.");
                            System.out.println("Вы в очередной раз осматриваете провиант, садитесь на кресло и засыпаете.");
                            InventoryMethods.showInventory();
                            System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                            Utils.setResultOfDay1(8);
                            Utils.stopGameWin();
                            day++;
                        }
                    }
                }
                //КТО ТО НАСТУПИТ НА ГВОЗДЬ
                if ((chanceThatSomebodyDie > 33) && (chanceThatSomebodyDie <= 66)) {
                    System.out.println("Вы заглядываете в коридор и видите, что " + myAllNeighbours.get(0) + " лежит на полу.");
                    System.out.println("К вам прибегает ваш второй сосед, вместе вы бежите к раненному.");
                    System.out.println("Вы видите, что он живой и пытается встать.");
                    System.out.println("По своей невнимательности ваш товарищ наступил на огромный ржавый гвоздь. От такого гвоздя ни одна подошва не спасет.");
                    System.out.println("Вы берете его под руки и тащите в главную комнату. Понимаете, что кровотечение не сильное.");
                    System.out.println("Возможно, вы сможете ему чем-то помочь, нужно проверить припасы");
                    System.out.println("Вы начинаете открывать шкафы в поисках того, что может помочь вашему товарищу.");

                    if (InventoryMethods.inventoryChecker("Бинт") && InventoryMethods.inventoryChecker("Бутылка воды")) {
                        System.out.println("Вы нашли все необходимое для его лечения: чистую воду и бинт, но вам нужно решить стоит ли их тратить");
                        System.out.println(ANSI_BLUE + "Потратить бинт и воду (1); потратить только бинт (2); потратить только воду (3); ничего не тратить (4)" + ANSI_RESET);

                        int decision = Utils.getNum(1, 4);
                        if (decision == 1) {
                            InventoryMethods.inventoryRemover("Бутылка воды");
                            InventoryMethods.inventoryRemover("Бинт");
                            System.out.println("Вы обрабатываете рану водой, удаляете пыль и грязь, перемвязываете рану бинтом.");
                            System.out.println("Воды и бинтов еще хватит. Команда вам очень признательна");
                            System.out.println("Будем надеяться, что дня на восстановление ему хватит. Заражения крови быть не должно");
                            Utils.reputation(2);
                        }
                        if (decision == 2) {
                            InventoryMethods.inventoryRemover("Бинт");
                            System.out.println("По вашему мнению команда испытывает дефицит воды, потому вы используете только бинт");
                            System.out.println("Вы перематываете ногу раненного. Команда вами разочарована.");
                            System.out.println("По мнению команды, вода была бы немного полезней в данной ситуации нежели бинт.");
                            Utils.reputation(-2);
                        }
                        if (decision == 3) {
                            InventoryMethods.inventoryRemover("Бутылка воды");
                            System.out.println("Главное не допустить заражение крови. Вы проливаете рану водой, удаляя лишнюю пыль, позже прикрываете рану куском ткани.");
                            System.out.println("Команда рада, но тем не менее не довольна вашей жадностью. Команда вас немного осуждает");
                            Utils.reputation(-1);
                        }
                        if (decision == 4) {
                            System.out.println("Ресурсы не могут быть потрачены просто так, это всего лишь небольшая дырка в пятке, до свадьбы заживет.");
                            System.out.println("Команда критически расстроена вашим действиями.");
                            Utils.reputation(-3);
                        }

                        System.out.println("Вы оставляете ранненого отдыхать на кресле");
                        System.out.println("Вам надо сделать выбор, чем заниматься далее:");
                        System.out.println(ANSI_BLUE + "Пойти исследовать правый коридор (1); пойти исследовать левый коридор (2)." + ANSI_RESET);

                        int decision1 = Utils.getNum(1, 3);
                        if (decision1 == 1 || decision1 == 2) {
                            System.out.println("Выбор сделан. В фонаре еще остался заряд, но это не значит, что опастность минует");
                            System.out.println("Вы заходите в коридор, держась максимально близко друг к другу. Вдали вы видите нечто похожее на рубильник. Аккуратно идете в его сторону");
                            System.out.println(ANSI_BLUE + "Хотите ли вы дернуть его? Да - (1); Нет - (2)" + ANSI_RESET);

                            int decision2 = Utils.getNum(1, 2);
                            if (decision2 == 1) {

                                int chanceThatSomethingHappen = (int) (Math.random() * 100);
                                int badVariant = (int) (Math.random() * 100);

                                Utils.reputation(1);
                                System.out.println("Команда будет восхищена вашей храбростью. Вы дергаете рычаг иии...");
                                if (chanceThatSomethingHappen <= 33) {
                                    if (badVariant <= 20) {
                                        System.out.println("Проходит минута. Вы думаете, что ничего не произойдет, но вдруг в одной из комнат дальше по коридору включается свет");
                                        System.out.println("Вы уверенно идете на свет. Почему свет загорелся только в одной комнате остается загадкой.");
                                        System.out.println("Аккуратно заглянув туда вы обнаруживаете, что в комнате есть всего пару шкафов и стенд с противогазом");
                                        InventoryMethods.inventoryAdder("Противогаз");
                                        InventoryMethods.inventoryAdder("Автомат калашникова с патронами");
                                        InventoryMethods.inventoryAdder("Радио");
                                        System.out.println("Вы это забираете. Возвращаетесь в главную комнату, проверяете здоровье раненного товарища и начинаете разбирать находки.");
                                        System.out.println("Одной из находок было современное радио, работающее от батареек. Долго пытаетсь найти волну и вот наконец-то успех!");
                                        System.out.println("По этой волне вы слышите сообщение: ");
                                        System.out.println(ANSI_RED + " \" Джони, я нашел их! Джони, наша разработка сработала! Але-але, вы нас слышите? Мы знаем где вы находитесь! \"");
                                        System.out.println(" \" Через сутки мы будем у вас, готовьте все свои припасы, оружие и остальное!!! \"" + ANSI_RESET);
                                        System.out.println("На этом моменте сообщение обрывается. Вами было принято решение переехать в комнату, которую только что нашли, закрыть в ней дверь и переночевать");
                                        InventoryMethods.showInventory();
                                        System.out.println(ANSI_GREEN + "День 1 пройден!" + ANSI_RESET);
                                        Utils.setResultOfDay1(9);
                                        Utils.stopGameWin();
                                        day++;
                                    }
                                    if (badVariant > 20 && badVariant <= 40) {
                                        System.out.println("Проходит минута. Вы уже думаете, что ничего не произойдет, но вдруг в одной из комнат дальше по коридору включается свет");
                                        System.out.println("Без задней мысли вы идете на свет. Почему свет загорелся только в одной комнате остается загадкой.");
                                        System.out.println("Аккуратно заглянув туда вы обнаруживаете, что комната набита каким-то огромными зелеными жуками");
                                        System.out.println("Они на вас нападают, вы пытаесь отбиться, от них уже невозможно сбежать. К сожалению, ваша группа оказалась мертва.");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        Utils.setResultOfDay1(10);
                                        Utils.stopGameLost();
                                        day++;
                                    }
                                    if (badVariant > 40 && badVariant <= 60){
                                        System.out.println("Моментально включается свет во всем бункере; вы понимаете по крику своего раненного товарища.");
                                        System.out.println("Начинает орать сирена, а спустя полминуты - зацикленное сообщение: ");
                                        System.out.println(ANSI_RED + " \" Мы вас нашли, готовьтесь; Мы вас нашли, готовьтесь; Мы вас нашли, готовьтесь \"" + ANSI_RESET);
                                        System.out.println("Вы слышите какой-то жуткий звук, похожий на стук во входную дверь. Бежите в главную комнату.");
                                        System.out.println("Спустя 20 секунд вы прибегаете в главную комнату");
                                        System.out.println("Ваш товарищ мертв, а рядом с ним стоит целый отряд из рейдеров-мародеров.");
                                        System.out.println(" \" Мы вас нашли, а вы не подготовились \" - сказал их лидер, направил на вас пистолет и выстрелил");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        Utils.setResultOfDay1(11);
                                        Utils.stopGameLost();
                                        day++;
                                    }
                                }
                                if (chanceThatSomethingHappen > 33 && chanceThatSomethingHappen <= 66) {
                                    System.out.println("Проходит минута. Ничего не происходит. Возможно что-то включилось в другом месте.");
                                    System.out.println("В течении нескольких часов вы бродите по бункеру и не замечаете никаких изменений. Усталось дает о себе");
                                    System.out.println("Вы возвращаетесь в главную комнату, проверяете самочувствие раненного, а заодно припасы");
                                    InventoryMethods.showInventory();
                                    System.out.println("Садитесь в кресло и засыпаете, к сожалению день прошел не так радостно, как хотелось бы.");
                                    System.out.println(ANSI_GREEN + "День 1 пройден!" + ANSI_RESET);
                                    Utils.stopGameWin();
                                }
                                else {
                                    System.out.println("Через пару секунд вы слышите звук открывающейся двери. Звук относится откуда-то спереди. Без лишних раздумий вы идете туда. ");
                                    System.out.println(myAllNeighbours.get(1) + " пытается вас остановить, но вы устремлены к двери.");
                                    System.out.println("Это безрассудство портит вашу репутацию!");
                                    Utils.reputation(-1);
                                    System.out.println("Вы подходите к двери, ее толчища вас поражает, заглядываете туда.");
                                    if (badVariant > 50 && badVariant <= 80) {
                                        System.out.println("В этой огромной современной комнате сидит группа людей. Вы успеваете заметить, что все это время за вами кто-то следил.");
                                        System.out.println("Невозможно объяснить как так получилось. Вы проходите чуть дальше.");
                                        System.out.println("Лидер комнаты встает со своего места, наводит на вас пистолет и стреляет.");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        Utils.setResultOfDay1(12);
                                        Utils.stopGameLost();
                                        day++;
                                    }
                                    if (badVariant > 80){
                                        System.out.println("В этой современной комнате сидит группа людей в деловый костюмах. Вы успеваете заметить, что все это время за вами следили.");
                                        System.out.println("Невозможно объяснить как так получилось. Вы проходите чуть дальше.");
                                        System.out.println("Люди продолжают смотреть в монитор. Вы проходите еще дальше. Центральный смотрящий разворачивается на кресле.");
                                        System.out.println("В нем вы узнаете популярного политика, которого часто крутили по ТВ");
                                        System.out.println("Он встает со своего места, толкает другого человека за плечо, а тот наводит на вас пистолет и стреляет.");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        Utils.setResultOfDay1(13);
                                        Utils.stopGameLost();
                                        day++;
                                    }
                                    if (badVariant % 3 == 0 && badVariant % 5 == 0 && badVariant % 2 != 0) {
                                        System.out.println("Из двери идет пар, как в фильмах про космос. Вы заходите в нее. Внутри комнаты сидят непонятные человекоподобные существа.");
                                        System.out.println("Вы ловите их взгляд и чувствуете, как ваше тело превращается в жижу.");
                                        System.out.println("Вы смотрите на свои руки и видите, что они буквально текут на пол. Спустя полминуты вы умираете. ");
                                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                                        Utils.setResultOfDay1(14);
                                        Utils.stopGameLost();
                                    }
                                    else {
                                        System.out.println("Вы заходи вовнутрь. Там вы видите старый заброшенный командный пункт. Видимо этот бункер строился во времена холодной войны.");
                                        System.out.println("Вы обыскиваете эту комнату и находите немного ценностей: противогаз, аптечку с истекшим сроком годности и пистолет макарова с двумя обоймами.");
                                        InventoryMethods.inventoryAdder("Противогаз");
                                        InventoryMethods.inventoryAdder("Аптечка");
                                        InventoryMethods.inventoryAdder("Пистолет макарова с патронами");
                                        System.out.println("Вы забираете их и несете их в главную комнату");
                                        System.out.println("День подходит к концу, хотя вы не знаете этого наверняка, но биологические часы говорят вам, что пора спать.");
                                        System.out.println("Перед сном вы проверяете инвентарь, проверяете состояние раненного товарища и ложитесь спать");
                                        InventoryMethods.showInventory();
                                        System.out.println(ANSI_GREEN + "День 1 пройден" + ANSI_RESET);
                                        Utils.setResultOfDay1(15);
                                        Utils.stopGameWin();
                                    }
                                }
                                day++;
                            }
                            // не дернуть рычаг
                            if (decision2 == 2) {
                                System.out.println("Никто не знает, что этот рубильник включает, может быть он лишит нас кислорода или откроет входную дверь.");
                                System.out.println("Вы не решаетесь воспользоваться шансом. " + myAllNeighbours.get(1) + " слегка разочарован вашей трусостью.");
                                Utils.reputation(-1);
                                System.out.println("Остаток дня вы не знаете чем себя занять. Вы проверяете состояние раненного, ложитесь на кресло и думаете, что же с вами будет дальше");
                                System.out.println("Примерно так вы и закончили ваш день, предварительно проверив свои запасы");
                                InventoryMethods.showInventory();
                                System.out.println(ANSI_GREEN + "День 1 пройден!!!" + ANSI_RESET);
                                Utils.setResultOfDay1(16);
                                Utils.stopGameWin();
                                day++;
                            }
                        }
                    }
                    if (InventoryMethods.inventoryChecker("Бинт") || InventoryMethods.inventoryChecker("Бутылка воды")) {
                        if (InventoryMethods.inventoryChecker("Бинт")) {
                            System.out.println("Все что у вас есть для оказания помощи - только бинт.");
                            System.out.println("Потратить его да (1) или нет (2)?");
                            int decision = Utils.getNum(1, 2);
                            if (decision == 1) {
                                System.out.println("Вы аккуратно перевязываете ногу раннего бинтом, предварительно сдув пылинки мусора и протерев рану рукой. ");
                                System.out.println("Вы надеетесь, что это должно помочь");
                                System.out.println("Команда рада, что вы согласились ему помочь.");
                                Utils.reputation(1);
                            }
                            if (decision == 2) {
                                System.out.println("Количество медикаментов ограничено, стоит поэкономить. Вы решаете помочь ему подручными средствами.");
                                System.out.println("Вы аккуратно перевязываете ногу раннего его же футболкой, предварительно сдув пылинки мусора и протирев рану рукой. ");
                                System.out.println("Вы надеетесь, что это должно помочь. Команда немного осуждает ваше решение.");
                                Utils.reputation(-1);
                            }
                        }
                        else {
                            System.out.println("Все что у вас есть для оказания помощи - только бутылка воды.");
                            System.out.println(ANSI_BLUE + "Потратить ее да (1) или нет (2)?" + ANSI_RESET);
                            int decision = Utils.getNum(1, 2);
                            if (decision == 1) {
                                System.out.println("Вы аккуратно промываете ногу раннего водой, после чего перевязываете травму тканью.");
                                System.out.println("Вы надеетесь, что это должно помочь.");
                                System.out.println("Команда рада, что вы согласились ему помочь.");
                                Utils.reputation(1);
                            }
                            if (decision == 2) {
                                System.out.println("Количество воды ограничено, стоит поэкономить. Вы решаете помочь ему подручными средствами");
                                System.out.println("Вы аккуратно перевязываете ногу раннего его футболкой, предварительно сдув пылинки. ");
                                System.out.println("Вы надеетесь, что это должно помочь. Команда немного осуждает ваше решение");
                                Utils.reputation(-1);
                            }
                        }
                        Utils.showTextPart2();
                    }
                }
                //КОГО-ТО ЗАКГРЫЗУТ ТАРАКАНЫ И ОН УМРЕТ
                else {
                    System.out.println("Вы слышите страшные вои, визги, крики. Другой ваш прибегает к вам и вы вместе идете в правый коридор.");
                    System.out.println("Шум унялся. Вдали вы видите тусклое пламя свечи и ускоряете свой шаг.");
                    System.out.println("Вам кажется, что кто-то издает звуки, похожие на стрекот.");
                    System.out.println(ANSI_BLUE + "Побежать помогать своему товарищу (1); вернуться в главную комнату, попробовать найти оружие и вернуться (2)" + ANSI_RESET);
                    int decision = Utils.getNum(1, 2);

                    if (decision == 1) {
                        //todo сделать более логично
                        System.out.println("Вы тихо подходите ближе к месту, откуда доносился вой, гадая, кто это мог быть: мародеры, монстры или наркоманы.");
                        System.out.println("Кажется, что именно из дальней комнаты слышится странный стрекот. Решаете туда заглянуть.");
                        System.out.println("Там вы видите рой огромных тараканов, которые уже доедают труп вашего бывшего соседа.");
                        System.out.println("По своей глупости вы посветели фонариком прямо в их глаза...");
                        System.out.println(ANSI_RED + "Игра окончена!" + ANSI_RESET);
                        Utils.setResultOfDay1(26);
                        Utils.stopGameLost();
                        day++;
                    }

                    //ВЫ БУДЕТЕ РАЗВЕДОВАТЬ ТЕРРИТОРИЮ, НО СПЕРВА ПОИЩЕТЕ ОРУЖИЕ
                    if (decision == 2) {
                        Utils.reputation(1);
                        System.out.println("Ваш сосед горд вашим решением");
                        String weapon = null;
                        if (InventoryMethods.inventoryChecker("Пистолет макарова с патронами") ||
                                InventoryMethods.inventoryChecker("Ржавый автомат Калашникова с патронами") ||
                                InventoryMethods.inventoryChecker("Топор") || InventoryMethods.inventoryChecker("Армейский нож") ||
                                InventoryMethods.inventoryChecker("Кастет") || InventoryMethods.inventoryChecker("Кухонный нож"))
                        {
                            if (InventoryMethods.inventoryChecker("Пистолет макарова с патронами"))
                                weapon = "Пистолет макарова с патронами";
                            if (InventoryMethods.inventoryChecker("Ржавый автомат Калашникова с патронами"))
                                weapon = "Ржавый автомат Калашникова с патронами";
                            if (InventoryMethods.inventoryChecker("Топор"))
                                weapon = "Топор";
                            if (InventoryMethods.inventoryChecker("Армейский нож"))
                                weapon = "Армейский нож";
                            if (InventoryMethods.inventoryChecker("Кастет"))
                                weapon = "Кастет";
                            if (InventoryMethods.inventoryChecker("Кухонный нож"))
                                weapon = "Кухонный нож";

                            ArrayList<String> whatWasInClassroom = new ArrayList<>();
                            whatWasInClassroom.add("Ржавый автомат Калашникова с патронами");
                            whatWasInClassroom.add("Армейский нож");
                            InventoryMethods.inventoryAdder("Ржавый автомат Калашникова с патронами");
                            InventoryMethods.inventoryAdder("Армейский нож");

                            System.out.println("Вы решаете вернуться в главную комнату, взять что-то из оружия. Там вы находите " + weapon + ".");
                            System.out.println("Вы бредете через этот темный коридор, находите комнату, из которой шел шум и начинается освещать ее фонариком.");
                            System.out.println("Вы видите, что в этой комнате сидит куча огромных тараканов, которые жадно додедают труп вашего соседа");
                            System.out.println("При виде света они накидываются на вас, но вы отбиваете их атаку с помощью " + weapon + ". Перебив всех, вы аккуратно заходите в комнату.");
                            System.out.println("От " + myAllNeighbours.get(1) + "а практически ничего не осталось. Ему уже не помочь.");
                            System.out.println("Вы начинаете обыскивать комнату, оказывается, что это был какой-то учебный класс.");
                            System.out.println("Вы открываете все ящики и шкафы. Вот, что вы нашли: " + whatWasInClassroom + "." );
                            System.out.println("Вы забираете эти вещи с собой.");
                            System.out.println("Вы не знаете, откуда там появились эти жуки, поэтому по возвращении, вы решаетесь закрыть эту дверь до лучших времен.");
                            System.out.println(" \"Если бы была бы возможность восстановить электричество во всем бункере...\"");
                            System.out.println("Перед сном вы решили проверить свои запасы, ставите все ровным рядом на полу, возле входа и смотрите на них.");
                            System.out.println("К каждому предмету вы уже придумали применение.");
                            System.out.println("Итого, в вашем распоряжении имеются: ");
                            InventoryMethods.showInventory();
                            System.out.println("Откинувшись на стул, вы решаете, что пора бы поспать... ");
                            System.out.println(ANSI_GREEN + "День 1 пройден!" + ANSI_RESET);
                            Utils.setResultOfDay1(27);
                            Utils.stopGameWin();
                            day++;
                        }

                        //ЕСЛИ НЕТ ОРУЖИЯ
                        if (InventoryMethods.inventoryCheckerNot("Пистолет макарова с патронами") ||
                                InventoryMethods.inventoryCheckerNot("Ржавый автомат Калашникова с патронами") ||
                                InventoryMethods.inventoryCheckerNot("Топор") || InventoryMethods.inventoryCheckerNot("Армейский нож") ||
                                InventoryMethods.inventoryCheckerNot("Кастет") || InventoryMethods.inventoryCheckerNot("Кухонный нож"))
                        {
                            System.out.println("К сожалению, ничего, что могло бы помочь вам, не нашлось.");
                            System.out.println(ANSI_BLUE + "Ваш сосед предлагает вам вариант замуровать эту дверь и забыть про " + myAllNeighbours.get(0) + "а (1) или пойти посмотреть, что там произошло (2)" + ANSI_RESET);

                            //ПОЙТИ БЕЗ ОРУЖИЯ ИЛИ ЗАБИТЬ 1-ЗАБИТЬ  2-ПОЙТИ ПОМИРЕТЬ
                            int decision1 = Utils.getNum(1, 2);
                            if (decision1 == 1) {
                                System.out.println("Инстинкт самосохранения сильнее, чем желание помочь.");
                                System.out.println(ANSI_PURPLE + " \" Закрываем \" - говорите вы. " + myAllNeighbours.get(1) + " закрывает дверь." + ANSI_RESET);
                                System.out.println("Вы садитесь за стол и понимаете, что вы в бункере всего полдня, а вы уже потеряли своего соседа.");
                                System.out.println("Вы без понятия чем заниматься дальше.");
                                System.out.println("Надо немного отдохнуть, вы ложитесь в кресло в главной комнате, закрываете глаза и засыпаете.");
                                System.out.println("Проснулись вы оттого, что где-то в близи вы слышите знакомый стрекот, точно такой же как был в том коридоре.");
                                System.out.println("Вы открываете глаза, берете фонарик и идете в незакрытый коридор. Светите в даль и видите бегущую на вас толпу этих жуков.");
                                System.out.println("Видимо в той комнате была только маленькая часть от их роя. Вы отбегаете, будите соседа.");
                                System.out.println("Прежде чем вы закрыли дверь, почти сотня этих тварей успела забежать к вам в комнату...");
                                System.out.println(ANSI_RED + "Игра окончена" + ANSI_RESET);
                                Utils.setResultOfDay1(28);
                                Utils.stopGameLost();
                                day++;
                            }

                            if (decision1 == 2) {
                                System.out.println("Несмотря на страх и возможность быть убитым, вы решаетесь идти в бой с тем, что есть.");
                                System.out.println("Вы видите комнату, из которой, как вам казалось, доносились возгласы.");
                                System.out.println("По своей невнимательности вы освещаете это помещение фонариком.");
                                System.out.println("Видите группу огромных тараканов, которые жадно доедают вашего соседа.");
                                System.out.println("Они вас замечают и набрасываются. Ваша группа пытаетесь от них отбиться, но все тчетно...");
                                System.out.println(ANSI_RED + "Игра окончена" + ANSI_RESET);
                                Utils.setResultOfDay1(29);
                                Utils.stopGameLost();
                                day++;
                            }
                        }
                    }
                }
            }
        }
    }