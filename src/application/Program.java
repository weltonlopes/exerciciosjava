package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
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
		
		path = "c:\\arquivocsv\\";
		boolean sucess = new File(path + "out").mkdir();
		System.out.println("Directory created successfully:" + sucess);
		path = "c:\\arquivocsv\\out\\summary.csv";
		
		List<String> newArc = new ArrayList<>();
		for (Product p : products) {			
			newArc.add(p.toString());			
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for (String line: newArc) {
				bw.write(line);
				bw.newLine();
			}		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
		
		System.out.println("PRODUCTS:");
		for (Product p: products) {
			System.out.println(p);
		}
			
	}

}
