

public class Main {
	
	public static void main(String[] args) {
		
		GestorArchivos archivo = new GestorArchivos("rapigrama");
		archivo.leerArchivo();
		Jueguito test = new Jueguito(archivo);
		test.jugar();
		archivo.escribirArchivo(test.getResultado());
		System.out.print(test.getResultado());
			
		}
	}

