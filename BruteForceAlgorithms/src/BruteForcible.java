import java.awt.Point;

/**
 * @author masont
 *
 */

public interface BruteForcible {

	public abstract int sequentialSearch(int[] A, int K);
	
	public abstract void selectionSort(int[] A);
	
	public abstract int bruteForceStringMatch(String T, String P);
		
	public abstract Point[] bruteForceClosestPoints(Point[] P);
}
