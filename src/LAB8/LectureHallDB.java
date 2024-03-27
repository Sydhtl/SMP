package LAB8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LectureHallDB {
	//array
		ArrayList<LectureHall>lectureHallList=new ArrayList<>();
		//attribute
		int index;
		
		//the method for addLectureHall 
		public void addLectureHall(LectureHall lectureHall) {
			lectureHallList.add(lectureHall);
			File lectureHallList=new File("LecturerHallList.txt");
			try {
				if(!lectureHallList.exists()){
					lectureHallList.createNewFile();
					System.out.println("Succesfully created");
				}
				if(lectureHallList.canWrite()) {
					//use fileOutputStream to append content, truee=appendrrv
				PrintWriter writer =new PrintWriter(new FileOutputStream(lectureHallList,true));
				//writer.println(matric+" , "+name +" ' "+ agree);
				writer.append(lectureHall+"\n");
				writer.close();
				}
				else{
					System.out.println("The data file is in read only mode");
				}
				ArrayList<LectureHall>lectureHalls =new ArrayList();
				Scanner fileScanner=new Scanner(lectureHallList);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		//the method for printLectureHall
		public void printLectureHall() {
			Collections.sort(lectureHallList);
			for (LectureHall lectureHall : lectureHallList) {
				if(lectureHall!=null)
				System.out.println(lectureHall);
		}
		}
		//the method for findLectureHall
		public String findLectureHall(String hallsName) {
			for(LectureHall lectureHall:lectureHallList) {
				
				if(lectureHall!=null&&lectureHall.hallName.equals(hallsName)) {
					System.out.println("HALL SUCCESFULLY CHOOSEN");
					return hallsName;
				}
			}
			System.out.println("Unknown hall Name");
			return null;
		}
		
	}