package LAB8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public final class StudentDB {
	ArrayList<Student>studentList=new ArrayList<>();
	 int index;
	
//static Scanner scanner=new Scanner(System.in);

public  void addStudent(Student student) {
	
	//add to students array
studentList.add(student);

File studentList=new File("StudentList.txt");
try {
	if(!studentList.exists()){
		studentList.createNewFile();
		System.out.println("Succesfully created");
	}
	if(studentList.canWrite()) {
		//use fileOutputStream to append content, truee=appendrrv
	PrintWriter writer =new PrintWriter(new FileOutputStream(studentList,true));
	//writer.println(matric+" , "+name +" ' "+ agree);
	writer.append(student+"\n");
	writer.close();
	}
	else{
		System.out.println("The data file is in read only mode");
	}
	ArrayList<Student>students =new ArrayList();
	Scanner fileScanner=new Scanner(studentList);
}catch(IOException e) {
	e.printStackTrace();
}
}
//instance method for delete student in the database
	public void deleteStudent(Student student) {
	
		for (Student st:studentList) {
			if(student!=null&&student==st) {
				//
			}
				
		}
	}
	//instance method for delete student in the database
	public void deleteStudent(String matric) {
		for(int i=0; i<studentList.size();i++) {
			if(studentList.get(i)!=null&&studentList.get(i).getMatric().equals(matric)) {
				studentList.remove(i);
			}
		}
	}
	//instance method for find student using the matric number
	public  Student findStudent(String matric) {
		
		
		for(Student student:studentList) {
			
			if(student!=null&&student.getMatric().equals(matric)) {
				
				return student;
			}
			}
		
		return null;
		
	}
	//instance method for print student
	public  void printStudent() {
		Collections.sort(studentList);
		for (Student student : studentList) {
			if(student!=null)
			System.out.println(student);
			
	}
}
}