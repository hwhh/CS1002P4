import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Person{

String name, email; 
boolean student;
int noOfPresentations=0;
static Person people[]=new Person[W07Practical.numberOfPeople];
Workshop [] workshops  = new Workshop [W07Practical.numberOfPresentations/20];

static void newPerson(int noOfPeople) {
	try {
		File temp = new File("randomNames.txt");
		Scanner randomNames = new Scanner (temp);
		temp = new File("randomEmail.txt");
		Scanner randomEmail = new Scanner (temp);
		Person people[]=new Person[noOfPeople];
		for(int i=0; i<noOfPeople; ++i){
			Random random = new Random();
    	 	people[i]=new Person(); // Create Object
    		people[i].name= randomNames.nextLine();
    		people[i].email = randomEmail.nextLine();
    		people[i].student = random.nextBoolean();	
		}

	}
	catch (Exception e){
            System.out.println("Error");       
    }   
}

public void workshopSighnUp(Workshop workshop){
	try{
		workshops[noOfPresentations++] = workshop;
		//Workshop.attendeeSighnUp();
	}catch ( ArrayIndexOutOfBoundsException e){
		System.out.println("Too many workshops");
	}
}


public void chocie (){
	char choocieInput;
	int addToWorkshop; 
	do{
		choocieInput = Character.toLowerCase(EasyIn.getChar());
	}while(choocieInput!= 'a' && choocieInput!='q');
	
	if (choocieInput== 'a'){
		for(int i=0; i<W07Practical.numberOfPeople; ++i){
			people[i].printDetails(i+1);	
		}
		System.out.println("Which item would you like to edit?");
		do{
			addToWorkshop = EasyIn.getInt();
		    System.out.println("Please enter a workshop number");
		    addToWorkshop = EasyIn.getInt();
			System.out.println("Enter 'S' to save changes");
		    char Save = Character.toLowerCase(EasyIn.getChar()); 
		  	if (Save =='s'){
		  		System.out.println("Changes saved");
		  		workshopSighnUp(Workshop.workshops[addToWorkshop-1]);
		  	}
		  	else 
		  		break;
		}while(addToWorkshop<1 || addToWorkshop>(W07Practical.numberOfPeople/20));
	}
	else if (choocieInput== 'q')
		System.out.println("No changes made");
}
		


public void printDetails(int count){
	System.out.println(count+". name : " +name+" email: " +email+ " student: "+student);
}



}

