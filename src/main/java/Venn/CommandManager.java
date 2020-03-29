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
		
		
	}
	
	public void execute(LabelSerializable removedLabel,
			LabelSerializable newLabel) {
		
		undoStack.push(new Command(removedLabel,newLabel));
		redoStack.clear();
	}
	
	public void undo() {
		if (undoStack.size() != 0) {
			Command old = undoStack.pop();
			redoStack.push(old);
			
			if (old.hasRemoved()) {
				elementList.add(old.getRemovedLabel());
				}
			if (old.hasNew()) {
				labelData.update(old.getNewLabel().getText());
			}
		}
	}
	
	public void redo() {
		if (redoStack.size() != 0) {
			Command newLabel = redoStack.pop();
			undoStack.push(newLabel);
			
			if (newLabel.hasNew()) 
				elementList.add(newLabel.getNewLabel());
			if (newLabel.hasRemoved())
				labelData.update(newLabel.getRemovedLabel().getText());
		}
	}

}
