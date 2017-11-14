import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class FormulaDrawer {
	PolarCanvas pCanvas;
	MatrixUtils utils;
	int rotateCamera;

	FormulaDrawer(PolarCanvas pCanvas){
		this.pCanvas=pCanvas;
		utils=new MatrixUtils();
		rotateCamera=0;
	}
	
	
	void drawFormula7(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){
			double threedtheta=((double)i/1000)*2*Math.PI;

			double theta=((double)i/1000)*8*Math.PI;
			double r=Math.pow(Math.E, Math.cos(theta))-2*Math.cos(4*theta)+Math.pow(Math.cos(theta/4.0),3.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundZ(next, threedtheta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	
	
	
	void drawFormula6(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*24*Math.PI;
			double threedtheta=((double)i/1000)*2*Math.PI;
			double r=Math.pow(Math.E,(double) Math.cos(theta))-2*Math.cos(4*theta)+Math.pow(Math.sin(theta/12),5.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundY(next, threedtheta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	
	
	void drawFormula5Helper2(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double r=1+2*Math.cos(3*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundZ(next, theta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);
	
	}
	
	
	void drawFormula5Helper1(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<pCanvas.iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double r=1+2*Math.cos(4*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundZ(next, theta);
			three_list.add(next);;
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
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
			//next=utils.rotateAroundZ(next, theta);
			three_list.add(next);;
			}
			else if(d<0){
				Point3D next = new Point3D(0, 0,0);
				//next=utils.rotateAroundZ(next, theta);
				three_list.add(next);
			
			}
		}
		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, 100);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
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
			if(i==0&&pCanvas.iterations==400){
				System.out.println("debug");
			}
			//next=utils.rotateAroundZ(next, theta);
			three_list.add(next);
			
			}
			else if(d<0){
				Point3D next = new Point3D(0, 0,0);
				//next=utils.rotateAroundZ(next, theta);
				three_list.add(next);
			
			}
		
		}

		three_list=CameraRotate(three_list);
		utils.scalePoint3D(three_list, 100);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
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
				next=utils.rotateAroundX(next, theta);
				three_list.add(next);
			}
			three_list=CameraRotate(three_list);
			utils.scalePoint3D(three_list, 10);
			p_list = utils.convert3DPointsTo2DPoints(three_list, 500);
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
				next=utils.rotateAroundX(next, theta);
				three_list.add(next);
			}
			three_list=CameraRotate(three_list);
			utils.scalePoint3D(three_list, 50);
			p_list = utils.convert3DPointsTo2DPoints(three_list, 500);
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
				next=utils.rotateAroundY(next, theta);
				three_list.add(next);
			}
			three_list=CameraRotate(three_list);
			utils.scalePoint3D(three_list, 10);
			p_list=utils.convert3DPointsTo2DPoints(three_list, 5000);
			drawPointArr(g2d, p_list);
		}
		



	}

	
	
	
	ArrayList<Point3D> CameraRotate(ArrayList<Point3D>three_list){
		double theta=((double)pCanvas.iterations/1000)*2*Math.PI;
		if(rotateCamera==1){
			three_list=utils.rotateAllPointsAroundX((ArrayList<Point3D>)three_list.clone(), -theta);

		}
		if(rotateCamera==2){
		three_list=utils.rotateAllPointsAroundY((ArrayList<Point3D>)three_list.clone(), -theta);
		}
		if(rotateCamera==3){
			three_list=utils.rotateAllPointsAroundZ((ArrayList<Point3D>)three_list.clone(), -theta);

		}
		return three_list;
	}
	
	

	void drawFormula1(Graphics2D g2d){
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();

		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		double theta;
		
		for(int i=0; i<pCanvas.iterations; i++){

			theta=((double)i/1000)*2*Math.PI;
			double r=Math.cos(3*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundY(next, theta);
			//next=utils.rotateAroundX(next, Math.toRadians(30));
			if(i==998){
				System.out.println("d");
			}
			three_list.add(next);
			
		}
			three_list=CameraRotate(three_list);
			
			utils.scalePoint3D(three_list,100);
			p_list=utils.convert3DPointsTo2DPoints(three_list, 5000);
			drawPointArr(g2d, p_list);
		



	}



	

	void drawPointArr(Graphics2D g2d, ArrayList<Point2D.Double> l){
		for(int i=0; i<l.size()-1; i++){
			Line2D.Double line=new Line2D.Double(l.get(i), l.get(i+1));
			g2d.draw(line);
		}

	}

}
