package vennData;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComponentTest {
	
	Component cp;
	
	@Test public void ComponentCreation() {
		byte[] tr1 = {2,1};
        cp = new Component("test", tr1);
        assertTrue("Constructor creates Component correcctly", cp != null);
        assertTrue("Constructor assigns name corrrctly", cp.getName().equals("test"));
        assertTrue("Constructor assigns attributes correctly", cp.getAttributes() == tr1); 
    }
	
}
