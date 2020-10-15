package trabajo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGrafo {
	private Grafo testUno = new Grafo();
	
	@Before
	public void init() {
		testUno.agregarVertice("A");
		testUno.agregarVertice("B");
		testUno.agregarVertice("C");
		testUno.agregarArista("A", "B");
	}
	
	// PRUEBAS SOBRE VERTICES
	
	@Test public void testSize() {
		assertEquals("Mirando size inicial", 3, testUno.sizeVertices());
	}
	
	@Test public void testAdd() {
		testUno.agregarVertice("D");
		assertEquals("Nuevo vertice en grafo", 4, testUno.sizeVertices());
	}
	
	@Test public void testRemove() {
		testUno.eliminarVertice("D");
		assertEquals("Eliminado vertice", 3, testUno.sizeVertices());
	}
	
	// PRUEBAS SOBRE ARISTAS
	
	@Test public void testAddArista() {
		testUno.agregarAristaDir("A", "C");
		assertEquals("Nueva Arista en A", 2, testUno.sizeAdyacentes("A"));
	}
	
	@Test public void testRemoveArista() {
		testUno.eliminarAristaDir("A", "B");
		assertEquals("Eliminada una arista de A", 0, testUno.sizeAdyacentes("A"));
	}
	
	@After
	public void Destroy() {
		testUno.eliminarVertice("A");
		testUno.eliminarVertice("B");
		testUno.eliminarVertice("C");
	}
	
}
