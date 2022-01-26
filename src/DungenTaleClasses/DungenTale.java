/*
 * Chase Hart
 * January 22, 2018
 * this is the interface which conects the classes to the GUI's
 */
package DungenTaleClasses;

/**
 *
 * @author chase.hart
 */
public interface DungenTale {

    public String getName();//return the name of the human

    public void setName(String name); //change the name of the human

    public int getAttack();//gets the players attack

    public void setAttack(int attack);// sets the players attack

    public int getArmour();// get the players armour

    public void setArmour(int armor);// sets the players armour

    public int getHealth();//return the health of a human

    public void setHealth(int h);//change the health of a human

    @Override
    public String toString();//return a string representation of a human object

}
