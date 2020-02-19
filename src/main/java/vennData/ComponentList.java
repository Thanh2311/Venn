package vennData;

public class ComponentList {
	
	private ComponentListNode first, last;
	private int length;
	
	public ComponentList() {
		this.first = null;
		this.last = null;
		length = 0;
	}
	
	public void append(Component c) {
		if (this.length == 0) {
			ComponentListNode node = new ComponentListNode(c,null, null);
			this.first = node;
			this.last = node;
		}else {
			ComponentListNode node = new ComponentListNode(c, null, this.last);
			this.last.setNext(node);
			this.last = node;
		}
		length ++;
		
	}
	
	public void append(ComponentList list) {
		
		ComponentListNode next = list.first;
		while(next != null) {
			this.append(next.getComponent());
			next = next.getNext();
		}
	}
	
	public int getLength() {
		return this.getLength();
	}
	
	public ComponentListNode getFirst() {
		return this.first;
	}
	
	public ComponentListNode getLast() {
		return this.last;
	}
	
	public String toString() {
		String out = "";
		ComponentListNode next = first;
		while(next != null) {
			out += next.toString();
			out += "\n";
			next = next.getNext();
		}
		return out;
	}
	
	
}


