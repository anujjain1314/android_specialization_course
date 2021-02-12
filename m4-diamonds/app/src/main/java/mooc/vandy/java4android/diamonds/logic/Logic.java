package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // number of character
        int widthOfFrame = 2 * size + 2;
        int heightOfFrame = 2 * size + 1;

        for (int i = 1; i <= heightOfFrame; i++) {
            //draw top and bottom of frame
            if (i == 1 || i == heightOfFrame) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= widthOfFrame; j++) {
                    if (j == 1 || j == widthOfFrame) {
                        sb.append("+");
                    } else {
                        sb.append("-");
                    }
                }
                mOut.print(sb);
            }
            //draw middle of frame
            else if ((heightOfFrame + 1) / 2 == i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= widthOfFrame; j++) {
                    if (j == 1 || j == widthOfFrame) {
                        sb.append("|");
                    } else {
                        if (j == 2) {
                            sb.append("<");
                        } else if (j == widthOfFrame - 1) {
                            sb.append(">");
                        } else {
                            fillCentreOfDiamond(sb,i);
                        }
                    }
                }
                mOut.print(sb);

            }
            // draw upper diamond
            else if ((heightOfFrame + 1) / 2 > i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= widthOfFrame; j++) {
                    if (j == 1 || j == widthOfFrame) {
                        sb.append("|");
                    } else {
                        if ( j == widthOfFrame / 2 - i + 2) {
                            sb.append("/");
                        }else if(j == widthOfFrame / 2 + i - 1){
                            sb.append("\\");
                        }
                        else if (j > widthOfFrame / 2 - i + 2 && j < widthOfFrame / 2 + i - 1) {
                            fillCentreOfDiamond(sb,i);
                        } else {
                            sb.append(" ");
                        }
                    }
                }
                mOut.print(sb);
            }

            // draw lower diamond
            else if ((heightOfFrame + 1) / 2 < i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= widthOfFrame; j++) {
                    if (j == 1 || j == widthOfFrame) {
                        sb.append("|");
                    } else {
                        if ( j == widthOfFrame / 2 - heightOfFrame + i + 1) {
                            sb.append("\\");
                        }else if(j == widthOfFrame / 2 + heightOfFrame - i ){
                            sb.append("/");
                        }
                        else if (j > widthOfFrame / 2 - heightOfFrame + i + 1 && j < widthOfFrame / 2 + heightOfFrame - i) {
                            fillCentreOfDiamond(sb,i);
                        } else {
                            sb.append(" ");
                        }
                    }
                }
                mOut.print(sb);

            }


            mOut.println();
        }

    }

    private void fillCentreOfDiamond(StringBuilder sb , int rowNumber){
        if (rowNumber % 2 == 1) {
            sb.append("-");
        } else {
            sb.append("=");
        }
    }

    // TODO -- add any helper methods here


}
