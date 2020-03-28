package Venn;

import java.io.Serializable;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class LabelSeri extends Label implements Serializable {
	
	private String text;
	
	public LabelSeri() {
		// TODO Auto-generated constructor stub
	}

	public LabelSeri(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public LabelSeri(String text, Node graphic) {
		super(text, graphic);
		// TODO Auto-generated constructor stub
	}

}
