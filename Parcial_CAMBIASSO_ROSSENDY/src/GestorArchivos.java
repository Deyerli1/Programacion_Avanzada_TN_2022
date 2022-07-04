import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivos {

	private String path;

	GestorArchivos(String path) {
		this.path = path;

	}

	public Arbol leerArchivo() {
		try {
			Scanner archivo = new Scanner(new File(path + ".in"));

			int cantNodos = archivo.nextInt();
			int cantArcos = archivo.nextInt();
			int[][] matAdj = new int[cantNodos][cantNodos];
			int[] apuntado = new int[cantNodos + 1];
			for (int i = 0; i < cantArcos; i++) {
				int salida = archivo.nextInt();
				int destino = archivo.nextInt();
				matAdj[salida - 1][destino - 1] = 1;
				apuntado[destino]++;
			}

			Grafo grafo = new Grafo(matAdj, cantNodos);
			Arbol arbol = new Arbol(grafo, apuntado);
			archivo.close();
			return arbol;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void escribirArchivo(Arbol arbol) {
		try {
			FileWriter archivo = new FileWriter(path + "BSF.out");
			PrintWriter output = new PrintWriter(archivo);

			if (arbol.isArbol()) {
				output.println("Si" + " " + arbol.getRaices().get(0));
				output.close();
				return;
			}
			output.println("NO");
			if (!arbol.isR1()) {
				for (Integer raiz : arbol.getRaices()) {
					output.print(raiz + " ");
				}
				if (arbol.getRaices().isEmpty()) {
					output.print("0");
				}
				output.println();
			} else {
				output.println(arbol.getRaices().get(0));
			}

			if (!arbol.isR2()) {
				for (Integer nodo : arbol.getNodosInvalidos()) {
					output.print(nodo + " ");
				}
				output.println("");
			} else {
				output.println("0");
			}

			if (arbol.isR1()) {
				if (!arbol.isR3()) {
					int[] distancias = arbol.getDistancias();
					boolean[] visitados = arbol.getVisitados();
					if (!arbol.bsf) {
						for (int i = 0; i < distancias.length; i++) {
							if (distancias[i] == Integer.MAX_VALUE - 1000) {
								output.print(i + 1 + " ");
							}
						}
					} else
						for (int i = 0; i < visitados.length; i++) {
							if (visitados[i] == false) {
								output.print(i + 1 + " ");
							}
						}
				} else {
					output.println("0");
				}
			} else {
				output.println("0");
			}
			output.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void escribirArchivoFatiga() {
		try {
			FileWriter archivo = new FileWriter("DOOM" + ".out");
			PrintWriter output = new PrintWriter(archivo);

			output.println(10000 + " " + 10000);

			for (int i = 1; i <= 10000; i++) {
				output.println(1 + " " + i);
			}
			output.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
