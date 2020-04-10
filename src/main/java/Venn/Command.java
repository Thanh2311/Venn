package Venn;

import java.util.ArrayList;
import java.util.List;

public class Command {
	
	private List<LabelSerializable> lastState;
	
	public Command(ArrayList<LabelSerializable> lastState) {
		super();
		this.lastState = (ArrayList)lastState.clone();
	
	}

	public List<LabelSerializable> getLastState() {
		return lastState;
	}

	public void setLastState(List<LabelSerializable> lastState) {
		this.lastState = lastState;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String contain = "";
		for (LabelSerializable i : lastState) {
			contain += i.getText() + ", " ;
		}
		return contain;
	}

	

}
