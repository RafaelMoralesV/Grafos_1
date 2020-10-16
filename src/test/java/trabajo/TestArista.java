package trabajo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArista {
	private Arista testuno;
	private Arista testdos;
	private Arista aux;
	
	
	@Before
	public void init() {
		Vertice ver1 = new Vertice("ver1");
		Vertice ver2 = new Vertice("ver2");
		testuno = new Arista(ver1, ver2, 2);
		
		testdos = new Arista("ver1", "ver2", 2);
		
		aux = new Arista("Inicio", "Otro", 0);
	}
    
	// GETTERS
	
	@Test public void testGetterInicio() {
		assertEquals(testuno.getInicio(), testdos.getInicio());
	}
	
	@Test public void testGetterDestino() {
		assertEquals(testuno.getDestino(), testdos.getDestino());
	}
	
	@Test public void testGetterPeso() {
		float aux1=testuno.getPeso();
		float aux2=testdos.getPeso();
		assertEquals(aux1,aux2,0.0);
	}
	
	// SETTERS
	
	@Test public void testSetterDestino() {
		testuno.setDestino(new Vertice("Otro"));
		assertEquals(testuno.getDestino(), aux.getDestino());
	}
	
	@Test public void testSetterInicio() {
		testuno.setInicio(new Vertice("Inicio"));
		assertEquals(testuno.getInicio(), aux.getInicio());
	}
	@Test public void testSetterPeso() {
		testuno.setPeso(0);
		assertEquals(testuno.getPeso(), aux.getPeso(), 0.0);
	}
	


}
