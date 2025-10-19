package app.model;

public class Student {
	private int rollNumber;
	private int age;
	private String name;
	private String gender;
	
	
	
	public Student() {
		super();
	}
	
	public Student(int rollNumber, int age, String name, String gender) {
		super();
		this.rollNumber = rollNumber;
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}
	
	

}
