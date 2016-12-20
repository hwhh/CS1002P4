import java.util.Scanner;
import java.io.*;
import java.util.Random;
public class Presenter{

String name, affilation;
int presentationFee,  noOfPresentations;
static final int MAX_NUMBER_PRESENTATIONS = 10;

Presentation [] presentations  = new Presentation [MAX_NUMBER_PRESENTATIONS];
static Presenter presenters[]= new Presenter[W07Practical.numberOfPresenters];


int totalFees =0; 

static void newPresenter(int noOfPeople) {
	try {
		File temp = new File("randomPresenterNames.txt");
		Scanner randomNames = new Scanner (temp);
		temp = new File("randomPresentation.txt");
		Scanner randomAffilation = new Scanner (temp);	
		for(int i=0; i<noOfPeople; ++i){
			Random random = new Random();
    	 	presenters[i]=new Presenter(); // Create Object
    		presenters[i].name= randomNames.nextLine();
    		presenters[i].affilation = randomAffilation.nextLine();
    		presenters[i].presentationFee = (W07Practical.getRandom(40))+10;	
		}
	for(int i=0; i<noOfPeople; ++i){
			presenters[i].printDetails();
		}
	}
	catch (Exception e){
            System.out.println("Error");       
    }   
}

public void presentationSighnUp(Presentation presentation){
	try{
		presentations[noOfPresentations++] = presentation;	
	}catch ( ArrayIndexOutOfBoundsException e){
		System.out.println("Too many presentations for one presenter");
	}
}

public void printDetails(){
	System.out.println("name : " +name+"affiliation : " +affilation+ " cost: £" +presentationFee);
	if (presentations != null ) {
		for (Presentation presentation: presentations){
			if (presentation!= null){
				totalFees++;
				//System.out.println(totalFees);
				presentation.printDetails();	
			}
		}
	totalFees=totalFees*presentationFee;
	//System.out.println("Presenter fees :" +totalFees);
	}

}

}
