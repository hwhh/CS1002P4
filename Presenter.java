public class Presenter{

//Class atributes
String name, affilation;
int presentationFee;

//THE MAX NUMBER OF PRESENTATIONS ALLOWED TO BE PRESENTED BY ANY ONE PRESENTER //
static final int MAX_NUMBER_PRESENTATIONS = 10;
int noOfPresentations =0; 

//An atribute which holds all the instances of the presentation class
Presentation [] presentations  = new Presentation [MAX_NUMBER_PRESENTATIONS];


public void presentationSighnUp(Presentation presentation){
	try{//Try to add a presentation to the presentations array
		presentations[noOfPresentations++] = presentation;	
	}catch ( ArrayIndexOutOfBoundsException e){
		System.out.println("Too many presentations for one presenter");
	}
}


public void printDetails(){
	System.out.println("Name : " +name+", Affiliation : " +affilation +" Presenter Fee: £"+presentationFee+".00");

}


}
