import java.util.*;
import java.util.Scanner;
import java.io.*;

public class W07Practical{

/*It should be noted that many atributes are being randomly made
this however can easily been changed and was done to speed up testing etc.*/


//THE MAX NUMBER OF OBJECTS ALLOWED TO BE CREATED FROM VARIOUS CLASSES//
static final int MAX_NO_PRESENTATIONS = 10;
static final int MAX_NO_PEOPLE = 20;
static final int MAX_NO_PRESENTERS = 20;

//ARRAYS HOLDING A LIMITED NUMBER OF OBJECTS FROM VARIOUS CLASSES//
static Presentation [] presentations = new Presentation [MAX_NO_PRESENTATIONS]; 
static Person [] people = new Person [MAX_NO_PEOPLE];
static Presenter [] presenters = new Presenter [MAX_NO_PRESENTERS];

/*To ensure there is no more than the max number of people
added to array every time a new object is added to the corresponding
array these values are incremented*/
static int presentationCounter = 0;
static int personCounter = 0;
static int presenterCounter = 0;



static void presenterCheck(int personCounter, Presenter presenter){
	//Checks to see if the max number of presenters made, has been exceed
	if (personCounter<=10)
		presenters[presenterCounter]=presenter;//Add the presenter passed in to the presenter array
	else
		System.out.println("Error no more presenters can be created at this time");
}

static void presentationCheck(int presentationCounter, Presentation presentation){
	//Checks to see if the max number of presentations made, has been exceed
	if (presentationCounter<=10)
		presentations[presentationCounter]= presentation;//Add the presentation passed in to the presentations array
	else
		System.out.println("Error no more presentations can be added to this workshop");
}

static void personCheck(int personCounter, Person person){
	//Checks to see if the max number of people made, has been exceed
	if (personCounter<=20)
		people[personCounter]=person;//Add the person passed in to the people array
	else
		System.out.println("Error workshop already full, no more attendees can be added ");

}

static int getRandom(int max){ 
	return (int) (Math.random()*max); //Return a rendom number between 0 and a max value passed in
}

static String timeFormat(){
String time = Integer.toString((getRandom(11))+9);//Generate a random time between 11am and 6pm
//Format the time
if (time.length()==1)
	time =  "0"+time+":00";
else
	time =  time+":00";
return time;
}

public static Presentation addPresentation(String title, Presenter presenter){
		//ADDING A NEW PRESENTATION//
		Presentation presentation = new Presentation();
		presentation.title = title;
		presentation.time = timeFormat();//Set and format the presentation time
		//Set the duration to a random amount of hours between 1-5 and then add of 10 minutes 
		presentation.duration = (getRandom(4))+(7f/6f);
		presentationCheck(presentationCounter, presentation);//Try to add new presentation to people array 
		presentationCounter++;
		return presentation; 
}

public static Person addPerson(int presenterCount){
	Person person = new Person();
	//TRY STATEMENT USED INCASE OF INVALID/COURRPT TEXT FILE
	try{
		Random random = new Random();//New radom boolean variable
		File temp = new File("randomNames.txt");//File variable temp set to randomNames.txt
		Scanner randomNames = new Scanner (temp);//randomNames variable set to the contents of the file variable, temp
		temp = new File("randomEmail.txt");	//File variable temp set to randomNames.txt
		Scanner randomEmail = new Scanner (temp);//randomNames variable set to the contents of the file variable, temp
		for (int i = 0; i<presenterCount; i++){
			person.name = randomNames.nextLine();//Name atribute of new person set to the next line in the randomNames text file
			person.email = randomEmail.nextLine();//Email atribute of new person set to the next line in the randomEmail text file
		}
		person.student = random.nextBoolean();//Student atribute set to a randomly generated boolean value
		personCheck(personCounter, person);//Try to add new person to people array 
		personCounter++;
		return person;
	}
	catch (Exception e){
            System.out.println("Error workshop already full, no more attendees can be added "); 
            return person;
    }
}

public static Presenter addPresenter(int presenterCount){
	Presenter presenter = new Presenter(); 
	try{
		File temp = new File("randomPresenterNames.txt");//File variable temp set to randomNames.txt
		Scanner randomPresenterNames = new Scanner (temp);//randomNames variable set to the contents of the file variable, temp
		temp = new File("randomAffiliation.txt");;//File variable temp set to randomAffiliation.txt
		Scanner randomAffiliation = new Scanner (temp);	//randomAffiliation variable set to the contents of the file variable, temp
		for (int i = 0; i<presenterCount; i++){
    		presenter.name= randomPresenterNames.nextLine();//Name atribute of new person set to the next line in the randomNames text file
    		presenter.affilation = randomAffiliation.nextLine();//Affiliation atribute of new person set to the next line in the randomNames text file
    	}
	   	presenter.presentationFee = ((getRandom(40))+10);//Presenter fee set to random number between 10 and 40
		presenterCheck(presenterCounter, presenter);//Try to add new person to people array 
		presenterCounter++;	
		return presenter; 
	}
	catch (Exception e){
            System.out.println("Error no more presenters can be created at this time"); 
            return presenter;
    }
}

public static void main (String[] args){
	////////////// PEOPLE  ///////////////
	Person person1 = addPerson(1);
	Person person2 = addPerson(2);
	Person person3 = addPerson(3);
	Person person4 = addPerson(4);
	Person person5 = addPerson(5);
	Person person6 = addPerson(6);
	Person person7 = addPerson(7);
	Person person8 = addPerson(8);
	Person person9 = addPerson(9);
	Person person10 = addPerson(10);
	Person person11 = addPerson(11);
	Person person12 = addPerson(12);
	Person person13 = addPerson(13);
	Person person14 = addPerson(14);
	Person person15 = addPerson(15);
	Person person16 = addPerson(16);
	Person person17 = addPerson(17);
	Person person18 = addPerson(18);
	Person person19 = addPerson(19);
	Person person20 = addPerson(20);
	Person person21 = addPerson(21);
	
		
	////////////// PRESENTORS ///////////////
	Presenter presenter1 = addPresenter(1);
	Presenter presenter2 = addPresenter(2);
	Presenter presenter3 = addPresenter(3);
	Presenter presenter4 = addPresenter(4);
	Presenter presenter5 = addPresenter(5);
	Presenter presenter6 = addPresenter(6);
	Presenter presenter7 = addPresenter(7);
	Presenter presenter8 = addPresenter(8);
	Presenter presenter9 = addPresenter(9);
	Presenter presenter10 = addPresenter(10);
	
	Presenter presenter11 = addPresenter(11);
	
	////////////// PRESENTATIONS ///////////////
	Presentation GC0= addPresentation("Steering (Initial membership)", presenter1);
	GC0.presentationPresentator(presenter1);
	Presentation GC1= addPresentation("In Vivo -- In Silico", presenter2);
	GC1.presentationPresentator(presenter2);
	Presentation GC2= addPresentation("Ubiquitous Computing: Experience, Design and Science", presenter3);
	GC2.presentationPresentator(presenter3);
	Presentation GC3= addPresentation("Memories for Life", presenter4);
	GC3.presentationPresentator(presenter4);
	Presentation GC4= addPresentation("Ubiquitous Computing: Experience, Design and Science", presenter5);
	GC4.presentationPresentator(presenter5);
	Presentation GC5= addPresentation("The Architecture of Brain & Mind", presenter6);
	GC5.presentationPresentator(presenter6);
	Presentation GC6= addPresentation("Dependable Systems Evolution", presenter7);
	GC6.presentationPresentator(presenter7);
	Presentation GC7= addPresentation("Journeys in Nonclassical Computation", presenter8);
	GC7.presentationPresentator(presenter8);
	Presentation GC8= addPresentation("Learning for Life", presenter9);
	GC8.presentationPresentator(presenter9);
	Presentation GC9= addPresentation("Bringing the Past to Life for the Citizen", presenter10);
	GC9.presentationPresentator(presenter10);
	Presentation GC10= addPresentation("One to many", presenter11);
	GC9.presentationPresentator(presenter11);
	
	////////////// WORKSHOP ///////////////
	Workshop workshop1 = new Workshop();
	//Set the properties of new object
	System.out.println("Please eneter a date for the workshop in the form dd/mm/yyyy : ");
	workshop1.date = workshop1.workshopDate();
	System.out.println("Please eneter the workshop venue : ");
	workshop1.venue = EasyIn.getString();
	System.out.println("Please eneter the workshop registration fee : ");
	workshop1.registrationFee = EasyIn.getInt();
	
	////////////// ADD PRESENTATIONS TO WORKSHOP ///////////////
	for (Presentation presentation: presentations){
		workshop1.presentationSighnUp(presentation);
	}	
	
	////////////// ADD PEOPLE TO WORKSHOP  ///////////////
	for (Person person: people){
		workshop1.attendeeSighnUp(person);	
	}
	
 	
	workshop1.printDetails();//Call the printDetails method from the object workshop1
	workshop1.attendeesRegistered();//Call the attendeesRegistered method from the object workshop1
	
	//Ask the user what they wish to do
	int option=0;
	System.out.println("");
	System.out.println("Please enter a choice:");
	System.out.println("1. Display attendees");
	System.out.println("2. Display presenters");
	System.out.println("3. Quit");
	do{
		option = EasyIn.getInt();
		if (option == 1){
		//Print the details of the all the people in the people array
			if (people != null ) {
				for (Person person: people){
					if (person!= null){
						person.printDetails();
					}
				}
			}
		}
		else if (option == 2){
		//Print the details of the all the presenters in the presenters array
			if (presenters != null ) {
				for (Presenter presenter: presenters){
					if (presenter!= null){
						presenter.printDetails();
					}
				}
			}
		}
		
		
	}while (option!=3);//If 3 entered program terminated 
	
}


}


