package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {

    public static final int HERD = 24;
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }


    public void simulateHerd(Random rand) {
        int snailInside = HERD; // initially all snails are inside
        mOut.print("There are currently " + snailInside + " snails in the pen and " + (HERD - snailInside) + " snails in the pasture");

        for (int i = 1; i <= MAX_ITERATIONS; i++) {
            mOut.println();
            // choose a gate to move through
            Gate selectedGate = selectGate(snailInside, rand);

            // choose a snail count to move
            int count = chooseSnailCountToMove(selectedGate, snailInside, rand);

            // move the snails and update the count of snail inside
            snailInside += selectedGate.thru(count);

            mOut.print("There are currently " + snailInside + " snails in the pen and " + (HERD - snailInside) + " snails in the pasture");
        }

    }

    /**
     * This method Select a random gate and return that [GATE] object.
     * <p>
     * if all snails are inside. It selects [mEastGate] to move out of herd,
     * if all snails are outside. It selects [mWestGate] to move in of herd,
     * otherWise, It selects a random gate
     */
    private Gate selectGate(int snailInside, Random rand) {
        //if all the snails are inside
        if (snailInside == HERD) {
            return mEastGate;
        }
        // if all the snails are outside
        else if (snailInside == 0) {
            return mWestGate;
        }
        // if snails are both outside and inside. return a randomly selected gate
        else {
            if (rand.nextBoolean()) { // select a random gate, either 0 or 1
                return mEastGate;
            } else {
                return mWestGate;
            }
        }
    }

    /**
     * This method randomly selects number of snails to move,
     * depending on the selected gate and
     * how many snails are inside of herd
     * and and return that value.
     */
    private int chooseSnailCountToMove(Gate selectedGate, int snailInside, Random rand) {

        if (selectedGate.getSwingDirection() == Gate.IN) {
            return rand.nextInt(HERD - snailInside) + 1; //to generate random number between 1 to snail Outside of herd
        } else if (selectedGate.getSwingDirection() == Gate.OUT) {
            return rand.nextInt(snailInside) + 1; //to generate random number between 1 to snail Inside of herd
        } else {
            return 0;
        }

    }


}
