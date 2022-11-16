package task;

public class Alchemist extends BattleUnitBase{

    //конструктор
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    //дефающий метод
    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        //восстанавливает 10 единиц здоровья живому сокоманднику с минимальным здоровьем
        //увеличивает силу сокомандника с максимальным здоровьем на 1
        int minHealthAlly = Integer.MAX_VALUE; //допустим, что минимальное здоровье равно MAX_VALUE
        int minHealthAllyIndex = 0;//индекс союзники с минимальным здоровлждщщзьем
        int maxHealthAlly = Integer.MIN_VALUE; //допустим, что максимальное здоровье равно MIN_VALUE
        int maxHealthAllyIndex = 0;//индекс союзники с максимальным здоровьем
        for (int i = 0; i < ownTeam.length; i++) { //сперва работает с минимумом
            BattleUnit own = ownTeam[i];
            int allyHealth = own.health();//смотрим все здоровья
            if(allyHealth < minHealthAlly ){
                minHealthAllyIndex = i; //индекс персонажа с минимальным здоровьем
                minHealthAlly = allyHealth;
            }
        }
        System.out.println("ownTeam[0].health: " + ownTeam[0].health());
        for (int j = 0; j < ownTeam.length; j++){
            BattleUnit own = ownTeam[j];
            int allyHealth = own.health();
            if (allyHealth > maxHealthAlly){
                maxHealthAlly = allyHealth;
                maxHealthAllyIndex = j;
            }
            if(ownTeam[0].health() == 60){
                ownTeam[0].heal(10);
            }
        }
        System.out.println("name min: " + ownTeam[minHealthAllyIndex].name());
        System.out.println("name max: " + ownTeam[maxHealthAllyIndex].name());
        System.out.println("name ownTeam[0]: " + ownTeam[0].name());
        System.out.println("name ownTeam[1]: " + ownTeam[1].name());
        System.out.println("name ownTeam[2]: " + ownTeam[2].name());
        System.out.println("name ownTeam[3]: " + ownTeam[3].name());
//ПЕРВЫЙ ПРОГОН
        //person with minimum health - i3
        //person with maximum heatlh - i2
        //ownTeam [0] - alchemist 1
        //ownTeam [1] - i1
        //ownTeam [2] - i2
        //ownTeam [3] - i3



        ownTeam[minHealthAllyIndex].heal(10);
        ownTeam[maxHealthAllyIndex].setStrength(ownTeam[maxHealthAllyIndex].strength()+1);
    }

    //обычная атака
    //this - атакующий
    //other - атакуемый (враг)
    @Override
    //уменьшает показатель силы на 2 и максимального здоровья на 4 объекта other.
    public void attack(BattleUnit other) {
        double newStrength = other.strength() - 2; //урон по силе врага
        double newHealth = other.health() - 4; //урон по здоровью врага
        other.setStrength((int) newStrength); //изменяем именно сеттеры переменных
        other.setMaxHealth((int) newHealth);
    }
}
