package Venn;

import vennData.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("lab 0 testing");
		//VennGui vg = new VennGui();
		String test = "321";
		byte[] ts = test.getBytes();
		for(int i = 0; i<ts.length; i++) {
			ts[i] = (byte)((ts[i]-48)%10);
			System.out.println(ts[i]);
		}
		System.out.println("-------------------------------");
		//vennData.TestGUI tg = new TestGUI();
		MatrixDiagram md = new MatrixDiagram();
		System.out.println(MatrixDiagram.test_getIndex(ts,4));
		//vennData.testShell tsh = new vennData.testShell();
	}

}
