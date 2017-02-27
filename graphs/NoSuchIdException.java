package graphs;
@SuppressWarnings("serial")
public class NoSuchIdException extends Exception {

	private String id;

	public NoSuchIdException(String id) {
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
}
