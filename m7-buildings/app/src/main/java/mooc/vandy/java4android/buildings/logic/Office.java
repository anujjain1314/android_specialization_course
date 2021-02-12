package mooc.vandy.java4android.buildings.logic;

import java.util.Objects;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {
    private String mBusinessName;
    private int mParkingSpaces = 0;
    private static int sTotalOffices = 0;

    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        sTotalOffices++;
    }

    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth, String mBusinessName) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        sTotalOffices++;
        this.mBusinessName = mBusinessName;
    }

    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth, String mBusinessName, int mParkingSpaces) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        sTotalOffices++;
        this.mBusinessName = mBusinessName;
        this.mParkingSpaces = mParkingSpaces;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setParkingSpaces(int mParkingSpaces) {
        this.mParkingSpaces = mParkingSpaces;
    }

    public static int getTotalOffices() {
        return sTotalOffices;
    }

    @Override
    public String toString() {
        String office = "Business: ";
        if (mBusinessName != null) {
            office += mBusinessName;
        } else {
            office += "unoccupied";
        }

        if (mParkingSpaces>0) {
            office += "; has "+ mParkingSpaces +" parking spaces";
        }

        office = office +" (total offices: "+sTotalOffices+")";

        return office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return mParkingSpaces == office.mParkingSpaces && this.calcBuildingArea() == office.calcBuildingArea();
    }
}
