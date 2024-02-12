package DAO;

import java.sql.*;
import model.Student;



public class StudentDAO{

	private String dbUrl = "jdbc:postgresql://localhost:5432/school_db";
	private String username = "postgres";
	private String passwd = "postgres";
	
	
	public StudentDAO() {
	}
	
    public String registerStudentPrepared(Student studentObject) {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "INSERT INTO student (student_id, stu_first_name, stu_last_name) VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(2, studentObject.getFirstName());
            pst.setString(3, studentObject.getLastName());
            pst.setInt(1, studentObject.getStudent_id());
            int rowsAffected = pst.executeUpdate();
            con.close();
            if (rowsAffected >= 1) {
                return "Student successfully recorded";
            } else {
                return "Student not recorded";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "SERVER ERROR";
    }

    public String updateStudentPrepared(Student studentObject) {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "UPDATE student SET stu_first_name=?, stu_last_name=? WHERE student_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentObject.getFirstName());
            pst.setString(2, studentObject.getLastName());
            pst.setInt(3, studentObject.getStudent_id());
            int rowsAffected = pst.executeUpdate();
            con.close();
            if (rowsAffected >= 1) {
                return "Student successfully updated";
            } else {
                return "Student not found";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "SERVER ERROR";
    }

    public String deleteStudentPrepared(Student studentObject) {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "DELETE FROM student WHERE student_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentObject.getStudent_id());
            
            int rowsAffected = pst.executeUpdate();
            con.close();
            if (rowsAffected >= 1) {
                return "Student successfully deleted";
            } else {
                return "Student not found";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "SERVER ERROR";
    }

    public String retrieveStudentPrepared() {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "SELECT * from student";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            int counter = 0;
            while (rs.next()) {
                counter++;
                System.out.println("\nStudent " + counter);
                System.out.println("-----------------");
                System.out.println("Student ID: " + rs.getString(1));
                System.out.println("First name: " + rs.getString(2));
                System.out.println("Last name: " + rs.getString(3));
            }
            if (counter == 0) {
                System.out.println("No datass");
            }
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "SERVER ERROR";
    }

    public Student retrieveStudentByIdPrepared(Student studentObject) {
        Student stu = null;
    	try {

            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "SELECT * FROM student WHERE student_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentObject.getStudent_id());
            ResultSet rs = pst.executeQuery();
            
            int counter = 0;
            while (rs.next()) {
                counter ++;
                stu = new Student();
                stu.setStudent_id(Integer.parseInt(rs.getString(1)));
                stu.setFirstName(rs.getString(2));
                stu.setLastName(rs.getString(3));
            }
            if (counter == 0) {
                System.out.println("Student not found");
            }
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stu;
    }
}