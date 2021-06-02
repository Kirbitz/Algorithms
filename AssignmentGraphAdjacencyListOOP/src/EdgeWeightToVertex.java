/**
 * 
 */

/**
 * Class that keeps track of EdgeWeights to a vertex
 * @author MarefkeTyler
 * @version 2021.17.3
 */
public class EdgeWeightToVertex {
	private Vertex toVertex;
	private int weight;
	
	/**
	 * Construct for EdgeWeightToVertex class that initializes toVertex and weight with inputs
	 * @param toVertex - the vertex to go to
	 * @param weight - the weight of the edge
	 */
	public EdgeWeightToVertex(Vertex toVertex, int weight) {
		this.toVertex = toVertex;
		this.weight = weight;
	}
	
	/**
	 * Retrieves the vertex from the class
	 * @return the toVertex
	 */
	public Vertex getToVertex() {
		return toVertex;
	}
	
	/**
	 * Retrieves the weight from the class
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Returns the string form of EdgeWeightToVertex
	 * @return string of toVertex, weight
	 */
	public String toString() {
		return toVertex + ", " + weight;
	}
}
