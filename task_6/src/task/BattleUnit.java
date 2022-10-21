package task;
public class BattleUnit {

    //набор приватных членов
    private int force, armor, health, x, y;

    //конструкторы, смысл, как в треугольнике
    public BattleUnit(int force, int armor, int health, int x, int y){
        this.force = force;
        this.armor = armor;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    //методы (которые возвращают характеристики)
    public int getStrength(){
        return force;
    }
    public int getArmor(){
        return armor;
    }
    public int getHealth(){
        return health;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void attacked(BattleUnit enemy) {
        if (armor > 0) {
            int damage;
            if (enemy.force >= armor) {
                damage = enemy.force - armor;
                health = health - damage;
            } else {
                health = health - 0;
            }
        } else health = health - enemy.force;
        }

    // методы изменения координат
    public void moveUp(){
        y--;
    }
    public void moveDown(){
        y++;
    }
    public void moveLeft(){
        x--;
    }
    public void moveRight(){
        x++;
    }

    //метод теста на живучесть игрока
    public boolean isAlive(){
        return health > 0;
    }
}