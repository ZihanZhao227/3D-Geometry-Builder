/**
 * Project 2
 * This is a hard project about the Cartesian coordinates.
 * From a point, to a unit vector, then a triangle, then face, and lastly, to be a cube
 * There are numerous possibilities to make mistakes.
 * But after this project, mt coding skill grow a lot, also my pressure.
 * Thank you for giving me scores.
 *
 * @author Zihan Zhao
 * @version July, 12, 2024
 */
public class Point {
    //Fields
    private double x;
    private double y;
    private double z;
    //constructor
    public Point(double x, double y, double z) {
        //Construct a newly allocated Point object and
        // instantiate the fields to their respective parameters.
        this.x = x;
        this.y = y;
        this.z = z;

    }
    public Point() {
        //Construct a newly allocated Point object and
        // instantiate all fields set to 0.0.
        //Point point = new Point (0.0, 0.0, 0.0);
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    //methods


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public boolean equals(Point point) {

        if (this == point) {
            return true;
        }
        if (point == null) {
            return false;
        }
        final double precision = 0.0001;
        return Math.abs( this.x - point.x ) < precision &&
                Math.abs( this.y - point.y ) < precision &&
                Math.abs( this.z - point.z ) < precision;

    }
    public String toString() {
        //formatted to EXACTLY 3 decimal places
        //(x1.000, y2.000, z0.000)
        return String.format("(x%.3f, y%.3f, z%.3f)", x , y, z  );
    }
}
