
public class Main {
	public static void main(String[] args) {
		GestorArchivos archivo = new GestorArchivos("caso3");
		for (int i = 1; i <= 7; i++) {
			archivo.setPath("caso"+i);
			Arbol arbol = archivo.leerArchivo();
			arbol.bsf = true; /// TRUE SI SE USA BSF, FALSE PARA DIJKSTRA
			arbol.analizarArbol();
			archivo.escribirArchivo(arbol);
		}
		//archivo.escribirArchivoFatiga();
//		archivo.setPath("DOOM");
//		Arbol arbol = archivo.leerArchivo();
//		arbol.bsf = false;
//		arbol.analizarArbol();
//		archivo.escribirArchivo(arbol);
	}
}
