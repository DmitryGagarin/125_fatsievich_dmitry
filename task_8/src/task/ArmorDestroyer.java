package task;

import java.util.Arrays;

public class ArmorDestroyer extends BattleUnitBase{

    //конструктор
    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    @Override
    //выбирает живого противника с максимальной броней.
    //Если противник в броне, наносит урон броне, равный удвоенной силе. (+)
    //Иначе наносит урон здоровью, равный четверти силы. (+)
    //ownTeam - моя команда (зачем нужна)???
    //нужно найти врага с максимальной броней
    //ownTeam и enemyTeam - массивы
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int maxArmorEnemy = 0; //идекс живого противника с максимальной бронёй
        int maxArmor = 0; //значение армора
        for (int i = 0; i<enemyTeam.length; i++) {
            BattleUnit enemy = enemyTeam[i]; //просматриваем все элементы массива
            int enemyArmor = enemy.armor();//смотрим все брони
            int enemyHealth = enemy.health();//смотрим все хп
            if(enemyHealth > 0 && enemyArmor > maxArmor) { //проверка на наличие брони и армора
                maxArmorEnemy = i; //индекс персонажа с максимальной броней
                maxArmor = enemyArmor;
            }
        }
        double doubleAttack = this.strength*2; //двойнная атака
        double quarterAttack = this.strength / 4; //четверть атаки
        if (enemyTeam[maxArmorEnemy].armor() > 0) { //если броня противника больше 0, наносим удар по броне
            enemyTeam[maxArmorEnemy].damageArmor((int) doubleAttack);
        } else { //если нет, то по здоровью
            enemyTeam[maxArmorEnemy].takeDamage((int) quarterAttack);
        }
    }

    @Override
            //this. - атакующий
            //other. - атакуемый (враг) - enemy = new infantryman
    public void attack(BattleUnit other) {
        double fullAttack = this.strength;
        double halfAttack = this.strength / 2; //создаем переменную, равную половине силе
        double quarterAttack = this.strength / 4; //создаем переменную, равную четверти силе
        if(fullAttack < 1) fullAttack=1;
        if(halfAttack < 1) halfAttack=1; //проверка на то, что урон не может быть меньше 1
        if(quarterAttack < 1) quarterAttack=1; //проверка на то, что урон не может быть меньше 1
        if (other.armor() > 0){
            other.takeDamage((int) quarterAttack);
            other.damageArmor((int) fullAttack);
        } else {
            other.takeDamage((int) halfAttack);
        }
    }
}
