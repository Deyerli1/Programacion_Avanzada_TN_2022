
public class Luchador {
	private int altura;
	private int peso;

	Luchador(int altura, int peso){
		this.altura = altura;
		this.peso = peso;
	}
	
	public boolean dominar(Luchador contrincante) {
		
		if(this.altura > contrincante.altura) {
            if(this.peso >= contrincante.peso)
                return true;
            return false;
        }
        if (this.peso > contrincante.peso)
        {
            if (this.altura >= contrincante.altura)
                return true;
            return false;
        }
		
        return false;
	}
}
