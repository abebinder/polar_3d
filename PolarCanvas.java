
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

/*
 * The canvas where the figures are drawn. Simply adjusts which formula to draw in paintcompoenent based
 * on user selction and draws it. 
 */
public class PolarCanvas extends JPanel
{
	Color myColor;
	MatrixUtils utils;
	Line2D.Double myLine;
	int iterations;
	int whichToDraw;
	FormulaDrawer drawer;
	public PolarCanvas ()
	{
		drawer=new FormulaDrawer(this);
		utils=new MatrixUtils();
		//The following is another way to guarantee correct size.	 
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.WHITE);
		iterations=0;
		whichToDraw=1;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  //without this no background color set.

		Graphics2D g2d = (Graphics2D)g; //cast so we can use JAVA2D.
		g2d.setStroke(new BasicStroke(2));
		g2d.translate(getWidth()/2,getHeight()/2);
		g2d.scale(1, -1);
		
		
		
		if(whichToDraw==1){
			drawer.drawFormula1(g2d);
		}
		else if(whichToDraw==2){
			drawer.drawFormula2(g2d);
		}
		else if(whichToDraw==3){
			drawer.drawFormula3Helper1(g2d);
			drawer.drawFormula3Helper2(g2d);
		}
		else if(whichToDraw==4){
			drawer.drawFormula4Helper1(g2d);
			drawer.drawFormula4Helper2(g2d);
		}
		else if(whichToDraw==5){
			drawer.drawFormula5Helper1(g2d);
			drawer.drawFormula5Helper2(g2d);
		}
		else if(whichToDraw==6){
			drawer.drawFormula6(g2d);
		}
		else if(whichToDraw==7){
			drawer.drawFormula7(g2d);
		}
		else if(whichToDraw==8){
			drawer.drawCustomFormula(g2d);
		}
		
		
		

	}
	




}// SimpleCanvas
