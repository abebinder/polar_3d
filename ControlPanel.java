import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

/*
 * Class that has the gui the user interacts with to change what is drawn. Made in windowbuilder
 * so hard to read.
 */

class ControlPanel extends JPanel implements ChangeListener,ActionListener
 {
 	PolarCanvas cPanel;
	private JTextField pxField;
	private JTextField pyField;
	private JTextField pzField;
	private JTextField zDirField;
	private JTextField xDirField;
	private JTextField yDirField;
	private JLabel plusLabel;
	private JLabel tLabel;
	private JButton noCameraRotation;
	private JButton rotateCameraAroundY;
	private JLabel lblCustomVectorAngle;
	private JPanel panel_3;
	private JTextArea txtrUseTheSlider;
	private JButton drawFormulaOneButton;
	private JButton drawFormulaTwoButton;
	private JButton drawFormula3Button;
	private JButton rotateCameraAroundX;
	private JButton rotateCameraAroundZ;
	private JButton drawFormulaFourButton;
	private JButton drawFormulaFiveButton;
	private JButton drawFormulaSixButton;
	private JButton drawFormulaSevenButton;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton drawAroundXAxis;
	private JButton drawAroundZ;
	private JButton drawAroundY;
	private JButton btnDrawFigureNormally;
	private JButton btnDrawCustomFormula;
	private JPanel panel_6;
	private JLabel lblNewLabel;
	private JTextField txtCosx;
	private JButton btnDrawFigureAround;
	private JLabel lblDraw;
	private JLabel lblAxis;
	private JLabel lblCamera;
	private JLabel lblCustomVectorAdjuster;
	private JLabel lblCustomFormulaDraw;
 
 	public ControlPanel(PolarCanvas cp)
	{
		cPanel=cp;
		setLayout(new BorderLayout(0, 0));
		JPanel r = new JPanel();
		add(r, BorderLayout.WEST);
		r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
		
		drawFormulaOneButton = new JButton("Draw Formula 1");
		drawFormulaOneButton.addActionListener(this);
		
		lblDraw = new JLabel("Draw");
		r.add(lblDraw);
		r.add(drawFormulaOneButton);
		
		drawFormulaTwoButton = new JButton("Draw Formula 2");
		drawFormulaTwoButton.addActionListener(this);
		r.add(drawFormulaTwoButton);
		
		drawFormula3Button = new JButton("Draw Formula 3");
		drawFormula3Button.addActionListener(this);
		r.add(drawFormula3Button);
		
		drawFormulaFourButton = new JButton("Draw Formula 4");
		drawFormulaFourButton.addActionListener(this);
		r.add(drawFormulaFourButton);
		
		drawFormulaFiveButton = new JButton("Draw Formula 5");
		drawFormulaFiveButton.addActionListener(this);
		r.add(drawFormulaFiveButton);
		
		drawFormulaSixButton = new JButton("Draw Formula 6");
		drawFormulaSixButton.addActionListener(this);
		r.add(drawFormulaSixButton);
		
		drawFormulaSevenButton = new JButton("Draw Formula 7");
		drawFormulaSevenButton.addActionListener(this);
		r.add(drawFormulaSevenButton);
		
		lblCustomFormulaDraw = new JLabel("Custom Formula Draw");
		r.add(lblCustomFormulaDraw);
		
		btnDrawCustomFormula = new JButton("Draw Custom Formula");
		btnDrawCustomFormula.addActionListener(this);
		r.add(btnDrawCustomFormula);
		
		panel_6 = new JPanel();
		r.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		lblNewLabel = new JLabel("r=");
		panel_6.add(lblNewLabel);
		
		txtCosx = new JTextField();
		txtCosx.setText("cos(x)");
		panel_6.add(txtCosx);
		txtCosx.setColumns(10);
		
		JPanel panel = new JPanel();
		
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		btnDrawFigureNormally = new JButton("Draw Figure Normally");
		btnDrawFigureNormally.addActionListener(this);
		
		lblAxis = new JLabel("Axis");
		panel_5.add(lblAxis);
		panel_5.add(btnDrawFigureNormally);
		
		drawAroundXAxis = new JButton("Draw Figure Around X Axis");
		drawAroundXAxis.addActionListener(this);
		panel_5.add(drawAroundXAxis);
		
		drawAroundY = new JButton("Draw Figure Around Y Axis");
		drawAroundY.addActionListener(this);
		panel_5.add(drawAroundY);
		
		drawAroundZ = new JButton("Draw Figure Around Z Axis");
		drawAroundZ.addActionListener(this);
		panel_5.add(drawAroundZ);
		
		btnDrawFigureAround = new JButton("Draw Figure Around Custom Axis");
		btnDrawFigureAround.addActionListener(this);
		panel_5.add(btnDrawFigureAround);
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		lblCamera = new JLabel("Camera");
		panel_4.add(lblCamera);
		
		noCameraRotation = new JButton("No Camera Rotation");
		panel_4.add(noCameraRotation);
		noCameraRotation.addActionListener(this);
		
		rotateCameraAroundX = new JButton("Rotate camera around X Axis");
		panel_4.add(rotateCameraAroundX);
		rotateCameraAroundX.addActionListener(this);
		
		
		
		rotateCameraAroundY = new JButton("Rotate Camera Around Y Axis");
		panel_4.add(rotateCameraAroundY);
		rotateCameraAroundY.addActionListener(this);
		
		rotateCameraAroundZ = new JButton("Rotate Camera Around Z Axis");
		panel_4.add(rotateCameraAroundZ);
		rotateCameraAroundZ.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		lblCustomVectorAdjuster = new JLabel("Custom Vector Adjuster");
		panel_3.add(lblCustomVectorAdjuster, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 4, 0, 0));
		
		pxField = new JTextField();
		pxField.setText("0");
		panel_2.add(pxField);
		pxField.setColumns(10);
		
		pyField = new JTextField();
		pyField.setText("0");
		panel_2.add(pyField);
		pyField.setColumns(10);
		
		pzField = new JTextField();
		pzField.setText("0");
		panel_2.add(pzField);
		pzField.setColumns(10);
		
		plusLabel = new JLabel("+");
		panel_2.add(plusLabel);
		
		xDirField = new JTextField();
		xDirField.setText("1");
		panel_2.add(xDirField);
		xDirField.setColumns(10);
		
		yDirField = new JTextField();
		yDirField.setText("1");
		panel_2.add(yDirField);
		yDirField.setColumns(10);
		
		zDirField = new JTextField();
		zDirField.setText("1");
		panel_2.add(zDirField);
		zDirField.setColumns(10);
		
		tLabel = new JLabel("t");
		panel_2.add(tLabel);
		
		lblCustomVectorAngle = new JLabel("Help");
		panel_1.add(lblCustomVectorAngle, BorderLayout.NORTH);
		
		txtrUseTheSlider = new JTextArea();
		txtrUseTheSlider.setLineWrap(true);
		txtrUseTheSlider.setWrapStyleWord(true);
		txtrUseTheSlider.setText("Welcome to the polar equation 3d rotate around axis grapher thingy."
				+ "Use the draw formula buttons on the left to select premade polar equations to draw "
				+ "onto the screen. They are, in order: \n 1. r= Cos(3*θ) \n 2. r=aθ \n 3. r=a(1+cos(θ)) and r=a(1+2cos(θ))"
				+ "\n 4. r^8=cos(3θ) \n 5. r=1+2cos(4θ) and r=1+2cos(3θ) \n 6. r=e^cos(θ) -2cos(4θ)+((sin(θ/12))^5"
				+ "\n 7. r=e^sin(θ) -2cos(4θ)+((cos(θ/4))^3"
				+ " \n You can also enter your own equation in the textbox next to r=, just make sure "
				+ "to format the equation using \"x\" as a substitute for theta "
				+ "and in proper javaluator formatting ex: \" cos(4*x)\""
				+" When you are done, press draw"
				+ "custom equation button and it will attempt to interpert your equation and draw it. Use the draw around "
				+ "axis buttons to choose which axis the figure is draw around. By default, it will be drawn on the xy plane, "
				+ "but the figures are much more interesting when drawn around an axis. You can input a custom axis "
				+ "for the figure to be rotated around using the textboxes on the bottom. Fill them in and click "
				+ "rotate around custom axis to do this. Finally, rotate the  camera while drawing to observe the "
				+ "3 dimensionality of the figures. They are mathematically facinating!"
				+ "");
		txtrUseTheSlider.setEditable(false);
		panel_1.add(txtrUseTheSlider, BorderLayout.CENTER);
    
   }
   
   public void stateChanged(ChangeEvent ev) //sets the slider values to their appropriate attributes in CubePanel
   {
	 
	 }
   
   public void actionPerformed(ActionEvent e){
	   /*
	    * depending on what rotatefig is equal to, the figure will be drawn around some axis.
	    */
	   if((JButton)e.getSource()==btnDrawFigureNormally){
		   cPanel.drawer.rotateFig=0;
	   }
	   if((JButton)e.getSource()==drawAroundXAxis){
		   cPanel.drawer.rotateFig=1;
	   }
	   if((JButton)e.getSource()==drawAroundY){
		   cPanel.drawer.rotateFig=2;
	   }
	   if((JButton)e.getSource()==drawAroundZ){
		   cPanel.drawer.rotateFig=3;
	   }
	   if((JButton)e.getSource()==btnDrawFigureAround){
		   cPanel.drawer.arbitraryx0=Double.parseDouble(pxField.getText());
		   cPanel.drawer.arbitraryy0=Double.parseDouble(pyField.getText());
		   cPanel.drawer.arbitraryz0=Double.parseDouble(pzField.getText());
		   cPanel.drawer.arbitraryxdir=Double.parseDouble(xDirField.getText());
		   cPanel.drawer.arbitraryydir=Double.parseDouble(yDirField.getText());
		   cPanel.drawer.arbitraryzdir=Double.parseDouble(zDirField.getText());


		   cPanel.drawer.rotateFig=4;
	   }
	   
	   /*
	    * depending on the value rotateCamera is, the whole figure will or will not be rotated
	    * by some angle after all points are established. 
	    */
	   if((JButton)e.getSource()==noCameraRotation){
		   cPanel.drawer.rotateCamera=0;
	   }
	   if((JButton)e.getSource()==rotateCameraAroundX){
		   cPanel.drawer.rotateCamera=1;
	   }
	   if((JButton)e.getSource()==rotateCameraAroundY){
		   cPanel.drawer.rotateCamera=2;
	   }
	   if((JButton)e.getSource()==rotateCameraAroundZ){
		   cPanel.drawer.rotateCamera=3;
	   }
	  
	   
	   
	   /*
	    * changes the polar formula that is drawn.
	    */
	   if((JButton)e.getSource()==drawFormulaOneButton){
		   cPanel.whichToDraw=1;
	   }
	   else if((JButton)e.getSource()==drawFormulaTwoButton){
		   cPanel.whichToDraw=2;
	   }
	   else if((JButton)e.getSource()==drawFormula3Button){
		   cPanel.whichToDraw=3;
	   }
	   else if((JButton)e.getSource()==drawFormulaFourButton){
		   cPanel.whichToDraw=4;
	   }
	   else if((JButton)e.getSource()==drawFormulaFiveButton){
		   cPanel.whichToDraw=5;
	   }
	   else if((JButton)e.getSource()==drawFormulaSixButton){
		   cPanel.whichToDraw=6;
	   }
	   else if((JButton)e.getSource()==drawFormulaSevenButton){
		   cPanel.whichToDraw=7;
	   }
	   else if((JButton)e.getSource()==btnDrawCustomFormula){
		   cPanel.drawer.equation=txtCosx.getText();
		   cPanel.whichToDraw=8;
	   }
	   


   }

}