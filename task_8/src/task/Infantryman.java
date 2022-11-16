package task;

public class Infantryman extends BattleUnitBase {
    //родительский класс - после Extends

    //конструктор
    public Infantryman(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    @Override
    //метод который ничего не делает
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
    }

    @Override
    //если противник в броне (+),наносит повреждения по здоровью, равные половине силы (+),
    //и повреждения по броне равные четверти силы, (+) иначе
    //наносит повреждения здоровью, равные силе. (+)
    //минимальные повреждения любого типа - 1
            //this. - атакующий
            //attacker. - атакуемый
            //все изменения в характеристиках делаются через методы из BattleUnitBase
    public void attack(BattleUnit attacker) { //заменил other На attacker Для более легкого понимая че происходит
        double halfAttack = (this.strength / 2); //создаем переменную, равную половине силе
        double quarterAttack = (this.strength / 4); //создаем переменную, равную четверти силе
        if(halfAttack < 1) halfAttack=1; //проверка на то, что урон не может быть меньше 1
        if(quarterAttack < 1) quarterAttack=1; //проверка на то, что урон не может быть меньше 1
        if(attacker.armor()==0) { //если брони у атакуемого нет, то его здоровье уменьшается на силу атакующего
            attacker.takeDamage(this.strength);
        } else {
            attacker.takeDamage((int) halfAttack); //если есть броня у атакумоего, то здоровье уменьшается на половину
            attacker.damageArmor((int) quarterAttack); //силы атакующего, а армор на четверть
        }
    }
}