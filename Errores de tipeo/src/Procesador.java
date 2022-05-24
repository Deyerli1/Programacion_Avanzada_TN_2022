 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Procesador {
    
    Procesador(){
        
    }
    
    public int procesar(String texto, String prueba) {
        
    	int[] iteraciones = new int[1];
        String arrayTexto[] = texto.split("");
        List<String> listaTexto = new ArrayList<String>();
        listaTexto.addAll(Arrays.asList(arrayTexto));
        
        String arrayPrueba[] = prueba.split("");
        List<String> listaPrueba = new ArrayList<String>();
        listaPrueba.addAll(Arrays.asList(arrayPrueba));
        
        int comienzo = 0;
        int index = 0;
        int movimientos = 0;
        
        for (String letra : listaTexto) {
            
            index = indexDe(comienzo, listaPrueba, letra,iteraciones);
            listaPrueba.add(comienzo, listaPrueba.get(index));
            if (listaPrueba.size() < index+1)
            	listaPrueba.remove(index+1);
            movimientos+=index-comienzo;
            comienzo++;
        }
        
        System.out.println(iteraciones[0]);
        return movimientos;
    }
    
    private int indexDe(int comienzo, List<String> lista, String letra, int[] iteraciones) {
        
        int index = comienzo;
        
        while(index < lista.size() && (lista.get(index).compareTo(letra) != 0)) {
            index++;
        }
        iteraciones[0]++;
        
        if(index == lista.size()) {
            return -1;
        }
        
        return index;
    }
    
}