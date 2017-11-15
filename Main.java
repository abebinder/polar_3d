
/*
 * The main class houses the two panels, connects them, and runs the loop with the sleep timer that 
 * causes animation.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import javax.swing.*;

public class Main
{
   
    

    public static void main(String[] args){
		PolarCanvas myCanvas = new PolarCanvas();
		ControlPanel cpanel=new ControlPanel(myCanvas);
		JFrame myFrame = new JFrame();
		myFrame.setTitle("Trip Balls");
		myFrame.setSize(300,300);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp=myFrame.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(myCanvas, BorderLayout.CENTER);
		cp.add(cpanel,BorderLayout.EAST);
		myFrame.pack(); 
		myFrame.setResizable(true);
		myFrame.setVisible(true);
		
		/*
		 * Loop that has the sleep command which causes a feeling of animation. Must be out 
		 * here and not in paintComponenet
		 */
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
		}
		
    }
} 


