package vennData;

import javax.swing.*;
import java.awt.*;

public class ArrayDiagram {
	
	public JPanel[] panels;
	int size = 2;
	
	public ArrayDiagram() {
		panels = new JPanel[3];
		for(JPanel jp : panels) {
			jp = new JPanel();
			jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		}
	}
	
	public ArrayDiagram(ComponentList list) {
		panels = new JPanel[3];
		//for(JPanel jp : panels) {
		for(int i = 0; i<panels.length;i++) {
			panels[i] = new JPanel();
			panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.Y_AXIS));
			panels[i].setBorder(BorderFactory.createTitledBorder("title: " + i));
			//panels[i].add(new JLabel("hi " + i));
		}
		genDiagram(list);
		TestGUI tg = new TestGUI(panels[0],panels[2],panels[1]);
	}
	
	public void genDiagram(ComponentList list) {
		ComponentListNode next = list.getFirst();
			while(next!=null) {
				addComponent(next.getComponenet());
				next = next.getNext();
			}
	}
	
	public JPanel getPanel(byte[] attributes) {
		int position = -1;
		for(byte i: attributes) {
			i = (byte) ((i-48)%10);
			if(i<1 || i>size) {
				
			}else {
				position = position + i;
			}
		}
		return panels[position];
	}
	
	public void addComponent(Component c) {
		JTextArea tf = new JTextArea();
		tf.setText(c.getName());
		JPanel jp = getPanel(c.getAttributes());
		jp.add(tf);
		//jp.add(new JLabel(c.getName()));
	}
	
	public void addComponent(JPanel jp, Component c) {
		JTextArea tf = new JTextArea();
		tf.setText(c.getName());
		jp.add(tf);
	}
	
}
