import java.util.ArrayList;
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

public class Cube {
    //Fields
    private Face[] mesh; //6: An array of Faces that make up the mesh of the Cube.
    //Constructor
    public Cube(Face one, Face two, Face three, Face four, Face five, Face six) {
        //Construct a newly allocated Cube object and instantiate the fields to their respective parameters.
        boolean validCube = true;
        boolean uniqueFace = true;
        boolean enoughSharedEdge = true;
        boolean oppositeSurfaceNormal = true;


        this.mesh = new Face[6];
        mesh[0] = one;
        mesh[1] = two;
        mesh[2] = three;
        mesh[3] = four;
        mesh[4] = five;
        mesh[5] = six;
        //确认每个面与其他4个面共用一条边。
        //1. Confirm that each face shares exactly one edge with each of 4 other faces.
        //one edge means two shared points/vertex of triangle
        //one face have 4 shared edge with other faces ,so 6* 4= 24

        //create an arrayList to store the mesh don't have shared edge, then it should be 6 face
        //then I use the for loop to count once if surface normal is op, count number should be 6
        ArrayList<Face> faceNotSharedEdge = new ArrayList<>();

        int totalSharedEdgesInCube = 0;
        for (int i = 0; i < mesh.length; i++) {
            for (int j = 0; j < mesh.length; j++) {
                //note the face should not compare with itself
                //if two face has one shared edge, then add to the total
                if (i != j && shareEdge( mesh[i], mesh[j] )) {
                    totalSharedEdgesInCube++;
                }
                if ( !shareEdge( mesh[i], mesh[j]) ) {
                    faceNotSharedEdge.add( mesh[i] );
                    faceNotSharedEdge.add( mesh[j] );
                }

            }
        }
        if (totalSharedEdgesInCube != 24) {
            enoughSharedEdge = false;
        }

        // 2. Confirm that no face is the same as another face.
        for (int i = 0; i < mesh.length; i++) {
            //check single face is valid or not
            if (mesh[i] == null) {
                validCube = false;

                //System.out.println("there is one invalid face (null) in a cube!");
                break;
            }
            for (int j = i + 1; j < mesh.length; j++) {
                if ( i != j && mesh[i].equals( mesh[j] )) {
                    uniqueFace = false;
                    //System.out.println("Invalid! There is at least a pair of same faces in a cube!");

//                    System.out.println("mesh[i]:    " + mesh[i]);
//                    System.out.println("mesh[j]:    " + mesh[j]);
                    break;

                }
            }
        }
        // 3. Confirm that each surfaceNormal of opposed Faces (faces that do not share an edge) is pointing in an
        // opposite direction.
        // 确认相对面(不共享一条边的面)的每个表面法线指向相反的方向。
        int oppositeSurfaceNormalCount = 0;
        if (enoughSharedEdge) {
            //time to deal with op face
            if (faceNotSharedEdge.size() != 6) {
                //in a cube , there must be 6 face that have op surface normal with others
                oppositeSurfaceNormal = false;
            } else {
                for (int i = 0; i < mesh.length; i++) {

                    for (int j = i + 1; j < mesh.length; j++) {
                        if ( !shareEdge( mesh[i], mesh[j]) ) {
                            UnitVector surfaceNormal1 = mesh[i].getSurfaceNormal();
                            UnitVector surfaceNormal2 = mesh[j].getSurfaceNormal();
                            //if op, then sum is 0
                            surfaceNormal2.setOppositeUnitVector();
                            if (surfaceNormal1.equals( surfaceNormal2 )) {
                                oppositeSurfaceNormalCount++;
                                break; //3 pair
                            }

                        }

                    }


                }
            }
        }
        if (oppositeSurfaceNormalCount != 3) {
            oppositeSurfaceNormal = false;
        }

        if (uniqueFace && enoughSharedEdge && oppositeSurfaceNormal  ) {
            validCube = true;
        } else {
            validCube = false;
        }

        if (!validCube) {
            //set each face in mesh to be an invalid face. (all fields 0.000).
            for (int i = 0; i < mesh.length ; i++) {
                mesh[i] = new Face( new Triangle(), new Triangle());
            }

        }

    }
    public Cube() {
        this.mesh = new Face[6];
        //set each face in mesh to be an invalid face. (all fields 0.000).
        for (int i = 0; i < mesh.length ; i++) {
            mesh[i] = new Face( new Triangle(), new Triangle());
        }

    }
    //Methods
    public Face[] getMesh() {
        return mesh;

    }
    public String toString() {
        //If any face is invalid, the toString() method should return:|InvalidCube|
        if (Arrays.toString(this.mesh).contains( "{InvalidFace}" )) {
            return "|InvalidCube|";
        }
        StringBuilder cubeToString = new StringBuilder("|C");
        for (Face perFace : mesh) {
            cubeToString.append( perFace.toString() );
        }
        //at the end, add the|
        cubeToString.append( "|" );

        return cubeToString.toString();

    }
    //methods used in constructor
    private boolean shareEdge(Face a, Face b) {
        //use mesh in face to get triangle, because in face.java mesh is tri
        Triangle[] triInFaceA = a.getMesh(); //should be 2 tri there
        Triangle[] triInFaceB = b.getMesh();

        for (Triangle perTriInFaceA : triInFaceA) {
            Point[] verticesPerTriA = perTriInFaceA.getVertices(); //get per tri in face A'a all vertices, should be 3
            for (Triangle perTriInFaceB : triInFaceB) {
                Point[] verticesPerTriB = perTriInFaceB.getVertices(); //get per tri in face B'a all vertices,
                // one tri should be 3,total loop should be 6, those two faces should be 8(minus the shared vertex)

                //time to loop all the vertices to check the count of shared vertices
                int sharedVertices = 0;
                for (Point vertexA : verticesPerTriA) {
                    for (Point vertexB: verticesPerTriB) {
                        if (vertexA.equals( vertexB )) {
                            sharedVertices++;
                        }
                    }
                }
                if (sharedVertices == 2) { //这是两个点确定一个线
                    //two shared pints means one shareEdge for PER tri in the faces
                    return true;
                }
            }
        }
        //otherwise, no shared edge
        return false;
    }



}
