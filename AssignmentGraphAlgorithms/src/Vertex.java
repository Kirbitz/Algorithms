

/**
 * @author masont
 *
 */
public class Vertex {
	
	/**
	 * The constant Vertex.WHITE is the color assigned to a Vertex during searching
	 */
	public static final int WHITE = 1;
	
	/**
	 * The constant Vertex.GREEN is the color assigned to a Vertex during searching
	 */
	public static final int GREEN = 2;
	
	/**
	 * The constant Vertex.BLACK is the color assigned to a Vertex during searching
	 */
	public static final int BLACK = 3;
	
	private String name;
	private int color, distance;
	private boolean visited;
	/**
	 * @param name of this instance of the Vertex
	 */
	public Vertex(String name) {
		super();
		this.name = name;
		setDistance(0);
		color = 0;
	}
	/**
	 * @return the color assigned to the Vertex (0 is unassigned)
	 */
	public int getColor() {
		return color;
	}
	/**
	 * @param color the color to assign to the Vertex
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * @return the name of the Vertex
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String s = name;
		/*//Print color if defined
		if(color==1)
			s+=", WHITE";
		else if(color==2)
			s+=", GREEN";
		else if(color ==3)
			s+=", BLACK";
		*/
		return s;
	}

	/**
	 * @return  visited as true if it has been visited and false otherwise
	 */
	public boolean getVisited() {
		return visited;
	}
	/**
	 * @param visited assign true if Vertex has been visited, otherwise false.
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	/**
	 * @return the distance to this vertex
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param set the distance of this vertex
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
