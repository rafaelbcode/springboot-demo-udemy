package com.udemydemo.cruddemo;

import com.udemydemo.cruddemo.dao.StudentDAO;
import com.udemydemo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student " + studentId);
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//get student based on id
		int studentId = 2;
		Student theStudent = studentDAO.findById(studentId);

		//change first name
		theStudent.setFirstName("Rafa");

		//update on DB
		studentDAO.update(theStudent);

		//display update
		System.out.println(theStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Rafa");

		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student > studentsList = studentDAO.findAll();

		for (Student student : studentsList) {
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		Student newStudent = new Student("daffy","duck","daffy@gmail.com");
		studentDAO.save(newStudent);

		int id = newStudent.getId();
		System.out.println("Saved student with id " + id);

		System.out.println("Retrieving student with id " + id);
		Student retrievedStudent = studentDAO.findById(id);
		System.out.println("Retrieved student " + retrievedStudent);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {
			System.out.println("Creating 3 student objects");
			Student newStudent1 = new Student("John","Rafa","rafa@gmail.com");
			Student newStudent2 = new Student("Jack","Rafa","rafa@gmail.com");
			Student newStudent3 = new Student("Joseph","Rafa","rafa@gmail.com");

			studentDAO.save(newStudent1);
			studentDAO.save(newStudent2);
			studentDAO.save(newStudent3);
		};



	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object");
		Student newStudent = new Student("Rafa","Rafa","rafa@gmail.com");

		//save
		System.out.println("Saving the student object");
		studentDAO.save(newStudent);

		//display id
		System.out.println("Saved student. Generated id: " + newStudent.getId());
	}



}
