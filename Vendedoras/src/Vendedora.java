import java.util.Arrays;
import java.util.LinkedList;

public class Vendedora {
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	private int[] salesVector;
	private int number;
	
	Vendedora(int[] total_sales, int number){
		salesVector = total_sales.clone();
		this.number = number;
	}
	
	public int calculate_max_sales(int min_sales) {
		
		
		int current_max = -1;
		for (int i = 0; salesVector.length - i >= min_sales; i++) {
		int current_amount=0;
			for (int j = 0; j < min_sales; j++) {
				current_amount += salesVector[i+j];
			}
			if (current_amount > current_max){
				current_max= current_amount;				
			}
		}
		return current_max;
	}
	
	public int aggregate(LinkedList<Vendedora> sellers,int min_sales) {
		
		int current_max = this.calculate_max_sales(min_sales);
		if(current_max == -1) {
			return 0;
		}
		if (sellers.peek() == null || current_max > sellers.peek().calculate_max_sales(min_sales)){
			sellers.clear();
			sellers.add(this);

			
		}else if(current_max == sellers.peek().calculate_max_sales(min_sales)) {
			sellers.add(this);
		}

		return 1;
	}
	
	

	@Override
	public String toString() {
		return "Vendedora [salesVector=" + Arrays.toString(salesVector) + " Numero " + (number+1) +"]";
	}
	
	
}
