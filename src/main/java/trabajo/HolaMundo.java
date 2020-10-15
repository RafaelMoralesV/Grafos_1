package trabajo;

public class HolaMundo {
	public static void main(String[] args) {
		Grafo g = new Grafo(4);
		g.agregarVertice("1");
	    g.agregarVertice("2");
	    g.agregarVertice("3");
	    g.agregarVertice("4");
	    g.agregarArista("1", "2");
	    g.agregarArista("1", "3");
	    g.agregarArista("2", "4");
	    g.Matriz(4);
	    System.out.print(g.toString());
	}
}
