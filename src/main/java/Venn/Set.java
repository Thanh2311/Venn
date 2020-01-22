package Venn;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextArea;

public class Set extends JPanel {

	/**
	 * Create the panel.
	 */
	public JTextArea textArea;
	
	
	public JTextArea getTextArea() {
		return textArea;
	}




	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}




	public Set() {
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(240, 240, 240), 3), new LineBorder(new Color(0, 0, 0), 2)));
		add(panel);
		
		textArea = new JTextArea();
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(240, 240, 240), 3), new LineBorder(new Color(0, 0, 0), 2)));
		add(panel_1);
		
		JTextArea textArea_1 = new JTextArea();
		panel_1.add(textArea_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder(new LineBorder(new Color(240, 240, 240), 3), new LineBorder(new Color(0, 0, 0), 2)));
		add(panel_2);
		
		JTextArea textArea_2 = new JTextArea();
		panel_2.add(textArea_2);

	}

	
}
