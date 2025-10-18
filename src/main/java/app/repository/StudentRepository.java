package app.repository;

import java.util.List;
import java.util.Optional;

import app.model.Student;

public interface StudentRepository {
	public int save(Student student);
	public int update(Student student);
	public int delete(Student student);
	public List<Student> get();
	public Optional<Student> getById(int rollNumber);
	public Optional<Student> getByName(String name);
}
