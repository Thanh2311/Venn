package Venn;

public class Command {
	
	private LabelSerializable removedLabel;
	private LabelSerializable newLabel;
	
	public Command(LabelSerializable removedLabel, LabelSerializable newLabel) {
		super();
		this.removedLabel = removedLabel;
		this.newLabel = newLabel;
	}

	public LabelSerializable getRemovedLabel() {
		return removedLabel;
	}

	public void setRemovedLabel(LabelSerializable removedLabel) {
		this.removedLabel = removedLabel;
	}

	public LabelSerializable getNewLabel() {
		return newLabel;
	}

	public void setNewLabel(LabelSerializable newLabel) {
		this.newLabel = newLabel;
	}
	
	public Boolean hasNew() {
		return (newLabel != null);
	}
	
	public Boolean hasRemoved() {
		return (removedLabel != null);
	}


}
