package LAB8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CredentialDB {
	//arrays in the class are activatedPerson, activatedLecturers,activatedStudent
		ArrayList<Person>activatedPerson=new ArrayList<>();
		ArrayList<Student>activatedStudent=new ArrayList<>();
		ArrayList<Lecturer>activatedLecturer= new ArrayList<>();
		//instance method for list of ActivateLecturerPerson
		
		public void activateLecturerPerson(Lecturer lecturer) {
			activatedLecturer.add(lecturer);
			activatedPerson.add(lecturer);
			
				System.out.println("LECTURER ACTIVATED");
				
				
			}
		//instance method for list of ActivateStudentPerson
		public void activateStudentPerson(Student student) {
			activatedStudent.add(student);
	    	activatedPerson.add(student) ;
	    	
			
			System.out.println("STUDENT ACTIVATED");
		}
		//instance method for list of ActivatedPersonList

		public void activatedPersonList() {
			for(Student student:activatedStudent) {
				if(student!=null) {
					System.out.println(student.name+"\t"+student.getMatric()+"\t"+student.getPassword()+"\n");			}
				
			}
			for(Lecturer lecturer:activatedLecturer) {
				if(lecturer!=null)
					System.out.print(lecturer.name+"\t"+lecturer.getStaffId()+"\t"+lecturer.getPassword()+"\n");
				
				
			}
		}
		//instance method for list of ActivateStudentPerson

		
		public boolean findActivateStudent(String upmID,String password) {
			for(Person p:activatedPerson) {
				if(p instanceof Student) {
					Student student=(Student)p;
					if(student!=null&&student.getMatric().equals(upmID)&&student.getPassword().equals(password)){
						System.out.println("Log In into Student Account");
						return true;
				}
				}
			}			return false;
		}
		
		public boolean findActivateLecturer(String upmID, String password) {
		for (Person p: activatedPerson) {
		
		 if(p instanceof Lecturer) {
			Lecturer lecturer=(Lecturer)p;
			if(lecturer!=null&&lecturer.getStaffId().equals(upmID)&&lecturer.getPassword().equals(password)){
				System.out.println("Log In into Lecturer Account");
				return true;
			}
		 }
		}
		return false;
		}
		//instance method for list of findStudent

		public Student findStudent(String matric) {
		for(Student student:activatedStudent) {
				
				if(student!=null&&student.getMatric().equals(matric)) {
					
					return student;
				}
				}
			
			return null;
			
		}
		//instance method for list of findLecturer

		public Lecturer findLecturer(String upmId) {
			for(Lecturer lecturer:activatedLecturer) {
					
					if(lecturer!=null&&lecturer.getStaffId().equals(upmId)) {
						
						return lecturer;
					}
					}
				
				return null;
				
			}
		}
