
public class Mesada {

	private int ladoMayor;
	private int ladoMenor;
	private int ancho;
	private int largo;

	Mesada(int a, int b) {
		if (a > b) {
			ladoMayor = a;
			ladoMenor = b;
		} else {
			ladoMayor = b;
			ladoMenor = a;
		}
		largo = Integer.max(a, b);
		ancho = Integer.min(a, b);
	}

	public int compararMesada(Mesada otra) {
		if((this.ladoMayor - otra.ladoMayor)==0) {
			return this.ladoMenor - otra.ladoMenor;
		}else {
			return	this.ladoMayor - otra.ladoMayor;
		}
	}
		
	public boolean entra(Mesada otra) {
		
		return this.ladoMayor <= otra.ladoMayor && this.ladoMenor <= otra.ladoMenor;
	}
//		return otra.largo - this.largo;

	@Override
	public String toString() {
		return "Mesada [ladoMayor=" + ladoMayor + ", ladoMenor=" + ladoMenor + "]";
//		return "Mesada [largo=" + largo + ", ancho=" + ancho + "]";
	}

}
