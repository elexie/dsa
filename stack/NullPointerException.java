package stack;

public class NullPointerException extends Exception{
	private String message;
	public NullPointerException(String message){
		this.message=message;
	}
	
	public String getMessage(){return this.message;}
}
