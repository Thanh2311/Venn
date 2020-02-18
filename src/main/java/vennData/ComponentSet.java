package vennData;

public class ComponentSet { //TODO, change implementation to array-based to allow indexing and easier sorting/finding
	private ComponentListNode first, last;
	private int length;
	
	public ComponentSet() {
		this.first = null;
		this.last = null;
		length = 0;
	}
	
	public void append(Component c) {
		if (this.length == 0) {
			ComponentListNode node = new ComponentListNode(c,null, null);
			this.first = node;
			this.last = node;
			length ++;
			
		}else {
		
			boolean hasComponent = false;
			ComponentListNode next = first;
			while(next != null) {
				if(next.getComponent().equals(c)) {
					hasComponent = true;
					break;
				}
				next = next.getNext();
			}
			if(hasComponent) {
				
			}else {
				ComponentListNode node = new ComponentListNode(c, null, this.last);
				this.last.setNext(node);
				this.last = node;
				length ++;
			}
		}
	}
	
	public void remove(Component c) {
		if (this.length == 1) {
			this.first = null;
			this.last = null;
			length = 0;
			
		}else {
			ComponentListNode next = first;
			while(next != null) {
				if(next.getComponent().equals(c)) {
					//delet this
					if(!next.hasNext()) {
						next.getPrevious().setNext(null);
						this.last = next.getPrevious();
					}else if(!next.hasPrevious()) {
						next.getNext().setPrevious(null);
						this.first = next.getNext();
					}else {
						next.getNext().setPrevious(next.getPrevious());
						next.getPrevious().setNext(next.getNext());
					}
					break;
				}
				next = next.getNext();
			}
		}

	}
	
	public int getLength() {
		return this.getLength();
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
	
	public ComponentList toList() {
		ComponentList list = new ComponentList();
		ComponentListNode next = first;
		while(next != null) {
			list.append(next.getComponent());
			next = next.getNext();
		}
		return list;
	}
}
