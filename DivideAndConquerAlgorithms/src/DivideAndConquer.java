import java.util.ArrayList;

/**
 * 
 */

/**
 * @author masont
 *
 */

public interface DivideAndConquer {
	public abstract int binarySearchRecursive(ArrayList<Integer> data, int value, int low, int high	);
	public abstract int binarySearchIterative(ArrayList<Integer> data, int value	);
	public abstract void insertionSort(ArrayList<Integer> A);
	public abstract void quickSort(ArrayList<Integer> A, int low, int high);
	public abstract int partition(ArrayList<Integer> A, int left, int right );
	public abstract void printArrayList(ArrayList<Integer> data);

}
