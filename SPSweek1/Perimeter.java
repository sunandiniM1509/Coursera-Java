import edu.duke.*;
import java.io.File;
public class Perimeter {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }
    public int getNumPoints (Shape s) {
       int numPoints = 0;
       for(Point p: s.getPoints()){
           numPoints += 1;
        }
        return numPoints;
    }
    public double getAverageLength(Shape s) {
        return getPerimeter(s) / getNumPoints(s);
    }
    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > largestSide)
                largestSide = currDist;
            prevPt = currPt;
        }
        return largestSide;
    }
    public double getLargestX(Shape s) {
        int largestX = 0;
        for(Point p: s.getPoints()){
            if(p.getX() > largestX){
                System.out.println(p.getX());
                largestX = p.getX();
            }
        }
        return largestX;
    }
    public double getLargestPerimeterMultipleFiles() {
        double largestPer = 0.0;
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPer){
                largestPer = getPerimeter(s);
            }
        }
        return largestPer;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;    
        double largestPer = 0.0;
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPer){
                largestPer = getPerimeter(s);
                temp = f;
            }
        }
        return temp.getName();
    }
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLen = getAverageLength(s);
        double largestX = getLargestX(s);
        double largestSide = getLargestSide(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numPoints);
        System.out.println("average length = " + avgLen);
        System.out.println("largest X = " + largestX);
        System.out.println("largest side = " + largestSide);
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println(getFileWithLargestPerimeter());
    }
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    public static void main (String[] args) {
        Perimeter pr = new Perimeter();
        // pr.testPerimeter();
        // pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}