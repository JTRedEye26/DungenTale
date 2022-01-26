/*
 * Chase Hart
 * January 22, 2018
 * This is the class that stores all the information of the characters
 */
package DungenTaleClasses;

/**
 *
 * @author Asus
 */
public class CharacterClass extends HumanAbstractClass {

    private final boolean archer;// these are the variables used
    private final boolean knight;
    private final boolean mage;
    private int healthPots, speedPots, strengthPots, repelPots;

    public CharacterClass(String name, int health, int armour, int attack, int coins, int healthPots, int speedPots, int strengthPots, int repelPots, boolean archer, boolean knight, boolean mage) {// this is the constructor
        super(name, health, armour, attack, coins);
        this.healthPots = healthPots;
        this.speedPots = speedPots;
        this.strengthPots = strengthPots;
        this.repelPots = repelPots;
        this.archer = archer;
        this.knight = knight;
        this.mage = mage;
    }

    public int getHealthPots() {// thses are the methods the get and set everything in this class
        return healthPots;
    }

    public void setHealthPots(int h) {
        this.healthPots = h;
    }

    public int getSpeedPots() {
        return speedPots;
    }

    public void setSpeedPots(int s) {
        this.speedPots = s;
    }

    public int getStrengthPots() {
        return strengthPots;
    }

    public void setStrengthPots(int s) {
        this.strengthPots = s;
    }

    public int getRepelPots() {
        return repelPots;
    }

    public void setRepelPots(int r) {
        this.repelPots = r;
    }

    public boolean getArcher() {
        return archer;
    }

    public boolean getKnight() {
        return knight;
    }

    public boolean getMage() {
        return mage;
    }

    boolean equals(CharacterClass a) {// this is the boolean check
        return a.name.equals(this.name)
                && a.health == this.health
                && a.armour == this.armour
                && a.attack == this.attack
                && a.coins == this.coins
                && a.healthPots == this.healthPots
                && a.speedPots == this.speedPots
                && a.strengthPots == this.strengthPots
                && a.repelPots == this.repelPots
                && a.archer == this.archer
                && a.knight == this.knight
                && a.mage == this.mage;
    }

    @Override
    public CharacterClass clone() {// creats a clone of the object
        CharacterClass theClone;

        theClone = new CharacterClass(this.name, this.health, this.armour, this.attack, this.coins, this.healthPots, this.speedPots, this.strengthPots, this.repelPots, this.archer, this.knight, this.mage);

        return theClone;
    }

    @Override
    public String toString() {// displays the properties of the charateristics
        String massage = ("" + getName() + "\nHP: "
                + getHealth() + "\nArmour: "
                + getArmour() + "\nAttack: "
                + getAttack() + "\nCoins: "
                + getCoins() + "\nhealth potions"
                + getHealthPots() + "\nspeed potions"
                + getSpeedPots() + "\nstrength potions"
                + getStrengthPots() + "\nrepel potions"
                + getRepelPots() + "\n");
        return massage;
    }
}
