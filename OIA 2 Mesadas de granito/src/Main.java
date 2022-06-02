import java.util.ArrayList;

public class Main {
 
	public static void main(String[] args) {
		
		System.out.println(	5%2);
		System.exit(0);
		ArrayList<Mesada> mesadas = new ArrayList<Mesada>();
		int pilas=0;
		mesadas.add(new Mesada(4,5));
		mesadas.add(new Mesada(9,3));
		mesadas.add(new Mesada(2,2));
		mesadas.add(new Mesada(1,2));
		mesadas.add(new Mesada(1,12));
		mesadas.add(new Mesada(2,12));
		System.out.println(	mesadas.toString());
		mesadas.sort(new CompararMesada());
		System.out.println(	mesadas.toString());
	
		for (int i = 0; i < mesadas.size()-1; i++) {
			
			if(mesadas.get(i).entra((mesadas.get(i+1)))) {
				pilas++;
			}
			
		}
		System.out.println(	pilas);
	
}
}
