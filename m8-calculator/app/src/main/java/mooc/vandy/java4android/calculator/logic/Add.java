package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add extends BaseOperation {
    /**
     * Constructor to create an Add operation.
     */
    public Add(int arg1, int arg2) {
        setArg1(arg1);
        setArg2(arg2);
    }

    /**
     * perform the add operation on [arg1] and [arg2]
     * and returns the result as [String] value.
     */
    @Override
    public String operate() {
        return String.valueOf(getArg1() + getArg2());
    }
}
