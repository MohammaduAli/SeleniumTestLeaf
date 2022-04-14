package week3.day2;

public class Desktop implements Hardware, Software {

	public void softwareResources() {
		
		System.out.println("Software Resources implemented in Desktop");
		
	}

	public void harwareResources() {
		
		System.out.println("Hardware Resources implemented in Desktop");
		
	}
	
	public void desktopModels() {
		
		System.out.println("Desktop Models: ");
		
	}
	
	public static void main(String[] args) {
		
		Desktop desktop = new Desktop();
		desktop.desktopModels();
		desktop.harwareResources();
		desktop.softwareResources();
		
	}

}
