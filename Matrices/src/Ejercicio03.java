public class Ejercicio03 {
    public static void main(String[] args) {
        int[][] matriz={{0,0,0,0}, {5,-6,-6,20}, {1,1,10,10}};
        int[] vec = new int[3];
        
        Ejercicio03 miEjercicio = new Ejercicio03();
        vec = miEjercicio.vectorModa(matriz);
        
        Ejercicio03 miEjercicioA = new Ejercicio03();
        miEjercicioA.verVector(vec);
    }
    
    public int[] vectorModa (int[][] matriz){
        int cantF = matriz.length - 1;
        int cantC = matriz[0].length - 1;
        int[] vecModa = new int[cantF+1];//se queda con el resultado final
        int ocurrencias;//guarda la cantidad de ocurrencias del valor actual de la matriz 
        Ejercicio03 miEjercicio = new Ejercicio03();

        for(int i = 0; i<=cantF ; i++){
            int[] vecModaActual = {0,0};//guarda la mayor moda de la fila actual [valor][ocurrencias]
            for(int j = 0; j<=cantC ; j++){
                ocurrencias = miEjercicio.ocurrencias(matriz[i], j, cantC+1);
                if(vecModaActual [1] == ocurrencias) {
                    if(vecModaActual[0] < matriz[i][j]) {
                        vecModaActual[0] = matriz[i][j];
                    }
                }
                else if(vecModaActual [1] < ocurrencias){
                    vecModaActual[1] = ocurrencias;
                    vecModaActual[0] = matriz[i][j];
                }
            } 
            vecModa[i] = vecModaActual[0];
        }
        
        return vecModa;
    }
    
    public int ocurrencias (int[] fila, int colActual, int columnas) {
        int ocurrencias=0;
        for(int i = colActual; i<columnas ; i ++) {
            if(fila[colActual] == fila[i])
                ocurrencias++;
        }
        return ocurrencias;
    }
    
    public void verVector (int[] vector){
        int cantC = vector.length;
        for(int i = 0; i<cantC; i++){
            System.out.print(vector[i]+" | ");
        }
    }
    
}