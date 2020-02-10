package vennData;

public class MatrixDiagram {
	private Object[][] setMatrix;
	private int sets;
	
	public MatrixDiagram() { //default 2 sets
		sets = 2;
		this.generateMatrix();
	}
	
	private void generateMatrix() {
		setMatrix = new Object[sets][];
		for(int i = 0; i < sets; i++) {
			int length = choose(sets, i);
			setMatrix[i] = new Object[length];
		}
	}
	
	//private void populateMatrix
	
	//private static int 
	
	public static int test_getIndex(byte[] attributes, int sets) {
		int i = attributes.length + 1;
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
	
	public static int choose(int s, int k) {
		//System.out.println(s);
		if(s<=0) {
			return 0;
		}
		int choose = factorial(s) / (factorial(s - k) * factorial(k));
		return choose;
	}
	
}
