package LAB8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CourseDB {
	//array for courseList
	//	Course[]courseList=new Course[10];
		ArrayList<Course>courseList=new ArrayList<>();
		//int index;
		
	/**
	 * instance method for addcourse
	 * @param course
	 */
		public  void addCourse(Course course) {
			
			//add to students array
			courseList.add(course);
			File courseList=new File("CourseList.txt");
			try {
				if(!courseList.exists()){
					courseList.createNewFile();
					System.out.println("Succesfully created");
				}
				if(courseList.canWrite()) {
					//use fileOutputStream to append content, truee=appendrrv
				PrintWriter writer =new PrintWriter(new FileOutputStream(courseList,true));
				//writer.println(matric+" , "+name +" ' "+ agree);
				writer.append(course+"\n");
				writer.close();
				}
				else{
					System.out.println("The data file is in read only mode");
				}
				ArrayList<Course>courses =new ArrayList();
				Scanner fileScanner=new Scanner(courseList);
			}catch(IOException e) {
				e.printStackTrace();
			}
			}
		
		//instance method for delete course
		
			
			//instance method for delete course
			public void deleteCourse(String code) {
				for(int i=0; i<courseList.size();i++) {
					if(courseList.get(i)!=null&&courseList.get(i).getCode().equals(code)) {
						courseList.remove(i);
					}
				}
			}
			//instance method for Find course
			public  Course findCourse(String code) {
				
				
				for(Course coursee:courseList) {
					
					if(coursee!=null&&coursee.getCode().equals(code)) {
						
						return coursee;
					}
					}
				
				return null;
				
			}
			//instance method for print course
			public  void printCourse() {
				Collections.sort(courseList);
				for (Course coursee : courseList) {
					if(coursee!=null)
					System.out.println(coursee);
					
			}
		}
		}