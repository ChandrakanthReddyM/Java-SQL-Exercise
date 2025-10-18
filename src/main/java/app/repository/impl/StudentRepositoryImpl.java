package app.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public Optional<Student> getById(int rollNumber) {
		try(Connection connection = AbstractDao.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT ROLLNUMBER, AGE, NAME FROM STUDENT WHERE ROLLNUMBER=?");
			statement.setInt(1, rollNumber);
			ResultSet resultSet = statement.executeQuery();
			
			Student student = new Student();
			
			while(resultSet.next()) {
				student.setRollNumber(resultSet.getInt(1));
				student.setAge(resultSet.getInt(2));
				student.setName(resultSet.getString(3));
			}
			if (student.getRollNumber() == 0) {
				return Optional.empty();
			} else {
				return Optional.ofNullable(student);
			}
		} catch(SQLException exception) {
			exception.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Optional<Student> getByName(String name) {
		try(Connection connection = AbstractDao.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement("SELECT ROLLNUMBER, AGE, NAME FROM STUDENT WHERE NAME = ?");
			statement.setString(1, name.toUpperCase());
			ResultSet resultSet = statement.executeQuery();
			Student student = new Student();
			while(resultSet.next()) {
				student.setRollNumber(resultSet.getInt(1));
				student.setAge(resultSet.getInt(2));
				student.setName(resultSet.getString(3));
			}
			if (student.getRollNumber() == 0) {
				return Optional.empty();
			} else {
				return Optional.ofNullable(student);
			}
		} catch (SQLException exception) {
			Optional.empty();
		}
		return Optional.empty();
	}

}
