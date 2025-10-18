package app;

import java.util.List;
import java.util.Optional;

import app.model.Student;
import app.repository.StudentRepository;
import app.repository.impl.StudentRepositoryImpl;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("Hello world!!!!");
		StudentRepository studentRepo = new StudentRepositoryImpl();
//		Student student = new Student();
//		student.setRollNumber(1);
//		student.setAge(30);
//		student.setName("Chandrakanth Reddy MACHUGARI");
//		int saveResult = studentRepo.save(student);
//		if (saveResult == 1) {
//			System.out.println("Record saved");
//		} else {
//			System.out.println("Save unsuccessful");
//		}
		
		List<Student> students = studentRepo.get();
		students.forEach(System.out::println);
		
		Optional<Student> getById = studentRepo.getById(10);
		getById.ifPresentOrElse(s -> {
			System.out.println(s);
		}, () -> {
			System.out.println("No student with ID");
		});
		
		Optional<Student> getByName = studentRepo.getByName("Chandrakanth Reddy MACHUGARI");
		getByName.ifPresentOrElse(s -> {
			System.out.println(s);
		}, () -> {
			System.out.println("No student with NAME");
		});
		
//		int deleteResult = studentRepo.delete(getByName.get());
//		if (deleteResult == 1) {
//			System.out.println("Student delete = "+getByName);
//		} else {
//			System.out.println("Delete Failed");
//		}
		Student updateAge = getByName.get();
		updateAge.setAge(29);
		int updateResult = studentRepo.update(getByName.get());
		if (updateResult == 1) {
			System.out.println("update Successfull");
		} else {
			System.out.println("Update Failed");
		}
		
	}

}
