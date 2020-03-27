package Venn;

import javafx.application.*;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

public class ApplicationWindow extends Application {

//	public static void main(String[] args) {
//		launch(args);
//	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			ScrollPane root = (ScrollPane)FXMLLoader.load(getClass().getResource("FX.fxml"));
			AnchorPane fakeRoot = (AnchorPane)root.getContent();
			BorderPane border = (BorderPane)fakeRoot.getChildren().get(1);
			Scene scene = new Scene(root,1280,720);
			border.prefWidthProperty().bind(primaryStage.widthProperty());
			border.prefHeightProperty().bind(primaryStage.heightProperty());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Venn Diagram Example");
			primaryStage.setMinHeight(650);
			primaryStage.setMinWidth(850);

			Pane input = (Pane)border.getLeft();
			primaryStage.widthProperty().addListener((observed, old, newV) -> {
						if ( newV.doubleValue() < 1100) {
							border.setLeft(null);
							border.setBottom(input);
						}
						else {
							border.setBottom(null);
							border.setLeft(input);
						}
			});
	;		primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
