package practice.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import practice.student.db.DatabaseConnection;
import practice.student.dto.Student;

public  class StudentDao {
	static Scanner sc=new Scanner(System.in);
	//insert
public static void addStudent(Student student) {
	String sql="insert into student(id,marks,name,address) Values (?,?,?,?)";
	Connection con=DatabaseConnection.getConnection();
	try {
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, student.getId());
		pst.setInt(2, student.getMarks());
		pst.setString(3, student.getName());
		pst.setString(4, student.getAddress());
		pst.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//update
public void updateStudent(int id,String name,int marks) {
	String sql="UPDATE student set name=?,marks=? where id=?";
	Connection con=DatabaseConnection.getConnection();
	try {
		PreparedStatement pst=con.prepareStatement(sql);
		
		pst.setString(1, name);
pst.setInt(2, marks);
pst.setInt(3, id);
int rows=pst.executeUpdate();
if(rows>0)
	System.out.println("updated successfully");
else
	System.out.println("no rows found");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//fetchaALL
public List<Student>fetchAll(){
	List<Student>stu=new ArrayList<Student>();
	String sql="SELECT * FROM student";
	Connection con=DatabaseConnection.getConnection();
	try {
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			Student s=new Student();
			
          s.setId(rs.getInt("id"));
          s.setMarks(rs.getInt("marks"));
          s.setName(rs.getString("name"));
          s.setAddress(rs.getString("address"));
          stu.add(s);
         
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return stu;
}
//delete
public void deleteStu(int id) {
	String sql="delete from student where id=?";
	Connection con=DatabaseConnection.getConnection();
	try {
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		
		 int rows = pst.executeUpdate();
         if (rows > 0) 
             System.out.println("Deleted successfully.");
          else 
             System.out.println("No rows found for the given ID.");
         } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
//fetch name address 
public List<Student>fetchNameAndAddress(){
	List<Student>s=new ArrayList<Student>();
String sql="SELECT name,address from student";
Connection con=DatabaseConnection.getConnection();
try {
	PreparedStatement pst=con.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	
	while(rs.next()) {
		Student stu=new Student();
		stu.setName(rs.getString("name"));
		stu.setAddress(rs.getString("address"));
		s.add(stu);
		}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return s;
}
}
