package Utilities;

import java.util.List;

public class JavaMethods{

	public static boolean listCompareFast(List<Integer> listSource, List<Integer> listDestination){
		
		if (listSource.toString().equals(listDestination)) {
			System.out.println("Both the list values are matching");
			return true;
		} else {
			System.out.println("Both the list values are not matching");
			return false;
		}
		
	}
	
	public static boolean listCompare(List<Integer> listSource, List<Integer> listDestination){
		boolean comparePass = true;
		String mismatchDataLog = "";
		
		if (listSource.size() == listDestination.size()) {
			for (int i = 0; i < listSource.size(); i++) {
				if (listSource.get(i) != listDestination.get(i)) {
					mismatchDataLog = "\n\tSource data " + listSource.get(i) + " at position " + (i+1) + " is not matching with the Destination data " + listDestination.get(i);
					comparePass = false;
				}
			}
		} else {
			System.out.println("Both the list sizes are not matching. First list size is " + listSource.size() + " and Second list size is " + listDestination.size());
			comparePass = false;
		}
		
		if (comparePass) {
			System.out.println("Both the list values are matching");
		} else {
			System.out.println("Both the list values are not matching and find below mismatch data" + mismatchDataLog);
		}
		
		return comparePass;
	}
}
