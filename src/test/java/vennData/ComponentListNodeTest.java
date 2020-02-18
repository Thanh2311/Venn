package vennData;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComponentListNodeTest {
	
	Component cp, cp2, cp3;
	ComponentListNode cn, cn2, cn3;
	byte[] tr1 = {2,1};
	
	@Test public void NodeCreation() {
        cp = new Component("test", tr1);
        cn = new ComponentListNode(cp, null, null);
        cp2 = new Component("test2", tr1);
        cn2 = new ComponentListNode(cp2, cn, cn);
        
        assertTrue("Constructor creates ComponentListNode", cn != null);
        assertTrue("Constructor assigns component correctly", cn.getComponent() == cp);
        assertTrue("Constructor assigns next node correctly - null case", cn.getNext() == null);
        assertTrue("Constructor assigns next node correctly - node case", cn2.getNext() == cn);
        assertTrue("Constructor assigns previous node correctly - null case", cn.getPrevious() == null);
        assertTrue("Constructor assigns previous node correctly - node case", cn2.getPrevious() == cn); 
    }
	
	@Test public void NodeMutation() {
        cp = new Component("test", tr1);
        cn = new ComponentListNode(cp, null, null);
        cp2 = new Component("test2", tr1);
        cn2 = new ComponentListNode(cp2, null, null);
        cp3 = new Component("test3", tr1);
        cn3 = new ComponentListNode(cp3, null, null);
        
        cn.setNext(cn2);
        assertTrue("Mutator assigns next node correctly", cn.getNext() == cn3);
        assertTrue("Mutator does not change previous node", cn.getPrevious() == null); 
        
        cn.setPrevious(cn3);
        assertTrue("Mutator does not change next node", cn.getNext() == cn2);
        assertTrue("Mutator assigns previous node correctly", cn.getPrevious() == cn3); 
    }
	
	@Test public void nodeExistence() {
		cp = new Component("test", tr1);
        cn = new ComponentListNode(cp, null, null);
        cp2 = new Component("test2", tr1);
        cn2 = new ComponentListNode(cp2, null, null);
        
        assertFalse("existence of next node is checked corretly", cn.hasNext());
        assertFalse("existence of previous node is checked corretly", cn.hasPrevious());
        
        cn.setNext(cn2);
        assertTrue("Mutator affects existence of next node correctly", cn.hasNext());
        assertFalse("Mutator affects existence of previous node correctly", cn.hasPrevious()); 
        
        cn.setPrevious(cn2);
        assertTrue("Mutator affects existence of next node correctly", cn.hasNext());
        assertTrue("Mutator affects existence of previous node correctly", cn.hasPrevious());
        
    }
}