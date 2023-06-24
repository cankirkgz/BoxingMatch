/**
 * Represents a fighter in the boxing match.
 */
public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    /**
     * Constructs a Fighter object with the given parameters.
     *
     * @param name   the name of the fighter
     * @param damage the amount of damage the fighter can inflict
     * @param health the initial health of the fighter
     * @param weight the weight of the fighter
     * @param dodge  the dodge chance of the fighter
     */
    public Fighter(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
    }

    /**
     * Calculates and applies the hit from this fighter to the opponent fighter.
     *
     * @param foe the opponent fighter
     * @return the remaining health of the opponent fighter after the hit
     */
    int hit(Fighter foe) {
        if (!isDodge(foe)) {
            System.out.println(this.name + " hit " + foe.name + " with " + this.damage + " damage.");
            foe.health -= this.damage;
            return Math.max(foe.health, 0);
        } else {
            System.out.println(foe.name + " dodged the incoming hit.");
            return Math.max(foe.health, 0);
        }
    }

    /**
     * Checks if the opponent fighter can dodge the hit.
     *
     * @param foe the opponent fighter
     * @return true if the opponent fighter can dodge, false otherwise
     */
    boolean isDodge(Fighter foe) {
        double random = Math.random() * 100;
        return (random <= foe.dodge);
    }
}
