
public class Ejercicio01 {
	
	public static void main(String[] args) {
		int mat1[][] = {
				{1,2,3,4,5,6},
				{7,8,9,10,11,12},
				{23,45,12,56,120,32},
		};
		
		Ejercicio01 ejercicio01 = new Ejercicio01();
		
		System.out.println(ejercicio01.HasZero(mat1));
	}

	
	public boolean HasZero(int mat[][]) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

}
