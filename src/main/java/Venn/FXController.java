package Venn;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

public class FXController {

	Font font = new Font("System Bold", 14);
	@FXML
	private Label leftLabel;
	@FXML
	private Label rightLabel;
	@FXML
	private TextField textbox;
	@FXML
	private Pane newLabelPaneLeft;
	@FXML
	private Pane newLabelPaneRight;
	@FXML
	private Pane selectedPane;
	@FXML
	private Shape selectedShape;
	@FXML
	private Label selectedLabel;
	@FXML
	private ContextMenu context;

	@FXML
	private void initialize() {

		MenuItem rename = new MenuItem("Rename");
		MenuItem delete = new MenuItem("Delete");
		MenuItem custom = new MenuItem("Customize");
		context = new ContextMenu(rename, delete, custom);

		rename.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rename(event);

			}
		});

//		leftLabel.setOnContextMenuRequested(e ->{
//			selectLabel(e);
//			context.show(leftLabel, e.getScreenX(), e.getScreenY());
//		});
//		
		// leftLabel.setContextMenu(context);
	}

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
			element.setContextMenu(context);
			selectedLabel = element;
			System.out.println("\"" + textbox.getText() + "\" added to " + selectedLabel.getText());
		}
		textbox.setText("");
		textbox.requestFocus();

	}

	/*
	 * Selects a set by mouse click, deselects the previous selection. Requires the
	 * Shape to be the first node in the selected pane, and the pane containing
	 * labels to be the second.
	 */
	@FXML
	public void selectSet(MouseEvent event) {

		Pane x = (Pane) event.getSource();

		if (selectedShape != null) {
			selectedShape.setStrokeWidth(1);
		}
		selectedShape = (Shape) x.getChildren().get(0);
		selectedShape.setStrokeWidth(4);

		selectedPane = (VBox) x.getChildren().get(1);

		System.out.println(((Label)((VBox) x.getParent()).getChildren().get(0)).getText() + " Selected");
		//System.out.println(selectedLabel.getText() + " Selected");

	}

	/* Opens a context menu on the requested label */

	@FXML
	public void contextOnLabel(ContextMenuEvent event) {

		Label x = (Label) event.getSource();
		selectedLabel = x;
		System.out.println(selectedLabel.getText() + " Selected");
		context.show(selectedLabel, event.getScreenX(), event.getScreenY());

	}

	@FXML
	public void deselect(MouseEvent event) {

		if (selectedShape != null) {
			selectedShape.setStrokeWidth(1);
			selectedShape.requestFocus();
		}

	}

	@FXML
	public void rename(ActionEvent event) {

		if (selectedLabel != null) {
			String oldLabel = selectedLabel.getText();
			selectedLabel.setText(textbox.getText());
			System.out.println("\"" + oldLabel + "\" renamed to \"" + selectedLabel.getText() + "\".");
		}

	}

}
