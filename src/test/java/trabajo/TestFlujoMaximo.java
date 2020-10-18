package trabajo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFlujoMaximo {
	@Test public void testFlujoMaximo() {
		float grafo[][] =new float[][] { {0, 16, 13, 0, 0, 0}, 
            {0, 0, 10, 12, 0, 0}, 
            {0, 4, 0, 0, 14, 0}, 
            {0, 0, 9, 0, 0, 20}, 
            {0, 0, 0, 7, 0, 4}, 
            {0, 0, 0, 0, 0, 0} 
          }; 
		
		MaximoFlujo m = new MaximoFlujo(6);
		
		assertEquals(23, m.fordFulkerson(grafo, 0, 5), 0.0);
	}
}
