import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test1() {
		
		Establo establo1 = new Establo();
		assertEquals(1, establo1.jinetes(new int[] {18, 15}));
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		
		Establo establo1 = new Establo();
		assertEquals(2, establo1.jinetes(new int[] {43, 23, 40, 13}));
	}
	
	@org.junit.jupiter.api.Test
	void test3() {
		
		Establo establo1 = new Establo();
		assertEquals(3, establo1.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));

	}
	
	@org.junit.jupiter.api.Test
	void test4() {
		
		Establo establo1 = new Establo();
		assertEquals(3, establo1.jinetes(new int[] {51, 51, 51}));

	}
	
	@org.junit.jupiter.api.Test
	void test5() {
		
		Establo establo1 = new Establo();
		assertEquals(4, establo1.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));

	}
}
