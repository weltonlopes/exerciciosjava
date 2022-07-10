package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		List<Product> products = new ArrayList<>();		
		for (int i = 0; i < n; i++) {
			
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Coomon, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");			
			double price = sc.nextDouble();
			
			if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufactureDate));
			} else if (type == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			} else {
				products.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		
		/* sem precisar digitar:
		Product product = new Product("Notebook", 1100.0);
		Product product2 = new UsedProduct("Iphone", 400.0, sdf.parse("15/03/2017"));
		Product product3 = new ImportedProduct("Tablet", 260.0, 20.0); 
		
		System.out.println(product.priceTag());
		System.out.println(product2.priceTag());
		System.out.println(product3.priceTag());
		*/
	
		sc.close();
	}
	
	
}
