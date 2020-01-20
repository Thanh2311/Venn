package Venn;

import java.awt.*;
import javax.swing.*;

public class VennGui extends JFrame{
	
	private JPanel diag, control, context;
	
	private Dimension diagSize = new Dimension(1200,720);
	private Dimension conSize = new Dimension(300,720);
	private Dimension texSize = new Dimension(1500,100);
	
	public VennGui() {
		super();
		setSize(1500,820);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		/*diagram
		diag = new JPanel();
		diag.setSize(diagSize);
		diag.setBounds(300,0,1200,720);
		diag.setBackground(Color.GRAY);
		//this.add(diag,BorderLayout.WEST);
		add(diag);
		*/
		
		//controls menu
		control = new JPanel();
		control.setSize(conSize);
		control.setBounds(0,0,300,720);
		control.setBackground(Color.RED);
		this.add(control,BorderLayout.EAST);
		
		//add component generator
		ComponentGenerator cGen = new ComponentGenerator();
		//this.add(cGen,BorderLayout.CENTER);
		
		//add(control);
		
		//context menu
		context = new JPanel();
		context.setSize(texSize);
		context.setBounds(0,720,1500,100);
		context.setBackground(Color.BLUE);
		this.add(context,BorderLayout.SOUTH);
		/*add(context);
		*/
		
	}
	
	
}
