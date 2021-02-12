package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    private static final int ADD = 1;
    private static final int SUBTRACT = 2;
    private static final int MULTIPLY = 3;
    private static final int DIVIDE = 4;
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;


    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;

    }


    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        //create a instance of a basic operation
        BaseOperation baseOperation;

        try {
            //check the type of operation and initialize the [baseOperation]
            switch (operation) {
                case ADD:
                    baseOperation = new Add(argumentOne, argumentTwo);
                    break;

                case SUBTRACT:
                    baseOperation = new Subtract(argumentOne, argumentTwo);
                    break;

                case MULTIPLY:
                    baseOperation = new Multiply(argumentOne, argumentTwo);
                    break;

                case DIVIDE:
                    baseOperation = new Divide(argumentOne, argumentTwo);
                    break;

                // if [operation] is not found then throw an [IllegalArgumentException]
                default:
                    throw new IllegalArgumentException("The operation must be either ADD, SUBTRACT, MULTIPLY or DIVIDE.");
            }

            // calculate the result after operation
            String result = baseOperation.operate();

            // Print the result to the user's display.
            mOut.print(String.valueOf(result));

        } catch (IllegalArgumentException e) {

            //display the message to user.
            mOut.print(e.getMessage());
        }


    }
}
