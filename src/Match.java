import java.util.Random;

/**
 * Represents a boxing match between two fighters.
 */
public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    /**
     * Constructs a Match object with the given parameters.
     *
     * @param f1         the first fighter
     * @param f2         the second fighter
     * @param minWeight  the minimum weight limit for the match
     * @param maxWeight  the maximum weight limit for the match
     */
    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    /**
     * Runs the boxing match between the fighters.
     */
    public void run() {
        if (isCheck()) {
            boolean isFirstFighterTurn = determineFirstFighterTurn();
            System.out.println("Starting the match: " + (isFirstFighterTurn ? f1.name : f2.name));

            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=========== NEW ROUND ===========");
                if (isFirstFighterTurn) {
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    f1.health = f2.hit(f1);
                } else {
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    f2.health = f1.hit(f2);
                }
                isFirstFighterTurn = !isFirstFighterTurn;
            }

            if (f1.health > 0) {
                System.out.println(f1.name + " won the boxing match!");
            } else if (f2.health > 0) {
                System.out.println(f2.name + " won the boxing match!");
            } else {
                System.out.println("The boxing match ended in a draw.");
            }
        } else {
            System.out.println("The fighters do not meet the weight requirements.");
        }
    }

    /**
     * Checks if the fighters meet the weight requirements for the match.
     *
     * @return true if the fighters meet the weight requirements, false otherwise
     */
    boolean isCheck() {
        return ((this.f1.weight >= minWeight && this.f1.weight <= maxWeight)
                && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight));
    }

    /**
     * Checks if there is a winner in the match.
     *
     * @return true if there is a winner, false otherwise
     */
    boolean isWin() {
        return this.f1.health == 0 || this.f2.health == 0;
    }

    /**
     * Determines which fighter will start the match with a 50% chance.
     *
     * @return true if the first fighter starts, false if the second fighter starts
     */
    boolean determineFirstFighterTurn() {
        Random random = new Random();
        return random.nextBoolean();
    }
}