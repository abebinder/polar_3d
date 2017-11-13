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
	private JToggleButton toggleCustomVector;
	private JToggleButton toggleWireFrame;
	private JButton btnNewButton;
	private JLabel lblCustomVectorAngle;
	private JPanel panel_3;
	private JTextArea txtrUseTheSlider;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
 
 	public ControlPanel(PolarCanvas cp)
	{
		cPanel=cp;
		setLayout(new BorderLayout(0, 0));
		JPanel r = new JPanel();
		add(r, BorderLayout.WEST);
		r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
		
		btnNewButton_1 = new JButton("New button");
		r.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		r.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		r.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		toggleCustomVector = new JToggleButton("Toggle Customm Axis");
		toggleCustomVector.addActionListener(this);
		panel.add(toggleCustomVector, BorderLayout.NORTH);
		
		toggleWireFrame = new JToggleButton("Toggle Wire Frame");
		toggleWireFrame.addActionListener(this);
		panel.add(toggleWireFrame, BorderLayout.SOUTH);
		
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
	 
	  

	 }//end stateChanged
   
   public void actionPerformed(ActionEvent e){
	   

	   
	   


   }

}