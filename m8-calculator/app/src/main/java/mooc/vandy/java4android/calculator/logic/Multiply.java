package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply extends BaseOperation {
    /**
     * Constructor to create an multiply operation.
     */
    public Multiply(int arg1, int arg2) {
        setArg1(arg1);
        setArg2(arg2);
    }

    /**
     * perform the multiply operation on [arg1] and [arg2]
     * and returns the result as [String] value.
     */
    @Override
    public String operate() {
        return String.valueOf(getArg1() * getArg2());
    }
}
