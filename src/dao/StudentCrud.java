package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Student;
import helper.StudentHelperClass;

public class StudentCrud {
	
	StudentHelperClass studentHelperClass=new StudentHelperClass();
	Connection connection=studentHelperClass.helperMethod();
	
	public void insrtStudent(Student student) {
		String query="insert into student values(?,?,?)";
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2,student.getName() );
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.execute();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(connection !=null) {
				connection.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
