import java.util.ArrayList;

public interface Graphable {

	/**
	 * getEdgeWeight will return weight on the edge starting at Vertex from and ending at Vertex to. It will return 0 if there
	 * is no edge.
	 * @param from - Vertex at start of the edge.
	 * @param to - Vertex at the end of the edge.
	 * @return - integer value of the cost or weight of this edge
	 */
	int getEdgeWeight(Vertex from, Vertex to);

	/**
	 * Add the distance to the matrix for the specified directed edge (from, to).
	 * @param from - Vertex at start of the edge.
	 * @param to - Vertex at the end of the edge.
	 * @param distance - the cost or weight  of this edge
	 * @return - true if edge added or false if an edge already exists.
	 */
	boolean addDirectedEdge(Vertex from, Vertex to, int distance);

	/**
	 * Add the distance to the matrix for the specified undirected edge. Add it for (from, to) and (to, from) both directions. 
	 * @param from - Vertex at start of the edge.
	 * @param to - Vertex at the end of the edge.
	 * @param distance
	 * @return - true if edge added or false if an edge already exists.
	 */
	boolean addUndirectedEdge(Vertex from, Vertex to, int distance);

	/**
	 * Remove the specified DirectedEdge. Set the distances to 0.
	 * @param from - Vertex at start of the edge.
	 * @param to - Vertex at the end of the edge.
	 * @return - true if edge deleted or false if no edge exists.
	 */
	boolean deleteDirectedEdge(Vertex from, Vertex to);

	/**
	 * Remove the specified UndirectedEdge (both directions in the matrix). Set the distances to 0.
	 * @param from - Vertex at start of the edge.
	 * @param to - Vertex at the end of the edge.
	 * @return - true if edge deleted or false if no edge exists.
	 */
	boolean deleteUndirectedEdge(Vertex from, Vertex to);

	/**
	 * Identify the list of vertices that have an edge from vertex (adjacent to vertex).
	 * @param vertex
	 * @return ArrayList of Vertex objects for all vertices adjacent to the parameter vertex. 
	 */
	ArrayList<Vertex> getAdjacentVertices(Vertex vertex);


}