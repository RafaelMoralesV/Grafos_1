package trabajo;

import java.util.List;
import java.util.Map;

public class GrafoPesado extends Grafo {
	
	/* Extiende a la clase grafo, añadiendo soporte para aristas con un peso
	 */
	
	private Map<Vertice, List<Arista>> vertAdyacentes;
	
	// Agregar y eliminar vertice son funciones heredadas de Grafo
	
	
	// Agrega una arista en una sola direccion
	void agregarAristaDir(String nombre1, String nombre2, float peso) {
		Vertice v1 = new Vertice(nombre1);
		Vertice v2 = new Vertice(nombre2);
		Arista ar = new Arista(v1, v2, peso);
		vertAdyacentes.get(v1).add(ar);
	}
	
	void agregarArista(String nameA, String nameB, float peso) {
		agregarAristaDir(nameA, nameB, peso);
		agregarAristaDir(nameB, nameA, peso);
	}
}
