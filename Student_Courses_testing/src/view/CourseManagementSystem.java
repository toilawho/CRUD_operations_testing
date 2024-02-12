package view;
import java.util.Scanner;
import DAO.CourseDAO;
import model.Course;

public class CourseManagementSystem {

	public static void main(String[] args) {
        boolean condition = true;
        String CourseId;
        String courseName;
        int courseCredits;        
        Course stud = new Course();
        CourseDAO dao = new CourseDAO();
        while(condition){
            System.out.println("==========================");
            System.out.println("Course MANAGEMENT SYSTEM");
            System.out.println("==========================");
            System.out.println("1. Register Course ");
            System.out.println("2. Update Course ");
            System.out.println("3. Delete Course ");
            System.out.println("4. Retrieve All Course");
            System.out.println("5. Search Course by ID");
            System.out.println("0. Exit");
            System.out.println("---------------------");
            System.out.print("Choose: "); 
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    do{
                        System.out.print("Enter Course ID: ");
                        CourseId = input.next(); 
                        if(CourseId.length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of 5 digits only.");
                        }
                    }while(true);
                    input.nextLine();
                    System.out.print("Enter Course Name: ");
                    courseName = input.nextLine();
                    System.out.print("Enter Course Credits: ");
                    courseCredits = input.nextInt();
                    stud.setCourseId(CourseId);
                    stud.setCourseName(courseName);
                    stud.setCourseCredit(courseCredits);
                    //create DAO object 
                    String feedback = dao.registerCoursePrepared(stud);
                    System.out.println(feedback);
                    System.out.println("Do you wish to continue? Use yes or no");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }
                    break;
                case 2:
                    do{
                        System.out.print("Enter Course ID to update: ");
                        CourseId = input.next(); 
                        if(CourseId.length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of exactly 5 digits.");
                        }
                    }while(true);
                    System.out.print("Enter updated First Name: ");
                    courseName = input.nextLine();
                    System.out.print("Enter updated Last Name: ");
                    courseCredits = input.nextInt();
                    stud.setCourseId(CourseId);
                    stud.setCourseName(courseName);
                    stud.setCourseCredit(courseCredits);
                    feedback = dao.updateCoursePrepared(stud);
                    System.out.println(feedback);
                    System.out.println("Do you wish to continue? Use Yes or No");
                    answer = input.next();
                    if (answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }                                      
                    break;
                case 3:
                    do{
                        System.out.print("Enter Course ID to delete: ");
                        CourseId = input.next(); 
                        if(CourseId.length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of exactly 5 digits.");
                        }
                    }while(true);
                    //create Course object to store data
                    //Course stud = new Course();
                    stud.setCourseId(CourseId);
                    //create DAO object 
                    //CourseDao dao = new CourseDao();
                    feedback = dao.deleteCoursePrepared(stud);
                    System.out.println(feedback);
                    System.out.println("Do you wish to continue? Use Yes or No");
                    String answerc3 = input.next();
                    if (answerc3.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }
                    break;
                case 4:
                    dao.retrieveCoursePrepared();
                    System.out.println("Do you wish to continue? Use Yes or No");
                    answer = input.next();
                    if (answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }
                    
                    break;
                case 5:
                    do{
                        System.out.print("Please enter Course ID: ");
                        CourseId = input.next(); 
                        if(CourseId.length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of exactly 5 digits.");
                        }
                    }while(true);
                    stud.setCourseId(CourseId);
                    Course course = dao.retrieveCourseByIdPrepared(stud);
                    System.out.println();
                    System.out.println("Course ID: " + course.getCourseId());
                    System.out.println("-----------------");
                    System.out.println("Course name: " + course.getCourseName());
                    System.out.println("Course credits: " + course.getCourseCredit());
                    System.out.println("Do you wish to continue? Use Yes or No");
                    String answerc5= input.next();
                    if (answerc5.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }
                    
                    break;                             
                case 0:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);
                    break;
                default:
                    
                    break;                    
            }
        }

	}

}
