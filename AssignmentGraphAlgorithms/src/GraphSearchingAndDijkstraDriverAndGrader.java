import java.util.ArrayList;
import java.util.LinkedList;

public class GraphSearchingAndDijkstraDriverAndGrader {

	public static void main(String[] args) {
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		vertices.add(A);
		vertices.add(B);
		vertices.add(C);
		vertices.add(D);
		
		//Create graph1 for testing
		GraphAdjacencyList graph1 = new GraphAdjacencyList(vertices);			
		graph1.addUndirectedEdge(A, B, 1);
		graph1.addUndirectedEdge(A, C, 3);
		graph1.addUndirectedEdge(B, C, 1);
		graph1.addUndirectedEdge(C, D, 2);
		
		int points = 0;
		
		points+=5; //constructed graph1
		//Output graph1 to match provided formatting
		System.out.println("Graph for testing:\n\n"+graph1); //test toString
		ArrayList<Vertex> adjacentToA = graph1.getAdjacentVertices(A);
		if(adjacentToA != null && adjacentToA.size() ==2)
			points+=5; //toString print of graph1
		else
			System.out.println("Either failed to add edges to A. Fix Add UndirectedEdge. Or, getAdjacentVertices is not correctly implemented.");
		
		System.out.println("You have "+points+" initial points from creating and printing graph1");	
		System.out.println("Earned "+points+" of 10 points");

//*************Test the implementation**************************************
				
//breadthFirstSearch testing

	
		GraphAdjacencyList bfs = graph1.breadthFirstSearch(A);
		System.out.println("breadthFirstSearch(A) results: \n" + bfs); //test toString		
		ArrayList<Vertex> bfsAdjacentA, bfsTestA;
		bfsTestA = new ArrayList<Vertex>();
		bfsTestA.add(B); bfsTestA.add(C);
		bfsAdjacentA = bfs.getAdjacentVertices(A);
		
		if(bfsAdjacentA != null && bfsAdjacentA.containsAll(bfsTestA)&& !bfsAdjacentA.contains(D))
			points+=4;
		else
			System.out.println("breadthFirstSearch failed to reach both B and C");
		
		
		if(bfs.getAdjacentVertices(B) != null && bfs.getAdjacentVertices(B).size() ==0 )// && adjacentD.contains(C))
			points+=3;
		else
			System.out.println("BFS Adjacent B should not have any adjacent vertices");
		
		
		if(bfs.getAdjacentVertices(C) != null && bfs.getAdjacentVertices(C).size() == 1 && bfs.getAdjacentVertices(C).contains(D))// && adjacentD.contains(C))
			points+=3;
		else
			System.out.println("BFS Adjacent C should have one adjacent vertice D");
	
		System.out.println("Earned "+points+" of 20 total points past breadthFirstSearch testing");

	 
		
//test depthFirstSearch	on new clean graph1	
		
	
		graph1 = new GraphAdjacencyList(vertices);			
		graph1.addUndirectedEdge(A, B, 1);
		graph1.addUndirectedEdge(A, C, 3);
		graph1.addUndirectedEdge(B, C, 1);
		graph1.addUndirectedEdge(C, D, 2);
		
		GraphAdjacencyList dfs = graph1.depthFirstSearch(A);
		System.out.println("depthFirstSearch(A) results: \n" + dfs); //test toString		
		ArrayList<Vertex> dfsAdjacentA;
		
		dfsAdjacentA = dfs.getAdjacentVertices(A);
		
		if(dfsAdjacentA != null && (dfsAdjacentA.contains(B)||dfsAdjacentA.contains(C) ) && !dfsAdjacentA.contains(D))
			points+=6;
		else
			System.out.println("depthFirstSearch should reach either B or C but not both");
		
		
		if(dfs.getAdjacentVertices(D) != null && dfs.getAdjacentVertices(D).size() ==0 )
			points+=4;
		else
			System.out.println("DFS Adjacent D should not have any adjacent vertices");
		
			
		System.out.println("Earned "+points+" of 30 points past depthFirstSearch");
	
		
//test BFS and DFS on larger graph2
	
	
		//Second Graph to test
		ArrayList<Vertex> vertices2 = new ArrayList<Vertex>();
		
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
				
		vertices2.add(a);
		vertices2.add(b);
		vertices2.add(c);
		vertices2.add(d);
		vertices2.add(e);
		vertices2.add(f);
		
		
		GraphAdjacencyList graph2 = new GraphAdjacencyList(vertices2);
				
		graph2.addUndirectedEdge(a, c, 1);
		graph2.addUndirectedEdge(a, d, 1);
		graph2.addUndirectedEdge(c, e, 1 );
		graph2.addUndirectedEdge(c, b, 1);
		graph2.addUndirectedEdge(d, e, 1);
		graph2.addUndirectedEdge(e, f, 1);
		graph2.addUndirectedEdge(b, f, 1);
		
		System.out.println("Graph2:\n"+graph2);
		
		GraphAdjacencyList bfs2 = graph2.breadthFirstSearch(a);
		if(bfs2.getAdjacentVertices(a) != null && bfs2.getAdjacentVertices(a).size() ==2 )
			points+=2;
		else
			System.out.println("BFS Adjacent a should have two adjacent vertices");
		
		GraphAdjacencyList dfsTree2 = graph2.depthFirstSearch(a);
		if(dfsTree2.getAdjacentVertices(a) != null && dfsTree2.getAdjacentVertices(a).size() ==1 )
			points+=2;
		else
			System.out.println("DFS Adjacent a should have one adjacent vertices");
		
		//BFS and DFS from Vertex c
		GraphAdjacencyList bfsTree2c = graph2.breadthFirstSearch(c);
		if(bfsTree2c.getAdjacentVertices(c) != null && bfsTree2c.getAdjacentVertices(c).size() ==3 )
			points+=3;
		else
			System.out.println("BFS Adjacent c should have three adjacent vertices");
		
		GraphAdjacencyList dfsTree2c = graph2.depthFirstSearch(c);
		if(dfsTree2c.getAdjacentVertices(c) != null && dfsTree2c.getAdjacentVertices(c).size() ==1 )
			points+=3;
		else
			System.out.println("DFS Adjacent c should have one adjacent vertex");

		System.out.println("Earned "+points+" of 40 total points past second graph with bfs and dfs\n\n");
	
		
//test Dijkstras in ArrayList on new clean graph1	
		
	
		System.out.println("Starting testing of Dijkstra's Algorithm:");
		graph1 = new GraphAdjacencyList(vertices);			
		graph1.addUndirectedEdge(A, B, 1);
		graph1.addUndirectedEdge(A, C, 3);
		graph1.addUndirectedEdge(B, C, 1);
		graph1.addUndirectedEdge(C, D, 2);
		
		graph1.Dijkstra(A);
		
		if(A.getDistance() == 0 )
			points+=2;
		else
			System.out.println("Distance should be 0 in start Vertex A");
		
		if(B.getDistance() == 1 )
			points+=2;
		else
			System.out.println("Distance should be 1 in Vertex B");
		
		if(C.getDistance() == 2 )
			points+=3;
		else
			System.out.println("Distance should be 2 in Vertex C (not 3)");
		
		if(D.getDistance() == 4 )
			points+=3;
		else
			System.out.println("Distance should be 4 in Vertex D");
		
		System.out.println("Earned "+points+" of 50 total points past Dijkstras");
		
	 

		System.out.println("\nFinal points: "+points+" of 50 total points ");
		
	}
}
