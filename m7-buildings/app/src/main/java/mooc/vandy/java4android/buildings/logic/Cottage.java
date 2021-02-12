package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage extends House {
    private boolean mSecondFloor;


    public Cottage(int dimension, int mLotLength, int mLotWidth) {
        super(dimension, dimension, mLotLength, mLotWidth);
    }

    public Cottage(int dimension, int mLotLength, int mLotWidth, String mOwner, boolean mSecondFloor) {
        super(dimension, dimension, mLotLength, mLotWidth, mOwner);
        this.mSecondFloor = mSecondFloor;
    }

    public boolean hasSecondFloor() {
        return mSecondFloor;
    }

    @Override
    public String toString() {
        String cottage = super.toString();
        if(mSecondFloor){
            cottage += "; is a two story cottage" ;
        }else {
            cottage += "; is a cottage";
        }

        return cottage;
    }
}

