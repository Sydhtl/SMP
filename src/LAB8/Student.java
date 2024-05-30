package LAB8;

import java.util.Date;
/**
 * 
 * @author saidahtul
 *
 */

public class Student extends Person implements Comparable <Student>{
	//attributes that carry values
	private String matric;
	public String program;
	private String phone;
	public Date dob;
	private String password;
	private  Course[] registerCourses = new Course[10];
	private int courseIndex;
	
	/**
	 * default constructor, comment out because i dont want anyone to create 
	 * a student object without the arguments (parameter values)
	 */
	
	//public Student() {
	//	}
	
	/**
	 * constructor with parameters
	 * @param matric
	 * @param name
	 * @param phone
	 * @param program
	 * @param dob
	 */
	public Student(String name,String matric, String phone, String program) {
		super(name);
		this.matric =  matric;
		this.phone = phone;
		this.program = program;
		
	}
	public Student(String name, String matric, String password) {
		super(name);
		this.matric=matric;
		this.password=password;
	}
	
	/**
	 * to print this object in this format
	 */
	public String toString() {
		return  matric+"\t"+name+"\t"+phone;
		
	}
	/**
	 * This is the method to getPassword to call password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	//This is the method to setPassword to call password
	public void setPassword(String newPassword) {
		password=newPassword;
	}
	/**
	 * setter (mutator)for phone  
	 */
	public void setPhone(String newNumber) {
		phone = newNumber;
	}
	
	/**
	 * returns the matric of this student
	 * @return
	 */
	public String getMatric() {
		return matric;
	}
	
	/**
	 * returs the phone number of this student
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	//this is the method to getName to call name;
	public String getName() {
		return name;
	}
	public String getUsername() {
        return matric;
    }
	/**
	 * Register a course for this student
	 * @param course
	 */
	public void registerCourse(Course course) {
		for(int i=0;i<courseIndex;i++) {
			if(registerCourses[i].equals(course)) {
				return;
			}
		}
		registerCourses[courseIndex++] = course;
		courseIndex++;
		course.registerStudent(this);
	}
	

	/**
	 * Print all courses registered by this student
	 */
	public  void printCourses() {
		for(Course course: registerCourses) {
			if(course!=null) {
			System.out.println(course);
			}
		}
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		  return this.matric.compareTo(o.getMatric());
	}
}