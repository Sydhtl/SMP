package LAB8;
/**
 * 
 * @author saidahtul
 *
 */

public class LectureHall implements Comparable<LectureHall> {
	//attributes
String hallName;
int capacity;

//constructor for the lectureHall

	public LectureHall(String hallName,int capacity) {
		this.hallName=hallName;
		this.capacity=capacity;
		}
	public LectureHall(String hallName) {
		this.hallName=hallName;
	}
	
	//this is how the constructor will be prinetd out.
	public String toString() {
		return hallName;
	}
	@Override
	public int compareTo(LectureHall o) {
		// TODO Auto-generated method stub
		 return this.hallName.compareTo(o.getLectureHallName());
	}
	private String getLectureHallName() {
		// TODO Auto-generated method stub
		return hallName;
	}
	
}
