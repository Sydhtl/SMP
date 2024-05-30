package LAB8;

import java.util.Date;

/**
 * 
 * @author saidahtul
 *
 */
public class Lecturer extends Person implements Comparable<Lecturer>{
//attributes
	private String staffId;
	private  String password;
	public String phone;
	Course[]courseLecturers=new Course[10];
	int index;
	
	
	
	//constructor for lecturer
	public Lecturer(String name,String staffId, String phone) {
		super(name);
		this.staffId=staffId;
		this.phone=phone;
		
	}
	//constructor for lecturer
	public Lecturer(String name,Date dob, String staffId) {
		super(name,dob);
		this.staffId=staffId;
	}
	//constructor for lecturer
	public Lecturer(String name,String staffId,String password, String phone) {
		super(name);
		this.staffId=staffId;
		this.password=password;
		this.phone=phone;
	}
	//this is how the constructor for this class will be printed out
	public String toString() {
		return(name+"\t"+staffId+"\t"+phone);
	}
	//constructor for getStaffId
	public String getStaffId() {
		return staffId;
	}
	//constructor for getPassword
	public String getPassword() {
		return password;
	}
	public String getUsername() {
        return staffId;
    }
	//constructor for registerCourse
	public void registerCourse(Course course) {
		for(int i=0;i<index;i++) {
			if(courseLecturers[i].equals(course)) {
				return;
			}
		}
		courseLecturers[index++] = course;
		index++;
		course.registerLecturer(this);
	
		courseLecturers[index++] = course;
		
	}
	//constructor for printCourses
	public void printCourses() {
		for(Course course: courseLecturers) {
			if(course!=null) {
			System.out.println(course);
			return;
			}
		
	}
		
	}
	
	//constructor for setPassword
	public void setPassword(String password2) {
		password=password2;
	}
	@Override
	public int compareTo(Lecturer o) {
		// TODO Auto-generated method stub
		return this.staffId.compareTo(o.getStaffId());
    
	}
	
}