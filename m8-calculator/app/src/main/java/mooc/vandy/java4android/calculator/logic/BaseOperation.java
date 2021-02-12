package mooc.vandy.java4android.calculator.logic;


/**
 * Defines an abstract class for basic operations performed on [int].
 */
public abstract class BaseOperation {
    private int arg1;
    private int arg2;

    /**
     * returns the first argument.
     */
    public int getArg1() {
        return arg1;
    }

    /**
     * updates the first argument.
     */
    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    /**
     * returns the second argument.
     */
    public int getArg2() {
        return arg2;
    }

    /**
     * updates the second argument.
     */
    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    /**
     * return an String result after an operation is performed.
     */
    public abstract String operate();
}
