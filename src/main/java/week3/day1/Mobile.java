package week3.day1;


//Create 3 classes
//- Mobile (methods: sendMsg, makeCall, saveContact), AndroidPhone (takeVideo), SmartPhone (connectWhatsApp)
//- AndroidPhone extends Mobile and SmartPhone extends AndroidPhone
//- Create an object for SmartPhone class and execute all methods

public class Mobile {

	public void sendMessage() {
		
		System.out.println("Mobile sends a message");
		
	}
	
	public void makeCall() {
		
		System.out.println("Mobile makes a call");

	}
	
	protected void saveContact() {
		
		System.out.println("Mobile saves a contact");

	}

	protected void openAssistant() {
		System.out.println("Opening Assistant");
	}
	
	public static void main(String[] args) {

		
	}


}
