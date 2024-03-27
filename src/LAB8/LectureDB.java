package LAB8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LectureDB {
	//array
			ArrayList<Lecturer>lecturerList=new ArrayList<>();
		//attribute
		int index;
		//constructor for addLecturer
		public void addLecturer(Lecturer lecturer) {
			lecturerList.add(lecturer);
			File lecturerList=new File("LecturerList.txt");
			try {
				if(!lecturerList.exists()){
					lecturerList.createNewFile();
					System.out.println("Succesfully created");
				}
				if(lecturerList.canWrite()) {
					//use fileOutputStream to append content, truee=appendrrv
				PrintWriter writer =new PrintWriter(new FileOutputStream(lecturerList,true));
				//writer.println(matric+" , "+name +" ' "+ agree);
				writer.append(lecturer+"\n");
				writer.close();
				}
				else{
					System.out.println("The data file is in read only mode");
				}
				ArrayList<Lecturer>lecturers =new ArrayList();
				Scanner fileScanner=new Scanner(lecturerList);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		//constructor for printLecturer
		public  void printLecturer() {
			Collections.sort(lecturerList);
			for (Lecturer lecturer : lecturerList) {
				if(lecturer!=null)
				System.out.println(lecturer);
				
		}
		}
		//constructor for deleteLecturer
		public void deleteLecturer(String staffId) {
			for(int i=0; i<lecturerList.size();i++) {
				if(lecturerList.get(i)!=null&&lecturerList.get(i).getStaffId().equals(staffId)) {
					lecturerList.remove(i);
				}
			}
		}
		//constructor for findLecturer
		public Lecturer findLecturer(String staffId) {
			for(Lecturer lecturer:lecturerList) {
				if(lecturer!=null&&lecturer.getStaffId().equals(staffId)) {
					return lecturer;
				}
			}
			return null;
		}
		
	}
