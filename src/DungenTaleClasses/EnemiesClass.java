/*
 * Chase Hart
 * January 22, 2018
 * this is where the information about the enimies are stored
 */
package DungenTaleClasses;

/**
 *
 * @author Asus
 */
public class EnemiesClass extends HumanAbstractClass {

    public EnemiesClass(String name, int health, int armour, int attack, int Coins) {// this is the constructor
        super(name, health, armour, attack, Coins);
    }

    boolean equals(EnemiesClass e) {// this checks the object to see if its the dame as this object
        return e.name.equals(this.name)
                && e.health == this.health
                && e.armour == this.armour
                && e.attack == this.attack
                && e.coins == this.coins;
    }

    @Override

    public EnemiesClass clone() {// this clones the object
        EnemiesClass theClone;

        theClone = new EnemiesClass(this.name, this.health, this.armour, this.attack, this.coins);

        return theClone;
    }

    @Override
    public String toString() {// this displays the properties of the object
        String massage = ("" + getName() + "\nHP: "
                + getHealth() + "\nArmour: "
                + getArmour() + "\nAttack: "
                + getAttack() + "\nCoins"
                + getCoins() + "\n");
        return massage;
    }

}
