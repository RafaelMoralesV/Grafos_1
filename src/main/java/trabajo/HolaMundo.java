package trabajo;


public class HolaMundo{
	public static void main(String[] args) {
		Grafo g = new Grafo();
		g.agregarVertice("A");
	    g.agregarVertice("B");
	    g.agregarVertice("C");
	    g.agregarVertice("D");
	    g.agregarArista("A", "B");
	    g.agregarAristaDir("A", "C");
	    g.agregarArista("B", "D");
	    g.generarMatriz();
	    System.out.print(g.toString());
	}
}
