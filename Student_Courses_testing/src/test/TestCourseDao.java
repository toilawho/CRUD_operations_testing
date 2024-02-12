package test;

import DAO.CourseDAO;
import model.Course;
import static org.junit.Assert.*;
import java.sql.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCourseDao {

	private static String dbUrl = "jdbc:postgresql://localhost:5432/school_db";
	private static String username = "postgres";
	private static String passwd = "postgres";	
	private static CourseDAO dao;
	
	
	@BeforeClass
	public static void setUpBeforeClass(){		
        try {
			Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        dao = new CourseDAO();
	}

	@AfterClass
	public static void tearDownAfterClass(){		
        try {
			Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void registerCourseTest() {
		Course course = new Course();
		course.setCourseId("INSY323");
		course.setCourseName("Computer Networks");
		course.setCourseCredit(4);
		
		dao.registerCoursePrepared(course);
		
		Course courseDb = dao.retrieveCourseByIdPrepared(course);
		assertEquals("Course name should be equal", "Computer Networks",courseDb.getCourseName());
		
		
	}
	
	@Test
	public void updateCourseTest() {
		Course course = new Course();
		course.setCourseId("SENG395");
		course.setCourseName("Software Engineering");
		course.setCourseCredit(3);
		
		dao.registerCoursePrepared(course);
		course.setCourseName("Software Quality Assurance");
		dao.updateCoursePrepared(course);
		
		Course CourseDb = dao.retrieveCourseByIdPrepared(course);
		assertEquals("Updated first name should be equal.", "Software Quality Assurance", CourseDb.getCourseName());

	}
	
	@Test
	public void deleteCourseTest() {
		Course course = new Course();
		course.setCourseId("INSY323");
		dao.deleteCoursePrepared(course);
		Course CourseDb = dao.retrieveCourseByIdPrepared(course);
		assertNull("Course should be null",CourseDb);
	}
	
	
}
