package stack;

public  interface StackArrayADT<E> {
	public abstract void push(E e);
	public abstract E peek() throws EmptyCollectionException;
	public abstract E pop() throws EmptyCollectionException;
	public abstract E[] reverseStack();
	public abstract int getSize();
	public abstract boolean isEmpty();
	public abstract E[] condense();
	public abstract E[] doubleCapacity(int c);
	public abstract E[] clearStack();
}
