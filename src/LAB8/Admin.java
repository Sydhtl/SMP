package LAB8;
/**
 * 
 * @author saidahtul
 *
 */

public class Admin extends Person {
	
	//in the class Admin, the attributes are index, adminID, passwordAdminID
	public int index;
	public String adminID;
	private String passwordAdminID;
	
	
	
	

//This is the constructor method for Admin;
	//It contains adminID, passwordAdminID,name;
public Admin(String adminID,String passwordAdminID,String name) {
	super(name);
	this.adminID=adminID;
	this.passwordAdminID=passwordAdminID;
}







//this is the method for getAdminID to call the adminID;
public String getAdminID() {
	return adminID;
}
//this is the method for getPasswordAdmin to call the passwordAdmin;
public String getPasswordAdmin() {
	return passwordAdminID;
}
//this is the toString method to print the Admin class; ;
public String toString() {
	return("Admin Id :"+adminID+"\tName: "+name+"\tPassword:"+passwordAdminID);
}







@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return getAdminID();
}







@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return getPasswordAdmin();
}





}

