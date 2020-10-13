package trabajo;

import java.util.*;

public class Grafo {
	/* Clase principal que describe un grafo basico
	 * Contiene metodos para funcionar como grafo sin peso, con o sin direcciones para las aristas
	 */
	
	
	private Map<Vertice, List<Vertice>> vertAdyacentes;

	// Getter
	public Map<Vertice, List<Vertice>> getVertAdyacentes() {
		return vertAdyacentes;
	}
	// Setter
	public void setVertAdyacentes(Map<Vertice, List<Vertice>> vertAdyacentes) {
		this.vertAdyacentes = vertAdyacentes;
	}
	
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
	
	// Agrega una arista entre vertices
	void agregarArista(String nombre1, String nombre2) {
		agregarAristaDir(nombre1, nombre2);
		agregarAristaDir(nombre2, nombre1);
	}
	
	// Agrega una arista en una sola direccion
	void agregarAristaDir(String nombre1, String nombre2) {
		Vertice v1 = new Vertice(nombre1);
		Vertice v2 = new Vertice(nombre2);
		vertAdyacentes.get(v1).add(v2);
	}
	
	void quitarArista(String nombre1, String nombre2) {
	    Vertice v1 = new Vertice(nombre1);
	    Vertice v2 = new Vertice(nombre2);
	    List<Vertice> eV1 = vertAdyacentes.get(v1);
	    List<Vertice> eV2 = vertAdyacentes.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	} 
}
