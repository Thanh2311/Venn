package Venn;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Circle extends JFrame {
	
	public Circle() {
		
		setTitle("Circle");
		setSize(960,960);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawOval(380, 300, 200, 200);
		
		g.setColor(Color.RED);
		g.drawOval(280, 300, 200, 200);
	
	}
	
	public static void main(String[] args) {
		
		Circle c = new Circle();
		Circle c2 = new Circle();
		c.paint(null);
		c2.paint(null);
		
	}

}
