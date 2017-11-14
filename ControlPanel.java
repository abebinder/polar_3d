import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

/*
 * Class that has the gui the user interacts with to change what is drawn
 */

class ControlPanel extends JPanel implements ChangeListener,ActionListener
 {
 	PolarCanvas cPanel;
	JSlider customThetaSlider;
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
	private JButton btnNewButton;
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
 
 	public ControlPanel(PolarCanvas cp)
	{
		cPanel=cp;
		setLayout(new BorderLayout(0, 0));
		JPanel r = new JPanel();
		add(r, BorderLayout.WEST);
		r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
		
		drawFormulaOneButton = new JButton("Draw Formula 1");
		drawFormulaOneButton.addActionListener(this);
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
		
		btnDrawCustomFormula = new JButton("Draw Custom Formula");
		btnDrawCustomFormula.addActionListener(this);
		r.add(btnDrawCustomFormula);
		
		JPanel panel = new JPanel();
		
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		btnDrawFigureNormally = new JButton("Draw Figure Normally");
		btnDrawFigureNormally.addActionListener(this);
		panel_5.add(btnDrawFigureNormally);
		
		drawAroundXAxis = new JButton("Draw Figure Around X");
		drawAroundXAxis.addActionListener(this);
		panel_5.add(drawAroundXAxis);
		
		drawAroundY = new JButton("Draw Figure Around Y Axis");
		drawAroundY.addActionListener(this);
		panel_5.add(drawAroundY);
		
		drawAroundZ = new JButton("Draw Figure Around Z Axis");
		drawAroundZ.addActionListener(this);
		panel_5.add(drawAroundZ);
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		noCameraRotation = new JButton("No Camera Rotation");
		panel_4.add(noCameraRotation);
		noCameraRotation.addActionListener(this);
		
		rotateCameraAroundX = new JButton("rotate camera around x");
		panel_4.add(rotateCameraAroundX);
		rotateCameraAroundX.addActionListener(this);
		
		rotateCameraAroundZ = new JButton("Rotate Camera Around Z");
		panel_4.add(rotateCameraAroundZ);
		rotateCameraAroundZ.addActionListener(this);
		
		rotateCameraAroundY = new JButton("Rotate Camera Around Y");
		panel_4.add(rotateCameraAroundY);
		rotateCameraAroundY.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		customThetaSlider = new JSlider(SwingConstants.VERTICAL, 0, 360, 0);
		customThetaSlider.addChangeListener(this);
		customThetaSlider.setPaintTicks(true);
		customThetaSlider.setPaintLabels(true);
		customThetaSlider.setMinorTickSpacing(10);
		customThetaSlider.setMajorTickSpacing(50);
		panel_1.add(customThetaSlider, BorderLayout.WEST);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
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
		
		btnNewButton = new JButton("Input Custom Vector");
		btnNewButton.addActionListener(this);
		panel_3.add(btnNewButton, BorderLayout.EAST);
		
		lblCustomVectorAngle = new JLabel("Custom Vector Angle Adjuster");
		panel_1.add(lblCustomVectorAngle, BorderLayout.NORTH);
		
		txtrUseTheSlider = new JTextArea();
		txtrUseTheSlider.setLineWrap(true);
		txtrUseTheSlider.setWrapStyleWord(true);
		txtrUseTheSlider.setText("Use the slider on the left to change angle. Input custom vector below by typing in numbers you want and pressing input button");
		txtrUseTheSlider.setEditable(false);
		panel_1.add(txtrUseTheSlider, BorderLayout.CENTER);
    
   }
   
   public void stateChanged(ChangeEvent ev) //sets the slider values to their appropriate attributes in CubePanel
   {
	 
	 }
   
   public void actionPerformed(ActionEvent e){
	   
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
		   cPanel.whichToDraw=8;
	   }
	   


   }

}