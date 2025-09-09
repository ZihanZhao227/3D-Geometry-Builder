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
public class UnitVector {
    //This class represents a Unit Vector in 3 dimensional Cartesian space.
    // A unit vector is a direction with magnitude 1
    //Fields
    private double i; //the x component of a vector in 3D space
    private double j; //y
    private double k; //z

    //Constructors:
    public UnitVector(double i, double j, double k) {

        //Confirm that the magnitude of the UnitVector is equal to 1.000.
        final double precision = 0.0001;
        double magnitude = Math.sqrt( Math.pow( i, 2 ) + Math.pow( j, 2 ) + Math.pow( k, 2 ));
        if (Math.abs( magnitude - 1 ) < precision) {
            this.i = i;
            this.j = j;
            this.k = k;

        } else if (magnitude == 0) {
            //in the case where the magnitude is equal to 0 all fields
            // should be initialized to 0.000.
            this.i = 0.000;
            this.j = 0.000;
            this.k = 0.000;
        } else {
            this.i = i / magnitude;
            this.j = j / magnitude;
            this.k = k / magnitude;
        }

    }

    public UnitVector(Point start, Point end) {
        //a newly allocated UnitVector object from the two given points
        i = end.getX() - start.getX();
        j = end.getY() - start.getY();
        k = end.getZ() - start.getZ();
        UnitVector unitVector = new UnitVector(end.getX() - start.getX(),  end.getY() - start.getY(),
                end.getZ() - start.getZ() );
        //+/- 0.0001 precision
        final double precision = 0.0001;
        double magnitude = Math.sqrt( i * i + j * j + k * k);

        if (Math.abs( magnitude - 1.0 ) > precision) {
            if (magnitude == 0) {
                //in the case where the magnitude is equal to 0 all fields
                // should be initialized to 0.000.
                this.i = 0.000;
                this.j = 0.000;
                this.k = 0.000;
            } else {
                this.i = i / magnitude;
                this.j = j / magnitude;
                this.k = k / magnitude;
            }
        }

    }
    public UnitVector() {
        //Construct a newly allocated UnitVector object with
        // all fields instantiated to 0.000. (An invalid vector)
        //UnitVector unitVector = new UnitVector (0.000, 0.000, 0.000);
        this.i = 0.000;
        this.j = 0.000;
        this.k = 0.000;
    }
    //Methods:


    public double getI() {
        return i;
    }

    public double getJ() {
        return j;
    }

    public double getK() {
        return k;
    }

    public boolean equals(UnitVector unitVector) {
        //within +/- 0.0001 precision true
        if (unitVector == null) {
            return false;
        }
        if (this == unitVector) {
            return true;
        }
        final double precision = 0.0001;
        return Math.abs( this.i - unitVector.i ) < precision &&
                Math.abs( this.j - unitVector.j ) < precision &&
                Math.abs( this.k - unitVector.k ) < precision;
        //otherwise false
    }
    public UnitVector crossProduct(UnitVector b) {
        //Returns a newly allocated UnitVector object with fields set by
        double i2 = this.j * b.k - this.k * b.j;
        //double newJ = this.k * b.i - this.i * b.k;
        double j2 = this.k * b.i - this.i * b.k;
        double k2 = this.i * b.j - this.j * b.i;
        //Confirm that the magnitude of the UnitVector is equal to 1.000
        //within +/- 0.0001
        final double precision = 0.0001;
        double magnitude2 = Math.sqrt( i2 * i2 + j2 * j2 + k2 * k2);

        if (Math.abs( magnitude2 - 1.0 ) > precision) {
            if (magnitude2 == 0) {
                //in the case where the magnitude is equal to 0 all fields
                // should be initialized to 0.000.
                i2 = 0.000;
                j2 = 0.000;
                k2 = 0.000;
            } else {
                this.i = i / magnitude2;
                this.j = j / magnitude2;
                this.k = k / magnitude2;
            }
        }

        return new UnitVector(i2, j2, k2);

    }

    public String toString() {
        //If i, j, and k, are equal to 0.000 then the resulting toString() should be:
        //<InvalidUnitVector>
        //within +/- 0.0001 precision
        final double precision = 0.0001;

        if ((this.i - precision < 0.000) && (this.j - precision < 0.000) && (this.k - precision < 0.000)) {
            return "<InvalidUnitVector>";
        }

        //EXACTLY 3 decimal places.
        //Returns the String representation of this UnitVector.
        //<0.816i, 0.408j, 0.408k>
        return String.format( "<%.3fi, %.3fj, %.3fk>", i, j, k);
    }

    public void setOppositeUnitVector() {
        this.i = (-1) * i;
        this.j = (-1) * j;
        this.k = (-1) * k;

    }


}
