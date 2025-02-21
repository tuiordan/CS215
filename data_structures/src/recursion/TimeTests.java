package recursion;
import java.time.*;
import ulist.*;
import slist.*;

public class TimeTests {

	public static void main(String[] args) throws Exception {
		
		
		Ar_UList myList1 = new Ar_UList();
		Ar_SList myList2 = new Ar_SList();
		
		LocalDateTime currentTime1 = LocalDateTime.now();

		for(int i = 1; i <= 250000; i++) 
			myList1.putItem(i);
		
		LocalDateTime postExeTime1 = LocalDateTime.now();
		
		LocalDateTime currentTime2 = LocalDateTime.now();
		for(int i = 1; i <= 250000; i++) 
			myList1.getItem(i);
		LocalDateTime postExeTime2 = LocalDateTime.now();
		
		LocalDateTime currentTime3 = LocalDateTime.now();

		for(int i = 1; i <= 250000; i++) 
			myList2.putItem(i);
		
		LocalDateTime postExeTime3 = LocalDateTime.now();
		
		LocalDateTime currentTime4 = LocalDateTime.now();
		
		for(int i = 1; i <= 10; i++)
			for(int j = 1; j <= 250000; j++) 
				myList2.getItem(j);
		
		LocalDateTime postExeTime4 = LocalDateTime.now();
		

		double elapsedTime1 = Duration.between(currentTime1,postExeTime1).toMillis();
		System.out.println(elapsedTime1 + " milliseconds have passed when adding to the Ar_UList");
		
		double elapsedTime2 = Duration.between(currentTime2,postExeTime2).toMillis();
		System.out.println(elapsedTime2 + " milliseconds have passed when getting elements of the Ar_UList");
		
		double elapsedTime3 = Duration.between(currentTime3,postExeTime3).toMillis();
		System.out.println(elapsedTime3 + " milliseconds have passed when adding to the Ar_SList");
		
		double elapsedTime4 = Duration.between(currentTime4,postExeTime4).toMillis();
		System.out.println(elapsedTime4 + " milliseconds have passed when adding to the Ar_SList");
		
	}

}
