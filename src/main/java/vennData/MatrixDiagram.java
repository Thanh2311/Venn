package vennData;

public class MatrixDiagram {
	private ComponentSet[][] setMatrix;
	private int sets;
	
	public MatrixDiagram() { //default 2 sets
		sets = 2;
		this.populateMatrix();
	}
	
	public MatrixDiagram(int size) { //up to  sets
		this.sets = size;
		this.populateMatrix();
	}
	
	private void populateMatrix() {
		setMatrix = new ComponentSet[sets][];
		for(int i = 0; i < sets; i++) {
			int length = choose(sets, i+1);
			setMatrix[i] = new ComponentSet[length];
			for(int j = 0; j < length; j++) {
				setMatrix[i][j] = new ComponentSet();
			}
		}
	}

	public ComponentSet getFromAttributes(byte[] attributes){
		int i = attributes.length - 1;
		int j = 0;
		for (int k = 0; k < attributes.length; k++) {
			j += choose((int)(sets-attributes[k]), k+1);
		}
		return setMatrix[i][j];
	}
	
	public void loadFromComponentList (ComponentList list){
		ComponentListNode next = list.getFirst();
		while (next != null){
			byte[] attributes = next.getComponent().getAttributes();
			this.getFromAttributes(attributes).append(next.getComponent());
			next = next.getNext();
		}
	}
	
	public int getSize(){
		return this.sets;
	}
	
	public static int test_getIndex(byte[] attributes, int sets) {
		//int i = attributes.length - 1;
		int j = 0;
		for (int k = 0; k < attributes.length; k++) {
			j += choose((int)(sets-attributes[k]), k+1);
			System.out.println(choose(sets-attributes[k], k+1));
		}
		return j;
	}
	
	private static int factorial(int n) {
		if (n <= 0) {
			return 1;
		}else {
			return factorial(n-1) * n;
		}
	}
	
	private static int choose(int s, int k) {
		//System.out.println(s);
		if(s<=0) {
			return 0;
		}
		int choose = factorial(s) / (factorial(s - k) * factorial(k));
		return choose;
	}
	
	public ComponentList toList() {
		ComponentList list = new ComponentList();
		for(int i = 0; i < setMatrix.length; i++) {
			for(int j = 0; j < setMatrix[i].length; j++) {
				list.append(setMatrix[i][j].toList());
			}
		}
		return list;
	}
	
}
