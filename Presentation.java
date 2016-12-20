public class Presentation{

//Class atributes
String title, time;
int cost;
float duration;
Presenter presenter;


/*So that one presenter can present many arrays but an 
presentation can only be presented by one presenter, each 	
presentation has a presenter atribute which is set equal to 
one presenter handled in*/
public void presentationPresentator (Presenter newPresenter){
		this.presenter = newPresenter;
		//Calculate the cost of the presentation
		cost=presenter.presentationFee;	
		//the presentation is then added to the prentations array for the presenter passed in 
		newPresenter.presentationSighnUp(this);
}


public void printDetails(){		
	duration=duration*60f;//Convert the duration of presentation, from hours to minutes
	//Round the duration to 2.dp and then print the details of the workshop over 2 lines
	System.out.printf("Presentation title: "+title +"%n Time: "+time+ " - 	Duration (5 min overlap): %.2f minutes %n",	duration);
	System.out.println("");
}

}