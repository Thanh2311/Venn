package Venn;

import java.io.Serializable;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LabelSerializable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private String font;
	private String parent;
	private double size;
	private double x;
	private double y;
	private double red;
	private double green;
	private double blue;
	private double opacity;
	
	public LabelSerializable() {
		// TODO Auto-generated constructor stub
	}

	public LabelSerializable(Label label) {
		text = label.getText();
		font = label.getFont().getName();
		parent = label.getParent().getId();
		size = label.getFont().getSize();
		x = label.getLayoutX();
		y = label.getLayoutY();
		red = ((Color)label.getTextFill()).getRed();
		green = ((Color)label.getTextFill()).getGreen();
		blue = ((Color)label.getTextFill()).getBlue();
		opacity = ((Color)label.getTextFill()).getOpacity();
		
		// TODO Auto-generated constructor stub
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRed() {
		return red;
	}

	public void setRed(double red) {
		this.red = red;
	}

	public double getGreen() {
		return green;
	}

	public void setGreen(double green) {
		this.green = green;
	}

	public double getBlue() {
		return blue;
	}

	public void setBlue(double blue) {
		this.blue = blue;
	}

	public double getOpacity() {
		return opacity;
	}

	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}
	
	
	


}
