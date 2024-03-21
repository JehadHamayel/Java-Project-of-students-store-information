package assignment2;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class DriverTest {
	public static void main(String[] args) {
		Students[][] students; //Define an array of students type
		Scanner input = new Scanner(System.in);   //Define a new scanner for input, followed by print sentences
		System.out.print("Enter Number of classes: ");
		int numOfClasses = input.nextInt();//Enter values from the user
		int numOfStudent;
		while(numOfClasses<=0) { //Check if the number of classes is allowed or not
			numOfClasses = input.nextInt();
			}
		students = new Students[numOfClasses][]; //Enter the size of the rows of ِarray
		System.out.println("---------------------------------");
		for(int n=0 ; n < students.length;n++) {//loop in order to fill the number of classes in the array
			System.out.print("Enter Number of students in class#"+(n+1)+" : ");
			numOfStudent = input.nextInt();
			while(numOfStudent <= 1 || numOfStudent >= 100) {//loop checks the number of students allowed
				System.out.print("This number of students unacceptable Please enter another value:");
				numOfStudent = input.nextInt();
			}
			students[n] = new Students[numOfStudent];
			System.out.println("---------------------------------");
			for(int m=0 ; m<students[n].length;m++) {//loop in order to fill the classes with students
				System.out.println("Student #"+(m+1));
				System.out.println("Enter first name, last name, id and date of birth(YEAR//MONTH//DAY):");
				//example: Jehad Hamayel 1200348 2002 3 14
				String firstName = input.next();
				String lastName = input.next();
				int id = input.nextInt();
				Date dateOfBirth = new Date(input.nextInt()-1900,(input.nextInt()-1),input.nextInt());
				students[n][m]=new Students(firstName,lastName,id,dateOfBirth);
				}
			System.out.println("---------------------------------");
			}	
		sortStudents(students);//Calling Function Sort
		double grade;
		for(int n=0;n< students.length;n++) {
			//Loop in order to enter the marks for students whose names are arranged according to the required condition
			System.out.println("---------------------------------");
			System.out.println("Enter Grades for calss#"+(n+1));
			for(int m=0;m<students[n].length;m++) {
				System.out.println(students[n][m].getFirstName()+" "+students[n][m].getLastName()+" "+students[n][m].getId());
				System.out.println("Enter his/her grade");
				grade=input.nextDouble();
				students[n][m].setGrade(grade);
			}
		 }
		input.close();//close the scanner
		printClass(students);//Calling Function printing
		}
	public static String emailSetter(String firstName,String lastName) {
		//A function to create an automatic email using the student's first and second name
		String email;
		email = firstName.charAt(0) + "" + lastName; 
		return email.toLowerCase() + "@ritaj.birzeit.edu";
	}
	public static void sortStudents (Students[][] stud){//Function arranges the array as required
		Students tem;		
		for(int n=0;n<stud.length;n++) {//loops for checking between names in order to arrange them as required
				for(int p=0;p<stud[n].length;p++) {
					for(int i=p+1;i<stud[n].length;i++) {
						for(char l='a';l<='z';l++){
						if(numOfChar(stud[n][p],l)<numOfChar(stud[n][i],l)) {
							tem=stud[n][i];
							stud[n][i]=stud[n][p];
							stud[n][p]=tem;
						}
						if(numOfChar(stud[n][p],l)!=numOfChar(stud[n][i],l)) {
							break;
						}
					}
				}
			}
		}
}
	public static int numOfChar(Students name,char letter) {
		//Function to count the number of letters in a name and return the number of any letter in any name
		int[] countOfChar=new int[26];
		String nam = name.getLastName();
		String na=nam.toLowerCase();
		char[] so = na.toCharArray();
		for(int i=0;i<so.length;i++) {
			char l='a';
			while(l<='z') {
				if(so[i]==l)
				countOfChar[l-97]++;
				l++;
			}	
		}
		return countOfChar[letter-97];
	}
	public static void printClass(Students[][] str) {//To print the results of students with their gardes
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		for(int e=0;e< str.length;e++) {
			System.out.println("---------------------------------");
			System.out.println("Class #"+(e+1)+"  ordering\n");
			for(int r=0;r<str[e].length;r++) {
				System.out.print(str[e][r].getFirstName()+" "+str[e][r].getLastName()+"  ");
				System.out.print(",id: "+str[e][r].getId()+" ");
				System.out.print(",Email: "+emailSetter(str[e][r].getFirstName(),str[e][r].getLastName())+" ");
				System.out.printf(",Grade =%.2f%%",str[e][r].getGrade());
				String date = simpleDateFormat.format(str[e][r].getDateOfBirth());
				System.out.println(" ,Date of Birth: "+date);
			}
			
			System.out.printf("\nAVG of class#%d: %.2f%% \n",(e+1),calculateAvg(str,e));
	}
		}
	public static double calculateAvg(Students[][] str,int x) {//Function to calculate the release for each class
		double sum=0;
		for(int f=0;f<str[x].length;f++)
			sum = sum +str[x][f].getGrade();
		return sum/str[x].length;
	}
}
