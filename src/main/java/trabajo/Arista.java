package trabajo;

public class Arista {
	
	/* Clase de apoyo diseñada para funcionar con grafos con peso
	 */
	private float peso;
	private Vertice inicio, destino;
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Vertice getInicio() {
		return inicio;
	}
	public void setInicio(Vertice inicio) {
		this.inicio = inicio;
	}
	public Vertice getDestino() {
		return destino;
	}
	public void setDestino(Vertice destino) {
		this.destino = destino;
	}
	
	public Arista(Vertice inicio, Vertice destino, float peso){
		this.peso = peso;
		this.inicio = inicio;
		this.destino = destino;
	}
	
	public Arista(String inicio, String destino, float peso) {
		Vertice in = new Vertice(inicio);
		Vertice out = new Vertice(destino);
		this.peso = peso;
		this.inicio = in;
		this.destino = out;
	}
}
