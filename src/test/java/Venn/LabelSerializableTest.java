package Venn;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
class LabelSerializableTest {
	
	private Label label;

	@Start
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		Pane parent = new Pane();
		parent.setId("hello");
		label = new Label("test");
		label.setTextFill(new Color(0.12, 0.24 , 0.36, 0.48));
		parent.getChildren().add(label);
		label.setLayoutX(320);
		label.setLayoutX(59);
	}
	

	
	@Test
	void test1() {
		LabelSerializable data = new LabelSerializable(label);
		assertEquals(data.getText(), label.getText());
	}	
	@Test
	void test2() {
		LabelSerializable data = new LabelSerializable(label);
		assertEquals(data.getRed(), ((Color)label.getTextFill()).getRed());
		assertEquals(data.getBlue(), ((Color)label.getTextFill()).getBlue());
		assertEquals(data.getGreen(), ((Color)label.getTextFill()).getGreen());
		assertEquals(data.getOpacity(), ((Color)label.getTextFill()).getOpacity());
	}	
	@Test
	void test3() {
		LabelSerializable data = new LabelSerializable(label);
		assertEquals(data.getX(), label.getLayoutX());
		assertEquals(data.getY(), label.getLayoutY());
		
	}	

	
		
	
	


}
