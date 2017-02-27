package stack;

public class StackList<E> implements StackListADT {

	private Node top;// node at the head of the stack
	private Node bottom;// first node placed in the stack
	private Node current;// will be used to loop through the stack
	private Node newNode;
	private Node prevNode;
	private int size;// number of nodes in stack

	public StackList() {
		this.top = null;
		this.bottom = null;
		this.size = 0;
	}

	@Override
	public void push(Object e) throws NullPointerException {
		if (e == null) {
			throw new NullPointerException(
					"Cannot push a null value on the stack");
		} else {
			newNode = new Node((E) e);
			if (top == null) {
				top = newNode;
				bottom = newNode;
			} else {
				top.setNext(newNode);
				newNode.setNext(null);
				top = newNode;
			}
			size += 1;
		}
	}

	@Override
	public E peek() throws EmptyCollectionException {
		if (top == null) {
			throw new EmptyCollectionException("Stack is empty. Cannot peek");
		} else {
			return top.getData();
		}
	}

	@Override
	public E pop() throws EmptyCollectionException {
		E popped;
		newNode = new Node();
		prevNode = new Node();
		if (top == null) {
			throw new EmptyCollectionException("Stack is empty. Cannot pop");
		} else {
			popped = top.getData();
			if (this.size == 1) {
				prevNode = new Node(); // null
				bottom = prevNode;
				top = prevNode;
				size--;
				return popped;
				// top.setNext(newNode): null pointer.this is the same as
				// null.setNext(newNode)
			} else {
				int x = 1;
				current = bottom;

				while (current != null) {
					if (x == this.size - 1)// if we are at the node that
											// precedes 'top'
					{
						prevNode = current;
						newNode = null;
						break;
					}
					current = current.getNext();
					x++;
				}
			}
			top = prevNode;
			top.setNext(newNode);
			size--;
			return popped;
		}
	}

	@Override
	public void reverseStack() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void clearStack() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		
		String[] dataArray=new String[this.size];
		current=bottom;
		int len=dataArray.length;
		for(int x=0;x<len;x++){
			dataArray[x]=""+current.getData();
			current=current.getNext();
		}
		String dataStr="";
		
		//insert dataArray[N] to dataArray[0] into dataStr
		for(int x=len-1;x>-1;x--){
			dataStr+=dataArray[x]+"\n";
		}
		return dataStr;
	}

	public E getTop() {
		return this.top.data;
	}

	public E getBottom() {
		return this.bottom.data;
	}

	private class Node {
		private E data;
		private Node next;

		public Node(E e) {
			this.data = e;
			this.next = null;
		}

		public Node() {
			this.data = null;
			this.next = null;
		}

		public E getData() {
			return this.data;
		}

		public Node getNext() {
			return this.next;
		}

		public void setData(E data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
