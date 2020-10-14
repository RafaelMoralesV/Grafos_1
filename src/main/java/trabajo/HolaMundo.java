package trabajo;

public class HolaMundo {
	public static void main(String[] args) {
		/* Clase de pruebas
		 * Actualmente solo existe solo para probar que el codigo funciona
		 */
		System.out.println("Existe clase vertice y grafo basico, direccionado y pesado");
		
		Grafo testUno = new Grafo();
		
		testUno.agregarVertice("A");
		testUno.agregarVertice("B");
		testUno.agregarArista("A", "B");
		testUno.agregarVertice("C");
		testUno.agregarAristaDir("C", "B");
		
		testUno.eliminarVertice("B");
		testUno.agregarArista("A", "C");
		testUno.eliminarAristas("A", "C");
		
		
	}
}
