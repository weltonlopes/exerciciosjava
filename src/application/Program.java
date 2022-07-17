package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import model.entities.Course;
import model.entities.Instructor;
import model.entities.Student;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Course> list = new ArrayList<>();
		list.add(new Course("A", null));
		list.add(new Course("B", null));
		list.add(new Course("C", null));
		Instructor instructor = new Instructor("Alex", list);

		for (Course c : instructor.getCourse()) {

			System.out.print("How many students for course " + c.getName() + "? ");
			int num = sc.nextInt();
			List<Student> students = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				students.add(new Student(sc.nextInt()));
			}
			c.setStudents(students);
		}

		Set<Student> total = new HashSet<>();
		for (Course c : instructor.getCourse()) {
			total.addAll(c.getStudents());
		}	
		
		
		System.out.print(instructor.getName() 
				+ " has " 
				+ instructor.getCourse().size() 
				+ " courses "
				+ "and " 
				+ total.size() 
				+ " students");
		

		sc.close();

	}

}
