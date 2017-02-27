package queue;

public class IllegalStateException extends Exception{
private String message;

	public IllegalStateException(String message){
		this.message=message;
	}
public String getMessage(){
	return this.message;
}
}
