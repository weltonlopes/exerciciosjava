package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import entities.Employee;

// ESSE AQUI FOI DIFICIL, TIVE QUE FICAR OLHANDO NO RESOLVIDO...

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String path = "c:\\projetos\\in.txt";
		List<Employee> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
					
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				list.add(new Employee(name, email, salary));
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		double salary = 2000.0;
		List<String> emailList = list.stream()
				.filter(x -> x.getSalary() > salary)
				.map(x -> x.getEmail())
				.collect(Collectors.toList());
		System.out.println("Emails > 2000.0: ");
		emailList.forEach(System.out::println);
		
		double sum = list.stream()
				.filter(x -> x.getName().charAt(0)=='M') 
				.map(x -> x.getSalary())
				.reduce(0.0, (x , y) -> x + y);
		System.out.printf("Soma do salario comecando com M: %.2f" , sum);

	}

}
