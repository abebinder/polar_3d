import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javaluator.DoubleEvaluator;
import javaluator.StaticVariableSet;


/*
 * The important class! The one that handles the math behind drawing all the figures.
 * Most Methods in this class are nearly identical. 
 * 1. Evaluate some r using a polar equation.
 * 2. Set the cartesian points to be r*cos(theta), r*sin(theta) in a four loop that draws part of the figure.
 * 3. rotate said point around the 3d axis we are drawing the figure around.
 * 4. Stick all points into a point array
 * 5. If the camera needs to be rotated, rotate all points in the point array by some value.
 * 6. Do perspective transform,
 * 7. scale
 * 8.  draw figure.
 */
public class FormulaDrawer {
	PolarCanvas pCanvas;
	MatrixUtils utils;
	int rotateCamera;
	int rotateFig;
	DoubleEvaluator eval;
	double arbitraryx0;
	double arbitraryy0;
	double arbitraryz0;
	double arbitraryxdir;
	double arbitraryydir;
	double arbitraryzdir;
	String equation;
	int eye;

	FormulaDrawer(PolarCanvas pCanvas){
		eye =5000;
		equation="cos(x)";
		eval=new DoubleEvaluator();
		this.pCanvas=pCanvas;
		utils=new MatrixUtils();
		rotateCamera=0;
		rotateFig=0;
	}
	
	/*
	 * Draws a custom polar formula using the capabilitiese of javaluator.
	 */
	void drawCustomFormula(Graphics2D g2d){
		StaticVariableSet<Double> variables = new StaticVariableSet<Double>(); //javaluator junk
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			variables.set("x", theta); //changes the variable xs value to be equal to theta
			double r=eval.evaluate(equation,variables); //evaluates the custom expression
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0); //tells what point the cartesian coord is (z always zero since normally drawn on xy plane
			next=pointRotate(next, theta); //rotates point around some axis
			three_list.add(next);; //adds to pointlist
		}
		three_list=CameraRotate(three_list); //rotates all points by some theta if camera is enabled
		utils.scalePoint3D(three_list, 100); //scales
		p_list=utils.convert3DPointsTo2DPoints(three_list, eye); //perspective transform
		drawPointArr(g2d, p_list); //draws lines betweeen consecutive points



	}
	
	
	/*
	 * these are all basically structured the same way as the one before so I won't go through them
	 * some have little adjustments to avoid getting the wrong shape. 
	 */
	void drawFormula7(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*8*Math.PI;
			double r=Math.pow(Math.E, Math.cos(theta))-2*Math.cos(4*theta)+Math.pow(Math.cos(theta/4.0),3.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=pointRotate(next, theta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, pCanvas.getWidth()/11);
		p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	
	
	
	void drawFormula6(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*24*Math.PI;
			double r=Math.pow(Math.E,(double) Math.cos(theta))-2*Math.cos(4*theta)+Math.pow(Math.sin(theta/12),5.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=pointRotate(next, theta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, pCanvas.getWidth()/11);
		p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	
	
	void drawFormula5Helper2(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double r=1+2*Math.cos(3*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=pointRotate(next, theta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, pCanvas.getWidth()/8);
		p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
		drawPointArr(g2d, p_list);
	
	}
	
	
	void drawFormula5Helper1(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double r=1+2*Math.cos(4*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=pointRotate(next, theta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, pCanvas.getWidth()/8);
		p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	void drawFormula4Helper1(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double d =Math.cos(3*theta);
			
			if(d>=0){
			double r=-Math.pow(d, 1/8.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=pointRotate(next,theta);
			three_list.add(next);;
			}
			else if(d<0){
				Point3D next = new Point3D(0, 0,0);
				next=pointRotate(next, theta);
				three_list.add(next);
			
			}
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, pCanvas.getWidth()/4);
		p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
		drawPointArr(g2d, p_list);



	}
	
	
	
	void drawFormula4Helper2(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double d =Math.cos(3*theta);
			
			if(d>=0){
			double r=Math.pow(d, 1/8.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=pointRotate(next, theta);
			three_list.add(next);
			
			}
			else if(d<0){
				Point3D next = new Point3D(0, 0,0);
				next=pointRotate(next, theta);
				three_list.add(next);
			
			}
		
		}

		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, pCanvas.getWidth()/4);
		p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
		drawPointArr(g2d, p_list);
	}
	
	
	
	
	
	void drawFormula3Helper1(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();

		for (int a = 0; a < 10; a++) {
			p_list=new ArrayList<Point2D.Double>();
			three_list=new ArrayList<Point3D>();
			double theta;
			for (int i = 0; i < pCanvas.iterations; i++) {

				 theta = ((double) i / 1000) * 2 * Math.PI;
				double r = a*(1+2*Math.cos(theta));
				Point3D next = new Point3D(r * Math.cos(theta), r * Math.sin(theta),0.0);
				next=pointRotate(next, theta);
				three_list.add(next);
			}
			three_list=CameraRotate(three_list);
			utils.scalePoint3D(three_list, 10);
			p_list = utils.convert3DPointsTo2DPoints(three_list, eye);
			drawPointArr(g2d, p_list);
		}
	}
	
	
	void drawFormula3Helper2(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();

		for (int a = 0; a < 10; a++) {
			p_list=new ArrayList<Point2D.Double>();
			three_list=new ArrayList<Point3D>();
			double theta;
			for (int i = 0; i < pCanvas.iterations; i++) {

				theta = ((double) i / 1000) * 2 * Math.PI;
				double r = a*(1+Math.cos(theta));
				Point3D next = new Point3D(r * Math.cos(theta), r * Math.sin(theta),0.0);
				next=pointRotate(next, theta);
				three_list.add(next);
			}
			three_list=CameraRotate(three_list);
			utils.scalePoint3D(three_list, 50);
			p_list = utils.convert3DPointsTo2DPoints(three_list, eye);
			drawPointArr(g2d, p_list);
		}
	}
	
	
	
	
	void drawFormula2(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();

		for (int a = 0; a < 10; a++) {
			p_list=new ArrayList<Point2D.Double>();
			three_list=new ArrayList<Point3D>();
			double theta;
			for (int i = 0; i < pCanvas.iterations; i++) {

				theta = ((double) i / 1000) * 2 * Math.PI;
				double r = a*theta;
				Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
				next=pointRotate(next, theta);
				three_list.add(next);
			}
			three_list=CameraRotate(three_list);
			utils.scalePoint3D(three_list, 10);
			p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
			drawPointArr(g2d, p_list);
		}
		



	}

	
	
	
	
	
	

	void drawFormula1(Graphics2D g2d){
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();

		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		double theta;
		
		for(int i=0; i<pCanvas.iterations; i++){

			theta=((double)i/1000)*2*Math.PI;
			double r=Math.cos(3*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=pointRotate(next, theta);
			three_list.add(next);
			
		}
			three_list=CameraRotate(three_list);
			
			utils.scalePoint3D(three_list,pCanvas.getWidth()/4);
			p_list=utils.convert3DPointsTo2DPoints(three_list, eye);
			drawPointArr(g2d, p_list);
		



	}

	/*
	 * method used to rotate a single point around an axis depending on the value of rotatefig attritbute
	 */
	
	Point3D pointRotate(Point3D next, double theta){
		if(rotateFig==1){
			next=utils.rotateAroundX(next, theta);
		}
		if(rotateFig==2){
			next=utils.rotateAroundY(next, theta);
		}
		if(rotateFig==3){
			next=utils.rotateAroundZ(next, theta);
		}
		if(rotateFig==4){
			next=utils.rotateAroundArbitraryAxis(next, arbitraryx0, arbitraryy0, arbitraryz0, arbitraryxdir, arbitraryydir, arbitraryzdir, theta);
		}
		return next;
	}

	
	/*
	 * method to make it appear like camera is rotating around figure
	 * updates theta based on iteration of animation loop we are on
	 */
	ArrayList<Point3D> CameraRotate(ArrayList<Point3D>three_list){
		double theta=((double)pCanvas.iterations/1000)*2*Math.PI; //updates theta
		if(rotateCamera==1){
			three_list=utils.rotateAllPointsAroundX(three_list, -theta);

		}
		if(rotateCamera==2){
		three_list=utils.rotateAllPointsAroundY(three_list, -theta);
		}
		if(rotateCamera==3){
			three_list=utils.rotateAllPointsAroundZ(three_list, -theta);

		}
		return three_list;
	}
	

	/*
	 * method for drawing the actual figure as a bunch of lines between consecutive points
	 */
	void drawPointArr(Graphics2D g2d, ArrayList<Point2D.Double> l){
		for(int i=0; i<l.size()-1; i++){
			Line2D.Double line=new Line2D.Double(l.get(i), l.get(i+1));
			g2d.draw(line);
		}

	}

}
