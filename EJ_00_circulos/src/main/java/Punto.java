
public class Punto {
	
	private double x;
	private double y;
	
	Punto(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double distancia_a_punto(Punto otro) {
		return Math.hypot(this.x-otro.x,this.y-otro.y);
	}
	
}
