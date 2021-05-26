
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author masont
 *
 */
public class DivideAndConquerDriverUpdated {

	public static void main(String[] args) {
		int points = 0;
		int n = 100;
		Random random = new Random();
//Testing binarySearches		
		int pointsSearch = 0;
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		
		//fill lists with same data
		for(int i = 0; i < n ; i++ ) {
			int value = random.nextInt(n*10);
			list1.add( value  );
			list2.add( value);
			list3.add(value);
			list4.add(value);
			
		}
		
		//Using Collection in Java to sort list1.
		Collections.sort(list1);
		
		DivideAndConquer conquer = new DivideAndConquerAlgorithms();
	
//Test first element		
		int foundIndexRecursive = conquer.binarySearchRecursive(list1, list1.get(0), 0, list1.size()-1);
		int foundIndexIterative = conquer.binarySearchIterative(list1, list1.get(0));
		//System.out.println("foundIndex is "+foundIndex);
		if(foundIndexRecursive == foundIndexIterative && list1.get(foundIndexRecursive) == list1.get(0))
			pointsSearch+=5;
		else
			System.out.println("Failed to find first element in one of the binary search algorithms. -5");
		
//Test last element		
		foundIndexRecursive = conquer.binarySearchRecursive(list1, list1.get(n-1), 0, list1.size()-1);
		foundIndexIterative = conquer.binarySearchIterative(list1, list1.get(n-1));
		if(foundIndexRecursive == foundIndexIterative && list1.get(foundIndexRecursive) == list1.get(n-1) )
			pointsSearch+=5;
		else {
			System.out.println("Failed to find last element in one of the binary search algorithms. -5");
			System.out.println(foundIndexIterative + " " + foundIndexRecursive + "\n" + list1.get(n-1) + " " + list1.get(foundIndexRecursive));
		}
		
//Test 10th (middle) element		
		foundIndexRecursive = conquer.binarySearchRecursive(list1, list1.get(10), 0, list1.size()-1);
		foundIndexIterative = conquer.binarySearchIterative(list1, list1.get(10));
		if(foundIndexRecursive == foundIndexIterative && list1.get(foundIndexRecursive) == list1.get(10))
			pointsSearch+=5;
		else
			System.out.println("Failed to find 10th element in one of the binary search algorithms. -5");
		
//Test element not found		
		foundIndexRecursive = conquer.binarySearchRecursive(list1, 9999999, 0, list1.size()-1);
		foundIndexIterative = conquer.binarySearchIterative(list1, 9999999);	
		if(foundIndexRecursive == foundIndexIterative && foundIndexRecursive == -1)
			pointsSearch+=5;
		else
			System.out.println("One of the Binary Search methods failed to return -1 for element not in the list. -5");
		
		System.out.println("Points for searching is "+pointsSearch+ " out of possible 20 points in searching");
		points+=pointsSearch;
		
//InsertionSort 10 points
		
		conquer.insertionSort(list2);
		
		//compare sort of list2 to list1 sorted.
		boolean match = true;
		for(int i =0; i< list1.size(); i++) {
			if(((int) list1.get(i)) != ((int)list2.get(i)) ) {
				match = false;
				System.out.println("Element list1 "+list1.get(i)+ " at index "+ i + " does not match list 2 "+list2.get(i) +" after insertion sort");
			}
	    }
		if(match) {
			System.out.println("Insertion sort works for 10 points");
			points += 10;
			System.out.println("Total points are now "+points	);	
		}
		else
			System.out.println("Failed insertion sort algorithm. See above. -10");
		
//Partition 10 points
		
		int pivotLocation = conquer.partition(list4, 0, list4.size()-1);
		int pivot = list4.get(pivotLocation);
		System.out.println("The pivot is "+pivot);
		boolean working = true;
		for(int i =0; i< pivotLocation; i++) {
			if(list4.get(i) > pivot) {
				working = false;
				System.out.println("The value "+list4.get(i)+" at index "+i+" left of the pivot is greater than the pivot. Partition failed.");
			}
		}
		if (working) //less than partition is correct, now test greater than
		{
			System.out.println(" less than partition is correct, now test greater than to right of pivot ");
			for(int i =pivotLocation +1; i< list4.size(); i++) {
				if(list4.get(i) < pivot) {
					working = false;
					System.out.println("The value "+list4.get(i)+" at index "+i+" right of the pivot is less than the pivot. Partition failed.");
				}
			}
		}
		
		if(working) {
			System.out.println("Partition works for 10 points");
			points += 10;
			System.out.println("Total points are now "+points	);	
		
	//QuickSort 10 points
	
			conquer.quickSort(list3, 0, list3.size()-1);
			
			match = true;
			for(int i =0; i< list1.size(); i++) {
				if(((int) list1.get(i)) != ((int)list3.get(i)) ) {
					match = false;
					System.out.println("Element list1 "+list1.get(i)+ " at index "+ i + " does not match list 3 "+list3.get(i) +" after Quicksort");
				}
		    }
			if(match) {
				System.out.println("Quick sort works for 10 points");
				points += 10;
				System.out.println("Total points are now "+points	);
				
			}
		}
		else
		{
			System.out.println("Partition failed -10, so Quicksort will not work. Fix partition to try to get points for Quicksort -10");
		}
		System.out.println("************************************************\n  Final points are now "+points	);
	}
}
