package org.system;

public class Desktop extends Computer{

	public void desktopSize() {
		System.out.println("I am Desktop Size method");
	}
	
	public static void main(String[] args) {

		Desktop desktop = new Desktop();
		desktop.computerModel();
		desktop.desktopSize();
		
	}

}
