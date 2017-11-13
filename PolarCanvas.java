
/**
 * SimpleCanvas.java
 *
 * Part of the basic graphics Template.
 *
 */

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;


public class PolarCanvas extends JPanel implements MouseListener
{
	Color myColor;
	MatrixUtils utils;
	Line2D.Double myLine;
	int iterations;
	int paint_num;
	public PolarCanvas ()
	{
		utils=new MatrixUtils();
		//The following is another way to guarantee correct size.	 
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.lightGray);
		addMouseListener(this);
		iterations=0;
		paint_num=5;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  //without this no background color set.

		Graphics2D g2d = (Graphics2D)g; //cast so we can use JAVA2D.
		g2d.translate(getWidth()/2,getHeight()/2);
		g2d.scale(1, -1);
		ArrayList<Point2D.Double>p_list=new ArrayList<Point2D.Double>();	
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();
		
		drawFormula7(g2d);
		

	}
	
	
	
	

	
	
	
	
	void drawFormula7(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<iterations; i++){
			double threedtheta=((double)i/1000)*2*Math.PI;

			double theta=((double)i/1000)*8*Math.PI;
			double r=Math.pow(Math.E, Math.cos(theta))-2*Math.cos(4*theta)+Math.pow(Math.cos(theta/4.0),3.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundZ(next, threedtheta);
			three_list.add(next);;
		}
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	
	
	
	void drawFormula6(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<iterations; i++){

			double theta=((double)i/1000)*24*Math.PI;
			double threedtheta=((double)i/1000)*2*Math.PI;

			double r=Math.pow(Math.E,(double) Math.cos(theta))-2*Math.cos(4*theta)+Math.pow(Math.sin(theta/12),5.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundY(next, threedtheta);
			three_list.add(next);;
		}
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	
	
	void drawFormula5Helper2(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double r=1+2*Math.cos(3*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundZ(next, theta);
			three_list.add(next);;
		}
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);
	
	}
	
	
	void drawFormula5Helper1(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double r=1+2*Math.cos(4*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundZ(next, theta);
			three_list.add(next);;
		}
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);
	
	}
	
	
	
	
	void drawFormula4Helper1(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double d =Math.cos(3*theta);
			
			if(d>=0){
			double r=-Math.pow(d, 1/8.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundY(next, theta);
			three_list.add(next);;
			}
			else if(d<0){
				Point3D next = new Point3D(0, 0,0);
				next=utils.rotateAroundY(next, theta);
				three_list.add(next);
			
			}
		}
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);



	}
	
	
	
	void drawFormula4Helper2(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D> three_list=new ArrayList<Point3D>();

		for(int i=0; i<iterations; i++){

			double theta=((double)i/1000)*2*Math.PI;
			double d =Math.cos(3*theta);
			
			if(d>=0){
			double r=Math.pow(d, 1/8.0);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundY(next, theta);
			three_list.add(next);
			
			}
			else if(d<0){
				Point3D next = new Point3D(0, 0,0);
				next=utils.rotateAroundY(next, theta);
				three_list.add(next);
			
			}
		}
		utils.scalePoint3D(three_list, 50);
		p_list=utils.convert3DPointsTo2DPoints(three_list, 500);
		drawPointArr(g2d, p_list);



	}
	
	
	
	
	
	void drawFormula3Helper1(Graphics2D g2d){
		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();

		for (int a = 0; a < 10; a++) {
			p_list=new ArrayList<Point2D.Double>();
			three_list=new ArrayList<Point3D>();

			for (int i = 0; i < iterations; i++) {

				double theta = ((double) i / 1000) * 2 * Math.PI;
				double r = a*(1+2*Math.cos(theta));
				Point3D next = new Point3D(r * Math.cos(theta), r * Math.sin(theta),0.0);
				next=utils.rotateAroundY(next, theta);
				three_list.add(next);
			}
			utils.scalePoint3D(three_list, 20);
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
			for (int i = 0; i < iterations; i++) {

				double theta = ((double) i / 1000) * 2 * Math.PI;
				double r = a*(1+Math.cos(theta));
				Point3D next = new Point3D(r * Math.cos(theta), r * Math.sin(theta),0.0);
				next=utils.rotateAroundY(next, theta);
				three_list.add(next);
			}
			utils.scalePoint3D(three_list, 1);
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
			for (int i = 0; i < iterations; i++) {

				double theta = ((double) i / 1000) * 2 * Math.PI;
				double r = a*theta;
				Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
				next=utils.rotateAroundY(next, theta);
				three_list.add(next);
			}
			utils.scalePoint3D(three_list, 10);
			p_list=utils.convert3DPointsTo2DPoints(three_list, 5000);
			drawPointArr(g2d, p_list);
		}



	}

	
	
	
	
	
	

	void drawFormula1(Graphics2D g2d){
		ArrayList<Point3D>three_list=new ArrayList<Point3D>();

		ArrayList<Point2D.Double> p_list= new ArrayList<Point2D.Double>();
		double theta;
		
		for(int i=0; i<iterations; i++){

			theta=((double)i/1000)*2*Math.PI;
			double r=Math.cos(3*theta);
			Point3D next= new Point3D(r*Math.cos(theta), r*Math.sin(theta),0.0);
			next=utils.rotateAroundX(next, theta);
			if(i==998){
				System.out.println("d");
			}
			three_list.add(next);
			
		}
			utils.scalePoint3D(three_list,100);
			p_list=utils.convert3DPointsTo2DPoints(three_list, 5000);
			drawPointArr(g2d, p_list);
		



	}



	ArrayList<Point2D.Double> scalePointArr(int scale, ArrayList<Point2D.Double> l){
		for(int i=0; i<l.size(); i++){
			Point2D.Double p=l.get(i);
			p.x=p.getX()*scale;
			p.y=p.getY()*scale;
		}
		return l;
	}

	void drawPointArr(Graphics2D g2d, ArrayList<Point2D.Double> l){
		for(int i=0; i<l.size()-1; i++){
			Line2D.Double line=new Line2D.Double(l.get(i), l.get(i+1));
			g2d.draw(line);
		}

	}




	public void mouseClicked(MouseEvent e)
	{

	}

	//Empty methods to satisfy MouseListener interface
	public void mouseEntered(MouseEvent e){}

	public void mouseExited(MouseEvent e){}

	public void mousePressed(MouseEvent e){}

	public void mouseReleased(MouseEvent e){}





}// SimpleCanvas
