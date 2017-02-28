package graphs;

import java.util.ArrayList;

/**
 * An Adjacency Matrix implementation of a weighted and directed Graph
 * 
 * @author Elexie Munyeneh
 *
 */

public class AdjacencyMatrix<T> extends GraphADT<T> {

	ArrayList<T> vertices;
	int[][] adjacencyMatrix;
	boolean[] visited;
	int size;
	int cap;

	public AdjacencyMatrix(int cap) {
		vertices = new ArrayList<T>();
		this.cap = cap;
		adjacencyMatrix = new int[cap][cap];
		visited = new boolean[cap];
	}

	@Override
	public void addVertex(T vertex) {
		if (this.size < cap) {
			vertices.add(vertex);
			this.size += 1;
		}

	}

	/**
	 * adds a connection between two nodes with a default weight of 1
	 * 
	 * @param edge1
	 * @param edge2
	 */
	public void addEdge(int edge1, int edge2) {

		if (isInBounds(edge1, edge2)) {
			adjacencyMatrix[edge1][edge1] = 1;
		}

	}

	/**
	 * adds a connection between two nodes with the provided weight
	 * 
	 * @param edge1
	 * @param edge2
	 * @param weight
	 */
	public void addEdge(int edge1, int edge2, int weight) {
		if (isInBounds(edge1, edge2)) {
			adjacencyMatrix[edge1][edge2] = weight;
		}

	}

	/**
	 * 
	 * @return whether the graph is a completed graph
	 */
	public boolean isConnected() {
		return false;
	}

	/**
	 * removes an existing connection between two vertices
	 * 
	 * @param edge1
	 * @param edge2
	 */
	public void removeEdge(int edge1, int edge2) {

	}

	/**
	 * deletes a vertex from the adjacency matrix
	 * 
	 * @param vertex
	 */
	public void removeVertex(T vertex) {

	}

	@Override
	public String toString() {
		return printMatrix();
	}

	private String printMatrix() {
		String output = "";
		String returnString;

		// convert the values of vertices to a String
		for (int x = 0; x < this.size; x++) {
			output += vertices.get(x) + " ";
		}
		returnString = "---" + output.trim() + "\n";// the first row of vertices
		String[] outputArray = output.trim().split(" ");
		for (int x = 0; x < this.size; x++) {
			returnString += outputArray[x];
			for (int y = 0; y < this.size; y++) {
				returnString += " " + adjacencyMatrix[x][y] + " ";
			}
			returnString = returnString.trim() + "\n";
		}
		return returnString;
	}

	/**
	 * the number of nodes stored in the matrix, differs from capacity
	 * 
	 * @return
	 */
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return vertices.size() == 0;
	}

	public int getCap() {
		return this.cap;
	}

	@Override
	public boolean hasVertex(T vertex) {
		for (int x = 0; x < vertices.size(); x++) {
			if (String.valueOf(vertices.get(x)).equals(String.valueOf(vertex))) {
				return true;
			}
		}
		return false;
	}

	@Override
	/**
	 * 
	 * @param edge1
	 * @param edge2
	 * @return an edge exists between the two vertices
	 * (both vertices are connected)
	 */
	public boolean hasEdge(T vertex1, T vertex2) {
		// index1 & index2: the indices of the edges in the ArrayList
		int index1 = vertices.indexOf(vertex1), index2 = vertices
				.indexOf(vertex2);
		if (isInBounds(index1, index2)) {
			return adjacencyMatrix[index1][index2] > 0;
		}
		return false;
	}

	private boolean isInBounds(int edge1, int edge2) {
		boolean isInBounds = (edge1 >= 0 && edge2 >= 0)
				&& (edge1 < this.cap && edge2 < this.cap);
		;
		return isInBounds;
	}

	/**
	 * defines numerous edges using the provided array and overrides and
	 * existing edges
	 * 
	 * @param adjacencyMatrix
	 */
	public void setEdge(int[][] adjacencyMatrix) {
		if (adjacencyMatrix.length == this.cap) {
			this.adjacencyMatrix = adjacencyMatrix;

		}
	}

	// return the node at this index
	public T getNode(int index) {
		return vertices.get(index);
	}

	// bfs recursive
	public void bfs(T start) {
		System.out.print("" + "\t");
	}

	/**
	 * recursive implementation of bfs
	 * @param start the index to begin from
	 */
	public void dfs(int start) {
		visited[start]=true;
		System.out.print(vertices.get(start)+" ");
		int j=0;
		for(j=0;j<vertices.size();j++){
			//if there is a path between the two vertices
			//and one of the vertices has not been printed
			if(!visited[j]&&adjacencyMatrix[start][j]>0){
				dfs(j);
			}
		}
		

	}
	

}
