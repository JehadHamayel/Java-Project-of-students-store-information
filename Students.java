package assignment2;
import java.util.*;
public class Students {//The following variables are defined for the class
	private String firstName ;
	private String lastName ;
	private int id;
	private Date dateOfBirth;
	private double grade;
	public Students(){//The Default Constructor
		
	}
	//Constructor to enter student information and reserve a place
	public  Students(String firstName,String lastName,int id,Date dateOfBirth){
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.grade=0;
	}
	//Definition of getter and sitter for Variables
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
}
