package trabajo;

import java.util.*;

public class Grafo {
	/*
	 * Clase principal que describe un grafo basico Contiene metodos para funcionar
	 * como grafo sin peso, con o sin direcciones para las aristas
	 */

	protected Map<Vertice, List<Vertice>> vertAdyacentes;

	public Grafo() {
		this.vertAdyacentes = new HashMap<>();
	}

	// 						//
	// 		VERTICES 		//
	// 						//

	// Agregar nuevo vertice
	public void agregarVertice(String nombre) {
		this.vertAdyacentes.putIfAbsent(new Vertice(nombre), new ArrayList<>());
	}

	public void eliminarVertice(String nombre) {
		if(this.existsIn(nombre)) {
			Vertice v = new Vertice(nombre);
		
			// Elimina la lista de vertices adyacentes a 'nombre'
			this.vertAdyacentes.values().stream().forEach(e -> e.remove(v));
		
			// Elimina el vertice del grafo
			this.vertAdyacentes.remove(new Vertice(nombre));
		}
	}
	
	public List<Vertice> adyacentes(String vertice){
		// Retorna los vertices adyacentes a <vertice> o una lista vacia si el vertice no existe
		return (this.existsIn(vertice))?vertAdyacentes.get(new Vertice(vertice)):Collections.emptyList();
	}
	
	public boolean esNoDirigido() {
		// A partir de la matriz de adyacencia, define si el grafo es o no dirigido.
		boolean[][] grafo = this.generarMatrizAdyacencia();
		for(int i = 0; i < this.sizeVertices(); i++) {
			for(int j = i; j < this.sizeVertices(); j++) {
				if(grafo[i][j] != grafo[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	// 						//
	// 		ARISTAS 		//
	// 						//

	// Agrega una arista en una sola direccion
	public void agregarAristaDir(String nombre1, String nombre2) {
		if(this.existsIn(nombre1) && this.existsIn(nombre2)) {
			Vertice v1 = new Vertice(nombre1);
			Vertice v2 = new Vertice(nombre2);
			this.vertAdyacentes.get(v1).add(v2);
		}
	}

	// Agrega una arista entre vertices
	public void agregarArista(String nameA, String nameB) {
		this.agregarAristaDir(nameA, nameB);
		this.agregarAristaDir(nameB, nameA);
	}

	// Elimina una sola arista entre <nombre1> y <nombre2>
	public void eliminarAristaDir(String nombre1, String nombre2) {
		if(this.existsIn(nombre1)) {
			Vertice v1 = new Vertice(nombre1);
			Vertice v2 = new Vertice(nombre2);
			List<Vertice> eV1 = this.vertAdyacentes.get(v1);
			if (eV1 != null)
				eV1.remove(v2);
		}
	}

	// Elimina todas las aristas entre <nombre1> y <nombre2>
	public void eliminarAristas(String nameA, String nameB) {
		this.eliminarAristaDir(nameA, nameB);
		this.eliminarAristaDir(nameB, nameA);
	}

	// 					//
	// 		UTILS 		//
	// 					//

	public int sizeVertices() {
		return this.vertAdyacentes.size();
	}

	public int sizeAdyacentes(String nombre) {
		Vertice v = new Vertice(nombre);
		return this.vertAdyacentes.get(v).size();
	}
	
	public boolean existsIn(String nombre) {
		Vertice v = new Vertice(nombre);
		return vertAdyacentes.containsKey(v);
	}
	
	//									//
	// 		MATRIZ DE ADYACENCIA 		//
	// 									//
	
	public boolean[][] generarMatrizAdyacencia() {
		// Dimensiones y nueva matriz de adyacencia
		int numVerts = vertAdyacentes.size();
		boolean[][] matrizAdy = new boolean[numVerts][numVerts];

		// Generado nuevo arreglo con los vertices en el grafo
		Set<Vertice> keys = vertAdyacentes.keySet();
		Vertice[] arrVerts = keys.toArray(new Vertice[keys.size()]);

		// Se rellena la matriz segun la lista asociada a cada vertice
		for (int i = 0; i < arrVerts.length; i++) {
			for (int j = 0; j < arrVerts.length; j++) {
				matrizAdy[i][j] = vertAdyacentes.get(arrVerts[i]).contains(arrVerts[j]);
			}
		}
		return matrizAdy;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean[][] matrizAdy = this.generarMatrizAdyacencia();
		
		ArrayList<Vertice> l = new ArrayList<>(vertAdyacentes.keySet());
		for (int i = 0; i < vertAdyacentes.size(); i++) {
			s.append(l.get(i).getNombre() + ": ");
			for (boolean j : matrizAdy[i]) {
				s.append((j ? 1 : 0) + " ");
			}
			s.append("\n");
		}
		return s.toString();

	}
	
	public String graphToString(boolean[][] matrizAdy) {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < vertAdyacentes.size(); i++) {
			s.append(i + ": ");
			for (boolean j : matrizAdy[i]) {
				s.append((j ? 1 : 0) + " ");
			}
			s.append("<br />");
		}
		return s.toString();
	}
	
	
	//									//
	// 		PROPIEDADES DEL GRAFO 		//
	// 									//
	
	
	public boolean esConexo() {
		boolean[][] matrizAdy = this.generarMatrizAdyacencia();
		
		for(int i = 0; i < vertAdyacentes.size(); i++) {
			// Checkea valores para columnas
			boolean col = false;
			for(int j = 0; j < vertAdyacentes.size(); j++) {
				if(matrizAdy[j][i]) {
					col = true;
					break;
				}
			}
			boolean fil = false;
			for(int j = 0; j < vertAdyacentes.size(); j++) {
				if(matrizAdy[i][j]) {
					fil = true;
					break;
				}
			}
			if(!(fil || col)) {
				return false;
			}
			
		}
		return true;
	}

	public boolean esEuleriano() {
		int cont;
		int impares = 0;
		Set<Vertice> keys = vertAdyacentes.keySet();
		Vertice[] arrVerts = keys.toArray(new Vertice[keys.size()]);
		Vector<Integer> cantAdj = new Vector<>();
		for (int i = 0; i < arrVerts.length; i++) {
			cont = 0;
			for (int j = 0; j < arrVerts.length; j++) {

				if (vertAdyacentes.get(arrVerts[i]).contains(arrVerts[j]))
					cont++;
				if (j == vertAdyacentes.size())
					cantAdj.add(cont);
			}
		}
		for (int i = 0; i < arrVerts.length; i++)
		{
			if(cantAdj.elementAt(i) % 2 == 1 )
				impares++;
		}
		
		return impares < 2;

	}
	
	public List<Vertice> caminoHamiltoneano(){
		if (!this.esConexo()) {
			return Collections.emptyList();
		}
		Set<Vertice> keys = vertAdyacentes.keySet();
		
		for(Vertice v : keys) {
			Deque<Vertice> camino = new LinkedList<>();
			generarCaminos(camino, v);
			if(!camino.isEmpty()) {
				return new ArrayList<>(camino);
			}
		}
		return Collections.emptyList();
	}
	
	private Deque<Vertice> generarCaminos(Deque<Vertice> camino, Vertice vec){
		camino.push(vec);
		
		if(!camino.containsAll(vertAdyacentes.get(vec))) {
			for(Vertice v : this.adyacentes(vec.getNombre())) {
				if(camino.contains(v)) {
					continue;
				}
				generarCaminos(camino, v);
			}
		}
		if(esHamiltoneano((LinkedList<Vertice>) camino)) {
			return camino;
		}
		camino.pop();
		return camino;
	}
		
	private boolean esHamiltoneano(LinkedList<Vertice> camino) {
		int ultimo = camino.size() - 1;
		
		// Comprobar que el camino contiene todos los vertices y ninguno esta repetido
		Set<Vertice> set = new HashSet<>(camino);
		if(set.size() != vertAdyacentes.size()) {
			return false;
		}
		return (vertAdyacentes.get(camino.get(0)).contains(camino.get(ultimo)));
	}
}
