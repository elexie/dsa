package queue;

public class IndexOutOfBoundsException  extends Exception{
	private String message;
	private int index;
	
	public IndexOutOfBoundsException(String message,int index){
		this.index=index;
		this.message=message+". index "+index;

	}
	public String getMessage(){
		return this.message;
	}
	public int getIndex(){
		return this.index;
	}
	
	public void setIndex(int index){
		this.index=index;
	}
	
	public void setMessage(String message){
		this.message=message;
	}
}
