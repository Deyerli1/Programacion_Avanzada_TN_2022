import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;

public class Vendedoras_main {

	public static void main(String[] args) {

		try {
			FileWriter output = new FileWriter("output.txt");
			PrintWriter print_output = new PrintWriter(output);
			int min_sales;
			int quantity;
			LinkedList<Vendedora> sellers = new LinkedList<Vendedora>();
			Vendedoras_main main = new Vendedoras_main();

			min_sales = main.read_sales_file(sellers);
			if ((quantity = sellers.size()) == 0) {
				print_output.println("No hay ganadoras");
			} else if (quantity == 1) {
				print_output.println(sellers.peek().getNumber());
				print_output.print(min_sales);
				print_output.println(" " + sellers.peek().calculate_max_sales(min_sales));

			} else {
				min_sales = main.purge(sellers, ++min_sales);
			}
			output.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 


	}

	public int read_sales_file(LinkedList<Vendedora> sellers) {

		int min_sales = 0;
		try {
			Scanner refarch = new Scanner(new File("sales.txt"));

			while (refarch.hasNextInt()) {

				min_sales = refarch.nextInt();

			}
			refarch.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			Scanner refarch = new Scanner(new File("sales.txt"));

			int total_sellers = refarch.nextInt();

			for (int i = 0; i < total_sellers; i++) {

				int seller_sales = refarch.nextInt();
				if (seller_sales < min_sales) {
					for (int j = 0; j < seller_sales; j++) {
						refarch.nextInt();
					}
					continue;
				}
				int[] sales = new int[seller_sales];

				for (int j = 0; j < seller_sales; j++) {
					sales[j] = refarch.nextInt();
				}
				Vendedora current_seller = new Vendedora(sales, i);

				current_seller.aggregate(sellers, min_sales);

			}
			refarch.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return min_sales;
	}

@SuppressWarnings("unchecked")
public int purge(LinkedList<Vendedora> sellers, int min_sales) {

		LinkedList<Vendedora> reduced_sellers = new LinkedList<Vendedora>();
		while (sellers.size() > 1) {
			for (Vendedora vendedora : sellers) {
				vendedora.aggregate(reduced_sellers, min_sales);
			}
			min_sales++;
			sellers = (LinkedList<Vendedora>) reduced_sellers.clone();
			reduced_sellers.clear();
		}
		// Tuve que poner esta escritura de archivo aca porque cuando esta funcion vuelve, la lista por algun motivo
		// vuelve a su valor original??
		try {
			FileWriter output = new FileWriter("output.txt");
			PrintWriter print_output = new PrintWriter(output);
			if (sellers.size() == 0) {
				print_output.println("No se puede desempatar’.");
			} else {
				print_output.println(sellers.peek().getNumber()+1);
				print_output.print(--min_sales);
				print_output.println(" " + sellers.peek().calculate_max_sales(min_sales));
			}
			output.close();
		}catch(Exception E) {
			E.printStackTrace();
		}
		return min_sales;

	}

}
