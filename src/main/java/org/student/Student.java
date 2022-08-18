package org.student;

import org.college.College;
import org.department.Department;

public class Student extends Department {

	public void studentName() {
		
		System.out.println("Student name method is called from the class name " + this.getClass().toString());
		
	}

	public void studentDept() {
		
		System.out.println("Student dept method is called from the class name " + this.getClass().toString());
		
	}

	public void studentId() {
		
		System.out.println("Student id method is called from the class name " + this.getClass().toString());
		
	}
	
	public static void main(String[] args) {

		Student student = new Student();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
		student.deptName();
		student.studentName();
		student.studentDept();
		student.studentId();
		
	}

}
