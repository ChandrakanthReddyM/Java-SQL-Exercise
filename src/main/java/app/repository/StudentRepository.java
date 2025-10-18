package app.repository;

import app.model.Student;

public interface StudentRepository {
	public void save(Student student);
	public void update();
	public void delete(int rollNumber);
	public void get();
	public Student getById(int rollNumber);
	public Student getByName(String name);
}
