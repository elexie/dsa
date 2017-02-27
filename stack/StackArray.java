package stack;

public class StackArray<E> implements StackArrayADT<E> {
	
	/**
	 * size: number of elements in the stack
	 * capacity: total number of slots in the array
	 * index: index of the element at the top of the stack
	 */
	E[] stack;
	private int capacity;
	private int index;
	private int size;
	
	public StackArray(E[] stack){
		this.size=findSize(stack);
		this.capacity=stack.length;
		this.stack= stack;
		this.index=(stack.length)-1;
	}
	public StackArray(){
		this.size=0;
		this.capacity=0;
		this.stack=(E[]) new Object[capacity];
		this.index=0;
	}

	@Override
	public void push(E e) {
		if(this.size==this.capacity){
			if(size==0)
			{
				//parameter 1 because the initial
				//capacity is 0
			this.stack=doubleCapacity(1);
			}
			else{
				this.stack=doubleCapacity(this.capacity);
			}
		}
		stack[index]=e;
		index++;
		size++;
	}
	
	@Override
	public E pop() throws EmptyCollectionException {
		if(this.size==0){
			throw new EmptyCollectionException("Stack is Empty. Cannot pop");
		}
		else{
			E popped=stack[index];
			index--;
			size--;
			return popped;
		}

	}
	
	@Override
	public E peek() throws EmptyCollectionException {
		if(this.size==0){
			throw new EmptyCollectionException("Stack is empty. Cannot peek");
		}
		else{
			return stack[index];
		}
	}
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return getSize()==0;
	}

	@Override
	public E[] condense() {
	E[] condensed=(E[]) new Object[this.size];
	for(int x=0;x<(this.size);x++){
		condensed[x]=stack[x];	
	}
	return condensed;	
	}
	
	@Override
	public E[] reverseStack() {
		
		return null;
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	@Override
	public E[] doubleCapacity(int c) {
	E[] newStack=(E[]) new Object[c*2];
	for(int x=0;x<this.size;x++){
		newStack[x]=this.stack[x];
	}
	this.capacity=newStack.length;
	return newStack;
	}
	
	private int findSize(E[] stack){
		int size=0;
		for(int x=0;x<(stack.length);x++){
			if(stack[x]!=null){
				size+=1;
			}
			else{
			break;	
			}
		}
	return size;
	}
	
	public String toString(){
		String string="";
		for(int x=0;x<(this.size);x++){
			string+=this.stack[x]+"\n";
		}
		return string.trim();
	}
	@Override
	public E[] clearStack() {
		int size=this.size;
		for(int x=0;x<size;x++){
			
		}
		return this.stack;
	}
}
