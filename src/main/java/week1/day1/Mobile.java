package week1.day1;

public class Mobile {

	String mobileModel = "Oneplus 6";
	float mobileWeight = 164.5F;
	boolean isFullyCharged = true;
	int mobileCost = 35000;
		
	public void makeACall(){
		System.out.println("Mobile is making a call");
	}
	
	public void sendMessage() {
		System.out.println("Mobile is sending a message");
	}
	
	public void playVideo() {
		System.out.println("Mobile is playing a video");
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main method");
		
		Mobile myMobile = new Mobile();
		myMobile.makeACall();
		myMobile.sendMessage();
		myMobile.playVideo();
		System.out.println("\nMobile Specifications ->");
		System.out.println("Mobile Model: " + myMobile.mobileModel);
		System.out.println("Mobile Weight: " + myMobile.mobileWeight);
		System.out.println("Mobile is fully charged: " + myMobile.isFullyCharged);
		System.out.println("Mobile Cost: " + myMobile.mobileCost);
		
	}
}
