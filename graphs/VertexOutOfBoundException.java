package graphs;

/**
 * @
 * @author Elexie
 *
 */
@SuppressWarnings("serial")
public class VertexOutOfBoundException extends Exception {
	private int vertex;

	public VertexOutOfBoundException(int vertex) {
		this.vertex = vertex;
	}

	public int getVertex() {
		return vertex;
	}
}
