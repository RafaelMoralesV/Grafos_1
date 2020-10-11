package Grafo1;
   //LIBRERIAS
import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	//GRAFO USANDO LISTAS QUE IMPLEMENTA JAVA (arraylist)
	private List<Vertice> vert;
	private List<Arista> arist;
	
	public Grafo() {
		vert = new ArrayList<>();
		arist = new ArrayList<>();
	}
	
	//METODOS
	
	//AGREGAR VERTICE
	public void Agregar(String nombre) {
		Vertice nuevo = new Vertice(nombre);
		vert.add(nuevo);
	}
	//BORRAR VERTICE
	public void Borrar(String nombre) {
		//CON ESTE FOR PUEDES RECORRER TODOS LOS ELEMENTOS DE UNA LISTA
		//VARIABLE AUX:LISTA QUE SE QUIERE RECORRER
		for(Vertice aux : vert) {
			if(aux.getNombre() == nombre) {
				vert.remove(aux);
			}
		}
		
	}

	

}
