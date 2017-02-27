package stack;

public interface StackListADT<E>{
	public  void push(E e)  throws NullPointerException;
	public  E peek() throws EmptyCollectionException;
	public  E pop() throws EmptyCollectionException;
	public  void reverseStack();
	public  int getSize();
	public  boolean isEmpty();
	public   void clearStack();
	public String toString();
}
