package app.repository;

import java.util.List;

import app.model.Student;

public interface StudentRepository {
	public int save(Student student);
	public void update();
	public void delete(int rollNumber);
	public List<Student> get();
	public Student getById(int rollNumber);
	public Student getByName(String name);
}
