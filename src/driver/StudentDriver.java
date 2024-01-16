package driver;

import dao.StudentCrud;
import dto.Student;

public class StudentDriver {
	public static void main(String[] args) {
		StudentCrud studentCrud=new StudentCrud();
		Student student=new Student();
		student.setId(55);
		student.setName("keshava");
		student.setEmail("keshu@gmaul.com");
		
		studentCrud.insrtStudent(student);
	}

}
