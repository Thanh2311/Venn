package vennGUI;

import javafx.*;
import javafx.scene.layout.StackPane;

public class PaneSet extends StackPane {
	
	private byte[] attributes;
	
	public PaneSet() {
		super();
	}
	
	public void setAttributes(byte[] attr) {
		this.attributes = attr;
	}
	
	public byte[] getAttributes() {
		return this.attributes;
	}
}
