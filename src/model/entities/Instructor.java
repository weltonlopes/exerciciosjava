package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Instructor{
	
		private String name;
		
		private List<Course> course = new ArrayList<>();

		public Instructor(String name, List<Course> course) {
			this.name = name;
			this.course = course;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Course> getCourse() {
			return course;
		}

		public void setCourse(List<Course> course) {
			this.course = course;
		}
		
		
		
		
	
}
