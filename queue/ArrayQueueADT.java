package queue;
/**
 * Interface for an array based implementation
 * of a Queue data structure
 * 
 * @T a generic data type
 * @author Elexie Munyeneh
 * 
 */
public interface ArrayQueueADT<T> {
	public abstract void enqueue(T data) throws IndexOutOfBoundsException;
	T dequeue() throws IllegalStateException;
	T peekFront();
	T peekBack();
	boolean isFull();
	boolean isEmpty();
	String toString();
}
