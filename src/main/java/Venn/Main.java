package Venn;

import vennData.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("lab 0 testing");
		//VennGui vg = new VennGui();
		String test = "2";
		byte[] ts = test.getBytes();
		for(int i = 0; i<ts.length; i++) {
			ts[i] = (byte)((ts[i]-48)%10);
			System.out.println(ts[i]);
		}
		byte[] ts2 = {2,1};
		byte[] ts3 = {1};
		System.out.println("-------------------------------");
		//vennData.TestGUI tg = new TestGUI();
		MatrixDiagram<String> md = new MatrixDiagram<String>();
		
		md.setFromAttributes(ts,"set 2");
		md.setFromAttributes(ts2,"intersection of 2 and 1");
		md.setFromAttributes(ts3,"set 1");
		
		System.out.println(md.getFromAttributes(ts));
		System.out.println(md.getFromAttributes(ts2));
		System.out.println(md.getFromAttributes(ts3));
		//vennData.testShell tsh = new vennData.testShell();
	}

}
