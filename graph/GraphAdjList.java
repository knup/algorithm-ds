/**  
 * This class implements a graph using adjacency list
 * 
 * @author anupkhadka
 * @usage java GraphAdjList <filename>
 * See graphs.txt for sample file
 */

package graph;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class GraphAdjList {

	private class Neighbor {
		int vertexNum;
		Neighbor next;

		private Neighbor(int vertexNum) {
			this.vertexNum = vertexNum;
			next = null;
		}

		private Neighbor(int vertexNum, Neighbor next) {
			this.vertexNum = vertexNum;
			this.next = next;
		}
	}

	private class Vertex {
		String name;
		Neighbor adjList;
	
		private Vertex(String name) {
			this.name = name;
			adjList = null;
		}
		
		private Vertex(String name, Neighbor neighbors) {
			this.name = name;
			adjList = neighbors;
		}
	}

	private int V;	
	private Vertex[] adjLists;

	public GraphAdjList(String fileName) throws FileNotFoundException {
		/* The file containing graph information should be in following 
         * order: 
         * numVertices (Eg. 2)
 		 * vertex1_name
		 * vertex2_name
		 * Edges
         * .....
         */

		Scanner sc = new Scanner(new File(fileName));
		
		V = sc.nextInt();
		adjLists = new Vertex[V];

		//read vertices
		for(int i = 0; i < V; i++) {
			adjLists[i] = new Vertex(sc.next());
		}

		//read edges
		while(sc.hasNext()) {
			int vertex1 = index(sc.next());
			int vertex2 = index(sc.next());
			adjLists[vertex1].adjList = new Neighbor(vertex2, adjLists[vertex1].adjList);
			adjLists[vertex2].adjList = new Neighbor(vertex1, adjLists[vertex2].adjList);
		}
	}

	/**
	 * Returns index for the vertex with the specific name 
     */
	private int index(String name) {
		for(int i = 0; i < V; i++) {
			if(adjLists[i].name.equals(name)) {
				return i;
			}
		} 
		return 0;
	}

	/**
	 * Prints the graph 
     */
	public void print() {
		for(int i = 0; i < V; i++) {
			System.out.print(adjLists[i].name+" is friends with: ");
			Neighbor iterator = adjLists[i].adjList;
			while(iterator != null) {
				System.out.print(adjLists[iterator.vertexNum].name+" ");
				iterator = iterator.next;
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String [] args) throws FileNotFoundException {
		if(args.length < 1) {
			System.out.println("java GraphAdjList <graph_file>");
		} else {
			GraphAdjList graph = new GraphAdjList(args[0]);
			graph.print();
		}
	}
}
