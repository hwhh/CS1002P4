import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Workshop{

//Class atributes
String date, venue, workshopState;
int registrationFee, totalFees;


//THE MAX NUMBER OF OBJECTS ALLOWED TO BE CREATED FROM VARIOUS CLASSES//
static final int MAX_NUMBER_PEOPLE = 20;
static final int MAX_NUMBER_PRESENTATIONS = 10;

/*To ensure there is no more than the max number of people
added to array every time a new object is added to the corresponding
array these values are incremented*/
int noOfPresentation =0; 
int noOfPeople =0;


float total=0;
float registrationCollection =0f; 
float registrationCollectionStudent =0f; 


//An atribute which holds all the instances of the person class
Person [] attendees = new Person [MAX_NUMBER_PEOPLE]; 
//An atribute which holds all the instances of the presentation class
Presentation [] presentations= new Presentation [MAX_NUMBER_PRESENTATIONS];



public String feesCheck(int totalFees, float total){
	//Determine the state of the workshop
	String workshopState ="";
	if (totalFees > registrationCollection) 
		workshopState=("DEFICIT");
	else if (totalFees < registrationCollection) 
		workshopState=("SURPLUS ");
	else if (totalFees ==registrationCollection)
		workshopState=("BROKEN EVEN");
	return workshopState;
}

public void presentationSighnUp(Presentation presentation){
	presentations[noOfPresentation++] = presentation;//Add presentation to presentation array
	totalFees+=presentation.cost;

}

public void attendeeSighnUp(Person attendee){
	attendees[noOfPeople++] = attendee;	
}

public void attendeesRegistered(){
	// Determine the number of people attending the workshop
	int i =0;
	for (Person atetendee: attendees){//Cycle through each element of the attendees array checking for attendees 
		if (atetendee!= null) i++;
	}
	System.out.println("");
	if (i==20) System.out.println("THERE ARE CURRENTLY: "+i + " ATTENDEES SIGNED UP -- WORKSHOP FULL");
	else System.out.println("THERE ARE CURRENTLY: "+i + " ATTENDEES SIGNED UP");
}

public void printDetails(){	
	System.out.println("");
	System.out.println("########## WORKSHOP DETAILS ##########");
	System.out.println("");
	System.out.println("Date : " +date+", Venue: " +venue +", Total cost of workshop : £"+totalFees);
	
	//Check to see if an attenddee is a student or not
	if (attendees != null ) {
		for (Person atetendee: attendees){
			if (atetendee!= null){
				if (atetendee.student==true)
					registrationCollectionStudent++;
				else
					registrationCollection++;
			}
		}
	registrationCollectionStudent=registrationCollectionStudent*(registrationFee*0.7f); //If an attendee is a student they receive 30% discount
	registrationCollection=registrationCollection*registrationFee;
	total=registrationCollection+registrationCollectionStudent;
	
	workshopState=feesCheck(totalFees, total);
	System.out.println("");
	System.out.println("Registration fees collected : £" +total+ "		THEREFORE STATUS : " +workshopState);
	System.out.println("");
	}
	//Print out all the presentations in the workshop	
	if (presentations != null ) {
		for (Presentation presentation: presentations){
			if (presentation!= null){
				presentation.printDetails();	
			}
		}	
	}
}

public String workshopDate(){
	String dateString ="" ;
	//Continous loop until the user eneters a valid date
	do{
		dateString = EasyIn.getString();	
	}while (validDate(dateString)==false);
	return dateString;	
}

public boolean validDate (String dateString){
	//try statement so that if a user eneters an invalid string the program doesn't crash
	try{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//Set the variable dateFormat to the defined format 
		Date currentDate = new Date();//Set the variable currentDate to the current date
		Date newDate = dateFormat.parse(dateString);//Convert the dateString string variable passed in, into an actual date
		//If the date is valid and in the futre everything valid
		if(newDate.after(currentDate)){
            String returnDate = dateFormat.format(currentDate); 
			return true; 
            }
        //If the date in the past or the same the same as the current date, it is not valid
        else if(newDate.before(currentDate) || newDate.equals(currentDate)){
           	System.out.println("Date can not be in the past, please re-eneter a date");
            return false; 
            }
        else
        	return false; 
       
	}catch (ParseException e){
     	System.out.println("Invalid input!");
      return false;
	}
}


}


