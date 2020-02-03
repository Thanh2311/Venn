package vennData;

public class ComponentList {
	
	ComponentListNode first, last;
	int legnth, diagSize;
	
	public ComponentList() {
		diagSize = 2;
		this.first = null;
		this.last = null;
		legnth = 0;
	}
	
	public ComponentList(int size) {
		diagSize = size;
		this.first = null;
		this.last = null;
		legnth = 0;
	}
	
	public void append(Component c) {
		if (this.legnth == 0) {
			ComponentListNode node = new ComponentListNode(c,null, null);
			this.first = node;
			this.last = node;
			legnth ++;
		}else {
			ComponentListNode node = new ComponentListNode(c, null, this.last);
			this.last.setNext(node);
			this.last = node;
			legnth ++;
		} 
	}
	
	public int getSize() {
		return this.diagSize;
	}
	
	public void setSize(int size) {
		if(size <2) {
			
		}else {
			diagSize = size;
		}
	}
	
	public ComponentListNode getFirst() {
		return this.first;
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


