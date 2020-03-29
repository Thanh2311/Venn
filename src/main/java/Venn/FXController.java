package Venn;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class FXController {

	
	private static final DataFormat LABEL_FORMAT = new DataFormat("label");
	
	
	public LabelData labelData;
	
	public List<LabelSerializable> elementList;
	
	private FileChooser chooser;
	
    private File file;
    
    private CommandManager undoManager;
	
	@FXML
	private Font font;
	@FXML
	private Color textColor;
	@FXML
	private ComboBox<String> fontBox;
	@FXML
	private ComboBox<String> fontSizeBox;
	@FXML
	private ColorPicker colorBox;
	@FXML
	private VBox customizeBox;
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
	private Button saveButton;
	@FXML
	private Button saveAsButton;
	@FXML
	private Button loadButton;
	@FXML
	private Button clearButton;
	@FXML
	private Button undoButton;
	@FXML
	private Button redoButton;
	@FXML
	private Button testButton;
	@FXML
	private Pane newLabelPaneLeft;
	@FXML
	private Pane newLabelPaneRight;
	@FXML
	private Pane selectedPane;
	@FXML
	private Pane leftPane;
	@FXML
	private Pane rightPane;
	@FXML
	private Pane middlePane;
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
	private Rectangle border;
	@FXML
	private AnchorPane root;

	private double x;
	private double y;

	@FXML
	private void initialize() {
		
		labelData = new LabelData();
		
		elementList = labelData.getList();
		
		chooser = new FileChooser();
		chooser.getExtensionFilters().add((new FileChooser.ExtensionFilter("Venn Files(*.venn)", "*.venn")));
		
		undoManager = new CommandManager(labelData);

	
		font = Font.getDefault();	//initializes font and color
		textColor = Color.BLACK;

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
		
		custom.setOnAction(new EventHandler<ActionEvent>() {
			
//			Opens a window to delete the label right clicked on.
			@Override
			public void handle(ActionEvent event) {
				customize();
				
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
		
		border.widthProperty().bind(root.widthProperty());
		border.heightProperty().bind(root.heightProperty());	// resizes the red border when dragging outside the circle
		
		fontBox.getItems().addAll(Font.getFontNames());			// populates font box
		fontBox.setValue(font.getFamily());
		
		List<String> list = new ArrayList<>();		 
		for (int i = 8; i <= 24; i += 2) {
			list.add(String.valueOf(i) );
		}
		fontSizeBox.getItems().addAll(list);					// populates font size box
		fontSizeBox.setValue(Integer.toString((int)font.getSize()));	//Done this way to remove trailing point and decimal point	
		
		colorBox.setValue(Color.BLACK);

		
	}

	
	
	
	
	
	/*
	 * Adds a new Label to the left box
	 */
	@FXML
	public void addButton(ActionEvent event) {

		if (!textbox.getText().isEmpty() && !textbox.getText().trim().isEmpty()) {
			addElement(textbox.getText(), selectedPane);
			LabelSerializable exe = new LabelSerializable(selectedElement);
			elementList.add(exe);
			undoManager.execute(null, exe);
		//	System.out.println("\"" + textbox.getText() + "\" added to " + selectedTitle.getText());
		}
		textbox.setText("");
		textbox.requestFocus();
		//System.out.println(labelData.toString());

	}
	
	@FXML
	public void saveButton(ActionEvent event) throws FileNotFoundException {
		if (file != null) {
			labelData.save(file);
			System.out.println("Saved to " + file.getName());
		}
		else {
			saveAsButton(event);
		}
	}
	
	@FXML
	public void saveAsButton(ActionEvent event) throws FileNotFoundException {
		
		chooser.setTitle("Save File");
		chooser.setInitialFileName("NewDiagram");
		if (file != null)
			chooser.setInitialDirectory(file.getParentFile());
		file = chooser.showSaveDialog(null);
		if (file != null)
			labelData.save(file);
		
	}
	
	
	@FXML
	public void loadButton(ActionEvent event) throws FileNotFoundException {
	
	    chooser.setTitle("Open File");
	    
	    chooser.setInitialFileName("NewDiagram");
	    if (file != null)
	    	chooser.setInitialDirectory(file.getParentFile());
	    file = chooser.showOpenDialog(null);
	    if (file != null) {
	    	//clear();
	    	elementList.clear();
	    	labelData.read(file);
	    	//elementList = labelData.getList();
	    	load();
	    	System.out.println(file.getName() + " loaded");
	    }
	}

	@FXML
	public void clearButton(ActionEvent event) {

		Alert dialog = new Alert(AlertType.CONFIRMATION);
		dialog.setTitle("Clear All");
		dialog.setContentText("Are you sure you want to clear all elements?");
		dialog.setHeaderText(null);
		dialog.setGraphic(null);
		dialog.getDialogPane().setMaxSize(100, 100);
		Optional<ButtonType> result = dialog.showAndWait();
		// checks if you clicked ok or cancel
		if (result.get() == ButtonType.OK) {
			clearUI();
			elementList.clear();
		}

	}

	@FXML
	public void undoButton(ActionEvent event) {
		undoManager.undo();
		load();
		//System.out.println(labelData.toString());
	}
	
	
	@FXML
	public void redoButton(ActionEvent event) {
		undoManager.redo();
		load();
		//System.out.println(labelData.toString());
	}
	
	@FXML
	public void testButton(ActionEvent event) {
	
		System.out.println(labelData.toString());
	}
	
	/*
	 * Selects a set by mouse click, deselects the previous selection. Requires the
	 * Shape to be the first node in the selected pane, and the pane containing
	 * labels to be the second.
	 * 
	 * Depreciated
	 */
	@FXML
	public void selectSet(MouseEvent event) { 

//		if (event.getButton() == MouseButton.PRIMARY || event.isPrimaryButtonDown()) {
//			deselectAll(event);
//			textbox.requestFocus();
//			
//			Pane x = (Pane) event.getSource();
//			selectedShape = (Shape) x.getChildren().get(0);
//			selectedShape.setStrokeWidth(4);
//
//			//selectedPane = (Pane) x.getChildren().get(1);
//			selectedTitle = ((Label) ((Pane) (x).getParent()).getChildren().get(0));
//
//			System.out.println(selectedTitle.getText() + " selected");
//
//		}
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
		String oldText = selectedLabel.getText();
		
		if (selectedShape == border) 
			delete();
		else if (db.hasContent(LABEL_FORMAT) && selectedLabel.getParent().getParent() != event.getSource()) {
		//	((Pane)selectedLabel.getParent()).getChildren().remove(selectedLabel);
			((Pane)((Pane)event.getSource()).getChildren().get(1)).getChildren().add(selectedLabel);
			//if (!selectedShape.getBoundsInLocal().contains(selectedLabel.getBoundsInLocal())) {
				//System.out.println(selectedLabel + " transfered from ");
			//	selectedShape.con
				event.setDropCompleted(true);  
				selectedLabel.setLayoutX(0);
				selectedLabel.setLayoutY(0); 

			//}
		}
		else {
			selectedLabel.setLayoutX(event.getSceneX() + x);
			selectedLabel.setLayoutY(event.getSceneY() + y); 
			//selectedLabel.trans
		}
		labelData.update(oldText, selectedLabel);
	}
	
	
	@FXML 
	public void dragDone(DragEvent event) {
	 // if(!event.isPrimaryButtonDown()) selectedLabel = (Label) event.getSource();
		border.setOpacity(0);
		selectedLabel.setOpacity(1);
		selectedLabel.setCursor(Cursor.HAND); 
	  }
	
	
	
	@FXML 
	public void updateFont(ActionEvent event) {
		
		String size = fontSizeBox.getValue(); 
		if (size == null || size.isEmpty() || !size.matches("[0-9]+")) 
			fontSizeBox.setValue(Integer.toString((int)font.getSize()));
		else if (Integer.parseInt(size) > 100)
			fontSizeBox.setValue("99");
		else if (Integer.parseInt(size) <= 0)
			fontSizeBox.setValue("1");
		else
			font = new Font(fontBox.getValue(),Double.parseDouble(size));
	}
	
	
	@FXML 
	public void updateColor(ActionEvent event) {

		textColor = colorBox.getValue();
	}
	
	
	

	
	public Label addElement(String text, Pane pane) {
		
		Label element = new Label(text);
		element.setFont(font);
		element.setTextFill(textColor);
		element.setWrapText(true);
		element.setOnContextMenuRequested(placeholder.getOnContextMenuRequested());
		element.setOnDragDetected(placeholder.getOnDragDetected());
		element.setOnDragDone(placeholder.getOnDragDone());
		pane.getChildren().add(element);
	
		
		selectedElement = element;
		
		
		
		return element;
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
			labelData.update(selectedLabel.getText());
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
			labelData.update(oldText, selectedLabel);
		}

	}
	
	
	public void customize() {	// Structured poorly, mostly just recreating colorBox,fontBox, and fontSizeBox for use in contextmenu
		
		String oldText = selectedLabel.getText();
		Alert dialog = new Alert(AlertType.CONFIRMATION);
		
		DialogPane dpane = dialog.getDialogPane();
		ColorPicker color = new ColorPicker();
		color.setValue((Color) selectedLabel.getTextFill());
		HBox hb = new HBox();
		ComboBox<String> font = new ComboBox<>();
		font.setMaxWidth(140);
		font.getItems().addAll(Font.getFontNames());
		font.setValue(selectedLabel.getFont().getName());
		ComboBox<String> sizebox = new ComboBox<>();
		sizebox.setEditable(true);
		sizebox.setMaxWidth(60);
		sizebox.getItems().addAll(fontSizeBox.getItems());
		sizebox.setValue(Integer.toString((int)selectedLabel.getFont().getSize()));
		
		hb.getChildren().addAll(font,sizebox);
		hb.resizeRelocate(0, 25, 200, 25);
		color.resize(200, 25);
		dpane.getChildren().addAll(color);
		dpane.getChildren().addAll(hb);
		dpane.setMaxSize(1, 600);
		dpane.setMinHeight(100);
		dialog.setTitle("Customize");
		dialog.setHeaderText("");
		dialog.setGraphic(null);
		Optional<ButtonType> result = dialog.showAndWait();
		// checks if you clicked ok or cancel
		if (result.get() == ButtonType.OK) {
			String size = sizebox.getValue(); 
			if (size == null || size.isEmpty() || !size.matches("[0-9]+")) 
				sizebox.setValue(Integer.toString((int)selectedLabel.getFont().getSize()));
			else if (Integer.parseInt(size) > 100)
				sizebox.setValue("99");
			else if (Integer.parseInt(size) <= 0)
				sizebox.setValue("1");
			else
				selectedLabel.setFont(new Font(font.getValue(), Double.parseDouble(sizebox.getValue())));
			selectedLabel.setTextFill(color.getValue());
			labelData.update(oldText, selectedLabel);
			System.out.println(font.getValue());
		}
		
	}
	
	
	public void clearUI() {
//		for(LabelSerializable label : elementList) {
//			Pane pane = (Pane) root.lookup("#"+ label.getParent());
//			pane.getChildren().clear();
//		}
		//elementList.clear();
		
		selectedPane.getChildren().clear();
		leftPane.getChildren().clear();
		rightPane.getChildren().clear();
		middlePane.getChildren().clear();
	}
	
	public void load() {
		clearUI();
		
		for (LabelSerializable i : elementList) {
    		selectedElement = addElement(i.getText(),
    				(Pane)root.lookup("#"+ i.getParent()));
    		selectedElement.setFont(new Font(i.getFont(), i.getSize()));
    		selectedElement.setLayoutX(i.getX());
    		selectedElement.setLayoutY(i.getY());
    		selectedElement.setTextFill(new Color(i.getRed(), i.getGreen(),
    				i.getBlue(), i.getOpacity()));
    	}
	}


}
