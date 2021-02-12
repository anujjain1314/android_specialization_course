package mooc.vandy.java4android.buildings.logic;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor.
 */
public final class Neighborhood {

    private Neighborhood() {
    }

    public static void print(Building[] buildings, String header, OutputInterface out) {
        out.print(header);
        for (Building building : buildings){
            out.print(building.toString());
            out.println();
        }
        out.print("Total neighborhood area: "+calcArea(buildings));
    }

    public static int calcArea(Building[] buildings) {
        int totalArea = 0;
        for (Building building : buildings){
            totalArea += building.calcLotArea();
        }
        return totalArea;
    }

}
