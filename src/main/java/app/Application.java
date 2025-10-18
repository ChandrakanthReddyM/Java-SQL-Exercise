package app;

import app.model.Student;
import app.repository.StudentRepository;
import app.repository.impl.StudentRepositoryImpl;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("Hello world!!!!");
		Student student = new Student();
		student.setRollNumber(2);
		student.setAge(30);
		student.setName("Sonia BAGCHI");
		StudentRepository studentRepo = new StudentRepositoryImpl();
		int saveResult = studentRepo.save(student);
		if (saveResult == 1) {
			System.out.println("Record saved");
		} else {
			System.out.println("Save unsuccessful");
		}
		
		
	}

}
