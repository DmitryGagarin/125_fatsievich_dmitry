package bunker;

public class Day2 extends Fight {
    public static void run() {

        Fight.myCharacter = CharactersChoice.myCharacter;
        Fight.myNeighbour1 = CharactersChoice.myNeighbour1;
        Fight.myNeighbour2 = CharactersChoice.myNeighbour2;
        Fight.reputation = Utils.reputation;

        Utils2.partOfText1();
        AllCheckers.numberOfFood();
        AllCheckers.numberOfWater();
        AllCheckers.numberOfWeapon();
        Utils2.partOfText2();

        //System.out.println(reputation+", "+teamDamage+", "+teamHealth+", "+enemyTeamDamage+", "+enemyTeamHealth);
        myHealth = Fight.giveMyCharacterHealth(myCharacter);
        neighbour1Health = Fight.giveMyTheFirstNeighbourHealth(myNeighbour1);
        neighbour2Health = Fight.giveMyTheSecondNeighbourHealth(myNeighbour2);
        Fight.setTeamHealth(myHealth, neighbour1Health, neighbour2Health);
        Fight.giveTeamDamage();
        Utils.drawLine();
        System.out.println(ANSI_PURPLE + "         Небольшая статистика перед боем:");
        System.out.println("Ваша репутация: " + reputation);
        System.out.println("Сила вашей команды: " + teamDamage);
        System.out.println("Здоровье вашей команды: " + teamHealth);
        System.out.println("Сила вражеской команды: " + enemyTeamDamage);
        System.out.println("Здоровье вражеской команды: " + enemyTeamHealth + ANSI_RESET);
        Utils.drawLine();
        Fight.finalFight(reputation, teamDamage, teamHealth, enemyTeamDamage, enemyTeamHealth);
    }
}
