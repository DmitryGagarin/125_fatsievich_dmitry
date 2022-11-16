package task;

//имплиментируем класс BattleUnit в BattleUnitBase, чтобы получить все те методы, которые были там
public abstract class BattleUnitBase implements BattleUnit {

    //для return создаем спискок полей
    public int health=-1;
    protected int strength=-1000;
    protected int armor=-1;
    private int maxHealth;
    private final String name;
    int maxArmor;
    int baseStrength;

    //создаем конструктор по условию
    public BattleUnitBase(String name, int maxHealth, int baseStrength, int maxArmor ) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.baseStrength = baseStrength;
        this.maxArmor = maxArmor;
        //добавляем отдельные приколы, чтобы инициализовать переменные заранее (нужно для Infantryman)
        this.armor=armor();
        this.strength=strength();
        this.health=health();
    }
    
    //создаем АБСТРАКТНЫЕ классы
    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    public abstract void attack(BattleUnit other);
    
    //реализуем остальные классы. РЕАЛИЗУЕМ = OVERRIDE
    //просто возвращает имя
    @Override
    public String name (){
        return this.name;
    }

    //если армор = -1 (инициализуется в первый раз), то он равен максармору из конструктора
    @Override
    public int armor() {
        //int saveArmor = 40;
        if (armor == -1) {
            armor = maxArmor;
        }
        return armor;
    }

    //если здоровье = -1 (то есть инициализуется в первый раз), то хелс равен максхелс из конструктора
    //если здоровье <0, то здоровье равно 0 (проверка на наличие здоровья)
    //если здоровье больше максимального, то здоровье равно максимальному
    @Override
    public int health() {
        int retHealth=this.health;
        if (retHealth == -1) {
            retHealth = maxHealth;
        }
        if(retHealth <0 ){
            retHealth = 0;
        }
        if(retHealth > maxHealth ){
            retHealth = maxHealth;
        }
        this.health=retHealth;
        return retHealth;
    }

    //возвращает максхелс из конструктора
    @Override
    public  int maxHealth(){
        return  maxHealth;
    }

    //если здоровье больше максимально здоровья, то здоровье равно максимальному здоровью
    @Override
    public  void setMaxHealth(int value) {
        if (this.health > value) this.health = value;
        this.maxHealth = value;
    }

    //если хилит, то к здоровью добавляется value хила, опять же проверка не будет ли здоровье больше максимума
    @Override
    public void heal(int value) {
        this.health += value;
        if (this.health > maxHealth) this.health = maxHealth;
    }

    //вычитает из здоровья удар
    @Override
    public void takeDamage(int value) {
        health = health - value;
    }

    //если сила = -1 , то сила равно силе из конструктора
    @Override
    public int strength() {
        if (strength ==-1000 ) {
            strength = baseStrength;
        }
        return this.strength;
    }

    //ИЗНАЧАЛЬНО STRENGHT = baseStrength ПОТОМ STRENGTH РАВЕН setStrength
    //делает так, что новое здоровье равно value
    @Override
    public void setStrength(int value) {
        this.strength = value;
    }

    @Override //ТУТ ИЗМЕНЕНИЙ НИКАКИХ НЕ ПРОИСХОДИТ
    public int baseStrength(){
        return baseStrength;
    }

    //добавляет к армору value и тест на превышение максимума
    @Override
    public void restoreArmor(int value) {
        this.armor += value;
        if(this.armor > maxArmor) this.armor=maxArmor;
    }

    //срезает армор по value и проверка на существование, то есть армор не может быть меньше 0
    @Override
    public void damageArmor(int value) {
        this.armor -= value;
        if(this.armor < 0) this.armor=0;
    }

    //просто возвращает максармор
    @Override
    public int maxArmor(){
        return maxArmor;
    }

    //сетит максармор новым значение и тест на превышение армором максармора
    @Override
    public void setMaxArmor(int value) {
        this.maxArmor = value;
        if(this.armor>value) this.armor=value;
    }
}
