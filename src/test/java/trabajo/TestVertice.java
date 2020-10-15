package trabajo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVertice {
	
	public Vertice testuno = new Vertice("test");
	public Vertice testdos = new Vertice("test");
	
	//PRUEBAS
	
	@Test
	public void testequals() {
		assertTrue(testuno.equals(testdos));
	}
	
	@Test 
	public void testHashCode() {
		int aux1 = testuno.hashCode();
		int aux2 = testdos.hashCode();
		assertEquals(aux2, aux1, 0);
	}
	
}
