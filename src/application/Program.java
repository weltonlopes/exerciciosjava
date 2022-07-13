package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		String path = "c:\\arquivocsv\\products.csv";
		
		List<Product> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				String product[] = line.split(",");
				String name = product[0];
				double value = Double.parseDouble(product[1]);
				int quantity = Integer.parseInt(product[2]);
				products.add(new Product(name,value,quantity));
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("PRODUCTS:");
		for (Product p: products) {
			System.out.println(p);
		}
			
	}

}
