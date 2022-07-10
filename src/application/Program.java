package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> taxPayers = new ArrayList<>();
		taxPayers.add(new Individual("Alex", 50000.0, 2000));
		taxPayers.add(new Company("SoftTech", 400000.0, 25));
		taxPayers.add(new Individual("Bob", 120000.0, 1000));

		System.out.println("TAXES PAID: ");
		double sum = 0.0;
		for (TaxPayer taxPayer : taxPayers) {
			System.out.println(taxPayer.getName() 
					+ ": $ "
					+ String.format("%.2f", taxPayer.tax()));
		}
		
		for (TaxPayer taxPayer : taxPayers) {
			sum += taxPayer.tax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", sum);
		sc.close();
	}

}
