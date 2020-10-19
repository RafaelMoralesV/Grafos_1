package trabajo;

import java.util.*;

public class GrafoPesado extends Grafo {
	
	/* Extiende a la clase grafo, añadiendo soporte para aristas con un peso
	 */
	
	private List<Arista> pesos;
	
	public GrafoPesado() {
		super.vertAdyacentes = new HashMap<>();
		this.pesos = new ArrayList<>();
	}
	
	public int sizeAristas() {
		return pesos.size();
	}
	
	// Encuentra una arista segun su inicio y fin
	private Arista encontrarArista(Vertice v1, Vertice v2) {
		for(Arista a : pesos) {
			if(a.getInicio().equals(v1) && a.getDestino().equals(v2)) {
				return a;
			}
		}
		return null;
	}
	private Arista encontrarArista(String inicio, String destino) {
		Vertice v1 = new Vertice(inicio);
		Vertice v2 = new Vertice(destino);
		return encontrarArista(v1, v2);
	}
	
	
	// Obten el peso de una arista en el grafo
	private float getPeso(Vertice inicio, Vertice fin) {
		// Retorna el peso de una arista, o -1 si la arista no existe
		Arista find = encontrarArista(inicio, fin);
		if(find != null) {
			return find.getPeso();
		}
		return -1;
	}
	public float getPeso(String inicio, String fin) {
		
		return getPeso(new Vertice(inicio), new Vertice(fin));
	}
	
	// Agregar vertice se hereda de Grafo
	@Override public void eliminarVertice(String nombre) {
		Vertice v = new Vertice(nombre);
		for(Arista a : pesos) {
			if(a.getInicio().equals(v) || a.getDestino().equals(v)) {
				pesos.remove(a);
			}
		}
		super.eliminarVertice(nombre);
	}
	
	// Agrega una arista en una sola direccion
	
	@Override public void agregarAristaDir(String nombre1, String nombre2) {
		if(this.existsIn(nombre1) && this.existsIn(nombre2)) {
			pesos.add(new Arista(new Vertice(nombre1), new Vertice(nombre2), 0));
			super.agregarAristaDir(nombre1, nombre2);
		}
	}
	public void agregarAristaDir(String nombre1, String nombre2, float peso) {
		if(this.existsIn(nombre1) && this.existsIn(nombre2)) {
			pesos.add(new Arista(new Vertice(nombre1), new Vertice(nombre2), peso));
			super.agregarAristaDir(nombre1, nombre2);
		}
	}
	
	// Agregar una arista en ambos sentidos
	@Override public void agregarArista(String nameA, String nameB) {
		this.agregarAristaDir(nameA, nameB, 0);
		this.agregarAristaDir(nameB, nameA, 0);
	}
	public void agregarArista(String nameA, String nameB, float peso) {
		this.agregarAristaDir(nameA, nameB, peso);
		this.agregarAristaDir(nameB, nameA, peso);
	}
	
	// Eliminar una arista
	@Override public void eliminarAristaDir(String nombre1, String nombre2){
		Arista a = null;
		do {
			a = this.encontrarArista(nombre1, nombre2);
			if(a != null) {
				pesos.remove(a);
			}
		}while(a != null);
		super.eliminarAristaDir(nombre1, nombre2);
	}
	// Eliminar arista en ambos sentidos
	@Override public void eliminarAristas(String nameA, String nameB) {
		this.eliminarAristaDir(nameA, nameB);
		this.eliminarAristaDir(nameB, nameA);
	}
	
	public float[][] generarMatrizPesos() {
		int numVerts = vertAdyacentes.size();
		float[][] matriz = new float[numVerts][numVerts];
		
		Set<Vertice> keys = vertAdyacentes.keySet();
		Vertice[] arrVerts = keys.toArray(new Vertice[keys.size()]);
		
		for (int i = 0; i < arrVerts.length; i++) {
			for (int j = 0; j < arrVerts.length; j++) {
				matriz[i][j] = this.getPeso(arrVerts[i], arrVerts[j]);
			}
		}
		return matriz;
	}
	
	public String toStringPeso() {
		StringBuilder s = new StringBuilder();
		float[][] matrizAdy = this.generarMatrizPesos();
		
		for (int i = 0; i < vertAdyacentes.size(); i++) {
			s.append(i + ": ");
			for (float j : matrizAdy[i]) {
				s.append((j==-1?"-":j) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	public String toStringPeso(float[][] grafo) {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < vertAdyacentes.size(); i++) {
			s.append(i + ": ");
			for (float j : grafo[i]) {
				s.append((j==-1?"-":j) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	
	// DIJKSTRA
	
	private static class Par{
		public Vertice anterior;
		public double peso;
		public Par(Vertice v, double p) {
			this.anterior = v;
			this.peso = p;
		}
	}
	
	public List<Vertice> dijkstra(String inicio, String destino){
		/*	distancia del vertice inicial = 0
		 * 	distancia a todos los demas = infinito
		 * 
		 * 	WHILE vertices sin visitar no este vacio
		 * 		visitar el siguiente vertice que este mas cerca
		 * 		FOR cada vecino sin visitar de este vertice
		 * 			Calcula la distancia desde el vertice inicial
		 * 			IF la dist es mas corta que la que ya se conoce
		 * 				Actualiza la distancia mas corta a este vertice
		 * 				Actualiza el vertice anterior a este vertice
		 * 			FI
		 *		SIGUIENTE vecino sin visitar
		 *		Agregar el vertice actual a la lista de vertices visitados
		 *	FIN WHILE
		 */
		
		int n = this.sizeVertices();
		
		Set<Vertice> keys = vertAdyacentes.keySet();
		ArrayList<Vertice> verts = new ArrayList<>(keys);
		int index = verts.indexOf(new Vertice(inicio));
		
		boolean[] SPT = new boolean[n];
		double[] dist = new double[n];
		for(int i = 0; i < n; i++) {
			dist[i] = Float.POSITIVE_INFINITY;
		}
		
		PriorityQueue<Par> pq = new PriorityQueue<>(verts.size(), new Comparator<Par>(){
			@Override
			public int compare(Par p1, Par p2) {
				if(p1.peso == p2.peso) {
					return 0;
				}
				return (p1.peso > p2.peso)?1:-1;
			}
		});
		
		dist[index] = 0;
		Par p0 = new Par(new Vertice(inicio), 0);
		pq.offer(p0);
		
		Vertice[] anteriores = new Vertice[n];
		Deque<Vertice> camino = new LinkedList<>();
		
		
		while(!pq.isEmpty()) {
			Par extraido = pq.poll();
			int ind = verts.indexOf(extraido.anterior);
			
			SPT[ind] = true;
			double minValue = extraido.peso;
			
			if(dist[ind] < minValue) {
				continue;
			}
			
			for(Vertice vecino : this.adyacentes(extraido.anterior.getNombre())) {
				
				int indexVecino = verts.indexOf(vecino);
				if(SPT[indexVecino]) {
					continue;
				}
				double nuevaDist = dist[ind] + getPeso(extraido.anterior, vecino);
				if(nuevaDist < dist[indexVecino]) {
					anteriores[indexVecino] = extraido.anterior;
					dist[indexVecino] = nuevaDist;
					Par p = new Par(vecino, nuevaDist);
					pq.offer(p);
				}
				
			}
			if (extraido.anterior.getNombre() == destino) {
				int begin = verts.indexOf(new Vertice(destino));
				camino.push(new Vertice(destino));
				while(!camino.contains(new Vertice(inicio))) {
					camino.push(anteriores[begin]);
					begin = verts.indexOf(anteriores[begin]);
				}
				break;
			}
		}
		
		return new ArrayList<>(camino);
	}
}






















