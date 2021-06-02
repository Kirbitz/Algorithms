/**
 * @author masont
 *
 */
public class EdgeWeightToVertex {
	
	Vertex toVertex;
	int weight;
		
	/**
	 * @param vertexFrom
	 * @param vertexTo
	 * @param weight
	 */
	public EdgeWeightToVertex(Vertex vertexTo, int weight) {
		this.toVertex = vertexTo;
		this.weight = weight;
	}
	/**
	 * @return the vertexTo
	 */
	public Vertex getToVertex() {
		return toVertex;
	}
	/**
	 * @return the distance
	 */
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return toVertex + ", "+weight;
	}
	
	

}
