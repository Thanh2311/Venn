package Venn;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
class CommandTest {
	
	private Label label;
	private ArrayList<LabelSerializable> list ;
	private Pane parent;

	@Start
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		parent = new Pane();
		parent.setId("hello");
		label = new Label("test");
		parent.getChildren().add(label);
		list = new ArrayList<LabelSerializable>();
		list.add(new LabelSerializable(label));
	}
	

	@Test
	void test1() {
		Command command = new Command(list);
		assertEquals("test, ", command.toString());
	}
	
	@Test
	void test2() {
		Command command = new Command(list);
		Label label2 = new Label("nice");
		parent.getChildren().add(label2);
		command.getLastState().add(new LabelSerializable(label2));
		assertEquals("test, nice, ", command.toString());	
	}
	
	@Test
	void test3() {
		Command command = new Command(list);
		Label label2 = new Label("nice");
		parent.getChildren().add(label2);
		command.getLastState().add(new LabelSerializable(label2));
		command.getLastState().remove(0);
		assertEquals("nice, ", command.toString());
	}

}
