package com.aperegarc.cruddemo;

import com.aperegarc.cruddemo.dao.StudentDAO;
import com.aperegarc.cruddemo.entity.Student;
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
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			queryForStudents(studentDAO);
		};

		}


	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Adri","Perez","adrigarciaprz@gmail.com");
		System.out.println("Save the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());;
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Adri","Perez","adrigarciaprz@gmail.com");
		System.out.println("Save the student...");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student: " + myStudent);

	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

}
