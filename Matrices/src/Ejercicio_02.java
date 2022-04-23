public class Ejercicio_02 {
    public static void main(String[] args) {
        int[][] matriz={{8,2,-3,4}, {5,-6,-6,20}, {21,1,-5,0}};
        
        Ejercicio_02 miEjercicio = new Ejercicio_02();
        matriz = miEjercicio.sumar(matriz);

        Ejercicio_02 miEjercicioA = new Ejercicio_02();
        miEjercicioA.verMatriz(matriz);
    }
    
    public int[][] sumar (int[][] matriz){
        int cantF = matriz.length - 1;
        int cantC = matriz[0].length - 1;
        int[][] matSuma = new int[cantF+1][cantC+1];
        
        for(int i = 0; i<=cantF ; i++){
            for(int j = 0; j<=cantC ; j++){
                matSuma[i][j] = matriz[i][j];
                if(i!=0)
                    matSuma[i][j] += matriz[i-1][j];//sumo arriba
                if(j!=0)
                    matSuma[i][j] += matriz[i][j-1];//sumo izquierda
                if(i!=cantF)
                    matSuma[i][j] += matriz[i+1][j];//sumo abajo
                if(j!=cantC)
                    matSuma[i][j] += matriz[i][j+1];//sumo derecha             
            }
        }
        return matSuma;
    }

    public void verMatriz (int[][] matriz){
        int cantF = matriz.length - 1;
        int cantC = matriz[0].length - 1;
        
        for(int i = 0; i<=cantF ; i++){
            for(int j = 0; j<=cantC ; j++){
                System.out.print(matriz[i][j]+" | ");
            }
            System.out.println();
        }
    }
}