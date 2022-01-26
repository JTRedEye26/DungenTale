/*
 * Chase Hart
 * January 22, 2018
 * This is the abstract class for all the other classes
 */
package DungenTaleClasses;

/**
 *
 * @author chase.hart
 */
abstract public class HumanAbstractClass implements DungenTale {

    protected String name;// these are the variables used in the class
    protected int health, attack, armour, coins;

    public HumanAbstractClass(String name, int health, int armour, int attack, int coins) {// this is the constructor
        this.name = name;
        this.health = health;
        this.armour = armour;
        this.attack = attack;
        this.coins = coins;
    }

    @Override
    public void setHealth(int h) {// these are the methods used to set and get the properties of the object
        this.health = h;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setArmour(int armour) {
        this.armour = armour;
    }

    @Override
    public int getArmour() {
        return armour;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    @Override
    public String toString() {
        String massage = ("" + getName() + "\nHP: "
                + getHealth() + "\nArmour: "
                + getArmour() + "\nAttack: "
                + getAttack() + "\nCoins:"
                + getCoins() + "\n");
        return massage;
    }

}
