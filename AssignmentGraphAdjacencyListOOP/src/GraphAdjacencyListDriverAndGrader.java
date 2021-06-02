import java.util.ArrayList;
import java.util.LinkedList;

public class GraphAdjacencyListDriverAndGrader {

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
		
		GraphAdjacencyList graph1 = new GraphAdjacencyList(vertices);	
		System.out.println("Vertices only:\n"+graph1);
		
		graph1.addUndirectedEdge(A, B, 1);
		graph1.addUndirectedEdge(A, C, 3);
		graph1.addUndirectedEdge(B, C, 1);
		graph1.addUndirectedEdge(C, D, 2);
		
		int points = 0;
		//Create graph1 for testing
		
		//int[][] distances = { {0, 1, 3, 0}, {1, 0, 1, 0}, {3, 1, 0, 2}, {0, 0, 2, 0} };
		//GraphMatrix  graph1 = new GraphMatrix( vertices);  //test constructor
		points+=5; //constructed graph1
		//Output graph1 to match provided formatting
		System.out.println(graph1); //test toString
		ArrayList<Vertex> adjacentToA = graph1.getAdjacentVertices(A);
		if(adjacentToA.size() ==2)
			points+=5; //toString print of graph1
		else
			System.out.println("Failed to add edges to A. Fix Add UndirectedEdge");
		
		System.out.println("You have "+points+" from creating and printing graph1");	
		System.out.println("Earned "+points+" of 10 points");

//*************Test the implementation**************************************	
//EdgeWeightToVertex class testing
		EdgeWeightToVertex edge = new EdgeWeightToVertex(A,7);
		if(A == edge.getToVertex() ) {
			points+=2;
		}
		else
			System.out.println("Failed to edge.getToVertex()");
		
		if(7 == edge.getWeight() ) {
			points+=3;
		}
		else
			System.out.println("Failed to getWeight in EdgeWeightToVertex");
		
		System.out.println("Earned "+points+" of 15 points past EdgeWeightToVertex testing");

//test getEdgeWeight		
		if(2 == graph1.getEdgeWeight(C,D) ) {
			points+=3;
		}
		else
			System.out.println("Failed to getEdgeWeight(C,D) of 2");
		
		
		if(0 == graph1.getEdgeWeight(B,D) ) {
			points+=2;
		}
		else
			System.out.println("Failed to getEdgeWeight(B,D) of 0 for no edge");
		System.out.println("Earned "+points+" of 20 points past getVertex");
		
//Test delete and add DirectedEdge
		//add C -> D already exists to return false
		if(graph1.addDirectedEdge(C,D, 3) == false ) {
			points+=2;
		}
		else
			System.out.println("Failed to return false adding a directed edge that already exists.");
		
		//delete C -> D directed edge (true)
		if( graph1.deleteDirectedEdge(C,D) ) {
			points+=3;
		}
		else
			System.out.println("Failed to deleteDirectedEdge C->D");
		
		if(0 == graph1.getEdgeWeight(C,D) ) {
			points+=2;
		}
		else
			System.out.println("Failed to set EdgeWeight to 0 for deletedDirectedEdge");
		
		
		
		if(graph1.addDirectedEdge(C,D,2) ) {
			points+=3;
		}
		else
			System.out.println("Failed to addDirectedEdge(C,D,2) that was just deleted");
		
	
		System.out.println("Earned "+points+" of 30 points past deleteDirectedEdge");
		

//Test delete and add UndirectedEdge
		//add C -> D already exists to return false
		if(graph1.addUndirectedEdge(C,D, 3) == false ) {
			points+=2;
		}
		else
			System.out.println("Failed to return false adding a undirected edge that already exists.");
		
		//delete C -> D directed edge (true)
		if( graph1.deleteUndirectedEdge(C,D) ) {
			points+=2;
		}
		else
			System.out.println("Failed to deleteUndirectedEdge C->D");
		
		if(0 == graph1.getEdgeWeight(C,D) ) {
			points+=2;
		}
		else
			System.out.println("Failed to set EdgeWeight to 0 for deletedUndirectedEdge C->D");
		
		if(0 == graph1.getEdgeWeight(D, C) ) {
			points+=2;
		}
		else
			System.out.println("Failed to set EdgeWeight to 0 for deletedUndirectedEdge D->C");
		
		if(graph1.addUndirectedEdge(C,D,2) ) {
			points+=2;
		}
		else
			System.out.println("Failed to addUndirectedEdge(C,D,2) that was just deleted");

		System.out.println("Earned "+points+" of 40 points past add and delete UndirectedEdge");
		
//test getAdjacentVertices in ArrayList
		
		ArrayList<Vertex> adjacentA, testA, adjacentD;
		testA = new ArrayList<Vertex>();
		testA.add(B); testA.add(C);
		adjacentA = graph1.getAdjacentVertices(A);
		
		if(adjacentA.containsAll(testA)&& !adjacentA.contains(D))
			points+=6;
		else
			System.out.println("Failed to find vertices adjacent to A");
		adjacentD = graph1.getAdjacentVertices(D);
		if(adjacentD.size() ==1 && adjacentD.contains(C))
			points+=4;
		else
			System.out.println("Failed to find Vertex C adjacent to D");
		
		System.out.println("Earned "+points+" of 50 total points past getAdjacentVertices");
		

	}
}
