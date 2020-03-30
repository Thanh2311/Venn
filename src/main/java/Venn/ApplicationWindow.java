package Venn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApplicationWindow extends Application {
	
	double width = 1280;
	double height = 720;
	
//	public static void main(String[] args) {
//		launch(args);
//	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			ScrollPane root = (ScrollPane)FXMLLoader.load(getClass().getResource("FX.fxml"));
			AnchorPane fakeRoot = (AnchorPane)root.getContent();
			BorderPane border = (BorderPane)fakeRoot.getChildren().get(1);
			Scene scene = new Scene(root,width,height);
			border.prefWidthProperty().bind(scene.widthProperty());
			border.prefHeightProperty().bind(scene.heightProperty());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Venn Diagram Example");
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
							//fakeRoot.setMaxHeight(0);
							fakeRoot.setMinHeight(height);
						//	fakeRoot.setPrefHeight(0);
						}
			});
	;		primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
