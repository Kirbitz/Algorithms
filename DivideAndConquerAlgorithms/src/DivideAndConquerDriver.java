/**
 * 
 */
import java.util.ArrayList;
import java.util.Random;
/**
 * @author MarefkeTyler
 *
 */
public class DivideAndConquerDriver {

	public static void main(String[] args) {
		ArrayList<Integer> testerList = new ArrayList<Integer>();
		Random random = new Random();
		testerList.add(-1);
		for (int i = 0; i < 100; i++) {
			testerList.add(1*i/*100 - i*//*random.nextInt(1000)*/);
		}
		testerList.add(10000);
		
		DivideAndConquerAlgorithms conquer = new DivideAndConquerAlgorithms();
		conquer.printArrayList(testerList);
		
		//Tests the insertion sort method
		//conquer.insertionSort(testerList);
		
		//Tests the quickSort method
		conquer.quickSort(testerList, 0, testerList.size() - 1);
		conquer.printArrayList(testerList);
		
		//Tests the BinarySearch recursive method
		int testValue = conquer.binarySearchRecursive(testerList, 50, 0, testerList.size());
		System.out.println();
		if(testValue != -1) {
			System.out.println("Value was found in the arraylist!");
		}
		else {
			System.out.println("No value found in the arraylist");
		}
		
		//Tests the BinarySearch iterative method
		int testValueIter = conquer.binarySearchIterative(testerList, 49);
		if(testValueIter != -1) {
			System.out.println("Value was found in the arraylist!");
		}
		else {
			System.out.println("No value found in the arraylist");
		}
	}

}
