

public class Torneo {
	private int[] dominados;
	private Luchador[] luchadores;
	
	Torneo(int cantidad){
		luchadores = new Luchador[cantidad];
	}
	
	public boolean agregarLuchador(Luchador luchador) {
		int i=0;
		while(luchadores[i] != null) {
			i++;
		}
		if(i==luchadores.length) {
			throw new TorneoLkeno();
		}
		luchadores[i]=luchador;
		
		return true;
	}
	
	public competencia
}
