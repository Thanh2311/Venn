package vennData;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComponentListTest {
	
	ComponentList n1;
	Component  cp;
	
	@Test public void listCreation() {
	
	 n1 = new ComponentList();
	
	assertTrue("Create an empty list", n1.getLength() == 0);
	assertTrue("First element is null", n1.getFirst() == null);
	
	byte[] tr1 = {2,1};
	cp = new Component("test", tr1);
	
	n1.append(cp);
	
	assertTrue("Append the first component to the list", n1.getLength() == 1);
	
	ComponentList list = new ComponentList();
	
	assertTrue("Create another empty list 'List2'", list.getLength() == 0);

	
	
	byte[] tr2 = {1,2};
	byte[] tr3 = {3,4};
	
	Component  cp2 = new Component("test", tr2);
	Component  cp3 = new Component("test", tr3);
	
	list.append(cp2);
	list.append(cp3);
	
	assertTrue("Append two components to the List2", list.getLength() == 2);

	n1.append(list);
	
	assertTrue("Append list1 to the List2", n1.getLength() == 3);

	
	assertTrue("FirstNode", n1.getFirst().getComponent().equals(cp));
	assertTrue("LastNode", n1.getLast().getComponent().equals(cp3));



	
	
	
	




	
	
	
	
	
	}

}
