package Venn;

import vennData.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("Hello World");

		

		System.out.println("lab 0 testing");
		//VennGui vg = new VennGui();
		String test = "123";
		byte[] ts = test.getBytes();
		for(byte b: ts) {
			System.out.println(b-48);
		}
		ComponentGenerator a = new ComponentGenerator();
		
		//vennData.TestGUI tg = new TestGUI();
		
		vennData.testShell tsh = new vennData.testShell();
	}

}
