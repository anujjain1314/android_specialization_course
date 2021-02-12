package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide extends BaseOperation {
    /**
     * Constructor to create an divide operation.
     * <p>
     * if [arg] is 0 throws a [IllegalArgumentException]
     */
    public Divide(int arg1, int arg2) {
        if (checkDivisionBy0(arg2)) {
            throw new IllegalArgumentException("You cannot divide a number by 0.");
        }
        setArg1(arg1);
        setArg2(arg2);
    }

    /**
     * check the division by 0.
     * return [true] or [false] accordingly.
     */
    private boolean checkDivisionBy0(int arg) {
        return arg == 0;
    }

    /**
     * perform the multiply operation on [arg1] and [arg2]
     * and returns the result as [String] value.
     */
    @Override
    public String operate() {
        int quotient = getArg1() / getArg2();
        int remainder = getArg1() % getArg2();
        return quotient + " R:" + remainder;
    }
}
