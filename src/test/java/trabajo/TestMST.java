package trabajo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMST {
	@Test public void GenerarSubGrafo(){
		MST t = new MST(5);
        float graph[][] = new float[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };
        float[][] nGrafo = t.generarSubGrafo(graph);
        float esperado[][] = new float[][] { { 0, 2, 0, 6, 0 },
            								{ 2, 0, 3, 0, 5 },
            								{ 0, 3, 0, 0, 0 },
            								{ 6, 0, 0, 0, 0 },
            								{ 0, 5, 0, 0, 0 } };
            				
         for(int i = 0; i < 5; i++) {
        	 for(int j = 0; j < 5; j++) {
        		 assertEquals(esperado[i][j], nGrafo[i][j], 0.0);
        	 }
         }
	}
}
