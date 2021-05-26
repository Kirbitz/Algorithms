import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarefkeTyler
 * @version 2021.2.15
 */
public class DivideAndConquerAlgorithms implements DivideAndConquer {

	/**
	 * ALGORITHM Recursive BinarySearch(A[0..n-1], value, low, high) 
	 * Searches for value in array A 
	 * Input: A sorted array A[0..n-1] of n elements. 
	 * Output: Index in array A of key or -1 if not found. 
	 * initially called with low = 0, high = N-1 
	 * BinarySearch(A[0..N-1], value, low, high) { 
	 * 		if (high < low) 
	 * 			return -1 
	 * 		mid = (low + high) / 2 
	 * 		if (A[mid] > value) 
	 * 			return BinarySearch(A, value, low, mid-1) 
	 * 		else if (A[mid] < value) 
	 * 			return BinarySearch(A, value, mid+1, high)
	 * 		else 
	 * 			return mid 
	 * }
	 * 
	 * @param data  - Array of searchable data
	 * @param value - item to find
	 * @param low   - low bound of the array
	 * @param high  - high bound of the array
	 */
	public int binarySearchRecursive(ArrayList<Integer> data, int value, int low, int high) {
		// if high < low then
		if (high < low)
			return -1;
		int mid = (low + high) / 2;
		// if A[mid] > value then
		if (data.get(mid) > value) {
			// return BinarySearch(A, value, low, mid-1)
			return binarySearchRecursive(data, value, low, mid - 1);
		} else if (data.get(mid) < value) {
			// return BinarySearch(A, value, mid+1, high)
			return binarySearchRecursive(data, value, mid + 1, high);
		} else
			return mid;
	}

	/**
	 * ALGORITHM Iterative BinarySearch(A[0..n-1], value) 
	 * Searches for value in array A 
	 * Input: A sorted array A[0..n-1] of n elements. 
	 * Output: Index in array A of key or -1 if not found. 
	 * BinarySearch(A[0..N-1], value) { 
	 * 		low = 0 
	 * 		high = N - 1 
	 * 		while (low <= high) { 
	 * 			mid = (low + high) / 2 
	 * 			if (A[mid] > value) 
	 * 				high = mid - 1 
	 * 			else if (A[mid] < value) 
	 * 				low = mid + 1 
	 * 			else 
	 * 				return mid 
	 * 			} 
	 * 		return -1 
	 * }
	 * 
	 * @param data  - Array of searchable data
	 * @param value - item to find
	 */
	public int binarySearchIterative(ArrayList<Integer> data, int value) {
		// low = 0; high = N-1
		int low = 0;
		int high = data.size() - 1;
		// while low <= high do
		while (low <= high) {
			int mid = (low + high) / 2;
			// if A[mid] > value then
			if (data.get(mid) > value) {
				// high = mid - 1
				high = mid - 1;
			}
			// else if A[mid] < value then
			else if (data.get(mid) < value) {
				// low = mid + 1
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * ALGORITHM InsertionSort(A[0..n-1]) 
	 * Sorts a given array by insertion sort
	 * Input: An array A[0..n-1] of n orderable elements 
	 * Output: Array A[0..n-1] sorted in nondecreasing order 
	 * InsertionSort(A[0..n-1]){ 
	 * 		for i = 1 to n-1 do 
	 * 			v = A[i] 
	 * 			j = i - 1 
	 * 			while j >= 0 and A[j] > v do 
	 * 				A[j+1] = A[j] 
	 * 				j = j - 1 
	 * 			A[j+1] = v
	 * 
	 * @param A - Array to be sorted
	 */
	public void insertionSort(ArrayList<Integer> A) {
		// for i = 1 to n-1 do
		for (int i = 1; i < A.size(); i++) {
			// v = A[i]; j = i-1
			int value = A.get(i);
			int j = i - 1;
			// while j >= 0 and A[j] > v do
			while (j >= 0 && A.get(j) > value) {
				// A[j+1] = A[j]; j = j-1
				A.set(j + 1, A.get(j));
				j -= 1;
			}
			// A[j+1] = v
			A.set(j + 1, value);
		}
	}

	/**
	 * ALGORITHM QuickSort(A[0..n-1], low, high) 
	 * Input: An array A[0..n-1] of n orderable elements, 
	 * 		low the value of the starting index, 
	 * 		high the value of the ending index 
	 * QuickSort(A[0..n-1], low, high){ 
	 * 		if (low < high){ 
	 * 			pi = partition(arr, low, high)
	 * 
	 * 			quickSort(arr, low, pi-1) 
	 * 			quickSort(arr, pi + 1, high) } }
	 */
	public void quickSort(ArrayList<Integer> A, int low, int high) {
		// if low < high then
		if (low < high) {
			// pi = partition(arr, low, high)
			int pi = partition(A, low, high);

			quickSort(A, low, pi - 1);
			quickSort(A, pi + 1, high);
		}
	}

	/**
	 * ALGORITHM Partition(A[0..n-1], left, right) 
	 * Input: A subarray A[l..r] of A[0..n-1], defined by its left and right indices l and r (l < r) 
	 * Output: A partition of A[l..r], with the split position returned as this function's value 
	 * Partition(A[0..n-1], left, right){ 
	 * 		p = A[left] 
	 * 		i = left 
	 * 		j = right + 1
	 * 		do{ 
	 * 			while A[i] < p and i < right do
	 * 				i = i + 1 
	 * 			while A[j] > p and j > left 
	 * 				j = j + 1
	 * 			swap(A[i], A[j]) 
	 * 		until i >= j 
	 * 		swap(A[i], A[j]) 
	 * 		swap(A[left], A[j])
	 * return j; }
	 */
	public int partition(ArrayList<Integer> A, int left, int right) {
		// p = A[left]; i = left + 1; j = right - 1
		int p = A.get(left);
		int i = left;
		int j = right + 1;
		// do until i >= j
		do {
			// while A[i] < p and i < right
			do {
				i++;
			}while (i < right && A.get(i) < p);
			// while A[j] > p and j > left
			do {
				j--;
			}while (A.get(j) > p && j > left);
			// swap(A[i], A[j])
			int temp = A.get(i);
			A.set(i, A.get(j));
			A.set(j, temp);
			
		} while (i < j);
		
		int value = A.get(i);
		A.set(i, A.get(j));
		A.set(j, value);
		
		value = A.get(left);
		A.set(left, A.get(j));
		A.set(j, value);

		return j;
	}

	/**
	 * ALGORITHM PrintArrayList(A[0..n-1]) 
	 * Input: An array A[0..n-1] to be printed
	 * 
	 * PrintArrayList(A[0..n-1]){ for i = 0 to n-1 do print A[i] }
	 */
	public void printArrayList(ArrayList<Integer> data) {
		// for i = 0 to n-1 do
		for (int i = 0; i < data.size(); i++) {
			// print A[i]
			if (i % 10 == 0)
				System.out.println();
			System.out.print(data.get(i) + " ");
		}
	}
}
