package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }


    /**
     * randomly set each gate to swing IN, be CLOSED, or swing OUT.
     */
    public void setCorralGates(Gate[] gate, Random rand) {
        for (int i = 0; i < gate.length; i++) {
            int randomDir = rand.nextInt(3) - 1;
            gate[i].setSwing(randomDir);
            mOut.print("Gate " + i + " " + gate[i].toString());
            mOut.println();
        }
    }

    /**
     * returns [true] if at least one gate in the array is set to swing IN so that snails can enter at least one corral.
     * <p>
     * returns [false] if all gates are set to OUT or CLOSED.
     */
    public boolean anyCorralAvailable(Gate[] corral) {
        for (Gate gate : corral) {
            if (gate.getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }


    public int corralSnails(Gate[] corral, Random rand) {
        int snailOutToPasture = 5;
        int attemptsRequired = 0;

        while (snailOutToPasture > 0) {
            //select a random gate
            int randomGateIndex = rand.nextInt(corral.length);
            Gate G = corral[randomGateIndex];

            //select a random count of snails to move
            int snailsToMove = rand.nextInt(snailOutToPasture) + 1;

            //update the snailOutToPasture count after the snails move through the gate.
            snailOutToPasture = snailOutToPasture - G.thru(snailsToMove);

            mOut.print(snailsToMove + " are trying to move through corral " + (randomGateIndex));
            mOut.println();

            //increment the attempt count.
            attemptsRequired++;
        }
        mOut.print("It took " + attemptsRequired + " attempts to corral all of the snails.");

        return attemptsRequired;

    }

}
