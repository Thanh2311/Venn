package Venn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class FXController {

	
	@FXML private Label leftLabel;
	@FXML private Label rightLabel;
	@FXML private TextField textbox;
	@FXML private Pane newLabelPane;
	
	@FXML public void addEleButton(ActionEvent event) {
		
		Label lbl1 = new Label(textbox.getText());
		lbl1.setAlignment(Pos.CENTER);
		lbl1.setFont(new Font("Ariel Bold", 15));
	    newLabelPane.getChildren().add(lbl1);
	   
		
	}
	
}
