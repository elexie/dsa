package stack;

public class EmptyCollectionException extends Exception{
	String message;
	public EmptyCollectionException(String message) {
		this.message=message;
	}
}
