package Venn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
class CommandManagerTest {
	
	private Label label;
	private Pane parent;
	private LabelData labeldata;

	@Start
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		parent = new Pane();
		labeldata = new LabelData();
		parent.setId("hello");
		label = new Label("test");
		parent.getChildren().add(label);
		labeldata.add(label);
	
	}
	
	

	@Test
	void test() {
		CommandManager cmd = new CommandManager(labeldata);
		Label label2 = new Label("no");
		parent.getChildren().add(label2);
		labeldata.add(label2);
		assertEquals(2, labeldata.getList().size());
		
	}
	@Test
	void test2() {
		CommandManager cmd = new CommandManager(labeldata);
		
		int rand = ((int)Math.random() *100);
		for (int i = 0; i < rand; i++) {
			Label label2 = new Label("no");
			parent.getChildren().add(label2);
			labeldata.add(label2);
		}
		assertEquals(rand + 1, labeldata.getList().size());
		
	}
	

	

}
