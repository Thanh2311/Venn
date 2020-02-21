package Venn;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class FXController {

	
	private static final DataFormat LABEL_FORMAT = new DataFormat("label");
	
	private Font font;
	@FXML
	private Label leftLabel;
	@FXML
	private Label rightLabel;
	@FXML
	private Label placeholder; // Placeholder only required for element context menus
	@FXML
	private TextField textbox;
	@FXML
	private Button addButton;
	@FXML
	private Pane newLabelPaneLeft;
	@FXML
	private Pane newLabelPaneRight;
	@FXML
	private Pane selectedPane;
	@FXML
	private Shape selectedShape;
	@FXML
	private Label selectedTitle;
	@FXML
	private Label selectedElement;
	@FXML
	private Label selectedLabel; // Use only this field to refer to selected label
	@FXML
	private ContextMenu contextElement;
	@FXML
	private ContextMenu contextTitle;
	@FXML
	private Shape border;

	private double x;
	private double y;

	@FXML
	private void initialize() {

		font = new Font("System Regular", 14);

		MenuItem rename = new MenuItem("Rename");
		MenuItem delete = new MenuItem("Delete");
		MenuItem custom = new MenuItem("Customize");

		rename.setOnAction(new EventHandler<ActionEvent>() {

//			Opens a window to rename the label right clicked on.
			@Override
			public void handle(ActionEvent event) {
				rename();
			}
		});

		delete.setOnAction(new EventHandler<ActionEvent>() {

//			Opens a window to delete the label right clicked on.
			@Override
			public void handle(ActionEvent event) {
				delete();

			}
		});

		contextTitle = new ContextMenu(rename, custom);
		contextElement = new ContextMenu(delete);

		// duplicates MenuItems because they are associated with only one ContextMenu
		for (MenuItem titleItem : contextTitle.getItems()) {
			MenuItem eleItem = new MenuItem(titleItem.getText());
			eleItem.setGraphic(titleItem.getGraphic());
			eleItem.setOnAction(titleItem.getOnAction());
			contextElement.getItems().add(eleItem);

		}

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
			element.setOnContextMenuRequested(placeholder.getOnContextMenuRequested());
			element.setOnDragDetected(placeholder.getOnDragDetected());
			element.setOnDragDone(placeholder.getOnDragDone());
			selectedPane.getChildren().add(element);
			selectedElement = element;
			System.out.println("\"" + textbox.getText() + "\" added to " + selectedTitle.getText());
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

		if (event.getButton() == MouseButton.PRIMARY || event.isPrimaryButtonDown()) {
			deselectAll(event);
			addButton.setDisable(false);
			textbox.requestFocus();
			
			Pane x = (Pane) event.getSource();
			selectedShape = (Shape) x.getChildren().get(0);
			selectedShape.setStrokeWidth(4);

			selectedPane = (Pane) x.getChildren().get(1);
			selectedTitle = ((Label) ((Pane) (x).getParent()).getChildren().get(0));

			System.out.println(selectedTitle.getText() + " selected");

		}
	}

	/* Opens a context menu on the requested element */
	@FXML
	public void contextOnElement(ContextMenuEvent event) {

		selectedElement = (Label) event.getSource();
		selectedLabel = selectedElement;
		System.out.println(selectedElement.getText() + " selected");
		contextElement.show(selectedElement, event.getScreenX(), event.getScreenY());

	}

	/* Opens a context menu on the requested title */
	@FXML
	public void contextOnTitle(ContextMenuEvent event) {

		selectedTitle = (Label) event.getSource();
		selectedLabel = selectedTitle;
		System.out.println(selectedTitle.getText() + " selected");
		contextTitle.show(selectedTitle, event.getScreenX(), event.getScreenY());

	}

	@FXML
	public void deselectAll(MouseEvent event) {

		if (selectedShape != null) {
			addButton.setDisable(true);
			selectedShape.setStrokeWidth(1);
			selectedShape.requestFocus();
		}

	}

	
	@FXML 
	public void setOnDragStarted(MouseEvent event) {
		
		selectedLabel = ((Label)event.getSource());
		x = selectedLabel.getLayoutX() - event.getSceneX(); 
		y = selectedLabel.getLayoutY() - event.getSceneY(); 
		selectedLabel.setOpacity(.5);
		selectedLabel.setCursor(Cursor.DEFAULT); 
		
		Dragboard db = selectedLabel.startDragAndDrop(TransferMode.MOVE) ;
		db.setDragView(selectedLabel.snapshot(null, null));
		ClipboardContent clip = new ClipboardContent();
		clip.put(LABEL_FORMAT, "label");
		db.setContent(clip);

		
	}
	
	
	@FXML
	public void setOnDragOver(DragEvent event) {
		Dragboard db = event.getDragboard();
		selectedShape = ((Shape)((Pane)event.getSource()).getChildren().get(0));
		if (selectedShape == border) {
			selectedShape.setOpacity(.64);
			selectedShape.setStrokeWidth(20);
		}
		else
			selectedShape.setStrokeWidth(4);
		if (db.hasContent(LABEL_FORMAT) 
				&& selectedLabel != null 
                && selectedLabel.getParent() != event.getSource()) {
            event.acceptTransferModes(TransferMode.MOVE);
        }
		
	}
	
	@FXML
	public void setOnDragExited(DragEvent event) {
		if (selectedShape == border)
			selectedShape.setOpacity(0);
		selectedShape.setStrokeWidth(1);
	}
	
	@FXML
	public void setOnDragDropped(DragEvent event) {
		Dragboard db = event.getDragboard();
		
		if (selectedShape == border) 
			delete();
		else if (db.hasContent(LABEL_FORMAT) && selectedLabel.getParent().getParent() != event.getSource()) {
			((Pane)selectedLabel.getParent()).getChildren().remove(selectedLabel);
			((Pane)((Pane)event.getSource()).getChildren().get(1)).getChildren().add(selectedLabel);
			//System.out.println(selectedLabel + " transfered from ");
			event.setDropCompleted(true);  
			selectedLabel.setLayoutX(0);
			selectedLabel.setLayoutY(event.getSceneY() + y); 
			}
		else {
			selectedLabel.setLayoutX(event.getSceneX() + x);
			selectedLabel.setLayoutY(event.getSceneY() + y); 
		}
		
	}
	
	
	@FXML 
	public void dragDone(DragEvent event) {
	 // if(!event.isPrimaryButtonDown()) selectedLabel = (Label) event.getSource();
		border.setOpacity(0);
		selectedLabel.setOpacity(1);
		selectedLabel.setCursor(Cursor.HAND); 
	  }
	  


	public void delete() {
		
		Alert dialog = new Alert(AlertType.CONFIRMATION);
		dialog.setTitle("Delete : " + selectedLabel.getText());
		dialog.setContentText("Are you sure you want to delete this element?");
		dialog.setHeaderText(null);
		dialog.setGraphic(null);
		dialog.getDialogPane().setMaxSize(100, 100);
		Optional<ButtonType> result = dialog.showAndWait();
		// checks if you clicked ok or cancel
		if (result.get() == ButtonType.OK) {
			System.out.printf("\"%s\" deleted\n", selectedLabel.getText());
			((Pane) selectedLabel.getParent()).getChildren().remove(selectedLabel);
		}
	}


	public void rename() {

		String oldText = selectedLabel.getText();
		TextInputDialog dialog = new TextInputDialog(oldText);
		dialog.setTitle("Rename " + oldText);
		dialog.setHeaderText(null);
		dialog.setGraphic(null);
		Optional<String> result = dialog.showAndWait();
		String newText = dialog.getEditor().getText();
		// checks if you clicked ok or cancel
		if (result.isPresent() && !newText.trim().isEmpty()) {
			selectedLabel.setText(newText);
			System.out.printf("\"%s\" renamed to \"%s\"\n", oldText, newText);
		}

	}

}
