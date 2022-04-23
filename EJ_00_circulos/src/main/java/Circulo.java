
public class Circulo {
	private Punto origen;
	private double radius;
	
	Circulo(Punto origen, double radius){
		this.origen=origen;
		this.radius=radius;
	}
	
	public boolean intersectaCon(Circulo otro) {
		double distancia_a_centro = this.origen.distancia_a_punto(otro.origen);
		
		if(distancia_a_centro <= this.radius+otro.radius) {
			return true;
		}else
			return false;
	}

}
