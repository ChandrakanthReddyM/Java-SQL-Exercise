package app.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.model.Student;
import app.repository.StudentRepository;
import app.util.AbstractDao;

public class StudentRepositoryImpl implements StudentRepository {
	
	
	
	@Override
	public int save(Student student) {
		
		try(Connection connection = AbstractDao.getConnection()){
			PreparedStatement statement = connection.prepareStatement("INSERT INTO STUDENT (ROLLNUMBER, AGE, NAME) VALUES(?,?,?)");
			statement.setInt(1, student.getRollNumber());
			statement.setInt(2, student.getAge());
			statement.setString(3, student.getName());
			return statement.executeUpdate();
		} catch(SQLException exception) {
			exception.printStackTrace();
			return -1;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int rollNumber) {
		

	}

	@Override
	public List<Student> get() {
		List<Student> students = new ArrayList<Student>();
		try(Connection connection = AbstractDao.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT ROLLNUMBER, AGE, NAME FROM STUDENT");
			while (resultSet.next()) {
				Student student = new Student();
				student.setRollNumber(resultSet.getInt(1));
				student.setAge(resultSet.getInt(2));
				student.setName(resultSet.getString(3));
				students.add(student);
			}
			return students;
		} catch(SQLException exception) {
			exception.printStackTrace();
			return null;
		}

	}

	@Override
	public Student getById(int rollNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
