import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 */

/**
 * Creates an adjacency list of a graph with vertices and edges
 * @author MarefkeTyler
 * @version 2021.17.3
 */
public class GraphAdjacencyList implements Graphable {
	private HashMap<Vertex, LinkedList<EdgeWeightToVertex>> adjacencyList;
	
	/**
	 * Constructor for GraphAdjacencyList that takes in a list of vertices
	 * @param listOfVertices - the list of vertices
	 */
	public GraphAdjacencyList(ArrayList<Vertex> listOfVertices) {
		adjacencyList = new HashMap<Vertex, LinkedList<EdgeWeightToVertex>>();
		for (int i = 0; i < listOfVertices.size(); i++) {
			adjacencyList.put(listOfVertices.get(i), new LinkedList<EdgeWeightToVertex>());
		}
	}
	
	/**
	 * Algorithm getEdgeWeight(F, T)
	 * Retrieves the edge weight from one vertex to the other
	 * Input: Vertex to come from and a vertex to go to
	 * Output: the edge weight going from F to T or -1 if vertices are not in hashmap
	 * getEdgeWeight(F, T)
	 * 		if F is not in hashmap
	 * 			return -1
	 * 		
	 * 		LinkedList <- get(F)
	 * 		iterator <- LinkedList.iterator
	 * 		while iterator has more
	 * 			if T = iterator.getToVertex
	 * 				return iterator.getWeight
	 * 		return -1
	 *
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @return weight - the weight of the edge
	 */
	@Override
	public int getEdgeWeight(Vertex from, Vertex to) {
		//if F is not in hashmap; return -1
		if(!adjacencyList.containsKey(from))
			return -1;
		
		LinkedList<EdgeWeightToVertex> adjacenctVertices = adjacencyList.get(from);
		Iterator<EdgeWeightToVertex> iterator = adjacenctVertices.iterator();
		//while iterator has more
		while(iterator.hasNext()) {
			EdgeWeightToVertex current = iterator.next();
			//if T = iterator.getToVertex; return iterator.getWeight
			if(current.getToVertex() == to)
				return current.getWeight();
		}
			
		return 0;
	}

	/**
	 * Algorithm addDirectedEdge(F, T, dist)
	 * Adds a directed edge to the graph with weight dist from F to T
	 * Input: Vertex to come from, Vertex to go to, and a weight or distance
	 * Output: Whether the edge could be added or not
	 * addDirectedEdge(F, T, dist)
	 * 		if F or T are not in hashmap
	 * 			return false
	 * 		LinkedList <- get(F)
	 * 		Iterator <- LinkedList.iterator()
	 * 		while iterator has more
	 * 			if T = iterator.getToVertex
	 * 				return false
	 * 		hashmap.get(F).add(new EdgeWeightToVertex(T, dist))
	 * 		return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @param distance - the weight of the edge
	 * @return whether the edge was added or not
	 */
	@Override
	public boolean addDirectedEdge(Vertex from, Vertex to, int distance) {
		//if F or T are not in hashmap; return -1
		if(!(adjacencyList.containsKey(from) && adjacencyList.containsKey(to)))
			return false;
		
		LinkedList<EdgeWeightToVertex> adjacentVertex = adjacencyList.get(from);
		Iterator<EdgeWeightToVertex> iterator = adjacentVertex.iterator();
		//while iterator has more
		while(iterator.hasNext()) {
			EdgeWeightToVertex current = iterator.next();
			//if T = iterator.getToVertex; return false
			if(current.getToVertex() == to)
				return false;
		}
		adjacencyList.get(from).add(new EdgeWeightToVertex(to, distance));
		return true;
	}

	/**
	 * Algorithm addUndirectedEdge(F, T, dist)
	 * Adds a directed edge to the graph with weight dist from F to T
	 * Input: Vertex to come from, Vertex to go to, and a weight or distance
	 * Output: Whether the edge could be added or not
	 * addUndirectedEdge(F, T, dist)
	 * 		if F or T are not in hashmap
	 * 			return false
	 * 		LinkedList <- get(F)
	 * 		Iterator <- LinkedList.iterator()
	 * 		while iterator has more
	 * 			if T = iterator.getToVertex
	 * 				return false
	 * 		LinkedList <- get(T)
	 * 		Iterator <- LinkedList.iterator()
	 * 		while iterator has more
	 * 			if F = iterator.getToVertex
	 * 				return false
	 * 		hashmap.get(F).add(new EdgeWeightToVertex(T, dist))
	 * 		hashmap.get(T).add(new EdgeWeightToVertex(F, dist))
	 * 		return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @param distance - the weight of the edge
	 * @return whether the edge was added or not
	 */
	@Override
	public boolean addUndirectedEdge(Vertex from, Vertex to, int distance) {
		//if F or T are not in hashmap; return -1
		if(!(adjacencyList.containsKey(from) && adjacencyList.containsKey(to)))
			return false;
		
		LinkedList<EdgeWeightToVertex> adjacentVertex = adjacencyList.get(from);
		Iterator<EdgeWeightToVertex> iterator = adjacentVertex.iterator();
		//while iterator has more
		while(iterator.hasNext()) {
			EdgeWeightToVertex current = iterator.next();
			//if T = iterator.getToVertex; return false
			if(current.getToVertex() == to)
				return false;
		}
		
		adjacentVertex = adjacencyList.get(to);
		iterator = adjacentVertex.iterator();
		//while iterator has more
		while(iterator.hasNext()) {
			EdgeWeightToVertex current = iterator.next();
			//if F = iterator.getToVertex; return false
			if(current.getToVertex() == from)
				return false;
		}
		adjacencyList.get(from).add(new EdgeWeightToVertex(to, distance));
		adjacencyList.get(to).add(new EdgeWeightToVertex(from, distance));
		return true;
	}

	/**
	 * Algorithm deleteDirectedEdge(F, T)
	 * This method deletes an edge between two vertices
	 * Input: Vertex to come from and vertex to go to
	 * Output: Whether the edge could be removed or not
	 * deleteDirectedEdge(F, T)
	 * 		if F or T are not in hashmap
	 * 			return false
	 * 		LinkedList <- get(F)
	 * 		Iterator <- LinkedList.iterator()
	 * 		while iterator has more
	 * 			if T = iterator.getToVertex
	 * 				remove edge from hashmap from F to T
	 * 		return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @return Whether the edge was deleted or not
	 */
	@Override
	public boolean deleteDirectedEdge(Vertex from, Vertex to) {
		//if F or T are not in hashmap; return false
		if(!(adjacencyList.containsKey(from) && adjacencyList.containsKey(to)))
			return false;
		
		LinkedList<EdgeWeightToVertex> adjacentVertex = adjacencyList.get(from);
		Iterator<EdgeWeightToVertex> iterator = adjacentVertex.iterator();
		//while iterator has more
		while(iterator.hasNext()) {
			EdgeWeightToVertex current = iterator.next();
			//if T = iterator.getToVertex
			if(current.getToVertex() == to)
				//Removes edge from hashmap from F to T
				adjacencyList.get(from).remove(current);
		}
		
		return true;
	}

	/**
	 * Algorithm deleteDirectedEdge(F, T)
	 * This method deletes an edge between two vertices
	 * Input: Vertex to come from and vertex to go to
	 * Output: Whether the edge could be removed or not
	 * deleteDirectedEdge(F, T)
	 * 		if F or T are not in hashmap
	 * 			return false
	 * 		LinkedList <- get(F)
	 * 		Iterator <- LinkedList.iterator()
	 * 		while iterator has more
	 * 			if T = iterator.getToVertex
	 * 				remove edge from hashmap from F to T
	 * 		LinkedList <- get(T)
	 * 		Iterator <- LinkedList.iterator()
	 * 		while iterator has more
	 * 			if F = iterator.getToVertex
	 * 				remove edge from hashmap from T to F
	 * 		return true
	 * 
	 * @param from - the vertex to come from
	 * @param to - the vertex to go to
	 * @return Whether the edge was deleted or not
	 */
	@Override
	public boolean deleteUndirectedEdge(Vertex from, Vertex to) {
		//if F or T are not in hashmap; return false
		if(!(adjacencyList.containsKey(from) && adjacencyList.containsKey(to)))
			return false;
		
		LinkedList<EdgeWeightToVertex> adjacentVertex = adjacencyList.get(from);
		Iterator<EdgeWeightToVertex> iterator = adjacentVertex.iterator();
		//while iterator has more
		while(iterator.hasNext()) {
			EdgeWeightToVertex current = iterator.next();
			//if T = iterator.getToVertex
			if(current.getToVertex() == to)
				//Removes edge from hashmap from F to T
				adjacencyList.get(from).remove(current);
		}
		
		adjacentVertex = adjacencyList.get(to);
		iterator = adjacentVertex.iterator();
		//while iterator has more
		while(iterator.hasNext()) {
			EdgeWeightToVertex current = iterator.next();
			//if T = iterator.getToVertex
			if(current.getToVertex() == from)
				//Removes edge from hashmap from F to T
				adjacencyList.get(to).remove(current);
		}
		return true;
	}

	/**
	 * Algorithm getAdjacentVertices(V)
	 * Returns a list of vertices adjacent to vertex V
	 * Input: Vertex V to check for adjacency
	 * Output: A list of adjacent vertices to V or null if V is not in the hashmap
	 * getAdjacentVertices(V)
	 * 		Create ArrayList B
	 * 		if V is not in hashmap
	 * 			return null
	 * 		LinkedList <- get(V)
	 * 		Iterator <- LinkedList.iterator()
	 * 		while iterator has more
	 * 			add iterator.next.getToVertex to B
	 * 		return B
	 */
	@Override
	public ArrayList<Vertex> getAdjacentVertices(Vertex vertex) {
		ArrayList<Vertex> adjacentVertices = new ArrayList<Vertex>();
		//if V is not in hashmap; return null
		if(!adjacencyList.containsKey(vertex))
			return null;
		
		LinkedList<EdgeWeightToVertex> vertexEdges = adjacencyList.get(vertex);
		Iterator<EdgeWeightToVertex> iterator = vertexEdges.iterator();
		//while iterator has more
		while(iterator.hasNext())
			//add iterator.next.getToVertex to B
			adjacentVertices.add(iterator.next().getToVertex());
		//return B
		return adjacentVertices;
	}

	/**
	 * Returns the string form of GraphAdjacencyList
	 * @return string of GraphAdjacencyList
	 */
	public String toString() {
		String graphAdjacency = "Adjacency List for graph:\n";
		SortedSet<Vertex> keys = new TreeSet<>(adjacencyList.keySet());
		for(Vertex key : keys) {
			graphAdjacency += "Vertex " + key + ":";
			LinkedList<EdgeWeightToVertex> adjacentVertices = adjacencyList.get(key);
			Iterator<EdgeWeightToVertex> iterator = adjacentVertices.iterator();
			while(iterator.hasNext()) {
				graphAdjacency += " ->" + iterator.next();
			}
			graphAdjacency += "\n";
		}
		return graphAdjacency;
	}
}
