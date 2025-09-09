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
public class Triangle {
    //A Triangle is comprised of 3 Vertices (Points) and
    // a "Surface Normal" in this case a UnitVector.

    //Fields
    private Point vertexA; //三角形的第一个顶点。
    private Point vertexB; //2
    private Point vertexC; //3
    private UnitVector surfaceNormal; //这个三角形的表面法线。

    //Constructor
    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        //构造一个新分配的Triangle对象，并将字段实例化为它们各自的参数。
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;

        //将单位向量表示为从A到B的向量(从A到B)和从A到C的向量(从A到C)的叉乘。
        UnitVector ab = new UnitVector((vertexB.getX() - vertexA.getX()),
                (vertexB.getY() - vertexA.getY()), (vertexB.getZ() - vertexA.getZ()));

        UnitVector ac = new UnitVector((vertexC.getX() - vertexA.getX()),
                (vertexC.getY()) - vertexA.getY() , (vertexC.getZ()) - vertexA.getZ());

        //ross product of the vector AB( B-A) & AC (C-A)
        this.surfaceNormal = ab.crossProduct( ac );

       //check surfaceNormal 的逻辑 是否valid ???
        //final double precision = 0.0001;

    }
    public Triangle() {
        //Construct a newly allocated Triangle object and instantiate
        //All vertices should be (x0.000, y0.000, z0.000)
        this.vertexA =  new Point(0.000, 0.000, 0.000);
        this.vertexB =  new Point(0.000, 0.000, 0.000);
        this.vertexC =  new Point(0.000, 0.000, 0.000);

        //The surfaceNormal should be invalid (all fields 0.000)
        //invalid
        this.surfaceNormal = new UnitVector(0.000, 0.000, 0.000);


    }
    //Methods


    public Point getVertexA() { //返回代表三角形顶点A的点。
        return vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }
    //返回一个代表三角形的点数组。
    //数组索引0应该是顶点a, 1应该是顶点b, 2应该是顶点c。
    public Point[] getVertices() {
        Point[] vertices = new Point[3];
        vertices[0] = this.vertexA;
        vertices[1] = this.vertexB;
        vertices[2] = this.vertexC;

        return vertices;
    }
    public boolean equals(Triangle triangle) {
        //If ALL vertices and surfaceNormal are equal then return true, otherwise return false.
        if (triangle == null) {
            return false;
        }
        if (this == triangle) {
            return true;
        }
        final double precision = 0.0001;
        return  Math.abs(this.vertexA.getX() - triangle.vertexA.getX()  ) < precision &&
                Math.abs(this.vertexA.getY() - triangle.vertexA.getY()) < precision &&
                Math.abs(this.vertexA.getZ() - triangle.vertexA.getZ() ) < precision &&
                Math.abs(this.vertexB.getX() - triangle.vertexB.getX() ) < precision &&
                Math.abs(this.vertexB.getY() - triangle.vertexB.getY() ) < precision &&
                Math.abs(this.vertexB.getZ() - triangle.vertexB.getZ() ) < precision &&
                Math.abs(this.vertexC.getX() - triangle.vertexC.getX() ) < precision &&
                Math.abs(this.vertexC.getY() - triangle.vertexC.getY() ) < precision &&
                Math.abs(this.vertexC.getZ() - triangle.vertexC.getZ() ) < precision &&
                Math.abs(this.surfaceNormal.getI() - triangle.surfaceNormal.getI() ) < precision &&
                Math.abs(this.surfaceNormal.getJ() - triangle.surfaceNormal.getJ() ) < precision &&
                Math.abs(this.surfaceNormal.getK() - triangle.surfaceNormal.getK() ) < precision;

        //surprise

    }
    public String toString() {
        //not contain 3 unique vertices
        //toString() should return: [InvalidTriangle]
        if (vertexA.equals( vertexB ) || vertexA.equals( vertexC ) || vertexB.equals( vertexC )) {
            return "[InvalidTriangle]";
        } else if (vertexA.toString().equals( "<InvalidUnitVector>" ) ||
                vertexB.toString().equals( "<InvalidUnitVector" +
                ">" ) || vertexC.toString().equals( "<InvalidUnitVector>" ) ) {
            // or the unit vector is invalid
            return "[InvalidTriangle]";
        } else {
            //Returns the String representation of this Triangle.
            //The result of calling toString() would be:
            //[A(x0.000, y0.000, z1.000);
            // B(x1.000, y-1.000, z1.000);
            // C(x1.000, y0.000, z1.000);
            // N<0.000i, 0.000j, 1.000k>]

            //point (vertex):(x1.000, y2.000, z0.000)
            //unit vector(surface normal):/<0.816i, 0.408j, 0.408k>
            return String.format( "[A%s; B%s; C%s; N%s]" , vertexA, vertexB, vertexC, this.getSurfaceNormal());
        }
    }
}
