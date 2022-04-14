package week3.day1;

public class SmartPhone extends AndroidPhone {

	public void connectWhatsapp() {
		System.out.println("Smart Phone is connecting to Whatsapp");
	}
	
	public void takeVideo() {

		System.out.println("Smart phone is taking a Video");
		
	}
	
	public static void main(String[] args) {
		
		SmartPhone smartPhone = new SmartPhone();
		
		smartPhone.sendMessage();
		smartPhone.makeCall();
		smartPhone.saveContact();
		smartPhone.takeVideo();
		smartPhone.connectWhatsapp();
	}

}
