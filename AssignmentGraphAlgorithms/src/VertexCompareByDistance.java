import java.util.Comparator;

/**
 * @author masont
 *
 */
public class VertexCompareByDistance implements Comparator<Vertex> {

	@Override
	public int compare(Vertex vertex1, Vertex vertex2) {
		if(vertex1.getDistance() > vertex2.getDistance())
			return 1;
		else if (vertex1.getDistance() < vertex2.getDistance())
			return -1;
		else
			return 0;
	}
}
