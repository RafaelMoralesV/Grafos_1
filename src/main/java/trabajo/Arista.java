package trabajo;

public class Arista {
	
	/* Clase de apoyo diseñada para funcionar con grafos con peso
	 */
	private float peso;
	private Vertice inicio;
	private Vertice destino;
	
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + Float.floatToIntBits(peso);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		return true;
	}
}
