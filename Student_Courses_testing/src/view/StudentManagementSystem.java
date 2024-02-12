package view;
import java.util.Scanner;

import DAO.StudentDAO;
import model.Student;

public class StudentManagementSystem {

	public static void main(String[] args) {
        boolean condition = true;
        int studentId;
        String firstName;
        String lastName;        
        Student stud = new Student();
        StudentDAO dao = new StudentDAO();
        while(condition){
            System.out.println("==========================");
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("==========================");
            System.out.println("1. Register Student ");
            System.out.println("2. Update Student ");
            System.out.println("3. Delete Student ");
            System.out.println("4. Retrieve All Student");
            System.out.println("5. Search Student by ID");
            System.out.println("0. Exit");
            System.out.println("---------------------");
            System.out.print("Choose: "); 
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    do{
                        System.out.print("Enter Student ID: ");
                        studentId = Integer.parseInt(input.next()); 
                        if(String.valueOf(studentId).length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of 5 digits only.");
                        }
                    }while(true);
                    input.nextLine();
                    System.out.print("Enter First Name: ");
                    firstName = input.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = input.nextLine();
                    //create student object to store data
                    //Student stud = new Student();
                    stud.setStudent_id(studentId);
                    stud.setFirstName(firstName);
                    stud.setLastName(lastName);
                    //create DAO object 
                    String feedback = dao.registerStudentPrepared(stud);
                    System.out.println(feedback);
                    System.out.println("Do you wish to continue? Use yes or no");
                    String answerc1 = input.next();
                    if (answerc1.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }
                    break;
                case 2:
                    do{
                        System.out.print("Enter Student ID to update: ");
                        studentId = Integer.parseInt(input.next()); 
                        if(String.valueOf(studentId).length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of exactly 5 digits.");
                        }
                    }while(true);
                    System.out.print("Enter updated First Name: ");
                    firstName = input.nextLine();
                    System.out.print("Enter updated Last Name: ");
                    lastName = input.nextLine();
                    stud.setStudent_id(studentId);
                    stud.setFirstName(firstName);
                    stud.setLastName(lastName);
                    feedback = dao.updateStudentPrepared(stud);
                    System.out.println(feedback);
                    System.out.println("Do you wish to continue? Use Yes or No");
                    String answerc2 = input.next();
                    if (answerc2.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }                                      
                    break;
                case 3:
                    do{
                        System.out.print("Enter Student ID to delete: ");
                        studentId = Integer.parseInt(input.next());
                        if(String.valueOf(studentId).length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of exactly 5 digits.");
                        }
                    }while(true);
                    //create student object to store data
                    //Student stud = new Student();
                    stud.setStudent_id(studentId);
                    //create DAO object 
                    //StudentDao dao = new StudentDao();
                    feedback = dao.deleteStudentPrepared(stud);
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
                    dao.retrieveStudentPrepared();
                    System.out.println("Do you wish to continue? Use Yes or No");
                    String answerc4 = input.next();
                    if (answerc4.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system.");
                        condition = false;
                    }
                    
                    break;
                case 5:
                    do{
                        System.out.print("Please enter Student ID: ");
                        studentId = Integer.parseInt(input.next());
                        if(String.valueOf(studentId).length() == 5){
                            break;
                        } else{
                            System.out.println("Please enter an ID of exactly 5 digits.");
                        }
                    }while(true);
                    stud.setStudent_id(studentId);
                    Student stuRetrieved = dao.retrieveStudentByIdPrepared(stud);
                    System.out.println();
                    System.out.println("Student ID: " + stuRetrieved.getStudent_id());
                    System.out.println("-----------------");
                    System.out.println("First name: " + stuRetrieved.getFirstName());
                    System.out.println("Last name: " + stuRetrieved.getLastName());
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
