import java.util.Scanner;
import java.io.*;
import java.util.Random;


public class Presentation{

String title, time;
int duration;
Presenter presenter;
Workshop workshop;

static Presentation presentations[]=new Presentation[W07Practical.numberOfPresentations];

public void presentationPresentator (Presenter newPresenter){
	this.presenter = newPresenter;
	newPresenter.presentationSighnUp(this);
}

public void presentationWorkshop (Workshop newWorkshop){
	this.workshop = newWorkshop;
	newWorkshop.presentationSighnUp(this);
}


static String timeFormat(){
String time = Integer.toString((W07Practical.getRandom(11))+9);
if (time.length()==1)
	time =  "0"+time+":00";
else
	time =  time+":00";
return time;
}


static void newPresentation(int numberOfPresentations) {
int numberOfWorkshops = 0;
	try {
		File temp = new File("randomPresentation.txt");
		Scanner randomPresentation = new Scanner (temp);
		for(int i=0; i<numberOfPresentations; ++i){
    	 	presentations[i] = new Presentation(); // Create Object
    		presentations[i].title= randomPresentation.nextLine();
    		presentations[i].time =timeFormat();
    		presentations[i].duration = (W07Practical.getRandom(4))+1;	
    		presentations[i].presentationPresentator(Presenter.presenters[i]);// need the same number of presentations as presenters for this to work... TITS 
		}
		for(int i=0; i<numberOfPresentations; i++){	
			presentations[i].presentationWorkshop(Workshop.workshops[numberOfWorkshops]);  
			if (i%20==0 && i>0)
				numberOfWorkshops++;	
		}
	}
	catch (Exception e){
        System.out.println("Error");       
    }   
}





public void printDetails(){
		System.out.println("Presentation title: " +title+", time: " +time);
}

}