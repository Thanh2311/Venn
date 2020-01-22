package vennData;

import java.util.Scanner;

public class testShell {
	private int sets;
	
	public testShell() {
		sets = 2;
		Scanner sc = new Scanner(System.in);
		Scanner lc = new Scanner("");
		ComponentList cl = new ComponentList();
		boolean hold = true;
		while (hold) {
			String input = sc.nextLine();
			lc = new Scanner(input);
			String command  = lc.next();
			
			
			switch(command){
				case("add"):
					String name = lc.next();
					String attr = lc.next();
					byte[] attb = attr.getBytes();
					if(attb.length != sets) {
						System.out.println("bad inputs");
						break;
					}
					cl.append(new Component(name, attb));
					break;
				case("list"):
					System.out.println(cl.toString());
					break;
				case("set"):
					sets = Integer.parseInt(lc.next());
					break;
				case("break"):
					hold = false;
				break;
			}
		}
		lc.close();
		sc.close();
	}
}
