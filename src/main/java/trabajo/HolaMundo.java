package trabajo;

public class HolaMundo {
	public static void main(String[] args) {
		Grafo g = new Grafo();
		g.agregarVertice("A");
	    g.agregarVertice("B");
	    g.agregarVertice("C");
	    //g.agregarVertice("4");
	    g.agregarArista("A", "B");
	    g.agregarAristaDir("A", "C");
	    //g.agregarArista("2", "4");
	    g.Matriz();
	    System.out.print(g.toString());
	}
}
