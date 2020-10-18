package trabajo;

import java.util.*;

public class MaximoFlujo {
	int cantVertices;
	
	public MaximoFlujo(int size) {
		this.cantVertices = size;
	}
	  
    /*	Retorna verdadero si existe aun un camino entre s y t en el grafo residual
     *  y rellena camino[] con este
     */
    boolean bfs(float grafoResidual[][], int s, int t, int camino[]) 
    { 
        // Declaro no haber visitado ningun nodo
        boolean visitado[] = new boolean[cantVertices]; 
        for(int i=0; i<cantVertices; ++i) 
            visitado[i]=false; 
  
        // Creo una cola, agrego s y lo marco como visitado
        LinkedList<Integer> cola = new LinkedList<Integer>(); 
        cola.add(s); 
        visitado[s] = true; 
        camino[s]=-1; 
  
        // Loop tipico de BFS
        while (cola.size()!=0) 
        { 
            int u = cola.poll(); 
  
            for (int v=0; v<cantVertices; v++) 
            { 
                if (visitado[v]==false && grafoResidual[u][v] > 0) 
                { 
                    cola.add(v); 
                    camino[v] = u; 
                    visitado[v] = true; 
                } 
            } 
        } 
  
        // Si llegamos hasta t en el grafo, existe un camino
        return (visitado[t] == true); 
    } 
  
    // retorna el flujo maximo entre un vertice s y t
    float fordFulkerson(float grafo[][], int s, int t) 
    { 
        int u, v; 
  
        //	Creo un grafo residual y lo relleno con las mismas
        //	capacidades que el grafo original.
        float grafoResidual[][] = new float[cantVertices][cantVertices]; 
  
        for (u = 0; u < cantVertices; u++) 
            for (v = 0; v < cantVertices; v++) 
                grafoResidual[u][v] = grafo[u][v]; 
  
        // Este arreglo lo rellena BFS, contiene un camino desde s hacia t
        int camino[] = new int[cantVertices]; 
  
        float flujoMaximo = 0;
  
        // Mientras haya un camino, aumento el flujo maximo
        while (bfs(grafoResidual, s, t, camino)) 
        { 
            // Encuentro la capacidad residual mas chica
            float flujoCamino = Float.MAX_VALUE; 
            for (v=t; v!=s; v=camino[v]) 
            { 
                u = camino[v]; 
                flujoCamino = Math.min(flujoCamino, grafoResidual[u][v]); 
            } 
  
            // Actualizo las capacidades residuales
            for (v=t; v != s; v=camino[v]) 
            { 
                u = camino[v]; 
                grafoResidual[u][v] -= flujoCamino; 
                grafoResidual[v][u] += flujoCamino; 
            } 
            flujoMaximo += flujoCamino; 
        } 
  
        // Retorna el flujo maximo
        return flujoMaximo; 
    } 
}
