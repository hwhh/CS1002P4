import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Workshop{

String date, venue;
int registrationFee;
static final int MAX_NUMBER_PEOPLE = 20;
static final int MAX_NUMBER_PRESENTATIONS = 20;
Person [] attendees = new Person [MAX_NUMBER_PEOPLE]; 
Presentation [] presentations  = new Presentation [MAX_NUMBER_PRESENTATIONS];
static Workshop workshops[]=new Workshop[W07Practical.numberOfPresentations/20];


static int noOfPresentations =0; 
int noOfPeople =0;
int registrationCollection =0; 


static void newWorkshop(int noOfPresentations) {
	try {
		for(int i=0; i<(W07Practical.numberOfPresentations)/20; ++i){
    	 	workshops[i]=new Workshop(); // Create Object
    		workshops[i].date=workshopDate();
    		workshops[i].venue="Jack Hall";
		}
	for(int i=0; i<(W07Practical.numberOfPresentations)/20; ++i){
			workshops[i].printDetails(i);
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

public void attendeeSighnUp(Person attendee){
	attendees[noOfPeople++] = attendee;	
}

public void attendeesRegistered(){
	int i =0;
	for (Person atetendee: attendees){
		if (atetendee!= null) i++;
	}
System.out.println(i + " attendees signed up");
}

public void printDetails(int count){	
	count++;	
	System.out.println(count+". ################ WORK SHOP "+count +" date : " +date+", venue: " +venue+" ################");
	if (attendees != null ) {
		for (Person atetendee: attendees){
			if (atetendee!= null){
				registrationCollection++;
				atetendee.printDetails(count);	
			}
		}
		registrationCollection=registrationCollection*registrationFee;
	System.out.println("Registration fees :" +registrationCollection);
	}
}

static String workshopDate(){
	String dateString ="" ;
	System.out.println("Please eneter the workshop date: ");
	do{
		dateString = EasyIn.getString();	
	}while (validDate(dateString)==false);
	return dateString;	
}

static boolean validDate (String dateString){
	try{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		Date newDate = dateFormat.parse(dateString);
	
		if(newDate.after(currentDate)){
            String returnDate = dateFormat.format(currentDate); 
			return true; 
            }
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


