/**
 * Represents one row from your dataset.
 *
 *  - Rename the class to match your dataset (e.g., Pokemon, StateData, CountryStat) ✔
 *  - Add at least 3 private attributes based on your CSV columns ✔
 *  - Write a constructor that initializes all attributes ✔
 *  - Add getter methods for the attributes you need in your analysis ✔
 *  - Override toString() to display the object's data ✔
 *  - Add Javadoc comments for the class and all methods ✔
 */
public class Pokemon {

    // Add at least 3 private attributes
    private String name;
    private String type;
    private int HP; 
    private int attack;
    private int defense;
    private int speed;

    /**
     * Constructor that initializes all attributes.
     * @param name the name of the Pokemon
     * @param type the type of the Pokemon
     * @param HP the health points
     * @param attack the attack stat
     * @param defense the defense stat
     * @param speed the speed stat
     */
    public Pokemon(String name, String type, int HP, int attack, int defense, int speed) {
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    /**
     * Gets the attack stat.
     * @return attack value
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets the HP stat.
     * @return HP value
     */
    public int getHP() {
        return HP;
    }

    /**
     * Gets total stats (HP + Attack + Defense + Speed).
     * @return total stats
     */
    public int getTotalStats() {
        return HP + attack + defense + speed;
    }

    /**
     * Returns a readable representation of the Pokemon.
     * @return formatted string of Pokemon data
     */
    public String toString() {
        return name + " (" + type + ") | HP: " + HP +
               ", Attack: " + attack +
               ", Defense: " + defense +
               ", Speed: " + speed +
               ", Total: " + getTotalStats();
    }

}