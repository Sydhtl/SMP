package LAB8;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * @author saidahtul 
 *
 */
//the class is SMP
	public class SMP {

		
		//this is an object of the StudentDB that can be used to access the methods and fields in StudentDB class.
		public static StudentDB studentDB=new StudentDB();
		//this is an object  of the CourseDB that can be used to access the methods and fields in CourseDB class.
		public static CourseDB courseDB=new CourseDB();
		//this is an object  of the CredentialDB that can be used to access the methods and fields in CredentialDB class.
		public static CredentialDB credentialDB=new CredentialDB();
		//this is an object of the LecturerDB that an be used to access the methods and fields in LecturerDB
		public static LectureDB lecturerDB=new LectureDB();
		//this is an object  of the Admin that can be used to access the methods and fields in Admin class.
		public static Admin admin=new Admin("Admin1","123456","Sai");
		//this is an object  of the LectureHallDB that can be used to access the methods and fields in LectureHallDB class.
		public static LectureHallDB lectureHallDB=new LectureHallDB();
		public static int index;
		
		
		
		
	
		public static Scanner scanner = new Scanner(System.in);

		/**
		 * This is the main method that will print out all of the code under main method.
		 * @param args
		 * @throws Exception
		 */
		public static void main(String[] args) throws Exception {
			System.out.print(admin);
			
			while (true) {	
				printLogInOption();
				
			}
		}
				/**
				 * this is the main method for admin
				 * @throws Exception
				 */
		public static void admin() throws Exception   {
			System.out.println("Enter Admin Id");
			String adminID=scanner.nextLine();
			if(adminID.equals(admin.adminID)) {
			
			System.out.println("Enter Admin Password");
			String adminPassword=scanner.nextLine();
			if(adminPassword.equals(admin.getPasswordAdmin())) {
		
			printAdminMenu();
			}
			}
			}
			
			
		
		/**
		 * This is the method for student
		 * @throws Exception
		 */
		
		public static void student() throws Exception {
			System.out.println("Enter Matric");
			String matric=scanner.nextLine();
			
			System.out.print("Enter Password");
			String password=scanner.nextLine();
			
			
			if(credentialDB.findActivateStudent(matric, password))  {
			
			printStudentMenu();
			}
				printLogInOption();
			
			}
			
			 
			
			
			
		//this is the method for printStudentMenu
		public static Lecturer printStudentMenu() throws Exception {

			while( true){
				
				System.out.println("-----------------------");
				System.out.println("STUDENT MENU");
				System.out.println("-----------------------");
				System.out.println("1	register Course for student");
				System.out.println("2	registered Course list");
				System.out.println("3	update phone");
				System.out.println("4	update password");
				System.out.println("5 	LOG OUT");
				System.out.println("Enter the next action:");
				String nextAction=scanner.nextLine();
			
				switch(nextAction) {
				
				case "1":
					/**
					 * This is the case that will print the createStudent method .
					 */
					registerCourse();
					break;
				case "2":
					listCoursesByStudent();
					/**
					 * This is the case that will print theprintStudentList() method .
					 */
					
					break;
				case "3":
					/**
					 * This is the case that will print deleteStudent() method .
					 */
					updatePhone();
					break;			
				case "4":
					/**
					 * This is the case that will print 	addCourse() method .
					 */
					updatePassword();
					break;
				case "5":
					/**
					 * This is the case that will print printCourseList()method .
					 */
					System.out.println("Successfully log out");
					printLogInOption();
					break;
				
					
					
					
					
				default:
					/**
					 * This is the class that will print a string of "Unknown menu option." .
					 */
					System.out.println("Unknown menu option.");
				
				}
				}
				
					
			}
		//this is the method for updatePassword
		private static void updatePassword() {
			System.out.print("MATRIC: ");
			String matric = scanner.nextLine();
			
			//pronpt yser for new phone number
			System.out.print("NEW PASSWORD: ");
			String password = scanner.nextLine();
			
			//scan for the object with this matric from the studnetlist
				Student student=credentialDB.findStudent(matric);
				student.setPassword(password);
				
				System.out.println("PASSWORD UPDATED");
			
				}			
		

		//this is the method for lecturer

		public static void lecturer() throws Exception {
			System.out.println("Enter staffId");
			String staffId=scanner.nextLine();
			System.out.println("Enter password");
			String password=scanner.nextLine();
			if(credentialDB.findActivateLecturer(staffId,password)){
			printLecturerMenu();
			}
			printLogInOption();
			}
		//this is the method for printLecturerMenu
		public static void printLecturerMenu() throws Exception {
			while(true) {
			System.out.println("-----------------------");
			System.out.println("LECTURER MENU");
			System.out.println("-----------------------");
			System.out.println("1	Register Course for Lecturer");
			System.out.println("2	registered Course list");
			System.out.println("4	update password");
			System.out.println("5 	LOG OUT");
			System.out.println("Enter the next action:");
			String nextAction=scanner.nextLine();
			
			switch(nextAction) {
			
			case "1":
				/**
				 * This is the case that will print the createStudent method .
				 */
				registerCourseForLecturer();
				break;
			case "2":
				listCoursesByLecturer();
				/**
				 * This is the case that will print theprintStudentList() method .
				 */
				
				break;
						
			case "3":
				/**
				 * This is the case that will print 	addCourse() method .
				 */
				updatePasswordLecturer();
				break;
			case "4":
				/**
				 * This is the case that will print printCourseList()method .
				 */
				System.out.println("Successfully log out");
				printLogInOption();
				break;
			
				
				
				
				
			default:
				/**
				 * This is the class that will print a string of "Unknown menu option." .
				 */
				System.out.println("Unknown menu option.");
			
			}
			}
		}
				
		
			//this is the updatePasswordLecturer
		private static void updatePasswordLecturer() {
			System.out.print("StaffId: ");
			String staffId = scanner.nextLine();
			
			
			//prompt user for new phone number
			System.out.print("NEW PASSWORD: ");
			String password = scanner.nextLine();
			
			//scan for the object with this matric from the studnetlist
			Lecturer lecturers=credentialDB.findLecturer(staffId);
				lecturers.setPassword(password);
				
				System.out.println("PASSWORD UPDATED");
					
				}			
			
		

		
		//this is the listCourseByLecturer
		private static void listCoursesByLecturer() {
			System.out.print("StaffID: ");
			String staffId = scanner.nextLine();
			Lecturer lecturer=lecturerDB.findLecturer(staffId);
			lecturer.printCourses();
						
		}
		//this is the registerCourseForLecturer
		private static void registerCourseForLecturer() {
			System.out.print("StaffId: ");
			String staffId = scanner.nextLine();
			System.out.print("COURSE CODE: ");
			String code = scanner.nextLine();
	
			/**
			 * we use the instance method to find the matric and
			 * register the student under the registerCourse()method
			 */
			Lecturer lecturer=lecturerDB.findLecturer(staffId);
			Course course=courseDB.findCourse(code);
			if(lecturer!=null&&course!=null) {
				lecturer.registerCourse(course);
			}
		}
	
		//this is the printLogInOption
		public static  void  printLogInOption() throws Exception {
			while(true) {
			System.out.println("\n************************"+"\nCHOOSE LOGIN OPTION:");
			System.out.println("1:ADMIN"+"\n2:Student"+"\n3:Lecturer");
			
			System.out.print("ENTER THE LOGIN OPTION:");
			String choice=scanner.nextLine();
			
			switch(choice) {
			case "1":
				admin();
					break;
				
			case"2":
				student();
					break;
				
			case"3":
				lecturer();
					break;
				
		
			default:
				System.out.println("Unknown menu option.");
					
				}
			}
			}
		
		

		

		/**
		 * Print the menu list for admin
		 * @throws Exception 
		 */
		
		
		public static void printAdminMenu() throws Exception  {
			
			while( true){
				
				System.out.println("-----------------------");
				System.out.println("ADMIN MENU");
				System.out.println("-----------------------");
				System.out.println("1	Add a New Student to the Database");
				System.out.println("2	List Students");
				System.out.println("3	Delete Students");
				System.out.println("4	Add a New Course to the Database");
				System.out.println("5	List Courses");
				System.out.println("6	Delete course");
				System.out.println("7	Add Lecturer");
				System.out.println("8	List Lecturer");
				System.out.println("9	Delete Lecturer");
				System.out.println("10 	Add lecture hall")	;
				System.out.println("11	Activate Person");
				System.out.println("12 	List of activated person");
				System.out.println("13 	LOG OUT");
				System.out.println("Enter the next action:");
				String nextAction=scanner.nextLine();
			
				switch(nextAction) {
				
				case "1":
					/**
					 * This is the case that will print the createStudent method .
					 */
					createStudent();
					break;
				case "2":
					/**
					 * This is the case that will print theprintStudentList() method .
					 */
					printStudentList();
					break;
				case "3":
					/**
					 * This is the case that will print deleteStudent() method .
					 */
					deleteStudent();
					break;			
				case "4":
					/**
					 * This is the case that will print 	addCourse() method .
					 */
					addCourse();
					break;
				case "5":
					/**
					 * This is the case that will print printCourseList()method .
					 */
					printCourseList();
					
				
					break;
				case "6":
				
					/**
					 * This is the case that will print removeCourse() method .
					 */
					removeCourse();
					break;
				
				case "7":
					createLecturer();
						
						break;
				case "8":
					listLecturer();
					
						break;
				case"9":
					deleteLecturer();
					break;
				case"10":
					addLetcureHall();
					break;
				case"11":
					activatePerson();
					break;
				case"12":
					printListActivatedPerson();
					break;
				case"13":
					System.out.println("Successfully log out");
					printLogInOption();
					break;
					
					
					
				default:
					/**
					 * This is the class that will print a string of "Unknown menu option." .
					 */
					System.out.println("Unknown menu option.");
				
				}
				}
				
					
			}
			
			
		
		//this is the method printListActivatedPerson
		private static void printListActivatedPerson() {
			
			credentialDB.activatedPersonList();
		}
		//this is the addLectureHall method
		private static void addLetcureHall() {
			System.out.print("Enter Lecture Hall name:");
			String lectureHall=scanner.nextLine();
			
			LectureHall lectureHalls=new LectureHall(lectureHall);
			lectureHallDB.addLectureHall(lectureHalls);
		
			
		}
		//this is t
		public static void activatePerson() {
			System.out.println("Enter your choice either Student or Lecturer(S/L)");
			String choice=scanner.nextLine();
			switch(choice) {
			case"s":case "S":
				System.out.print("Enter the matric number:");
				String matric=scanner.nextLine();
				System.out.print("Enter the password:");
				String password=scanner.nextLine();
				System.out.println("Enter the name:");
				String name=scanner.nextLine();
				Student student=new Student(name,matric,password);
				
				credentialDB.activateStudentPerson(student);
				File activatePersonStudent=new File("activatePerson.txt");
				try {
					if(!activatePersonStudent.exists()){
						activatePersonStudent.createNewFile();
						System.out.println("Succesfully created");
					}
					if(activatePersonStudent.canWrite()) {
						//use fileOutputStream to append content, truee=appendrrv
					PrintWriter writer =new PrintWriter(new FileOutputStream(activatePersonStudent,true));
					//writer.println(matric+" , "+name +" ' "+ agree);
					writer.append(matric+"\t"+password+"\t"+name+"\n");
					writer.close();
					}
					else{
						System.out.println("The data file is in read only mode");
					}
					ArrayList<Student>students =new ArrayList();
					Scanner fileScanner=new Scanner(activatePersonStudent);
				}catch(IOException e) {
					e.printStackTrace();
				}
				break;
		
			case"L":case"l":
				System.out.print("Enter the StaffId" );
				String staffId=scanner.nextLine();
				System.out.println("Enter the Password:");
				 password=scanner.nextLine();
				 System.out.print("Enter name");
				  name=scanner.nextLine();
				 Lecturer lecturer=new Lecturer(name,staffId,password);
				 credentialDB.activateLecturerPerson(lecturer);
				 File activatePersonLecturer=new File("activatePerson.txt");
					try {
						if(!activatePersonLecturer.exists()){
							activatePersonLecturer.createNewFile();
							System.out.println("Succesfully created");
						}
						if(activatePersonLecturer.canWrite()) {
							//use fileOutputStream to append content, truee=appendrrv
						PrintWriter writer =new PrintWriter(new FileOutputStream(activatePersonLecturer,true));
						//writer.println(matric+" , "+name +" ' "+ agree);
						writer.append(staffId+"\t"+password+"\t"+name+"\n");
						writer.close();
						}
						else{
							System.out.println("The data file is in read only mode");
						}
						ArrayList<Lecturer>lecturers =new ArrayList();
						Scanner fileScanner=new Scanner(activatePersonLecturer);
					}catch(IOException e) {
						e.printStackTrace();
					}
				 break;
				 
				default:
					System.out.print("Unknown option");
					break;
			}
			
		
			
			
			
			
			
		}

		public static void createLecturer() throws Exception {
			
			String name=null;
			String staffId=null;
			String dateFormat=null;
			
			while(name==null||name.trim().isEmpty()) {
			System.out.print("Enter lecturer name:");
			 name=scanner.nextLine();
			 if(name.isEmpty()) {
				 System.out.println("Name cannot be empty. Please enter a valid NAME");
				 printAdminMenu();
			 }
			}
			 
			while(staffId==null||staffId.trim().isEmpty()) {
				System.out.print("Enter lecturer Id ");
				 staffId=scanner.nextLine();
				 if(staffId.isEmpty()) {
					 System.out.println("StaffId cannot be empty. Please enter a valid STAFF ID");
					 printAdminMenu();
				 }
				}
			
			try {
			System.out.print("Enter lecturer dob:");
			System.out.print("DOB: [DD/MM/YYYY]");
			 dateFormat = "dd/MM/yyyy";
			Date dob=(new SimpleDateFormat(dateFormat).parse(scanner.nextLine()));
			Lecturer lecturer=new Lecturer(name,dob,staffId);
			lecturerDB.addLecturer(lecturer);
			}
			catch(Exception e) {
				System.out.println("Enter valid birth date");
					printAdminMenu();
			}
			
		}
public static void listLecturer() {
	lecturerDB.printLecturer();
	
			
		}
public static void deleteLecturer() {
	System.out.print("StaffID: ");
	String staffId = scanner.nextLine();
	lecturerDB.findLecturer(staffId);
	lecturerDB.deleteLecturer(staffId);
	
}
		/**
		 * Get the input from the user, then create a Student object, then put 
		 * the object into the StudentList
		 * @throws Exception 
		 * @throws Exception
		 */
		public static void createStudent() throws Exception {
			 String matric = "";
		     String name = "";
		     String phone = "";
		     String program = "";
		    
			
		        
		            System.out.print("MATRIC: ");
		            
		            matric = scanner.nextLine();
		            
		            if ( matric.length()==6) {
		           
		                System.out.println("MATRIC:" + matric +" is valid");
		                
		            
		       		} else {
		        		System.out.println("please enter the matric that consist 6 numbers");
		        		printAdminMenu();
		        	}
		          
			
		       
					System.out.print("NAME: ");
			 		name = scanner.nextLine();
			 		
			 		if (name.length() >= 1 && name.length() <= 255) {
               			System.out.println("Hello, " + name);
               			
            		} else {
               			System.out.println("Name must be between 1 and 255 characters long. Please enter a valid NAME.");
               			printAdminMenu();
           			}
       		 
		      
		            System.out.print("PHONE: ");
		            phone = scanner.nextLine();
		            if(phone.length()<=20 && phone.length()>=5) {
		                System.out.println("PHONE: " + phone);
		               
		            }
		            else {
		            	System.out.println("Enter Valid Phone Number!"); 
		            	printAdminMenu();
		            }
		        
		       
		            System.out.print("PROGRAM: ");
		            program = scanner.nextLine();
		            if (program.length() >= 1 && program.length() <= 255) {
		                System.out.println("Program : " + program );
		                
		            } else {
		            	System.out.println("Enter Valid PROGRAM");
		            	printAdminMenu();
		            	}
		            
		Student student = new Student(name, matric, phone, program);
		// add the new student to the database
		studentDB.addStudent(student);
		
		}
		        
			

		/**
		 * Print all the Student objects in the student list
		 */
		public static void printStudentList() {
			studentDB.printStudent();
			}
		
		private static void registerCourse() {
			System.out.print("MATRIC: ");
			String matric = scanner.nextLine();
			System.out.print("COURSE CODE: ");
			String code = scanner.nextLine();
	
			/**
			 * we use the instance method to find the matric and
			 * register the student under the registerCourse()method
			 */
			Student student=studentDB.findStudent(matric);
			Course course=courseDB.findCourse(code);
			if(student!=null&&course!=null) {
				student.registerCourse(course);
			}
		}
		
		/**
		 * Add a new course to the course database
		 * @throws Exception 
		 */
		private static void addCourse() throws Exception  {
			 String courseCode, courseName, lecturerName, lectureId = " ";
			 int codePrefix, codeNumber, credit, group = 0;
		        
		     System.out.print("COURSE CODE: ");
	         codePrefix = scanner.nextInt();

	            if (codePrefix==3) {
	                System.out.println("Valid course prefix");
	                if(codeNumber==4) {
	                	System.out.println( "Valid course number");
	                }
	                else {
	                	System.out.println("Invalid course number");
	                	printAdminMenu();
	                }
	            } else {
	                System.out.println("Invalid course code");
	                printAdminMenu();
	            }
	            
		    System.out.print("COURSE NAME: ");
		 	courseName = scanner.nextLine();
		 		
		 		if (courseName.length() >= 1 && courseName.length() <= 255) {
           			System.out.println("Course name" + courseName);
           			
        		} else {
           			System.out.println("Name must be between 1 and 255 characters long. Please enter a valid NAME.");
           			printAdminMenu();
           		 }
		 		
		         System.out.print("CREDIT: ");
		                group = scanner.nextInt();

		            	if (group >= 1 && group <=6) {
		           			System.out.println("Credit : " + credit);
		           			
		        		} else {
		           			System.out.println("Credit exists between 1-6. Please enter a valid CREDIT.");
		           			printAdminMenu();
		           		 }
		               

		        // Get and validate input for GROUP
		      
		                System.out.print("GROUP: ");
		                group = scanner.nextInt();

		            	if (group >=1 && group <= 50) {
		           			System.out.println("Group : " + group);
		           			
		        		} else {
		           			System.out.println("Group exists between 1-50. Please enter a valid GROUP.");
		           			printAdminMenu();
		           		 }
		               

		        System.out.print("LECTURER NAME: ");
		 		lecturerName = scanner.nextLine();
		 		
		 		if (lecturerName.length() >= 1 && lecturerName.length() <= 255) {
           			System.out.println("Hello" + lecturerName);
           			
        		} else {
           			System.out.println("Name must be between 1 and 255 characters long. Please enter a valid NAME.");
           			printAdminMenu();
           		 }

		        // Get and validate input for LECTURE ID
		 		
		             System.out.print("LECTURER ID: ");
		             lecturerId = scanner.nextLine();

		             if (lecturerId.length() == 6) {
		                 System.out.println("Valid lecturer id");
		                 printAdminMenu();// Reset matric to ensure the loop continues
		             } else {
		                 System.out.println("Invalid lecturer id");
		             }
		    



		  
			
			Course course = new Course(codePrefix, codeNumber, lecturerName, credit, group, lectureId);
			
			courseDB.addCourse(course);
			}
	
			
		

	

		
		
		/**
		 * Update phone number by matric
		 */
		public static void updatePhone() {
			///pormpt user for matric number
			System.out.print("MATRIC: ");
			String matric = scanner.nextLine();
			
			//pronpt yser for new phone number
			System.out.print("NEW PHONE NUMBER: ");
			String phone = scanner.nextLine();
			
			//scan for the object with this matric from the studnetlist
				Student student=studentDB.findStudent(matric);
				student.setPhone(phone);
				System.out.println("PHONE NUMBER UPDATED");
			
				}
			
		

		/**
		 * method to delete the student that already in the system.
		 */
		public static void deleteStudent() {
			
			System.out.print("MATRIC: ");
			String matric = scanner.nextLine();
			studentDB.findStudent(matric);
			
			studentDB.deleteStudent(matric);
		}
		

		/**
		 * Print all the CourseDB objects in the student list
		 */
		public static void printCourseList() {
			courseDB.printCourse();
		
		}

		/**
		 * Print all the CourseDB objects in the student list
		 */
		public static void removeCourse() {
			System.out.print("CODE: ");
			String code = scanner.nextLine();
			courseDB.deleteCourse(code);
		}

		/**
		 * Print all the Student objects in the student list
		 */
		public static void listCoursesByStudent() {
			System.out.print("MATRIC: ");
			String matric = scanner.nextLine();
			Student student=studentDB.findStudent(matric);
			student.printCourses();
			
		}

		/**
		 * Print all the COurse objects in the student list
		 */
		public static void listStudentByCourse() {
			System.out.print("CODE: ");
			String code = scanner.nextLine();
			Course course=courseDB.findCourse(code);
			course.printCourses();
		}
		}

	
