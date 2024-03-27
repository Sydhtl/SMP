package LAB8;

import java.util.Date;
/**
 * 
 * @author saidahtul
 *
 */
public abstract class Person {
	//attributes :name, dob;
public String name;
public Date dob;

public abstract String getUsername();
public abstract String getPassword();

//constructor for the class Person(Name, dob);
	public Person(String name, Date dob) {
		this.name=name;
		this.dob=dob;
	}
	//constructor for the class Person(name)
	public Person(String name) {
		this.name=name;
	}
	//this is how the Person constructor will be print out
	public String toString(){
		return (name);
	}
	
}
