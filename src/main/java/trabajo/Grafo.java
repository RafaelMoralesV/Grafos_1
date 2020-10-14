package trabajo;

import java.util.*;

public class Grafo {
	/* Clase principal que describe un grafo basico
	 * Contiene metodos para funcionar como grafo sin peso, con o sin direcciones para las aristas
	 */
	
	
	private Map<Vertice, List<Vertice>> vertAdyacentes;
	
	public Grafo() {
		vertAdyacentes = null;
	}

	// Getter
	public Map<Vertice, List<Vertice>> getVertAdyacentes() {
		return vertAdyacentes;
	}
	// Setter
	public void setVertAdyacentes(Map<Vertice, List<Vertice>> vertAdyacentes) {
		this.vertAdyacentes = vertAdyacentes;
	}
	
	//								//
	// 			VERTICES			//
	//								//
	
	// Agregar nuevo vertice
	void agregarVertice(String nombre) {
		vertAdyacentes.putIfAbsent(new Vertice(nombre), new ArrayList<>());
	}
	
	void eliminarVertice(String nombre) {
		Vertice v = new Vertice(nombre);
		
		// Elimina la lista de vertices adyacentes a 'nombre'
		vertAdyacentes.values().stream().forEach(e -> e.remove(v));
		
		// Elimina el vertice del grafo
		vertAdyacentes.remove(new Vertice(nombre));
	}
	
	//								//
	// 			ARISTAS				//
	//								//
	
	// Agrega una arista en una sola direccion
	void agregarAristaDir(String nombre1, String nombre2) {
		Vertice v1 = new Vertice(nombre1);
		Vertice v2 = new Vertice(nombre2);
		vertAdyacentes.get(v1).add(v2);
	}
	
	// Agrega una arista entre vertices
	void agregarArista(String nameA, String nameB) {
		agregarAristaDir(nameA, nameB);
		agregarAristaDir(nameB, nameA);
	}
	
	// Elimina una sola arista entre <nombre1> y <nombre2>
	void eliminarAristaDir(String nombre1, String nombre2) {
		Vertice v1 = new Vertice(nombre1);
	    Vertice v2 = new Vertice(nombre2);
	    List<Vertice> eV1 = vertAdyacentes.get(v1);
	    if (eV1 != null)
	        eV1.remove(v2);
	}
	
	// Elimina todas las aristas entre <nombre1> y <nombre2>
	void eliminarAristas(String nameA, String nameB) {
	    eliminarAristaDir(nameA, nameB);
	    eliminarAristaDir(nameB, nameA);
	} 
}
