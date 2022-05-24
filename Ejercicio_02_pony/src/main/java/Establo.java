
public class Establo {
	
	public int jinetes(int[] estaciones) {
        int distancia=0;
        int cantidad_jinetes=1;
        for(int i=0;i<estaciones.length;i++)
        {
        	distancia+=estaciones[i];
            if(distancia>100)
            {
            	distancia=estaciones[i];
            	cantidad_jinetes++;
            }
                
        }
    return cantidad_jinetes;

	}

}
