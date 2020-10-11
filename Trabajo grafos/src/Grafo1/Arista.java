package Grafo1;

public class Arista {
	
	int peso;
	private Vertice inicio;
	private Vertice fin;
	
	//SET Y GET
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Vertice getInicio() {
		return inicio;
	}
	public void setInicio(Vertice inicio) {
		this.inicio = inicio;
	}
	public Vertice getFin() {
		return fin;
	}
	public void setFin(Vertice fin) {
		this.fin = fin;
	}
	
	

}
