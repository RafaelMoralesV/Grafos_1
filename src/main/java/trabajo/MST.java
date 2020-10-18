package trabajo;

public class MST {
	// Clase Minimum Spanning Tree
	
	// Cantidad de vertices en el grafo
	private int V;
	
	public MST(int size) {
		this.V = size;
	}
	 
    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(float key[], Boolean mstSet[]){
        float min = Float.MAX_VALUE;
        int min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    int[] primMST(float graph[][])
    {
        // Array to store constructed MST
        int parent[] = new int[V];
 
        // Key values used to pick minimum weight edge in cut
        float key[] = new float[V];
 
        // To represent set of vertices included in MST
        Boolean mstSet[] = new Boolean[V];
 
        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        // Always include first 1st vertex in MST.
        key[0] = 0; // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = 0; // First node is always root of MST
 
        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);
 
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
 
            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++)
 
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        return parent;
    }
    
    public float[][] generarSubGrafo(float[][] graph){
    	int[] indices = this.primMST(graph);
    	float[][] grafo = new float[V][V];
    	for(int i = 0; i < V; i++) {
    		for(int j = 0; j < V; j++) {
    			grafo[i][j] = 0;
    		}
    	}
    	for(int i = 0; i < V; i++) {
    		grafo[i][indices[i]] = graph[i][indices[i]];
    		grafo[indices[i]][i] = graph[indices[i]][i];
    	}
    	for(int i = 0; i < V; i++) {
    		for(int j = 0; j < V; j++) {
    			System.out.print(grafo[i][j] + " ");
    		}
    		System.out.print("\n");
    	}
    	return grafo;
    }
}
