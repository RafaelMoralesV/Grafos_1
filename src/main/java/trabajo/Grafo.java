package trabajo;

import java.util.*;

public class Grafo {
	/* Clase principal que describe un grafo basico
	 * Contiene metodos para funcionar como grafo sin peso, con o sin direcciones para las aristas
	 */
	
	
	private Map<Vertice, List<Vertice>> vertAdyacentes;
	
	public Grafo() {
		this.vertAdyacentes = new HashMap<>();
	}
	
	//								//
	// 			VERTICES			//
	//								//

	// Agregar nuevo vertice
	public void agregarVertice(String nombre) {
		this.vertAdyacentes.putIfAbsent(new Vertice(nombre), new ArrayList<>());
	}
	
	public void eliminarVertice(String nombre) {
		Vertice v = new Vertice(nombre);
		
		// Elimina la lista de vertices adyacentes a 'nombre'
		this.vertAdyacentes.values().stream().forEach(e -> e.remove(v));
		
		// Elimina el vertice del grafo
		this.vertAdyacentes.remove(new Vertice(nombre));
	}
	
	//								//
	// 			ARISTAS				//
	//								//
	
	// Agrega una arista en una sola direccion
	public void agregarAristaDir(String nombre1, String nombre2) {
		Vertice v1 = new Vertice(nombre1);
		Vertice v2 = new Vertice(nombre2);
		this.vertAdyacentes.get(v1).add(v2);
	}
	
	// Agrega una arista entre vertices
	public void agregarArista(String nameA, String nameB) {
		this.agregarAristaDir(nameA, nameB);
		this.agregarAristaDir(nameB, nameA);
	}
	
	// Elimina una sola arista entre <nombre1> y <nombre2>
	public void eliminarAristaDir(String nombre1, String nombre2) {
		Vertice v1 = new Vertice(nombre1);
	    Vertice v2 = new Vertice(nombre2);
	    List<Vertice> eV1 = this.vertAdyacentes.get(v1);
	    if (eV1 != null)
	        eV1.remove(v2);
	}
	
	// Elimina todas las aristas entre <nombre1> y <nombre2>
	public void eliminarAristas(String nameA, String nameB) {
	    this.eliminarAristaDir(nameA, nameB);
	    this.eliminarAristaDir(nameB, nameA);
	} 
	
	//								//
	// 			UTILS				//
	//								//
	
	public int sizeVertices() {
		return this.vertAdyacentes.size();
	}
	
	public int sizeAdyacentes(String nombre) {
		Vertice v = new Vertice(nombre);
		return this.vertAdyacentes.get(v).size();
	}
}
