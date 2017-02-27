package graphs;

//http://www1.cs.columbia.edu/~bert/courses/3134/slides/Lecture16%20(examples%20cut).pdf
//http://www.cs.cmu.edu/~pattis/15-1XX/15-200/lectures/graphs/
//http://opendatastructures.org/ods-java/12_1_AdjacencyMatrix_Repres.html
//opendatastructures.org/ods-java/12_1_AdjacencyMatrix_Repres.html
//http://www.algolist.net/Data_structures/Graph/Internal_representation
//http://support.csis.pace.edu/CSISWeb/docs/techReports/techReport224.pdf
//http://www.wou.edu/~jcm/WebPageSpring2014/Postings/GraphADTIntro.pdf

public abstract class GraphADT<T> {

	public abstract void addVertex(T vertex);

	public abstract void addEdge(int edge1, int edge2);

	public abstract void addEdge(int edge1, int edge2, int weight);

	public abstract boolean isConnected();

	public abstract void removeEdge(int edge1, int edge2);

	public abstract void removeVertex(T vertex);

	public abstract String toString();

	public abstract int getSize();

	public abstract boolean isEmpty();

	public abstract boolean hasEdge(T vertex1, T vertex2);

	public abstract boolean hasVertex(T vertex);

}
