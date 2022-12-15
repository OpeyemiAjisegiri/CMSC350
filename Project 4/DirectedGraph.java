/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 4
 * Date: October 12th, 2021
 * File: DirectedGraph [DirectedGraph.java]
 * Purpose: Creates a Directed Graph from the file input. The Directed graph
 * is interacted with through the User Interface
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//import java.util.StringTokenizer;


public class DirectedGraph<T> /*extends Graph<vertex>*/ {
	/*static class Vertex<T>{
		private LinkedList<T> vertex = new LinkedList<T>();
		 
		Vertex(){}
		
		public void addVertex(T Vertex){
			vertex.add(Vertex);
		}
		
		public int getSize(){
			return vertex.size();
		}
		
	}*/
	
	private enum Mark {UNDISCOVERED, DISCOVERED};
	private Mark[] marks;
	/** Could not use the line before without a solution that doesn't require adding a String class  **/ 
	/*private LinkedList<Vertex> vertices = new LinkedList<Vertex>(); //AdjancencyList
	//private LinkedList<LinkedList<T>> vertex = new LinkedList<LinkedList<T>>();*/
	private LinkedList<T> vertices = new LinkedList<T>();
	private boolean cycle;
	
	private HashMap<T, List<T>> adjVertices = new HashMap<>();

	public DirectedGraph() {
	}
	
	private void addVertex(T vertex){
		adjVertices.put(vertex, vertices);
	}
	
	public void addEdge(T source, LinkedList<T> destinations) {
		if(!adjVertices.containsKey(source))
			addVertex(source);
		adjVertices.get(source).addAll(destinations);
		
		for(int a = 0; a < adjVertices.size() ;a++)
			System.out.println(adjVertices);
	}
	
	/*public void addVertices(LinkedList<T> v){
		//vertices.add(v);
		vertices.add(v);
		//vertices.addLast(v);
		System.out.println(vertices.size());
	}*/
	
	public void hasVertex(T vertex) {
		if(adjVertices.containsKey(vertex))
			System.out.println("The graph contains the vertex: "+vertex);
		else
			System.out.println("The graph doesn't contain the vertex: "+vertex);
	}
	
	public void hasEdge(T source, T destination) {
		if(adjVertices.get(source).contains(destination))
			System.out.println("A path between "+source+" and "+destination+" exist.");
		else
			System.out.println("A path between "+source+" and "+destination+" does not exist.");
	}
	
	public int getSize(){
		return vertices.size();
	}
	
	public int getIndex(T vertex)
	{
		return vertices.indexOf(vertex);
	}

	
	/*
	 * depth_first_search(vertex s)
		 if s is discovered
		 	perform cycle detected action
		 	return
		 perform add vertex action
		 mark s as discovered
		 perform descend action
		 for all adjacent vertices v
		 	depth_first_search(v)
		 perform ascend action
		 mark s as finished
	*/
	
	public void Depth_First_Search(T vertex) {
		int vertices = adjVertices.size();
		boolean[] visited = new boolean[vertices];
		
		List<T> destinations = adjVertices.get(vertex);
		if(destinations == null)
			return;
		for(T dest: destinations) {
			if(!visited[indexes.get(dest)])
				Depth_First_Search(dest);}
	}
	
	/*public void depth_first_search(T v) {
		LinkedList<T> isVisited = new LinkedList<T>();
			marks = new Mark[getSize()];
		LinkedList<T> visited = new LinkedList<T>();
		Stack<T> intended = new Stack<T>();
		for(int i = 0; i < vertices.size() ; i++) {
				marks[i] = Mark.UNDISCOVERED;
			if(vertices.get(i) == v) {
				isVisited.add(v);
				return;
			}else {
				for(int z = 0; z < vertices.get(i).size() ; z++) {
					intended.add(vertices.get(i).get(z));
				}
				while(!intended.isEmpty()) {
					T temp = intended.pop();
					if(intended.contains(temp))
						marks[i] = Mark.DISCOVERED;
					if(isVisited.contains(temp))
						continue;
					else {
						isVisited.add(temp);
						if(isVisited.contains(temp))
							cycle = true;
						if(temp == v) {
							return;
						}else
							continue;
					}
						
				}
			}
		}
		
	}*/
	
}
