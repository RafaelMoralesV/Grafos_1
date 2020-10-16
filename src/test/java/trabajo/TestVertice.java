package trabajo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVertice {
	
	public Vertice testuno = new Vertice("test");
	public Vertice testdos = new Vertice("test");
	
	//PRUEBAS
	
	@Test
	public void testEquals() {
		Vertice aux = new Vertice(null);
		Object auxDos = new Object();
		assertEquals(testuno, testdos);
		assertEquals(testuno, testuno);
		assertNotEquals(testuno, aux);
		assertNotEquals(testuno, auxDos);
		assertNotEquals(testuno, null);
		
		testuno.setNombre(null);
		assertNotEquals(testuno, new Vertice("Miguel"));
	}
	
	@Test 
	public void testHashCode() {
		int aux1 = testuno.hashCode();
		int aux2 = testdos.hashCode();
		assertEquals(aux2, aux1, 0);
		
		assertNotEquals(aux2, new Vertice(null));
	}
	
	@Test public void testSettersGetters() {
		testuno.setNombre("Miguel");
		assertEquals("Miguel", testuno.getNombre());
	}
	
}
