public class RunLocalTest {

    public static void main(String[] args) {
        testTriangle();
        testFace();
        testCube();
        testUnitVector();
    }

    private static void testTriangle() {
        Triangle triangle = new Triangle(new Point(0.000, 0.000, 1.000), new Point(1.000, -1.000, 1.000), new Point(1.000, 0.000, 1.000));
        String expected = "[A(x0.000, y0.000, z1.000); B(x1.000, y-1.000, z1.000); C(x1.000, y0.000, z1.000); N<0.000i, 0.000j, 1.000k>]";
        assert triangle.toString().equals(expected) : "Triangle test failed";
        System.out.println("Triangle test passed.");


        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0, 1, 0);
        Triangle validTriangle = new Triangle(a, b, c);
        System.out.println("Testing valid Triangle: " + validTriangle);

        Triangle invalidTriangle = new Triangle(a, a, a);  // Invalid: All points are the same
        System.out.println("Testing invalid Triangle: " + invalidTriangle);

    }

    private static void testFace() {
//        Triangle t1 = new Triangle(new Point(0.000, 0.000, 1.000), new Point(1.000, -1.000, 1.000), new Point(1.000, 0.000, 1.000));
//        Triangle t2 = new Triangle(new Point(0.000, 0.000, 1.000), new Point(0.000, -1.000, 1.000), new Point(1.000, -1.000, 1.000));
//        Face face = new Face(t1, t2);
//        String expected = "{F[A(x0.000, y0.000, z1.000); B(x1.000, y-1.000, z1.000); C(x1.000, y0.000, z1.000)] [A(x0.000, y0.000, z1.000); B(x0.000, y-1.000, z1.000); C(x1.000, y-1.000, z1.000)] N<0.000i, 0.000j, 1.000k>}";
//        assert face.toString().equals(expected) : "Face test failed";
//        System.out.println("Face test passed.");
//
//        Triangle t3 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0));
//        Triangle t4 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0));
//        Face validFace = new Face(t3, t4);
//        System.out.println("Testing valid Face: " + validFace);
//
//        Triangle t5 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0));
//        Face invalidFace = new Face(t3, t5);  // Invalid: Triangles do not share two vertices
//        System.out.println("Testing invalid Face: " + invalidFace);
//        Triangle t1 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0));
//        Triangle t2 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0));
//        Face validFace = new Face(t1, t2);
//        System.out.println("Testing valid Face: " + validFace);
//
//        Triangle t3 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0));
//        Face invalidFace = new Face(t1, t3);  // Invalid: Triangles do not share two vertices
//        System.out.println("Testing invalid Face: " + invalidFace);
        Triangle t1 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0));
        Triangle t2 = new Triangle(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0));
        Face validFace = new Face(t1, t2);
        System.out.println("Testing valid Face: " + validFace);

        Triangle t3 = new Triangle(new Point(1, 0, 0), new Point(1, 0, 0), new Point(1, 1, 0));
        Face invalidFace = new Face(t1, t3); // Invalid: Triangles do not share two vertices
        System.out.println("Testing invalid Face: " + invalidFace);
    }

    private static void testCube() {
        // Initialize the Faces based on the provided specifications
        Face f1 = new Face(
                new Triangle(new Point(0.000, 0.000, 1.000), new Point(1.000, -1.000, 1.000), new Point(1.000, 0.000, 1.000)),
                new Triangle(new Point(0.000, 0.000, 1.000), new Point(0.000, -1.000, 1.000), new Point(1.000, -1.000, 1.000))
        );
        Face f2 = new Face(
                new Triangle(new Point(0.000, -1.000, 1.000), new Point(0.000, 0.000, 1.000), new Point(0.000, 0.000,
                        0.000)),
                new Triangle(new Point(0.000, -1.000, 1.000), new Point(0.000, 0.000, 0.000), new Point(0.000, -1.000
                        , 0.000))
        );
        Face f3 = new Face(
                new Triangle(new Point(1.000, -1.000, 1.000), new Point(0.000, -1.000, 1.000), new Point(0.000, -1.000,
                        0.000)),
                new Triangle(new Point(1.000, -1.000, 1.000), new Point(0.000, -1.000, 0.000), new Point(1.000, -1.000
                        , 0.000))
        );
        Face f4 = new Face(
                new Triangle(new Point(1.000, -1.000, 0.000), new Point(0.000, 0.000, 0.000), new Point(1.000, 0.000,
                        0.000)),
                new Triangle(new Point(1.000, -1.000, 0.000), new Point(0.000, -1.000, 0.000), new Point(0.000, 0.000
                        , 0.000))
        );
        Face f5 = new Face(
                new Triangle(new Point(1.000, 0.000, 0.000), new Point(1.000, 0.000, 1.000), new Point(1.000, -1.000,
                        1.000)),
                new Triangle(new Point(1.000, 0.000, 0.000), new Point(1.000, -1.000, 1.000), new Point(1.000, -1.000
                        , 0.000))
        );
        Face f6 = new Face(
                new Triangle(new Point(0.000, 0.000, 0.000), new Point(0.000, 0.000, 1.000), new Point(1.000, 0.000,
                        1.000)),
                new Triangle(new Point(0.000, 0.000, 0.000), new Point(1.000, 0.000, 1.000), new Point(1.000, 0.000
                        , 0.000))
        );


        // Similarly initialize other Faces (f2, f3, f4, f5, f6) with respective points and triangles

        Cube cube = new Cube(f1, f2, f3, f4, f5, f6); // Simplification: in real case, use different faces as needed
        String expected = "|C{F[A(x0.000, y0.000, z1.000); B(x1.000, y-1.000, z1.000); C(x1.000, y0.000, z1.000)] [A" +
                "(x0.000, y0.000, z1.000); B(x0.000, y-1.000, z1.000); C(x1.000, y-1.000, z1.000)] N<-0.000i, 0.000j, 1.000k>}{F[A(x0.000, y-1.000, z1.000); B(x0.000, y0.000, z1.000); C(x0.000, y0.000, z0.000)] [A(x0.000, y-1.000, z1.000); B(x0.000, y0.000, z0.000); C(x0.000, y-1.000, z0.000)] N<-1.000i, -0.000j, -0.000k>}{F[A(x1.000, y-1.000, z1.000); B(x0.000, y-1.000, z1.000); C(x0.000, y-1.000, z0.000)] [A(x1.000, y-1.000, z1.000); B(x0.000, y-1.000, z0.000); C(x1.000, y-1.000, z0.000)] N<-0.000i, -1.000j, 0.000k>}{F[A(x1.000, y-1.000, z0.000); B(x0.000, y0.000, z0.000); C(x1.000, y0.000, z0.000)] [A(x1.000, y-1.000, z0.000); B(x0.000, y-1.000, z0.000); C(x0.000, y0.000, z0.000)] N<-0.000i, -0.000j, -1.000k>}{F[A(x1.000, y0.000, z0.000); B(x1.000, y0.000, z1.000); C(x1.000, y-1.000, z1.000)] [A(x1.000, y0.000, z0.000); B(x1.000, y-1.000, z1.000); C(x1.000, y-1.000, z0.000)] N<1.000i, 0.000j, -0.000k>}{F[A(x0.000, y0.000, z0.000); B(x0.000, y0.000, z1.000); C(x1.000, y0.000, z1.000)] [A(x0.000, y0.000, z0.000); B(x1.000, y0.000, z1.000); C(x1.000, y0.000, z0.000)] N<-0.000i, 1.000j, -0.000k>}|";
        assert cube.toString().equals(expected) : "Cube test failed";
        System.out.println("Cube test passed.");

        Face[] faces = new Face[6];
        for (int i = 0; i < 6; i++) {
            faces[i] = new Face(new Triangle(new Point(i, 0, 0), new Point(0, i, 0), new Point(0, 0, i)),
                    new Triangle(new Point(i, i, i), new Point(i, 0, i), new Point(0, i, i)));
        }
        Cube invalidCube = new Cube(faces[0], faces[0], faces[0], faces[0], faces[0], faces[0]);  // Invalid: All faces are the same
        System.out.println("Testing invalid Cube: " + invalidCube);
    }
    private static void testUnitVector() {
        // 测试有效的单位向量
        UnitVector validVector = new UnitVector(0.5, 0.25, 0.25);
        System.out.println("Testing valid UnitVector: " + (validVector.toString().equals("<0.816i, 0.408j, 0.408k>") ? "Passed" : "Failed"));

        // 测试所有分量都为0的情况，应返回 "<InvalidUnitVector>"
        UnitVector invalidVector = new UnitVector(0.0, 0.0, 0.0);
        System.out.println("Testing invalid UnitVector: " + (invalidVector.toString().equals("<InvalidUnitVector>") ? "Passed" : "Failed"));
    }
}
