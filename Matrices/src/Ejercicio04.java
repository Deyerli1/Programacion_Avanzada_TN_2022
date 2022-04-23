public class Ejercicio04 {
	public static void main(String[] args) {
		int[][] matriz = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] matDiagonales = new int[matriz.length][matriz[0].length];

		Ejercicio04 miEjercicio = new Ejercicio04();
		matDiagonales = miEjercicio.matrizDiagonales(matriz);
		miEjercicio.verMatriz(matDiagonales);
	}

	public int[][] matrizDiagonales(int[][] matriz) {
		int[][] matDiagonales = new int[matriz.length * 2 - 1][matriz.length];
		int filaActual = 0;

		for (int i = matriz.length - 1; i >= 0; i--) {
			int k = i;
			int col = 0;
			do {// recorremos abajo izquierda hacia arriba izquierda
				matDiagonales[filaActual][col] = matriz[k][col];
				k++;
				col++;
			} while (k != matriz.length);
			filaActual++;
		}

		for (int j = 1; j < matriz.length; j++) {
			int k = j;
			int fila = 0;
			do {// recorremos arriba izquierda+1 hacia arriba derecha
				matDiagonales[filaActual][fila] = matriz[fila][k];
				k++;
				fila++;
			} while (k != matriz.length);
			filaActual++;
		}
		return matDiagonales;
	}

	public void verMatriz(int[][] matriz) {
		/*
		 * for(int i = 0; i<matriz.length/2 ; i++){ for(int j = 0; j<=i ; j++){
		 * System.out.print(matriz[i][j]+" | "); } System.out.println(); }
		 * 
		 * for(int i = matriz.length/2; i>= 0; i--){ for(int j = 0; j<=i ; j++){
		 * System.out.print(matriz[i][j]+" | "); } System.out.println(); }
		 */

		int hola = 0;
		for (int i = 0; i < matriz.length; i++) {
			if (i <= matriz.length / 2) {
				hola = i;
			} else
				hola--;
			for (int j = 0; j <= hola; j++) {
				System.out.println(i + " " + j);
			}

		}

	}

}
