package vennData;

public class ComponentList {
	
	ComponentListNode first, last;
	int size;
	
	public ComponentList() {
		this.first = null;
		this.last = null;
		size = 0;
	}
	
	public void append(Component c) {
		if (this.size == 0) {
			ComponentListNode node = new ComponentListNode(c,null, null);
			this.first = node;
			this.last = node;
		}else {
			ComponentListNode node = new ComponentListNode(c, null, this.last);
			this.last.setNext(node);
			this.last = node;
		}
		size ++;
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
