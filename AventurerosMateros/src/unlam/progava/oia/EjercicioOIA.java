package unlam.progava.oia;

public class EjercicioOIA {
	
	private GestorDeArchivos archivo;
	private Ronda ronda;

	public static void main(String[] args) {
		EjercicioOIA ejercicio = new EjercicioOIA();
		
		ejercicio.leer("data.in");
		ejercicio.resolver();
		ejercicio.escribir("data.out");
	}

	/**
	 * Este método se encarga de leer la entrada de la
	 * consigna desde el archivo.
	 */
	public void leer(String path) {
		archivo = new GestorDeArchivos(path);
		archivo.leerArchivo();
	}
	
	/**
	 * Este método se encarga de escribir la salida de la
	 * consigna en el archivo.
	 */
	public void escribir(String path) {
		archivo.escribirArchivo(path, ronda.getGanador(), ronda.getEliminados());
	}
	
	/**
	 * Este método debe realizar la resolución del ejercicio.
	 * NO DEBE SITUARSE LA LOGICA AQUI, sino que se pueden
	 * utilizar clases adicionales, y los objetos creados en la
	 * etapa de lectura.
	 * Utilizar este mismo paquete para toda la resolución.
	 */
	public void resolver() {
		ronda = new Ronda(archivo.getCantAventureros());
		ronda.cebar(archivo.getMovimientos());
	}
}
