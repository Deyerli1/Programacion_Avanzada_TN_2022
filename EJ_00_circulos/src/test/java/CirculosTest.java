import static org.junit.Assert.*;

import org.junit.Test;

public class CirculosTest {

	@Test
	public void test() {
		Circulo circulo1= new Circulo(new Punto(1,1),1000000);
		Circulo circulo2= new Circulo(new Punto(-1,-1),1);
		
		boolean res=circulo1.intersectaCon(circulo2);
		boolean resultado_real = true;
		
		assertEquals(res, resultado_real);
	}

}
