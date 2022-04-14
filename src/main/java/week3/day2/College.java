package week3.day2;

public class College extends University{

	public static void main(String[] args) {
		
		University college = new College();
		college.underGraduate();
		college.postGraduate();

	}

	@Override
	void underGraduate() {

		System.out.println("Under graduate programs available in this college");
		
	}

}
