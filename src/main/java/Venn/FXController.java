package Venn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

public class FXController {
	
	Font font = new Font("System Bold", 14);
	@FXML private Label leftLabel;
	@FXML private Label rightLabel;
	@FXML private TextField textbox;
	@FXML private Pane newLabelPaneLeft;
	@FXML private Pane newLabelPaneRight;
	@FXML private Pane selectedPane;
	@FXML private Shape selectedShape;
	
	/*
	 * Adds a new Label to the selected Set's VBox, default Left
	 */	
	@FXML 
	public void addEleButton(ActionEvent event) {
		
		selectedPane = (selectedPane == null) ? newLabelPaneLeft : selectedPane;		
		if (!textbox.getText().isEmpty() && !textbox.getText().trim().isEmpty()) {		
			Label element = new Label(textbox.getText());
			element.setFont(font);
			element.setWrapText(true);
		    selectedPane.getChildren().add(element);
		}
			textbox.setText("");
			textbox.requestFocus();
		
	}

	/* Selects a set by mouse click, deselects the previous selection.
	 * Requires the Shape to be the first node in the selected pane,
	 * and the pane containing labels to be the second.  */
	@FXML 
	public void selectSet(MouseEvent event) {
		
		Pane x = (Pane) event.getSource();
		
		if (selectedShape != null) {
			selectedShape.setStrokeWidth(1);
		}
		selectedShape = (Shape)x.getChildren().get(0);
		selectedShape.setStrokeWidth(4);
		
		selectedPane = (VBox)x.getChildren().get(1);
		
		Pane parentPane = (VBox)x.getParent();
		Label selectedLabel = (Label)parentPane.getChildren().get(0);
		
		System.out.println(selectedLabel.getText()+ " Selected");
	}
	
	@FXML 
	public void deselect(MouseEvent event) {
		
		if (selectedShape != null) {
			selectedShape.setStrokeWidth(1);
			selectedShape.requestFocus();
		}
	
	}
	
	@FXML 
	public void context(ContextMenuEvent event) {
		System.out.println("test");
		
		
		
	}
}
