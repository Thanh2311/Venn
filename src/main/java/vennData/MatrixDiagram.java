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
	
	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		}else {
			return factorial(n-1);
		}
	}
	
	private static int choose(int s, int k) {
		int choose = factorial(s) / (factorial(s - k) * factorial(k));
		return choose;
	}
	
}
