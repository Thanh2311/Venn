package vennData;

public class ComponentSet { //TODO, change implementation to array-based to allow indexing and easier sorting/finding
	private int length = 25;
	Component[] arr1;
	private int index;
	
	public ComponentSet() {
		
		arr1 = new Component[length];
		index = 0;

	}
	
	public void append(Component c) {
		if (index < length) {
			arr1[index] = c;
			index ++;
			
		}else {
		
			Component[] arrDouble = new Component[2*arr1.length];
			for(int i =0; i<arr1.length; i++) {
				arrDouble[i] = arr1[i];
				
			}
			
			arr1 = arrDouble;
			arr1[index] = c;
		}
	}
	
	public void remove(Component c) {
		int temp = -1;
		for(int i =0; i < index; i++) {
			if(arr1[i] == c) {temp = i; break;}
		}
		
		for(int j = temp + 1; j <= index; j++ ) {
		arr1[temp] = null;
		
		arr1[j-1] = arr1[j];}
		index--;
	}
	
	public int getLength() {
		return index;
	}
	
	public Component getFirst() {
		return arr1[0];
	}
	
	public String toString() {
		String out = "";
		
		for(int i = 0; i< index; i++) {
			out += arr1[i];
			out += "\n";
		}
		return out;
	}
	
	public ComponentList toList() {
		ComponentList list = new ComponentList();
		int i = 0;
		while (i < index) {
			list.append(arr1[i]);
			i++;
		}
		return list;
	}
}
