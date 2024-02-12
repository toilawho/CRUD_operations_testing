package DAO;

import java.sql.*;
import model.Course;



public class CourseDAO{

	private String dbUrl = "jdbc:postgresql://localhost:5432/school_db";
	private String username = "postgres";
	private String passwd = "postgres";
	
	
	public CourseDAO() {
	}
	
    public String registerCoursePrepared(Course CourseObject) {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "INSERT INTO Course (Course_id, course_name, course_credits) VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, CourseObject.getCourseId());
            pst.setString(2, CourseObject.getCourseName());
            pst.setInt(3, CourseObject.getCourseCredit());

            
            int rowsAffected = pst.executeUpdate();
            con.close();
            if (rowsAffected >= 1) {
                return "Course successfully recorded";
            } else {
                return "Course not recorded";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "SERVER ERROR";
    }

    public String updateCoursePrepared(Course CourseObject) {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "UPDATE Course SET course_name=?, course_credits=? WHERE Course_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, CourseObject.getCourseName());
            pst.setInt(2, CourseObject.getCourseCredit());
            pst.setString(3, CourseObject.getCourseId());
            int rowsAffected = pst.executeUpdate();
            con.close();
            if (rowsAffected >= 1) {
                return "Course successfully updated";
            } else {
                return "Course not found";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "SERVER ERROR";
    }

    public String deleteCoursePrepared(Course CourseObject) {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "DELETE FROM Course WHERE Course_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, CourseObject.getCourseId());
            
            int rowsAffected = pst.executeUpdate();
            con.close();
            if (rowsAffected >= 1) {
                return "Course successfully deleted";
            } else {
                return "Course not found";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "SERVER ERROR";
    }

    public String retrieveCoursePrepared() {
        try {
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "SELECT * from Course";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            int counter = 0;
            while (rs.next()) {
                counter++;
                System.out.println("\nCourse " + counter);
                System.out.println("-----------------");
                System.out.println("Course ID: " + rs.getString(1));
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

    public Course retrieveCourseByIdPrepared(Course CourseObject) {
    	Course course = null;
        try {

            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            String sql = "SELECT * FROM Course WHERE Course_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, CourseObject.getCourseId());
            ResultSet rs = pst.executeQuery();
            
            int counter = 0;
            while (rs.next()) {
                counter ++;
                course = new Course();
                course.setCourseId(rs.getString(1));
                course.setCourseName(rs.getString(2));
                course.setCourseCredit(rs.getInt(3));
            }
            if (counter == 0) {
                System.out.println("Course not found");
            }
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return course;
    }
}