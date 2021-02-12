package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building {
    private String mOwner;
    private boolean mPool = false;

    public House(int mLength, int mWidth, int mLotLength, int mLotWidth) {
        super(mLength, mWidth, mLotLength, mLotWidth);
    }

    public House(int mLength, int mWidth, int mLotLength, int mLotWidth, String mOwner) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        this.mOwner = mOwner;
    }

    public House(int mLength, int mWidth, int mLotLength, int mLotWidth, String mOwner, boolean mPool) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        this.mOwner = mOwner;
        this.mPool = mPool;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setPool(boolean mPool) {
        this.mPool = mPool;
    }

    @Override
    public String toString() {
        String house = "Owner: ";
        if (mOwner != null) {
            house += mOwner;
        } else {
            house += "n/a";
        }

        if (hasPool()) {
            house += "; has a pool";
        }
        int openSpace = calcLotArea() - calcBuildingArea();
        if (openSpace > calcBuildingArea()) {
            house += "; has a big open space";
        }

        return house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return mPool == house.mPool && super.calcBuildingArea() == house.calcBuildingArea();
    }

}
