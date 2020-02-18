package Venn;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.control.*;

public class JavaFXMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("FX.fxml"));
			BorderPane border = (BorderPane)root.getChildren().get(1);
			Scene scene = new Scene(root,800,600);
			border.prefWidthProperty().bind(primaryStage.widthProperty());
			border.prefHeightProperty().bind(primaryStage.heightProperty());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Venn Diagram Example");
			primaryStage.setMinHeight(600);
			primaryStage.setMinWidth(800);
			// primaryStage.setResizable(false);
			//primaryStage.sizeToScene();
			//primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
