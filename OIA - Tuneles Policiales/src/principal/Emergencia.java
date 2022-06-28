package principal;

import java.util.ArrayList;

public class Emergencia {
	
	private Grafo grafo;
	private int emergencia;
	private ArrayList<Movil> arrayMoviles;

	
	Emergencia(){
		GestorArchivos archivo = new GestorArchivos("TUNELES");
		grafo = archivo.leerArchivo();
		emergencia = archivo.getEmergencia();
		arrayMoviles = archivo.getArrayMoviles();
		
	}
	
	public void rescatar() {
		for(Movil movil : arrayMoviles) {
			movil.setDistancias(grafo.djikstraMismoPeso(movil.getNodo(), emergencia, arrayMoviles));
			movil.setRecorrido(grafo.getPadres());
			
		}
		arrayMoviles.sort();
		for(Movil movil : arrayMoviles) {
			
			
		}
		
	}
	
	private int buscarMinimo

}
