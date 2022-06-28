package principal;


public class Movil {
	
	private int nodo;
	int recorrido[];
	int distancias[];
	int tiempo;
	
	Movil(int nodo){
		this.nodo = nodo;
	}

	public int[] getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido[]) {
		this.recorrido = recorrido;
	}

	public int getNodo() {
		return nodo;
	}

	public int[] getDistancias() {
		return distancias;
	}

	public void setDistancias(int[] distancias) {
		this.distancias = distancias;
	}
	
	

}
