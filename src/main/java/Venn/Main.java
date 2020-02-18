package Venn;

import vennData.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD


		

		System.out.println("lab 0 testing");
=======
>>>>>>> refs/remotes/origin/develop
		//VennGui vg = new VennGui();
		String test = "321";
		byte[] ts = test.getBytes();
		for(int i = 0; i<ts.length; i++) {
			ts[i] = (byte)((ts[i]-48)%10);
			System.out.println(ts[i]);
		}
<<<<<<< HEAD
		ComponentGenerator a = new ComponentGenerator();
=======
		byte[] ts2 = {3,1};
		byte[] ts3 = {2,1};
		byte[] ts4 = {2};
		System.out.println("-------------------------------");
>>>>>>> refs/remotes/origin/develop
		
		MatrixDiagram md = new MatrixDiagram(3);
		Component cp = new Component("hi", ts);
		Component cp1 = new Component("test", ts);
		Component cp2 = new Component("test2", ts2);
		Component cp3 = new Component("test3", ts3);
		Component cp4 = new Component("test4", ts4);
		md.getFromAttributes(ts).append(cp);
		md.getFromAttributes(ts).append(cp);
		md.getFromAttributes(ts).append(cp1);
		md.getFromAttributes(ts2).append(cp2);
		md.getFromAttributes(ts3).append(cp3);
		md.getFromAttributes(ts4).append(cp4);
		//md.getFromAttributes(ts).remove(cp); //tested - works
		
		//System.out.println(md.getFromAttributes(ts).toString());
		
		System.out.println(md.toList().toString());
	}

}
