package trabajo;

import java.util.List;

public class HolaMundo{
	public static void main(String[] args) {
		// DOES NOTHING FOR NOW
		GrafoPesado p = new GrafoPesado();
		p.agregarVertice("A");
		p.agregarVertice("B");
		p.agregarVertice("C");
		p.agregarVertice("D");
		p.agregarVertice("E");
		
		p.agregarArista("A", "B", 6);
		p.agregarArista("A", "D", 1);
		p.agregarArista("B", "D", 2);
		p.agregarArista("B", "E", 2);
		p.agregarArista("D", "E", 1);
		p.agregarArista("C", "B", 5);
		p.agregarArista("C", "E", 5);
		
		List<Vertice> l = p.dijkstra("A", "C");
		
		for(Vertice v : l) {
			System.out.print(v.getNombre() + " -> ");
		}
	}
}
