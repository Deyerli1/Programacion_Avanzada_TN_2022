import static org.junit.Assert.*;

import org.junit.Test;

public class CirculosTest {

	@Test
	public void test() {
		Circulo circulo1= new Circulo(new Punto(1,1),1);
		Circulo circulo2= new Circulo(new Punto(-1,-1),1);
		
		boolean res=circulo1.intersectaCon(circulo2);
		boolean resultado_real = false;
		
		assertEquals(res, resultado_real);
	}
	@Test
	public void test2() {
		Circulo circulo1= new Circulo(new Punto(1,1),1000000);
		Circulo circulo2= new Circulo(new Punto(-1,-1),1);
		
		boolean res=circulo1.intersectaCon(circulo2);
		boolean resultado_real = true;
		
		assertEquals(res, resultado_real);
	}
	@Test
	public void test3() {
		Circulo circulo1= new Circulo(new Punto(1,1),1);
		Circulo circulo2= new Circulo(new Punto(1,1),2);
		
		boolean res=circulo1.intersectaCon(circulo2);
		boolean resultado_real = true;
		
		assertEquals(res, resultado_real);
	}
	@Test
	public void test4() {
		Circulo circulo1= new Circulo(new Punto(1,1),1);
		Circulo circulo2= new Circulo(new Punto(2,2),0);
		
		boolean res=circulo1.intersectaCon(circulo2);
		boolean resultado_real = false;
		
		assertEquals(res, resultado_real);
	}
	
	@Test
	public void CasoDeCirculosJuntosNoIntersectados() {
	Circulo c1 = new Circulo(new Punto(0, 0), 2);
	Circulo c2 = new Circulo(new Punto(0, 0), 1);
	assertEquals(c1.intersectaCon(c2), false);
	}

}
