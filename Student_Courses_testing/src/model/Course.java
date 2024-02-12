package model;

public class Course {

	private String courseId;
	private String courseName;
	private int courseCredit;
	
	
	public Course() {
	}

	

	public Course(String courseId) {
		super();
		this.courseId = courseId;
	}



	public Course(String courseId, String courseName, int courseCredit) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
	}



	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getCourseCredit() {
		return courseCredit;
	}


	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}



}


