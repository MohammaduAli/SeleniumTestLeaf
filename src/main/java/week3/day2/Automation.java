package week3.day2;

public class Automation extends MultipleLanguage implements Language, TestTool {

	public static void main(String[] args) {

		Automation automation = new Automation();
		automation.selenium();
		automation.java();
		automation.python();
		automation.ruby();
		
	}

	public void selenium() {
		
		System.out.println("Selenium method implemented inside Automation class");
		
	}

	public void java() {
		
		System.out.println("Java language implemented inside Automation class");
		
	}

	@Override
	public void ruby() {
		
		System.out.println("Ruby language implemented inside Automation class");
		
	}

}
