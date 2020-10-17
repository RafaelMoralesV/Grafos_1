package trabajo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGrafoPesado {
	private GrafoPesado testSubject = new GrafoPesado();
	
	@Before public void init() {
		testSubject.agregarVertice("A");
		testSubject.agregarVertice("B");
		testSubject.agregarVertice("C");
		testSubject.agregarArista("A", "B", 5);
	}
	
	// Util get peso
	@Test public void testGetPeso() {
		assertEquals(5, testSubject.getPeso("A", "B"), 0.0);
	}
	
	// Eliminar vertice y aristas relacionadas
	@Test public void eliminarVertice() {
		int cantInicial = testSubject.sizeVertices();
		testSubject.eliminarVertice("B");
		// Se espera que la cantidad de vertices baje en 1
		assertEquals(cantInicial - 1, testSubject.sizeVertices(), 0.0);
		
		// Se espera que, al no haber arista, su peso sea -1
		assertEquals(-1, testSubject.getPeso("A", "B"), 0.0);
	}
	
	// Revisar agregar aristas mas metodo sobreescrito
	@Test public void testAgregarArista() {
		testSubject.agregarArista("B", "C", 10);
		assertEquals(4, testSubject.sizeAristas(), 0.0);
		
		testSubject.agregarAristaDir("C", "A", 2);
		assertEquals(5, testSubject.sizeAristas(), 0.0);
	}
	@Test public void testAgregarAristaOverriden() {
		testSubject.agregarArista("B", "C");
		assertEquals(4, testSubject.sizeAristas(), 0.0);
		
		testSubject.agregarAristaDir("C", "A");
		assertEquals(5, testSubject.sizeAristas(), 0.0);
	}
	
	@Test public void testEliminarAristaDir() {
		testSubject.eliminarAristaDir("A", "B");
		assertEquals(-1, testSubject.getPeso("A", "B"), 0.0);
	}
	@Test public void testEliminarAristas() {
		testSubject.eliminarAristas("A", "B");
		assertEquals(0, testSubject.sizeAristas(), 0.0);
	}
	
	@Test public void testMatrizPeso() {
		float[][] matrizEsperada = {{-1, 5, -1},
									{5, -1, -1},
									{-1, -1, -1}};
		
		assertArrayEquals(matrizEsperada, testSubject.generarMatrizPesos());
	}
	@Test public void testStringMatrizPeso() {
		String stringEsperada = "0: - 5.0 - \n1: 5.0 - - \n2: - - - \n";
		assertEquals(stringEsperada, testSubject.toStringPeso());
	}
}
