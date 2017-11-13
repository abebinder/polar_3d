
/**
 * BasicDraw.java
 *
 *
 * Template for beginning graphics programs.
 *
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import javax.swing.*;

public class Main
{
   
    //For this type of program, event handling determines the path of 
    //execution.  This main method "looks" like it sets up the frame
    //and then stops.

    public static void main(String[] args){
		PolarCanvas myCanvas = new PolarCanvas();
		JFrame myFrame = new JFrame();
		myFrame.setTitle("Basic Draw");
		myFrame.setSize(300,300);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp=myFrame.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(myCanvas, BorderLayout.CENTER);
		myFrame.pack(); 
		myFrame.setResizable(true);
		myFrame.setVisible(true);
		while (true) {
			for (int i = 0; i < 1000; i++) {
				myCanvas.iterations = i;
				myCanvas.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			myCanvas.paint_num++;
		}
		
    }
} // BasicDraw


