import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
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

public class Face {
    // a single face of a cube in 3 dimensional Cartesian space.
    //Fields
    private Triangle[] mesh; //一个三角形数组，这些三角形组合在一起形成这个面(a bounded square).
    private UnitVector surfaceNormal; //The surface normal of this Face.
    //Constructor
    public Face(Triangle one, Triangle two) {
        //1. If triangle one and two share two common vertices
        boolean twoSharedSameSurface = false;
        this.mesh = new Triangle[2];
        this.surfaceNormal = new UnitVector(0.000, 0.000, 0.000);
        int sharedVerticesOfTri = 0;
        Point[] verticesOne = {one.getVertexA(), one.getVertexB(), one.getVertexC()};
        Point[] verticesTwo = {two.getVertexA(), two.getVertexB(), two.getVertexC()};

        for (Point vOfOne : verticesOne) {
            for (Point vOfTwo : verticesTwo) {
                if (vOfOne.equals( vOfTwo )) {
                    sharedVerticesOfTri++;
                }
            }
        }
        //2. and their surface normals are equal,
        boolean hasEqualSurfaceNormal = false;
        if (one.getSurfaceNormal().equals( two.getSurfaceNormal() )) {
            hasEqualSurfaceNormal = true;
            //法线就是垂直于当前面然后向上，
            // 这个是区分一个正方体的不同面的，因为面的方向不一样
        }
        if (sharedVerticesOfTri >= 2 && hasEqualSurfaceNormal) {
            mesh[0] = one;
            mesh[1] = two;
            surfaceNormal = one.getSurfaceNormal();

        } else {
            //do not share at least two vertices or the surface normals are not equal,
            // then each triangle should be set to Triangle()
            mesh[0] = new Triangle();
            mesh[1] = new Triangle();
            // and the unit vector set to invalid (all fields 0.000).
            this.surfaceNormal = new UnitVector(0.000, 0.000, 0.000);
        }

    }
    public Face() {
        //Construct a newly allocated Face object and instantiate the fields as follows:
        // each triangle should be set to Triangle()
        // and the unit vector set to invalid (all fields 0.000). (The face is invalid)
        this.mesh = new Triangle[2];
        mesh[0] = new Triangle();
        mesh[1] = new Triangle();
        this.surfaceNormal = new UnitVector(0.000, 0.000, 0.000);

    }
    //Methods
    public Triangle[] getMesh() {
        //Returns the Triangle array that makes up the mesh of this Face.
        return mesh; //mesh is the Triangle array
    }
    public UnitVector getSurfaceNormal() {
        //Returns the UnitVector representing the surfaceNormal of this Face.
        return surfaceNormal;
    }
    public boolean equals(Face face) {
        //Compares this Face to face.
        if (face == null) {
            return false;
        }
        if (!Arrays.equals( this.getMesh(), face.getMesh() )) {
            return false;
        }
        for (int i = 0; i < mesh.length; i++) {
            if (this.mesh[i].equals( face.mesh[i] ) ) {
                return true;
            }
        }
        for (int i = 0; i < mesh.length; i++) {
            if ( !this.mesh[i].getSurfaceNormal().equals( face.mesh[i].getSurfaceNormal() ) ) {
                return false;
            }
        }
//        if (this.equals ( face )) {
//            return true;
//        }
        //within +/- 0.0001 precision
        final double precision = 0.0001;
        //Return true if the Triangles share the same vertices and normal vectors.

        return Math.abs( this.surfaceNormal.getI() - face.surfaceNormal.getI() ) < precision &&
                Math.abs(this.surfaceNormal.getJ() - face.surfaceNormal.getJ())  < precision &&
                Math.abs(this.surfaceNormal.getK() - face.surfaceNormal.getK()) < precision &&
                Arrays.equals( this.mesh, face.mesh );

        //Otherwise return false.
    }
    public String toString() {
        //If any Triangle is invalid the result of toString() should be: {InvalidFace}
        if (Arrays.toString( this.mesh ).contains("[InvalidTriangle]"  )) {
            return "{InvalidFace}";
            //2 tri, one maybe invalid, any Triangle is invalid
        }
        //mesh = new Triangle[2];
        for (int i = 0; i < 2; i++) {
            if (mesh[i].getSurfaceNormal().getI() == 0.000 && mesh[i].getSurfaceNormal().getJ() == 0.000
                    && mesh[i].getSurfaceNormal().getK() == 0.000) {
                return "{InvalidFace}";
            }
            //System.out.println ("i" + i);
        }

        if (mesh[0].toString().contains("[InvalidTriangle]"  ) || mesh[1].toString().contains(
                "[InvalidTriangle]"  )) {
            return "{InvalidFace}";
        }
        if ( !mesh[0].getSurfaceNormal().equals( mesh[1].getSurfaceNormal() )) {
            return "{InvalidFace}";
        }

        //Returns the String representation of this Triangle.
        //Triangle[0]:
        //vertexA= (x0.000, y0.000, z1.000)
        //vertexB= (x1.000, y-1.000, z1.000)
        //vertexC= (x1.000, y0.000, z1.000)
        //surfaceNormal = <0.000i, 0.000j, 1.000k>
        String stringOfTriangle1 = String.format( "[A%s; B%s; C%s]" , mesh[0].getVertexA(),
                mesh[0].getVertexB(), mesh[0].getVertexC());
        String stringOfTriangle2 = String.format( "[A%s; B%s; C%s]" , mesh[1].getVertexA(),
                mesh[1].getVertexB(), mesh[1].getVertexC());
        String faceSurfaceNormal = this.surfaceNormal.toString(); //<0.816i, 0.408j, 0.408k>
        //check
//        System.out.println("stringOfTriangle1    " + stringOfTriangle1 );
//        System.out.println("stringOfTriangle2    " + stringOfTriangle2 );
//        System.out.println("faceSurfaceNormal   " + this.surfaceNormal.toString());

        return String.format( "{F%s %s N%s}" , stringOfTriangle1, stringOfTriangle2, faceSurfaceNormal);

        //{F[A(x0.000, y0.000, z1.000); B(x1.000, y-1.000, z1.000); C(x1.000, y0.000, z1.000)] [A(x0.000, y0.000,
        // z1.000); B(x0.000, y-1.000, z1.000); C(x1.000, y-1.000, z1.000)] N<0.000i, 0.000j, 1.000k>}

        //Note: The surface normal for the triangles are not printed, only the one for the face.
    }





}
