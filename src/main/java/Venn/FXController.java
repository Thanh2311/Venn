package Venn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

public class FXController {
	
	@FXML private Label leftLabel;
	@FXML private Label rightLabel;
	@FXML private TextField textbox;
	@FXML private Pane newLabelPaneLeft;
	@FXML private Pane newLabelPaneRight;
	@FXML private Pane selectedPane;
	//@FXML private Shape selectedShape;
	
	/*
	 * Adds a new Label to the selected Sets VBox, default Left
	 */	
	@FXML public void addEleButton(ActionEvent event) {
		
		selectedPane = (selectedPane == null) ? newLabelPaneLeft : selectedPane;		
		if (!textbox.getText().trim().isEmpty()) {		
			Label lbl1 = new Label(textbox.getText());
			lbl1.setAlignment(Pos.CENTER_LEFT);
			lbl1.setFont(new Font("Ariel Bold", 15));
		    selectedPane.getChildren().add(lbl1);
		}
		else {
			textbox.setText(null);
		}
	}

	/* Selects a set by mouse click */
	@FXML public void selectSet(MouseEvent event) {
		
		Pane x = (Pane) event.getSource();
		selectedPane = (VBox) x.getChildren().get(1);	
		Pane parentPane = (VBox) x.getParent();
		Label selectedLabel = (Label)parentPane.getChildren().get(0);
		System.out.println(selectedLabel.getText()+ " Selected");
	}
}
