import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class GraphAdjacencyList implements Graphable {
	/** adjacencyList will store the name of a vertex (String) as the key that maps
	 * to a LinkedList of EdgeWeightToVertex objects. This will provide the adjacency list
	 * for our graph.
	 */
	private HashMap<String, LinkedList<EdgeWeightToVertex>> adjacencyList;

	/**
	 * ArrayList of all vertices in the graph 
	 */
	private ArrayList<Vertex> listOfVertices;
	/**
	 * GraphAdjacencyList constructor construct the HashMap adjacencyList.
	 * @param listOfVertices -ArrayList of Vertex objects for all vertices in graph.
	 */
	public GraphAdjacencyList(ArrayList<Vertex> listOfVertices) {
		adjacencyList = new HashMap< String, LinkedList<EdgeWeightToVertex> >();
		for(int i = 0; i<listOfVertices.size(); i++) {
			String vertexName = listOfVertices.get(i).getName();
			adjacencyList.put(vertexName, new LinkedList<EdgeWeightToVertex>());
		}
		this.listOfVertices = listOfVertices;
	}

	
	@Override
	public String toString() {
		String s = "Adjacency list for graph:\n";
		for( String key : adjacencyList.keySet() ) {
		
		  s += "Vertex "+key+":";
		  LinkedList<EdgeWeightToVertex> adjacentEdges = adjacencyList.get(key);
		  Iterator<EdgeWeightToVertex> iterator = adjacentEdges.iterator();
		  while (iterator.hasNext()) {
			  EdgeWeightToVertex edgeWeightToVertex = iterator.next();
			  s+= " ->"+edgeWeightToVertex;
		  }
		  s+="\n";
		}
		return s;
	}


	@Override
	public int getEdgeWeight(Vertex from, Vertex to) {
		LinkedList<EdgeWeightToVertex> adjacentVertices = adjacencyList.get(from.getName());
		for(int i = 0; i< adjacentVertices.size(); i++ )
			if(adjacentVertices.get(i).getToVertex() == to	)
				return adjacentVertices.get(i).getWeight();
		return 0;
	}

	
	
	private boolean edgeExists(Vertex from, Vertex to) {
		LinkedList<EdgeWeightToVertex> adjacentVertices = adjacencyList.get(from.getName());
		for(int i = 0; i< adjacentVertices.size(); i++ )
			if(adjacentVertices.get(i).getToVertex() == to	)
				return true;
		
		return false;
	}

	@Override
	public boolean addUndirectedEdge(Vertex from, Vertex to, int distance) {
		if(edgeExists(from, to) || edgeExists(to, from))
			return false;
		else {
			EdgeWeightToVertex edge = new EdgeWeightToVertex(to, distance);
			adjacencyList.get(from.getName()).add(edge);
			adjacencyList.get(to.getName()).add(new EdgeWeightToVertex(from, distance) );
			return true;
		}
	}

	
	@Override
	public boolean addDirectedEdge(Vertex from, Vertex to, int distance) {
		if(edgeExists(from, to))
			return false;
		else {
			EdgeWeightToVertex edge = new EdgeWeightToVertex(to, distance);
			adjacencyList.get(from.getName()).add(edge);
			return true;
		}
	}

	
	@Override
	public boolean deleteDirectedEdge(Vertex from, Vertex to) {
		if(edgeExists(from, to)) {
			LinkedList<EdgeWeightToVertex> adjacentVertices = adjacencyList.get(from.getName());
			for(int i = 0; i< adjacentVertices.size(); i++ )
				if(adjacentVertices.get(i).getToVertex() == to	)
					adjacentVertices.remove(i);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean deleteUndirectedEdge(Vertex from, Vertex to) {
		if(edgeExists(from, to)) {
			//loop through from 
			LinkedList<EdgeWeightToVertex> adjacentVertices = adjacencyList.get(from.getName());
			for(int i = 0; i< adjacentVertices.size(); i++ )
				if(adjacentVertices.get(i).getToVertex() == to	)
					adjacentVertices.remove(i);
			//loop through to to remove from
			adjacentVertices = adjacencyList.get(to.getName());
			for(int i = 0; i< adjacentVertices.size(); i++ )
				if(adjacentVertices.get(i).getToVertex() == from	)
					adjacentVertices.remove(i);
			
			return true;
		}
		else
			return false;
	}

	@Override
	public ArrayList<Vertex> getAdjacentVertices(Vertex vertex) {
		LinkedList<EdgeWeightToVertex> adjacentVertices = adjacencyList.get(vertex.getName());
		ArrayList<Vertex> adjacent = new ArrayList<Vertex>();
		for(int i = 0; i< adjacentVertices.size(); i++ )
			adjacent.add(adjacentVertices.get(i).getToVertex());
			
		return adjacent;
	}
	
	/**
	 * ALGORITHM Iterative BreadthFirstSearch(Vertex start)
	 *Traverses a graph using the breadth first methodology
	 *Input: Vertex start is the vertex to start the traversal.
	 *Output: Graph tree that represents the breadth first search tree traversal.
	 *BreadthFirstSearch(Vertex start){
	 *		initialize vertices;  mark all vertices white
	 *							  v[i].setColor(Vertex.WHITE)
	 *		Create new GraphAdjacencyList (listOfVertices) T (BFS tree)
	 *		Q = {start};  Q is a queue; insert vertex start
	 *		while (Q not empty) {
	 *			u = Dequeue Q
	 *			for each Vertex v in u->adjacent do { getAdjacentVertices
	 *				if(v->color == WHITE) {
	 *					v->color = GREEN;
	 *					Enqueue to Q Vertex v
	 *					tree T add directed edge(u, v, 1)
	 *				} end if
	 *			} end for each
	 *		} end while
	 *		return T
	 *} end algorithm
	 *
	 *@param start - the vertex to start from
	 *@return result - the final result
	 */
	public GraphAdjacencyList breadthFirstSearch(Vertex start) {
		//initializes vertices; marks all vertices white
		for (int i = 0; i < listOfVertices.size(); i++) {
			this.listOfVertices.get(i).setColor(Vertex.WHITE);
		}
		//Creates a final result tree and a queue for vertices
		GraphAdjacencyList result = new GraphAdjacencyList(this.listOfVertices);
		LinkedList<Vertex> myQueue = new LinkedList<Vertex>();
		
		//Creates a temporary vertex and adds vertex start to the queue
		Vertex temp;
		myQueue.add(start);
		//while (Q not empty)
		while(myQueue.size() > 0) {
			
			//u = Dequeue Q
			temp = myQueue.removeFirst();
			
			//for each Vertex v in u->adjacent do
			for(Vertex adjacentVertex : this.getAdjacentVertices(temp)) {
				
				//if (v->color == WHITE)
				if(adjacentVertex.getColor() == Vertex.WHITE) {
					//v->color = GREEN
					//Enqueue to Q vertex v
					//tree T add directed edge (u,v,1)
					adjacentVertex.setColor(Vertex.GREEN);
					myQueue.addLast(adjacentVertex);
					result.addDirectedEdge(temp, adjacentVertex, 1);
				} //end if
			} //end for each
			temp.setColor(Vertex.BLACK);
		} //end while
		return result;
	}//end algorithm
	
	/**
	 * ALGORITHM Iterative DepthFirstSearch(Vertex start)
	 * Traverses a graph using the depth first methodology
	 * Input: A graph that is connected and undirected
	 * Vertex start is the vertex to start the traversal
	 * Output: Graph tree that represents the depth first search tree
	 * 
	 * DepthFirstSearch(Vertex start) {
	 * 		create Stack<Vertex> S
	 * 		create ArrayList<Vertex> visited  store order of visited vertices
	 * 		create HashMap<Vertex, Vertex> predecessor stor predecessor value
	 * 		initialize each vertex u in the graph to set visited false
	 * 		push Vertex start onto S
	 * 		while S is not empty do
	 * 			u = pop S;
	 * 			if not visited u then
	 * 				set visited u = true
	 * 				add u to visited ArrayList
	 * 				for each adjacent vertex w of u do
	 * 					if w not visited do
	 * 						push Vertex w onto S
	 * 						put w as key and u as value in predecessor HashMap
	 * 					end if
	 * 				end for each
	 * 			end if
	 * 		end while
	 * 		Create GraphAdjacencyList tree with all vertices visited
	 * 		for each Vertex v stored in visited do
	 * 			if predecessor contains key for v
	 * 				get Vertex u from predecessor
	 * 				add directed edge (u,v,1) to tree
	 * 			end if
	 * 		end for
	 * 		return tree
	 * end DFS
	 * 
	 * @param start - the vertex to start from
	 * @param tree - the final result
	 */
	public GraphAdjacencyList depthFirstSearch(Vertex start) {
		//create Stack S, ArrayList visited, and HashMap predecessor
		Stack<Vertex> myStack = new Stack<Vertex>();
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		HashMap<Vertex, Vertex> predecessor = new HashMap<Vertex, Vertex>();
		
		//initialize each vertex u in the graph to set visited false
		for (int i = 0; i < listOfVertices.size(); i++) {
			this.listOfVertices.get(i).setVisited(false);;
		}
		//push Vertex start onto S
		myStack.push(start);
		
		//while S is not empty do
		while(!myStack.isEmpty()) {
			//u = pop S
			Vertex temp = myStack.pop();
			//if u is not visited then
			if(!temp.getVisited()) {
				//set u visited to true and add u to arraylist visited
				temp.setVisited(true);
				visited.add(temp);
				//for each adjacent vertex w of u do
				for(Vertex adjacentVertex : this.getAdjacentVertices(temp)) {
					//if w is not visited then
					if(!adjacentVertex.getVisited()) {
						//push w onto S and put w as key and u as value into predecessor
						myStack.push(adjacentVertex);
						predecessor.put(adjacentVertex, temp);
					}//end if
				}//end for each
			}//end if
		}//end while
		//create GraphAdjacencyList tree with visited vertices
		GraphAdjacencyList tree = new GraphAdjacencyList(visited);
		//for each vertex v in visited do
		for(Vertex visit : visited) {
			if(predecessor.containsKey(visit)) {
				//get u from predecessor
				//add directed edge (u, v, 1) to tree
				tree.addDirectedEdge(predecessor.get(visit), visit, 1);
			}//end if
		}//end for each
		return tree;
	}//end algorithm
	
	/**
	 * ALGORITHM Dijkstra(Vertex start)
	 * Traverses through the graph finding the shortest path from start to all other nodes
	 * Input: the vertex to start from
	 * 
	 * Dijkstra(Vertex start){
	 * 		create a HashMap<Vertex, Vertex> predecessor
	 * 		create a Comparator VertexCompareByDistance compare
	 * 		create PriorityQueue<Vertex> PQ = new PriorityQueue(compare)
	 * 
	 *  	for each vertex v in vertices
	 *  		dist[v] <- Infinity    v.setDistance(Integer.MAX_INT)
	 *  		if v is start
	 *  			set dist[start] <- 0
	 *  		add v to PQ
	 *  	end for
	 *  
	 *  	while PQ is not empty do
	 *  		u <- remove u from PQ    vertex in Q with min distance
	 *  		for each neighbor v of u do
	 *  			if PQ contains v
	 *  				alt <- u distance + weight of edge(u, v)
	 *  				if alt < v distance:
	 *  					remove v from PQ
	 *  					v distance <- alt
	 *  					add v to PQ
	 *  					put(v, u) in predecessor    u predecessor to v
	 *  				end if
	 *  			end if
	 *  		end for
	 *  	end while
	 *  print out distance to each vertex from the source vertex
	 *  
	 *  print out path from source to each vertex
	 *  	for each Vertex current in vertices
	 *  		String path = "";
	 *  		if(current != start)
	 *  			path = " ->"+current+", "+current.getDistance
	 *  			while predecessor contains key (current)
	 *  				if predecessor of current is source
	 *  					path = predecessor get current + path
	 *  				else
	 *  					path = " ->"+predecessor get current + path + ", " + current.getDistance
	 *  				current = predecessor.get(current)
	 *  			end while
	 *  		end if
	 *  		print path
	 *  	end for
	 */
	public void Dijkstra(Vertex start) {
		//create hashmap predecessor, VertexCompareByDistance compare, PriorityQueue myPQ
		HashMap<Vertex,Vertex> predecessor = new HashMap<Vertex, Vertex>();
		VertexCompareByDistance compare = new VertexCompareByDistance();
		PriorityQueue<Vertex> myPQ = new PriorityQueue<Vertex>(compare);
		
		//initialize vertex distances and adds vertices to myPQ
		for(Vertex vertex : listOfVertices) {
			vertex.setDistance(Integer.MAX_VALUE);
			if(vertex == start)
				vertex.setDistance(0);
			myPQ.add(vertex);
		}//end for each
		
		//while PQ is not empty
		while(!myPQ.isEmpty()) {
			//u <- remove u from PQ
			Vertex temp = myPQ.remove();
			//for each neighbor v of u do
			for(Vertex neighbor : this.getAdjacentVertices(temp)) {
				//if PQ contains v
				if(myPQ.contains(neighbor)) {
					//alt <- u dist + edge weight from (u,v)
					int alternateDist = temp.getDistance() + this.getEdgeWeight(temp, neighbor);
					//if alt < v dist
					if (alternateDist < neighbor.getDistance()) {
						//remove v from PQ
						//v dist = alt
						//add v to PQ
						//put (v,u) into predecessor
						myPQ.remove(neighbor);
						neighbor.setDistance(alternateDist);
						myPQ.add(neighbor);
						predecessor.put(neighbor, temp);
					}//end if
				}//end if
			}//end for each
		}//end while
		
		//print distance of each vertex from source
		for(Vertex vertexDist : listOfVertices) {
			System.out.println(vertexDist.getName() + ": " + vertexDist.getDistance());
		}//end for each
		
		//print each path from source to vertex
		for(Vertex current : listOfVertices) {
			String path = "";
			if(current != start) {
				path = " ->" + current + ", " + current.getDistance();
				while(predecessor.containsKey(current)) {
					if(predecessor.get(current) == start)
						path = predecessor.get(current) + path;
					else
						path = " ->"+predecessor.get(current)+", "+predecessor.get(current).getDistance() + path;
					current = predecessor.get(current);
				}//end while
			}//end if
			System.out.println(path);
		}//end for each
	}//end algorithm
}
