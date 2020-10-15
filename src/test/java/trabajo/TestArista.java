package trabajo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArista {
	private Vertice ver1 = new Vertice("ver1");
	private Vertice ver2 = new Vertice("ver2");
	private Arista testuno = new Arista(ver1,ver2,2);
	
	private Arista testdos = new Arista("ver1","ver2",2);
	
    
		
		//PRUEBAS
		
	@Test public void testGetPeso() {
		float aux1=testuno.getPeso();
		float aux2=testdos.getPeso();
		assertEquals(aux1,aux2,0.0);
	}
	
	


}
