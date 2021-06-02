/**
 * 
 */

/**
 * This class creates vertices for a graph
 * @author MarefkeTyler
 * @version 2021.17.3
 */
public class Vertex implements Comparable<Vertex> {
	//Private variables to be used in the class
	private String name;
	private int color;
	private boolean visited;
	private int distance;
	
	//Public color variables to be accessed outside of the class
	public static final int WHITE = 1;
	public static final int GREEN = 2;
	public static final int BLACK = 3;
	
	/**
	 * Constructor for Vertex
	 * Creates a vertex object with the name given in the parameter
	 * and sets the color to 1, visited to false, and distance to 0
	 * Input: the name of the vertex
	 * Vertex(name)
	 * 		name <- name
	 * 		color <- 1
	 * 		visited <- false
	 * 		distance <- 0
	 * 
	 * @param name - The name of the vertex
	 */
	public Vertex(String name) {
		this.name = name;
		this.color = 1;
		this.visited = false;
		this.distance = 0;
	}

	/**
	 * Returns the current color of the vertex
	 * @return color - the current vertex color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Allows the ability to change the current color of the vertex
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Returns true if the vertex has been visited and false if it has not
	 * @return visited - whether a vertex has been visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Allows the ability to change whether the vertex has been visited or not
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * Returns the distance from the source node using Dijkstra's Algorithm
	 * @return distance - the distance from the source node
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Allows the ability to change the distance from the source node
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * Returns the name of the node
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the name of the vertex in string form
	 * @return the vertex's name
	 */
	public String toString() {
		return getName();
	}

	public int compareTo(Vertex other) {
		return getName().compareTo(other.getName());
	}
}
