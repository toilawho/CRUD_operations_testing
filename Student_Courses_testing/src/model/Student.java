package model;

public class Student {
	
	private int student_id;
	private String firstName;
	private String lastName;
	
	
	

	public Student() {
	}

	



	public Student(int student_id) {
		super();
		this.student_id = student_id;
	}





	public Student(int student_id, String firstName, String lastName) {
		super();
		this.student_id = student_id;
		this.firstName = firstName;
		this.lastName = lastName;
	}





	public int getStudent_id() {
		return student_id;
	}




	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
}
