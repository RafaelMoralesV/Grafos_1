package trabajo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;

//import java.util.List;

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
	
	@Test public void testAdyacentes() {
		testUno.agregarVertice("AUX");
		testUno.agregarArista("A", "AUX");
		assertEquals(2, testUno.adyacentes("A").size(), 0.0);
		
		assertEquals(Collections.emptyList(), testUno.adyacentes("No Vertice"));
	}
	
	// PRUEBAS SOBRE ARISTAS
	
	@Test public void testAddArista() {
		testUno.agregarAristaDir("A", "C");
		assertEquals("Nueva Arista en A", 2, testUno.sizeAdyacentes("A"));
	}
	
	@Test public void testRemoveAristaDir() {
		testUno.eliminarAristaDir("A", "B");
		assertEquals("Eliminada una arista de A", 0, testUno.sizeAdyacentes("A"));
		assertEquals("Se mantiene una arista de B -> A", 1, testUno.sizeAdyacentes("B"));
	}
	
	@Test public void testRemoveAristas() {
		testUno.eliminarAristas("A", "B");
		assertEquals("Ninguna arista entre A y B", 0, testUno.sizeAdyacentes("A") + testUno.sizeAdyacentes("B"));
	}
	
	// PRUEBAS SOBRE PROPIEDADES DEL GRAFO
	
	@Test public void testEsNoDirigido() {
		// Actualmente el grafo es simple o no dirigido
		assertTrue(testUno.esNoDirigido());
		
		// Ahora al volverlo dirigido, el resultado cambia
		testUno.agregarAristaDir("A", "C");
		assertFalse(testUno.esNoDirigido());
	}
	
	@Test public void testCaminoHamiltoniano() {
		Grafo g = new Grafo();
		g.agregarVertice("A");
	    g.agregarVertice("B");
	    g.agregarVertice("C");
	    g.agregarVertice("D");
	    g.agregarVertice("E");
	    g.agregarVertice("F");
	    
	    
	    g.agregarArista("A", "B");
	    g.agregarArista("A", "C");
	    g.agregarArista("A", "F");
	    g.agregarArista("B", "C");
	    g.agregarArista("B", "F");
	    g.agregarArista("C", "D");
	    g.agregarArista("C", "E");
	    g.agregarArista("D", "E");
	    
	    assertEquals(Collections.emptyList(), g.caminoHamiltoneano());
	    
	    // Agregar esta arista lo vuelve hamiltoneano
	    g.agregarArista("D", "A");
	    assertNotEquals(Collections.emptyList(), g.caminoHamiltoneano());
	    
	}
	
	// PRUEBAS SOBRE UTILIDADES
	
	@Test public void testToString() {
		String stringEsperada = "0: 0 1 0 \n1: 1 0 0 \n2: 0 0 0 \n";
		assertEquals(stringEsperada, testUno.toString());
	}
	
	@After
	public void Destroy() {
		testUno.eliminarVertice("A");
		testUno.eliminarVertice("B");
		testUno.eliminarVertice("C");
	}
	
}
