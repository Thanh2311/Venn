package Venn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApplicationWindow extends Application {
	
	private double WIDTH = 1280;
	private double HEIGHT = 720;
	
//	public static void main(String[] args) {
//		launch(args);
//	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxml = new FXMLLoader();
			ScrollPane root = (ScrollPane)fxml.load(getClass().getResource("FX.fxml").openStream());
			FXController controller = (FXController)fxml.getController();
			AnchorPane fakeRoot = (AnchorPane)root.getContent();
			BorderPane border = (BorderPane)fakeRoot.getChildren().get(1);
			Scene scene = new Scene(root,WIDTH,HEIGHT);
			border.prefWidthProperty().bind(scene.widthProperty());
			border.prefHeightProperty().bind(scene.heightProperty());
			primaryStage.setScene(scene);
			primaryStage.setTitle("New Venn Diagram");
			primaryStage.setMinHeight(650);
			primaryStage.setMinWidth(850);

			double minHeight = fakeRoot.getMinHeight();
			Pane input = (Pane)border.getLeft();
			primaryStage.widthProperty().addListener((observed, old, newV) -> {
						if ( newV.doubleValue() < 1020) {
							border.setLeft(null);
							border.setBottom(input);			
							fakeRoot.setMinHeight(minHeight);
						}
						else {
							border.setBottom(null);
							border.setLeft(input);
							fakeRoot.setMinHeight(HEIGHT);
						}
			});
			
			
			scene.setOnKeyPressed((e)-> {
				if (e.isShortcutDown()) {
					e.consume();
					switch (e.getCode()) {
						case Z:
							controller.undo();
							break;
						case Y:
							controller.redo();
							break;
					default:
						break;
					}
					System.out.println(e.getCharacter());
				
				}
			});
			
			TextField textbox = ((TextField)((Pane)((Pane)border.getLeft()).getChildren().get(1)).getChildren().get(0));
			textbox.setOnKeyPressed(scene.getOnKeyPressed());
			
			primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
