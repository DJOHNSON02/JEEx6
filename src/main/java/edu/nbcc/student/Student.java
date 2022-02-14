package edu.nbcc.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Student {
	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	private int id;
	private String firstName;
	private String lastName;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 
	 * @return
	 */
	public static Vector<Student> getStudents() {
		Vector<Student> students = new Vector<Student>();
		students.addElement(new Student(1, "Student 1", "Student 1"));
		students.addElement(new Student(2, "Student 2", "Student 2"));
		students.addElement(new Student(3, "Student 3", "Student 3"));
		students.addElement(new Student(4, "Student 4", "Student 4"));
		students.addElement(new Student(5, "Student 5", "Student 5"));
		students.addElement(new Student(6, "Student 6", "Student 6"));
		return students;
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Student getStudent(int id) {
		Vector<Student> student = (Vector<Student>)getStudents().stream().filter(s -> s.getId() == id).collect(Collectors.toList());
		if (student.size() > 0) {
			return student.get(0);
		}
		return null;
	}
	/**
	 * 
	 * @param list
	 * @param student
	 * @return
	 */
	public static boolean isStudentOnTeam(Vector<Student> list, Student student) {
		return list.stream().filter(s -> s.getId() == student.getId()).collect(Collectors.toList()).size() > 0;
	}
}
