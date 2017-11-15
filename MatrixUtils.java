import java.awt.geom.Point2D;
import java.util.ArrayList;



/*
 * A class that has all sorts of math and vector utilities.
 */
public class MatrixUtils {
	
	
	
	
	/*
	 * Figures out if the z componenent of the cross product of two vectors is negative.
	 * Used to figure out if a face should be painted or  not. If the z vector
	 * of the normal is the same general direction of the eye vector to the cube, don't paint it
	 *  Changed from 0 to-.1 to avoid displaying more
	 * than necessary. More art than science choosing that number, but it looks pretty good when displayed
	 */
	boolean zOfCrossNegative(double[]u, double[]v){
		double[]cross=crossProduct(u, v);
		if(cross[2]<-0.1){
			return true;
		}
		return false;
	}
	
	/*
	 * does a cross product on two vectors of length 3 (represented by double arrs)
	 *  and returns another vector
	 * of  length 3
	 */
	
	double[]crossProduct(double[]u, double[]v){
        double i = u[1] * v[2] - v[1] * u[2];
        double j = v[0] * u[2] - u[0] * v[2];
        double k = u[0] * v[1] - v[0] * u[1];
        double[]ans={i,j,k};
        return ans;
	}
	
	/*
	 * Changes a 3d point into a matrix of length 4 (length four because homogenous cooridnate) so it can be
	 * multiplied by a transformation
	 */

	public double[][] convert3DPointTo4Matrix(Point3D p){
		
		double[][]d={{p.x},{p.y},{p.z},{1}};
		return d;
	}
	
	
	
	/*
	 * changes a homogenous 4d matrix (which represents a point) into a Point3D object to put back
	 * into the point array to be drawn later
	 */
	public Point3D convert4MatrixTo3DPoint(double[][]d){
		Point3D p=new Point3D(d[0][0]/d[3][0], d[1][0]/d[3][0], d[2][0]/d[3][0]);
		return p;
	}
	
	/*
	 * rotates an arraylist of Point3Ds around an arbitrary axis
	 */
	
	ArrayList<Point3D> rotateAllPointsAroundArbitrary(ArrayList<Point3D> a, double vector_p_x, double vector_p_y, double vector_p_z, double vx, double vy, double vz, double theta){
    	ArrayList<Point3D>ans=new ArrayList<Point3D>();
    	for(int i=0; i<a.size(); i++){
    		Point3D p=a.get(i);
    		p=rotateAroundArbitraryAxis(p, vector_p_x, vector_p_y, vector_p_z, vx, vy, vz, theta);
    		ans.add(p);
    	}
    	return ans;
    }
	
	
	
	/*
	 * rotate a singular Point3D around an arbitrary axis by theta degrees. Uses an algorithim sourced from
	 * http://paulbourke.net/geometry/rotate/
	 * THIS IS A GREAT ALGORITHIM. IT REQURIES MINIMAL sin and cos calculation (just around z axis relies on
	 * sin and cos theta) and uses mainly vector math to do rotations. Not sure quite why it all works,
	 * but I know the order:
	 * 1. translates vector to origin
	 * 2. rotate around x to get to xz plane.
	 * 3. rotate around y so vector is z axis
	 * 4. rotate by theta around z axis
	 * 5. undo step 3
	 * 6. undo step 2
	 * 7. undo step 1
	 */
	Point3D rotateAroundArbitraryAxis(Point3D p, double vector_p_x, double vector_p_y, double vector_p_z, double vx, double vy, double vz, double theta){
		double v_length=Math.pow(vx, 2.0)+Math.pow(vy, 2.0)+Math.pow(vz, 2.0);
		v_length=Math.pow(v_length, 1.0/2.0);
		double a=vx/v_length; //a,b,c,d are used in the helpers and are calculated using the unit vector of direction. no idea why it works.
		double b=vy/v_length;
		double c=vz/v_length;
		double d=Math.pow(b,2.0)+Math.pow(c,2.0);
		d=Math.pow(d, 1.0/2.0);
		p=translate(p, -vector_p_x, -vector_p_y, -vector_p_z); //translates vector to origin
		if(c!=0.0||b!=0.0){ //used to avoid divide by zero error
		p=arbitraryHelperOne(p,a, b, c, d); //rotate to get on xz plane
		}
		
		p=arbitraryHelperTwo(p, a, b, c, d); //rotate around y so vector is on z axis
		
		p=rotateAroundZ(p, theta); //rotate by theta around z
		
		p=arbitraryHelperTwo(p, -a, b, c, d); //undo step 3
		
		if(c!=0.0||b!=0.0){
		p=arbitraryHelperOne(p,a,-b,c,d); //undo step 2
		}
		p=translate(p, vector_p_x, vector_p_y, vector_p_z); //translates back from origin
		return p;
	}
	
	
	/*
	 * A helper for arbitrarry axis rotation that does steps 3 and 5.
	 * Don't know why it works but it does
	 */
	Point3D arbitraryHelperTwo(Point3D p, double a, double b, double c, double d){
		double[][]arr=convert3DPointTo4Matrix(p);
		double[][]trans={{d,0,-a,0}, {0,1,0,0},{a,0,d,0},{0,0,0,1}};
		double[][]ans=multiplyMatricies(trans, arr);
		Point3D ans_point=convert4MatrixTo3DPoint(ans);
		return ans_point;
	}
	
	/*
	 * A helper for arbitrary axis rotation that does steps 2 and 6
	 * Don't know why it works but it does
	 */
	Point3D arbitraryHelperOne(Point3D p, double a, double b, double c, double d){
		double[][]arr=convert3DPointTo4Matrix(p);
		double[][]trans={{1,0,0,0}, {0,c/d,-b/d,0},{0,b/d,c/d,0},{0,0,0,1}};
		double[][]ans=multiplyMatricies(trans, arr);
		Point3D ans_point=convert4MatrixTo3DPoint(ans);
		return ans_point;
	}
	
	
	/*
	 * does a translate on a point. Used for rotation around arbitrary axis
	 * (if starting point of vector is not origin)
	 */
	Point3D translate(Point3D p ,double x,double  y,double z){
		double[][]d=convert3DPointTo4Matrix(p);
		double[][]trans={{1,0,0,x}, {0,1,0,y},{0,0,1,z},{0,0,0,1}}; //creates translation matrix
		double[][]ans=multiplyMatricies(trans, d);
		Point3D ans_point=convert4MatrixTo3DPoint(ans);
		return ans_point;
	}
	
	
	/*
	 * rotates an arraylist of points around the z axis by theta degrees
	 */
	ArrayList<Point3D> rotateAllPointsAroundZ(ArrayList<Point3D> a, double theta){
    	ArrayList<Point3D>ans=new ArrayList<Point3D>();
    	for(int i=0; i<a.size(); i++){
    		Point3D p=a.get(i);
    		p=rotateAroundZ(p,theta);
    		ans.add(p);
    	}
    	return ans;
    }
    
	/*
	 * Rotates a singular point around z axis by theta degrees by building transformation matrix
	 * and multiplying to point
	 */
	
	public Point3D rotateAroundZ(Point3D p, double theta){
		double[][]d=convert3DPointTo4Matrix(p);
		double[][]trans={{Math.cos(theta),-Math.sin(theta),0,0}, {Math.sin(theta),Math.cos(theta),0,0},{0,0,1,0},{0,0,0,1}};
		double[][]ans=multiplyMatricies(trans, d);
		Point3D ans_point=convert4MatrixTo3DPoint(ans);
		return ans_point;
	}
	
	
	
	/*
	 * rotate an arraylist of points around the y axis by theta degrees
	 */
	
	ArrayList<Point3D> rotateAllPointsAroundY(ArrayList<Point3D> a, double theta){
    	ArrayList<Point3D>ans=new ArrayList<Point3D>();
    	for(int i=0; i<a.size(); i++){
    		Point3D p=a.get(i);
    		p=rotateAroundY(p,theta);
    		ans.add(p);
    	}
    	return ans;
    }
	
	/*
	 * rotates a singular point around y axis by building transformation matrix and 
	 * multiplying by point
	 */
	public Point3D rotateAroundY(Point3D p, double theta){
		double[][]d=convert3DPointTo4Matrix(p);
		double[][]trans={{Math.cos(theta),0,Math.sin(theta),0},{0,1,0,0}, {-Math.sin(theta),0,Math.cos(theta),0},{0,0,0,1}};
		double[][]ans=multiplyMatricies(trans, d);
		Point3D ans_point=convert4MatrixTo3DPoint(ans);
		return ans_point;
	}
	
	
	
	
	/*
	 * Rotates an arraylist of points around an x axis.
	 */
	ArrayList<Point3D> rotateAllPointsAroundX(ArrayList<Point3D> a, double theta){
    	ArrayList<Point3D>ans=new ArrayList<Point3D>();
    	for(int i=0; i<a.size(); i++){
    		Point3D p=a.get(i);
    		p=rotateAroundX(p,theta);
    		ans.add(p);
    	}
    	return ans;
    }
    
	/*
	 * rotates a point around the x axis by theta degrees by creating transfomration matrix
	 * and multiplying by point
	 */
	public Point3D rotateAroundX(Point3D p, double theta){
		double[][]d=convert3DPointTo4Matrix(p);
		double[][]trans={{1,0,0,0},{0,Math.cos(theta),-Math.sin(theta),0}, {0,Math.sin(theta),Math.cos(theta),0},{0,0,0,1}};
		double[][]ans=multiplyMatricies(trans, d);
		Point3D ans_point=convert4MatrixTo3DPoint(ans);
		return ans_point;
	}
	
	
	/*
	 * Multiplies two matricies that are represented by two_demensional double arrays
	 * MAKE SURE THE DIMENSIONS ARE RIGHT OF ARRS, THIS METHOD MIGHT RETURN IF DIMENSIONS ARE OFF
	 * Note:went online to get help building this method, couldn't figure out 
	 * the triple loop
	 */
	public double[][] multiplyMatricies(double[][] firstMatrix, double[][] secondMatrix) {

        int firstRows = firstMatrix.length;
        int firstCols = firstMatrix[0].length;
        int secondRows = secondMatrix.length;
        int secondCols = secondMatrix[0].length;
        double[][] ans = new double[firstRows][secondCols];
        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < secondCols; j++) {
                ans[i][j] = 0.0;
            }
        }

        for (int i = 0; i < firstRows; i++) { 
            for (int j = 0; j < secondCols; j++) { 
                for (int k = 0; k < firstCols; k++) { 
                    ans[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return ans;
    }
	
	
	/*
	 * The method that takes a 3d point and turns it into a 3d projection using
	 * the perspective transformation
	 */
	ArrayList<Point2D.Double> convert3DPointsTo2DPoints(ArrayList<Point3D> a, double e){
		ArrayList<Point2D.Double>two_list=new ArrayList<Point2D.Double>();
    	for(int i=0; i<a.size(); i++){
			Point3D p=a.get(i);
			double x=p.x;
			double y=p.y;
			double z=p.z;
			Point2D.Double n=new Point2D.Double(x/(1-z/e), y/(1-z/e)); //<-- this is the actual transformation
			two_list.add(n);
		}
		return two_list;
	}
    
    
    /*
     * Scales as 3d point by some number
     */
    void scalePoint3D(ArrayList<Point3D> a, int scale){ 
    	for(int i=0; i<a.size(); i++){
    		a.get(i).x=a.get(i).x*scale;
    		a.get(i).y=a.get(i).y*scale;
    		a.get(i).z=a.get(i).z*scale;


    	}
    }
	
	
}
