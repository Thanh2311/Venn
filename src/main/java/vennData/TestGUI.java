package vennData;

import javax.swing.*;
import java.awt.*;

public class TestGUI extends JFrame{
	
	public JPanel main, p1, p2, p3;
	
	public TestGUI(JPanel p1, JPanel p2, JPanel p3) {
		super();
		setSize(1500,820);
		setBounds(100, 100, 1200, 720);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//
		main = new JPanel();
		main.setLayout(new GridLayout(0, 3, 0, 0));
		add(main, BorderLayout.CENTER);
		
		//diagram panels
		//p1 = new JPanel();
		this.p1 = p1;
		main.add(p1);
		
		//p2 = new JPanel();
		this.p2 = p2;
		main.add(p2);
		
		//p3 = new JPanel();
		this.p3 = p3;
		main.add(p3);
		
		//pack();
		
	}
}
