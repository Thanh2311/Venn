package Venn;

import java.util.List;
import java.util.Stack;

public class CommandManager {
	
	
	private Stack<Command> undoStack;
	private Stack<Command> redoStack;
	private List<LabelSerializable> elementList;
	private LabelData labelData;
	
	public CommandManager(LabelData labelData) {
		
		undoStack = new Stack<>();
		redoStack = new Stack<>();
		this.labelData = labelData;
		this.elementList = labelData.getList();
		execute();
		
	}

	/*
	 * Call before any changes to elementList to save its state
	 */	
	public void execute() { 
		
		undoStack.push(new Command(labelData.getList()));
		redoStack.clear();
		}
	
	public void undo() {
		
		if (undoStack.size() > 1) {
			Command command = undoStack.pop();
			redoStack.push(new Command(labelData.getList()));
			elementList.clear();
			elementList.addAll(command.getLastState());
		}
	}
	
	public void redo() {
		
		if (redoStack.size() > 0) {
			Command command = redoStack.pop();
			undoStack.push(new Command(labelData.getList()));
			elementList.clear();
			elementList.addAll(command.getLastState());
		}
	}

	public List<LabelSerializable> getElementList() {
		return elementList;
	}


	

	
	

}
