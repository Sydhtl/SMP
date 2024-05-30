package LAB8;
/**
 * 
 * @author saidahtul
 *
 */
public class Course implements Comparable<Course>{
	
	
	//attributes
	private String code, name, lectureTime;
	CourseDB courseDB=new CourseDB();
	private int credit = 3, group;
	private Lecturer lecturer;
	public LectureHall lectureHall;
	public static Student []studentRegisterCourse=new Student[10];
public static Lecturer[]lecturerRegisterCourse=new Lecturer[10];
	int index;
	/**
	 * The constructor to create a course
	 * 
	 * @param code
	 * @param name
	 * @param credit
	 * @param group
	 */
	
	public Course(String code, String name, int credit, int group, String lectureName, String lectureId) {
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.group = group;
		this.lecturer = new Lecturer(lectureName,lectureId);
		
	}
	/**
	 * The constructor to create a course
	 * @param code
	 * @param name
	 * @param credit
	 * @param group
	 */
	public Course(String code,String name,int credit,int group) {
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.group = group;
	}

	
	/**
	 * this is the method to get the code 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lecturer
	 */
	/*public String getLecturer() {
		return lecturer;
	}

	/**
	 * @param lecturer the lecturer to set
	 */
	/*public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	/**
	 * @return the lectureTime
	 */
	public String getLectureTime() {
		return lectureTime;
	}

	/**
	 * @param lectureTime the lectureTime to set
	 */
	public void setLectureTime(String lectureTime) {
		this.lectureTime = lectureTime;
	}

	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * @return the group
	 */
	public int getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(int group) {
		this.group = group;
	}

	/**
	 * Print this course in this format
	 */
	public String toString() {
		return code + "\t" + name + "(" + credit + ") Group" + group;
	}
	/**
	 * this is the method to printCourses()
	 */
	public  void printCourses() {
		for(Student st : studentRegisterCourse) {
			System.out.println(st);
		}
	}
	/**
	 * This is the method to register student in the course;
	 * @param student
	 */
public void registerStudent(Student student) {
	for(int i=0;i<index;i++) {
		if(studentRegisterCourse[i].equals(student)) {
			return;
		}
	}
	studentRegisterCourse[index++] = student;
		index++;
		student.registerCourse(this);
	}
/**
 * This is the method to register lecturer in the course;
 * @param student
 */
	public void registerLecturer(Lecturer lecturer2) {
		for(int i=0;i<index;i++) {
			if(lecturerRegisterCourse[i].equals(lecturer)) {
				return;
			}
		}
		lecturerRegisterCourse[index++] = lecturer;
			index++;
			lecturer.registerCourse(this);
		
	}
@Override
public int compareTo(Course o) {
	 return this.code.compareTo(o.getCode());
}
}