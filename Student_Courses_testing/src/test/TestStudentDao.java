package test;

import DAO.StudentDAO;
import model.Student;
import static org.junit.Assert.*;
import java.sql.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStudentDao {

	private static String dbUrl = "jdbc:postgresql://localhost:5432/school_db";
	private static String username = "postgres";
	private static String passwd = "postgres";	
	private static StudentDAO dao;
	
	
	@BeforeClass
	public static void setUpBeforeClass(){		
        try {
			Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        dao = new StudentDAO();
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
	public void registerStudentTest() {
		Student stu = new Student();
		stu.setStudent_id(11111);
		stu.setFirstName("Bob");
		stu.setLastName("Mugisha");
		
		dao.registerStudentPrepared(stu);
		
		Student StudentDb = dao.retrieveStudentByIdPrepared(stu);
		assertEquals("Last name should be equal", "Mugisha",StudentDb.getLastName());
		
		
	}
	
	@Test
	public void updateStudentTest() {
		Student stu = new Student();
		stu.setStudent_id(33333);
		stu.setFirstName("Dan");
		stu.setLastName("Bolton");
		
		stu.setFirstName("Eric");
		dao.updateStudentPrepared(stu);
		
		Student StudentDb = dao.retrieveStudentByIdPrepared(stu);
		assertEquals("Updated first name should be equal.", "Eric", StudentDb.getFirstName());

	}
	
	@Test
	public void deleteStudentTest() {
		Student stu = new Student();
		stu.setStudent_id(11111);
		dao.deleteStudentPrepared(stu);
		Student StudentDb = dao.retrieveStudentByIdPrepared(stu);
		assertNull("Student should be null",StudentDb);
	}
	
	
}
