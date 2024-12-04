package practice.student.controller;

import java.util.List;
import java.util.Scanner;

import practice.student.dao.StudentDao;
import practice.student.dto.Student;

public class StudentController {
	 static Scanner sc = new Scanner(System.in);
	    static StudentDao studentDao = new StudentDao();

	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("\n--- Student Management System ---");
	            System.out.println("1. Add Student");
	            System.out.println("2. Update Student");
	            System.out.println("3. Fetch All Students");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Fetch By Name");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1: {
	                    System.out.println("Enter ID:");
	                    int id = sc.nextInt();
	                    System.out.println("Enter Marks:");
	                    int marks = sc.nextInt();
	                    System.out.println("Enter Name:");
	                    String name = sc.next();
	                    System.out.println("Enter Address:");
	                    String address = sc.next();

	                    Student stu = new Student();
	                    stu.setId(id);
	                    stu.setMarks(marks);
	                    stu.setName(name);
	                    stu.setAddress(address);
                        System.out.println("inseted successfully");
	                    studentDao.addStudent(stu);
	                    break;
	                }

	                case 2: {
	                    System.out.println("Enter ID to update:");
	                    int id = sc.nextInt();
	                    System.out.println("Enter new Name:");
	                    String name = sc.next();
	                    System.out.println("Enter new Marks:");
	                    int marks = sc.nextInt();

	                    Student stu = new Student();
	                    stu.setId(id);
	                    stu.setName(name);
	                    stu.setMarks(marks);

	                    studentDao.updateStudent(id,name,marks);
	                    break;
	                }

	                case 3: {
	                	 List<Student> students = studentDao.fetchAll();
	                     for (Student s : students) {
	                         System.out.println(s);
	                     }
	                    break;
	                }

	                case 4: {
	                	System.out.println("enter id to delete");
	                	int id=sc.nextInt();
	                 studentDao.deleteStu(id);
	                 
	                    break;
	                }

	                case 5: {
	                   List<Student>student=studentDao.fetchNameAndAddress();
	                   for(Student s1:student) {
	                	   System.out.println("Name: "+s1.getName()+","+"Address: "+s1.getAddress());
	                   }
	                  break;   
	                }

	                default: {
	                    System.out.println("Invalid choice, please try again.");
	                    break;
	                }
	            }
	        }
	    }
}


