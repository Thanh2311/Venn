package vennData;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComponentTest {
	
	Component cp, cp2, cp3;
	byte[] tr1 = {2,1};
	
	@Test public void ComponentCreation() {
        cp = new Component("test", tr1);
        assertTrue("Constructor creates Component", cp != null);
        assertTrue("Constructor assigns name correctly", cp.getName().equals("test"));
        assertTrue("Constructor assigns attributes correctly", cp.getAttributes() == tr1); 
    }
	
	@Test public void ComponentComparison() {
		byte[] tr1 = {2,1};
        cp = new Component("test", tr1);
        cp2 = new Component("test", tr1);
        cp3 = new Component("tesu",tr1);
        
        assertTrue("Components are compared by name only, same name case", cp.compareTo(cp2) == 0);
        assertTrue("Components are compared by name only, first < second", cp.compareTo(cp3) < 0);
        assertTrue("Components are compared by name only, first > second", cp3.compareTo(cp) > 0);
        
    }
}
