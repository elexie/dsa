package graphs;

public class Main {

	public static void main(String[] args) {
		int[] nodes = { 40, 10, 20, 30, 60, 50, 70 };
		String matrixName = "adj";
		int cap = 7;
		AdjacencyMatrix<Integer> adj = new AdjacencyMatrix<>(cap);
		System.out.println("Created an empty matrix [" + matrixName
				+ "] with capacity [" + cap + "]");
		System.out.println("adj.getCap(): " + adj.getCap());
		System.out.println("adj.isEmpty(): " + adj.isEmpty());
		for (int x = 0; x < nodes.length; x++) {
			adj.addVertex(nodes[x]);
		}
		System.out.println("Added the array: "
				+ java.util.Arrays.toString(nodes) + " to adj");

		System.out.println("adj.hasVertex(40): " + adj.hasVertex(40));
		System.out.println("adj.hasVertex(400): " + adj.hasVertex(400));
		System.out.println("adj.hasVertex(70): " + adj.hasVertex(70));
		System.out.println("adj.hasVertex(30): " + adj.hasVertex(30));
		System.out.println("adj.hasVertex(-1): " + adj.hasVertex(-1));

		System.out.println("\nAdded 7 nodes");
		System.out.println("adj.getSize(): " + adj.getSize());
		System.out.println("adj.toString():\n" + adj);

		int adjMatrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};
		adj.setEdge(adjMatrix);
		System.out.println("adj.setEdge(adjMatrix):");
		System.out.println(adj);
		
		//hasEdge
		System.out.println("\nadj.hasEdge(10,20):" + adj.hasEdge(10, 20));
		System.out.println("adj.hasEdge(20,10):" + adj.hasEdge(20, 10));
		System.out.println("adj.hasEdge(50,20):" + adj.hasEdge(50, 20));
		System.out.println("adj.hasEdge(70,70):" + adj.hasEdge(70, 70));
		System.out.println("adj.hasEdge(20,40):" + adj.hasEdge(20, 40));
		System.out.println("adj.hasEdge(20,40):" + adj.hasEdge(20, 10));
		System.out.println("adj.hasEdge(50,70):" + adj.hasEdge(50, 70));

		//addEdge 
		for (int x = 0; x < adj.size; x++) {
			adj.addEdge(x, x, Integer.valueOf(adj.getNode(x)));
		//	System.out.println(x);
		}
		System.out.println("\nconnect every vertex to itself and define"
				+ "\nthe weight of the edge as the same value of that vertex"
				+ "\n" + adj);

		//bfs and dfs
		System.out.println("\ndfs:");
		adj.dfs(0);
		adj.dfs(adj.getNode(0));
	}

}
