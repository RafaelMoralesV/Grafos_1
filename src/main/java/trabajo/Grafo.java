package trabajo;

import java.util.*;

public class Grafo {
	private Map<Vertice, List<Vertice>> vertAdyacentes;

	public Map<Vertice, List<Vertice>> getVertAdyacentes() {
		return vertAdyacentes;
	}

	public void setVertAdyacentes(Map<Vertice, List<Vertice>> vertAdyacentes) {
		this.vertAdyacentes = vertAdyacentes;
	}
	
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
	
	void agregarArista(String nombre1, String nombre2) {
		Vertice v1 = new Vertice(nombre1);
		Vertice v2 = new Vertice(nombre2);
		
		vertAdyacentes.get(v1).add(v2);
		vertAdyacentes.get(v2).add(v2);
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
