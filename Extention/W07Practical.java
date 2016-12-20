import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class W07Practical{


static int numberOfPeople= 0;
static int numberOfPresentations= 0;
static int numberOfPresenters =0;

static final int maxNumberPresentations = 10;
static final int maxNumberPeople = 20;
static Presentation [] presentations = new Presentation [maxNumberPresentations]; 
static Person [] persons = new Person [maxNumberPeople];
static int presentationCounter = 0;
static int personCounter = 0;



static void feesCheck(Presenter presenter, Workshop workshop){
	if (presenter.totalFees > workshop.registrationCollection) 
		System.out.println("Deficit");
	else if (presenter.totalFees < workshop.registrationCollection) 
		System.out.println("Surplus");
	else if (presenter.totalFees == workshop.registrationCollection)
		System.out.println("Broke even");
}



static void newPresenter(int noOfPeople){
	Person people[]=new Person[noOfPeople];
	for(int i=0; i<noOfPeople; ++i){
    	 people[i]=new Person(); // Create Object
	}
}


static void presentationCheck(int presentationCounter, Presentation presentation){
	if (personCounter<=10)
		presentations[personCounter++]= presentation;
	else
		System.out.println("Error");
}

static void personCheck(int personCounter, Person person){
	if (personCounter<=20)
		persons[personCounter++]=person;
	else
		System.out.println("Error");

}

static int getRandom(int max){ 
	return (int) (Math.random()*max); 
}

public static void main (String[] args){

	do{
		System.out.println("Please eneter the number of people to create");
		numberOfPeople=EasyIn.getInt();
		System.out.println("Please eneter the number of presentations to create");
		numberOfPresentations=EasyIn.getInt();
		System.out.println("Please eneter the number of presenters to create");
		numberOfPresenters=EasyIn.getInt();
		
	}while ((numberOfPeople<1 || numberOfPeople>50) && 
			(numberOfPresentations<1 || numberOfPresentations>50)&& 
			(numberOfPresenters<1 || numberOfPresenters>50)&&
			(numberOfPresenters<numberOfPresentations)&&
			(numberOfPresentations%20 == 0 && numberOfPresentations>=20)&&
			(numberOfPresenters<=numberOfPresentations));
	
	
	Workshop.newWorkshop(numberOfPresentations);
	Presenter.newPresenter(numberOfPresenters);
	Person.newPerson(numberOfPeople);
	Presentation.newPresentation(numberOfPresentations);

	//computerScience.presentationPresentator (steve);
	//maths.presentationPresentator (steve);
	
 
	

	/*Workshop workshop1 = new Workshop();
	//Set the properties of new object
	workshop1.date = workshop1.workshopDate();
	workshop1.venue = "Jack Hall";
	workshop1.registrationFee =10;
	
	
	
	workshop1.presentationSighnUp(computerScience);
	workshop1.attendeeSighnUp(john);
	
	
	presentationCheck(presentationCounter, computerScience);
	personCheck(personCounter, john);
	
	
	workshop1.attendeesRegistered();	
	steve.printDetails();
	
	workshop1.printDetails();
	
	feesCheck(steve, workshop1);*/

}

}


