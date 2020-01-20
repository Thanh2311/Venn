package Venn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentGenerator
	implements ActionListener{
	
	private String componentName = null;
	private JButton setC, clearC, genC;
	private JTextField tField;
	private JPanel tBar, mBar, bBar;
	
	private JFrame frame;
	
	public ComponentGenerator() {
		//test frame
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(250, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		//set text button
		setC = new JButton("set text");
		setC.addActionListener(this);
		setC.setActionCommand("set");
		
		//clear text button
		clearC = new JButton("clear text");
		clearC.addActionListener(this);
		clearC.setActionCommand("clear");
		
		//generate draggable component button
		genC = new JButton("generate item");
		genC.addActionListener(this);
		genC.setActionCommand("generate");
		
		//the textField
		tField = new JTextField();
		tField.setColumns(20);
		
		//top bar set and clear buttons
		tBar = new JPanel();
		tBar.setLayout(new FlowLayout());
		tBar.add(setC);
		tBar.add(clearC);
		
		//middle bar text field
		mBar = new JPanel();
		mBar.setLayout(new FlowLayout());
		mBar.add(tField);
		
		//bottom bar generate button
		bBar = new JPanel();
		bBar.setLayout(new FlowLayout());
		bBar.add(genC);
		
		frame.add(tBar);
		frame.add(mBar);
		frame.add(bBar);
		
		frame.pack();
		frame.setVisible(true);
		//frame.add(this);
	}
	
	
	private void generateComponent() {
		if (this.componentName == null || this.componentName.equals("")) {
			System.out.println("invalid component text");
		}else {
			System.out.println("create component with text: " + componentName);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()) {
			case("set"):
				componentName = tField.getText();
				System.out.println("component text set");
				break;
			case("clear"):
				componentName = null;
				tField.setText("");
				System.out.println("component text cleared");
				break;
			case("generate"):
				generateComponent();
				break;
			
		}
		
	};
	
}
