package org.student;

public class Students {

	public void getStudentInfo(int id) {
		
		System.out.println("Student id is " + id);
		
	}

	public void getStudentInfo(int id, String name) {
		
		System.out.println("Student id is " + id + " and name is " + name);
		
	}

	public void getStudentInfo(String email, int phoneNumber) {
		
		System.out.println("Student email address is " + email + " and phone number is " + phoneNumber);
		
	}
	
	public static void main(String[] args) {

		Students students = new Students();
		students.getStudentInfo(12);
		students.getStudentInfo(12,  "Ali");
		students.getStudentInfo("ali@gmail.com", 123456789);
	}

}
