import java.util.ArrayList;

/**
 * 
 */

/**
 * This class creates a graph with vertices and weighted edges using the matrix implementation
 * @author MarefkeTyler
 * @version 2021.10.3
 */
public class GraphMatrix implements Graphable {

	private Vertex[] vertices;
	private int[][] edgeWeights;
	
	/**
	 * Constructor for GraphMatrix with input of vertices array
	 * Input: Array A[0..n-1] that contains vertices
	 * GraphMatrix(A[0..n-1])
	 * 		vertices <- A[0..n-1]
	 * 		edgeWeights <- new Array B[0..n-1][0..n-1]
	 * 		for i <- 0 to i < n do
	 * 			for j <- 0 to j < m do
	 * 				edgeWeights[i][j] <- 0
	 * @param vertices - the array to taken in
	 */
	public GraphMatrix(Vertex[] vertices) {
		this.vertices = vertices;
		this.edgeWeights = new int[vertices.length][vertices.length];
		for (int i = 0; i < edgeWeights.length; i++) {
			for (int j = 0; j < edgeWeights[i].length; j++) {
				edgeWeights[i][j] = 0;
			}
		}
	}
	
	/**
	 * Constructor for GraphMatrix with input of vertices array
	 * Input: Array A[0..n-1] that contains vertices and array B[0..n-1][0..n-1]
	 * 			that contains edges between the vertices
	 * GraphMatrix(A[0..n-1], B[0..n-1][0..n-1])
	 * 		vertices <- A[0..n-1]
	 * 		edgeWeights <- B[0..n-1][0..n-1]
	 * @param vertices - the array to taken in
	 * @param edgeWeights - the second array to be taken in
	 */
	public GraphMatrix(Vertex[] vertices, int[][] edgeWeights) {
		this.vertices = vertices;
		this.edgeWeights = edgeWeights;
	}
	
	/**
	 * Algorithm returns the vertex within the array at the vertexIndex
	 * Input: The index to be checked for a vertex
	 * Output: The vertex at the specified location in array A[0..n-1] or null 
	 * 			if non was found
	 * getVertex(vertexIndex)
	 * 		if vertexIndex < 0 or vertexIndex > n-1
	 * 			return null
	 * 		else
	 * 			return Vertex in the array
	 * 
	 * @return the vertex at vertexIndex
	 */
	public Vertex getVertex(int vertexIndex) {
		//if vertexIndex < 0 or vertexIndex > n-1; return null
		if(vertexIndex < 0 || vertexIndex > vertices.length - 1)
			return null;
		//else return Vertex in the array
		return vertices[vertexIndex];
	}
	
	/**
	 * Algorithm uses concepts in SequentialSearch(Vertex k)
	 * Input: Key of the vertex to find in the array A[0..n-1]
	 * Output: The vertex's location within the array or -1 if the vertex is not
	 * 			found within the array
	 * indexOfVertex(vertex)
	 * 		n <- length of A
	 * 		i <- 0
	 * 		while i < n and vertex != A[i]
	 * 			i <- i + 1
	 * 		if i < n
	 * 			return i
	 * 		else
	 * 			return -1
	 * 
	 * @param vertex - the vertex to be found in the array
	 * @return the index of the vertex
	 */
	public int indexOfVertex(Vertex vertex) {
		int n = vertices.length;
		int i = 0;
		//while i < n and vertex != A[i]
		while(i < n && vertex != vertices[i])
			i++;
		//if vertex = A[i]; return i
		if(i < n)
			return i;
		//else return -1
		return -1;
	}
	
	/**
	 * Algorithm getEdgeWeight(F, T)
	 * Finds the weight of an edge between two vertices
	 * Input: Two vertices, one to come from and one to go to
	 * Output: The weight of the edge between the vertices or -1 if one or both of
	 * 			the vertices do not exist in the array vertices
	 * getEdgeWeight(F, T)
	 * 		index1 <- indexOfVertex(F)
	 * 		index2 <- indexOfVertex(T)
	 * 		if index1 = -1 or index2 = -1
	 * 			return -1
	 * 		else
	 * 			return edgeWeights[index1][index2]
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @return the weight of an edge
	 */
	@Override
	public int getEdgeWeight(Vertex from, Vertex to) {
		int indexFrom = indexOfVertex(from);
		int indexTo = indexOfVertex(to);
		
		//if index1 = -1 or index2 = -1; return -1
		if(indexFrom == -1 || indexTo == -1)
			return -1;
		
		//else return edgeWeights[index1][index2]
		return edgeWeights[indexFrom][indexTo];
	}

	/**
	 * Algorithm addDirectedEdge(F, T, dist)
	 * Adds a directed edge between two vertices
	 * Input: Two vertices one to come from and one to go to and a distance
	 * Output: A boolean of whether the edge could be added or not
	 * addDirectedEdge(F, T, dist)
	 * 		index1 <- indexOfVertex(F)
	 * 		index2 <- indexOfVertex(T)
	 * 		if index1 = -1 or index2 = -1
	 * 			return false
	 * 		if edgeWeights[index1][index2] > 0
	 * 			return false
	 * 		else
	 * 			edgeWeights[index1][index2] <- dist
	 * 			return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @param distance - the weight of the edge between from and to
	 * @return whether the directed edge was added or not
	 */
	@Override
	public boolean addDirectedEdge(Vertex from, Vertex to, int distance) {
		int indexFrom = indexOfVertex(from);
		int indexTo = indexOfVertex(to);
		
		//if index1 = -1 or index2 = -1; return false
		if(indexFrom == -1 || indexTo == -1)
			return false;
		
		//if edgeWeights[index1][index2] > 0; return false
		if(edgeWeights[indexFrom][indexTo] > 0)
			return false;
		
		//else return true
		edgeWeights[indexFrom][indexTo] = distance;
		return true;
	}

	/**
	 * Algorithm addUndirectedEdge(F, T, dist)
	 * Adds an undirected edge between two vertices
	 * Input: Two vertices one to come from and one to go to and a distance
	 * Output: A boolean of whether the edge could be added or not
	 * addUndirectedEdge(F, T, dist)
	 * 		index1 <- indexOfVertex(F)
	 * 		index2 <- indexOfVertex(T)
	 * 		if index1 = -1 or index2 = -1
	 * 			return false
	 * 		if edgeWeights[index1][index2] > 0 or edgeWeights[index2][index1] > 0
	 * 			return false
	 * 		else
	 * 			edgeWeights[index1][index2] <- dist
	 * 			edgeWeights[index2][index1] <- dist
	 * 			return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @param distance - the weight of the edge between from and to
	 * @return whether the undirected edge was added or not
	 */
	@Override
	public boolean addUndirectedEdge(Vertex from, Vertex to, int distance) {
		int indexFrom = indexOfVertex(from);
		int indexTo = indexOfVertex(to);
		
		//if index1 = -1 or index2 = -1; return false
		if(indexFrom == -1 || indexTo == -1)
			return false;
		
		//if edgeWeights[index1][index2] > 0 or edgeWeights[index2][index1] > 0; return false
		if(edgeWeights[indexFrom][indexTo] > 0 || edgeWeights[indexFrom][indexTo] > 0)
			return false;
		
		//else return true
		edgeWeights[indexFrom][indexTo] = distance;
		edgeWeights[indexTo][indexFrom] = distance;
		return true;
	}

	/**
	 * Algorithm deleteDirectedEdge(F, T)
	 * Deletes a Directed edge between two vertices
	 * Input: Two vertices one to come from and one to go to
	 * Output: A boolean of whether the edge could be deleted or not
	 * deleteDirectedEdge(F, T)
	 * 		index1 <- indexOfVertex(F)
	 * 		index2 <- indexOfVertex(T)
	 * 		if index1 = -1 or index2 = -1
	 * 			return false
	 * 		else
	 * 			edgeWeights[index1][index2] <- 0
	 * 			return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @return whether the directed edge was deleted or not
	 */
	@Override
	public boolean deleteDirectedEdge(Vertex from, Vertex to) {
		int indexFrom = indexOfVertex(from);
		int indexTo = indexOfVertex(to);
		
		//if index1 = -1 or index2 = -1; return false
		if(indexFrom == -1 || indexTo == -1)
			return false;
		
		//else return true
		edgeWeights[indexFrom][indexTo] = 0;
		return true;
	}

	/**
	 * Algorithm deleteUndirectedEdge(F, T)
	 * Deletes an Undirected edge between two vertices
	 * Input: Two vertices one to come from and one to go to
	 * Output: A boolean of whether the edge could be deleted or not
	 * deleteUndirectedEdge(F, T)
	 * 		index1 <- indexOfVertex(F)
	 * 		index2 <- indexOfVertex(T)
	 * 		if index1 = -1 or index2 = -1
	 * 			return false
	 * 		else
	 * 			edgeWeights[index1][index2] <- 0
	 * 			edgeWeights[index2][index1] <- 0
	 * 			return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @return whether the undirected edge was deleted or not
	 */
	@Override
	public boolean deleteUndirectedEdge(Vertex from, Vertex to) {
		int indexFrom = indexOfVertex(from);
		int indexTo = indexOfVertex(to);
		
		//if index1 = -1 or index2 = -1; return false
		if(indexFrom == -1 || indexTo == -1)
			return false;
		
		//else return true
		edgeWeights[indexFrom][indexTo] = 0;
		edgeWeights[indexTo][indexFrom] = 0;
		return true;
	}

	/**
	 * Algorithm getAdjacentVertices(V)
	 * This generates a list of all the vertices adjacent to the one inputed
	 * Input: A vertex to check for adjacent vertices from
	 * Output: An array A[0..n-1] containing the vertices adjacent to the vertex or null
	 * 			if the vertex does not exist or the array is empty
	 * getAdjacentVertices(V)
	 * 		A[0..n-1] <- new list
	 * 		index <- indexOfVertex(V)
	 * 		if index = -1
	 * 			return null
	 * 		else
	 * 			for i <- 0 to edgeWeights length do
	 * 				if edgeWeights[index][i] > 0
	 * 					add vertices[i] to A[0..n-1]
	 * 			return A[0..n-1]
	 * 
	 * @param vertex - the vertex to check for adjacent vertices
	 * @return adjacentVertices - the list of vertices adjacent to the vertex
	 */
	@Override
	public ArrayList<Vertex> getAdjacentVertices(Vertex vertex) {
		ArrayList<Vertex> adjacentVertices = new ArrayList<Vertex>();
		int index = indexOfVertex(vertex);
		
		//if index = -1; return null
		if(index == -1)
			return null;
		
		//else return A[0..n-1]
		for (int i = 0; i < edgeWeights.length; i++) {
			
			//if edgeWeights[index][i] != 0; add vertices[i] to A[0..n-1]
			if(edgeWeights[index][i] > 0) 
				adjacentVertices.add(vertices[i]);
		}
		
		//if A[0..n-1] length = 0; return null
		if(adjacentVertices.size() == 0)
			return null;
		return adjacentVertices;
	}
	
	/**
	 * Algorithm toString()
	 * Prints a string form of a GraphMatrix object
	 * Output: The string form of GraphMatrix
	 * toString()
	 * 		s <- "Adjacency Matrix for Graph:" + newline
	 * 		for i <- 0 to i < n do
	 * 			s <- s + vertices[i]
	 * 			for j <- 0 to j < m do
	 * 				if edgeWeights[i][j] > 0
	 * 					s <- s + " ->" + vertices[j] + ", " + edgeWeights[i][j]
	 * 			s <- s + newline
	 * 		return s
	 * 
	 * @return the string form of GraphMatrix
	 */
	public String toString() {
		String graphMatrixString = "Adjacency Matrix for Graph:\n";
		//for i <- 0 to i < n do
		for (int vertexFrom = 0; vertexFrom < edgeWeights.length; vertexFrom++) {
			graphMatrixString += vertices[vertexFrom];
			
			//for j <- 0 to j < m do
			for (int vertexTo = 0; vertexTo < edgeWeights[vertexFrom].length; vertexTo++) {
				
				//if edgeWeights[i][j] > 0; s <- s + " ->" + vertices[j] + ", " + edgeWeights[i][j]
				if(edgeWeights[vertexFrom][vertexTo] > 0)
					graphMatrixString += " ->" + vertices[vertexTo] + ", " + edgeWeights[vertexFrom][vertexTo];
			}
			graphMatrixString += "\n";
		}
		return graphMatrixString;
	}

}
