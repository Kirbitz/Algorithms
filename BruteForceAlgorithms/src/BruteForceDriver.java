
import java.awt.Point;
import java.util.Random;

/**
 * @author Marefke (marefket2658)
 *
 */
public class BruteForceDriver {

	public static void main(String[] args) {
		int n = 1000;
		Random random = new Random();
		int[] list = new int[n];
		for(int i = 0; i < n ; i++ ) {
			list[i]= random.nextInt(n*10);
		}
		
		BruteForceAlgorithms brute = new BruteForceAlgorithms();
		//print random array
		brute.printArray(list);
		//sort list
		brute.selectionSort(list);
		//Use brute to print out sorted array
		brute.printArray(list);

		//TODO Test SequentialSearch
		int[] data = {44,33,55,77,1,22,99,75};
		int tester = brute.sequentialSearch(data, 20);
		if(tester != -1)
			System.out.println("Yes found in data");
		else
			System.out.println("Failed to find in data!");
		//TODO Test BruteForceStringMatch
		String sampleString = "Algorithms is a cool class at Stout";
		String testerString = "Stout";
		tester = brute.bruteForceStringMatch(sampleString, testerString);
		if(tester != -1)
			System.out.println("Yes found in string");
		else
			System.out.println("Failed to find in string!");
		
		//TODO Test BruteForceClosestPoints
		Point[] points = new Point[3];
		points[0] = new Point(1,1);
		points[1] = new Point(5,5);
		points[2] = new Point(2,2);
		
		Point[] twoClosest = brute.bruteForceClosestPoints(points);
		System.out.println("The closest two points are: ");
		for(int i = 0; i< twoClosest.length; i++)
			System.out.println(twoClosest[i]);
		
	}
}
