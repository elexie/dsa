package lists;

import java.io.ObjectInputStream.GetField;

//http://www.mycstutorials.com/articles/data_structures/linkedlists
/**
 * 
 * @author Elexie This LinkedList implementation uses two classes: LinkedList
 *         and Node, a private class that acts as node objects in the linked
 *         lists
 * 
 *         The index of the list begins at 0
 *
 */
public class LinkedList {
	Node head;// the head node in the list
	int listCount;// number of nodes in the list
	int minIndex;// index of the firstElement
	int currentIndex;// position of the last valid index in the list

	/**
	 * @param minIndex
	 * 
	 */
	public LinkedList(int minIndex) {
		this.head = null;
		this.listCount = 0;
		this.minIndex = minIndex;
		this.currentIndex = minIndex;
	}

	void setMinIndex(int minIndex) {
		this.minIndex = minIndex;
	}

	/**
	 * Appends a new node to the end of the list
	 * 
	 * @param data
	 *            the data to be store in the new Node;
	 */
	void add(Object data) {

		// if: the list is empty

		// else: the list is not empty

		Node newNode = new Node(data);
		if (this.listCount == 0) {
			this.head = newNode;
			newNode.setIndex(minIndex);
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
			increaseCurrentIndex();
			newNode.setIndex(currentIndex);
		}
		this.listCount += 1;
	}

	/**
	 * Places a Node object at the specified index in the list, and shifts
	 * every Node after 'index' down 1. 
	 * 0<=index<size
	 * 
	 * @param data
	 *            the data to be stored in the node
	 * @param index
	 *            the index of the new Node
	 */
	void add(Object data, int index) {
		// if: the index is in range
		// if: index==first position in list
		// else: index>=minIndex and is a position within list
		// or last position in the list

		Node newNode = new Node(data);
		Node temp;
		boolean isInRange=index >= minIndex && index < listCount;
		if (isInRange) {
			if (index == minIndex || isEmpty()) {
				temp = this.head;
				newNode.next = temp;
				this.head = newNode;
				newNode.setIndex(this.minIndex);
			} else {
				temp = this.getNode(index);
				this.getNode(index - 1).setNext(newNode);
				newNode.setNext(temp);
				newNode.setIndex(temp.getIndex());
			}
			// increase all nodes after 'index' by one
			this.increaseIndices(index);
			increaseCurrentIndex();
			listCount += 1;
		} else {
			System.out.println("from_add: index is out of range");
		}

	}

	/**
	 * increases the index of every node after 'beginIndex' by 1
	 * 
	 * @param beginIndex
	 *            the index to begin from
	 */
	private void increaseIndices(int beginIndex) {
		boolean isInRange= beginIndex>=minIndex && beginIndex<=(currentIndex+1);
	//note: && beginIndex<=(currentIndex+1) and not && beginIndex<currentIndex
	//because if we call the add(Object, index) method, we might have to create
	//an additional index when we shift an element
			if(isInRange){
			Node current = this.getNode(beginIndex).getNext();
			while (current != null) {
				current.setIndex(current.getIndex() + 1);
				current = current.getNext();
			}
		}
		
	}


	/**
	 * Removes the specified index and shifts
	 * every succeeding index down 1
	 * @param index
	 *            the index to remove minIndex<=index<listSize
	 */
	void remove(int index) {		
		boolean isInRange = index >= minIndex && index < listCount;
		if (isInRange) {//	minIndex<=index<listCount

			//removing an element from the head of the list
			if (index == minIndex) {
				this.head = head.getNext();
				head.setIndex(minIndex);
			} 
			else{	//from the end of the list or within the list
				
				//end of the list
				if(index==currentIndex){
					this.getNode(index-1).setNext(null);
				}
				
				//within the list, and neither the last or first
				else{
					this.getNode(index-1).setNext(this.getNode(index+1));
				}
			}

			listCount -= 1;
			this.decreaseCurrentIndex();
			this.decreaseIndices(index);
			
		} else {

		}
	}
	
	public void increaseCurrentIndex() {
		this.currentIndex += 1;
	}

	public void decreaseCurrentIndex() {
		if(listCount>minIndex)
		{
		this.currentIndex -= 1;
		}
	}

	/**
	 * decreases the index of every node after
	 * beginIndex
	 * minIndex<=beginIndex<listCount
	 * @param beginIndex
	 */
	void decreaseIndices(int beginIndex) {
		boolean isInRange=beginIndex>=minIndex && beginIndex<listCount;
		if(isInRange){
			Node current = this.getNode(beginIndex).getNext();
			System.out.println("current: "+current);
			while (current != null) {
				current.setIndex(current.getIndex() - 1);
				current = current.next;
			}
			
		}
	
	}

	/**
	 * 
	 * @return the size of the list
	 */
	int size() {
		return this.listCount;
	}

	/**
	 * Returns the Node at the specified index
	 * 
	 * @param index
	 *            the index
	 * @return the Node object
	 */
	Node getNode(int index) {
		boolean isInRange=index>=minIndex && index<listCount;
		if(isInRange){
			Node current = head;
			while (current.getIndex() != index) {
				current = current.getNext();
			}
			return current;
		}
		
		return null;
	}

	/**
	 * 
	 * @param data
	 * @return the index of the given data
	 */
	Object getIndex(Object data) {
		Node current = head;
		// the unary operator gives the opposite of the condition it precedes
		while (!(current.getData().equals(data)) && current.getNext() != null) {
			current = current.getNext();
		}
		return current.getIndex();
	}

	/**
	 * 
	 * @param index
	 *            the index to find
	 * @return the data at the specified index
	 */
	Object getData(int index) {
		return getNode(index).getData();
	}

	/**
	 * @return a string representation of the data stored in each node
	 */
	public String toString() {
		String returnString = "";
		if (!isEmpty()) {
			Node current = head.getNext();
			while (current != null) {
				returnString += current.getData().toString() + " ";
				current = current.getNext();
			}
			return head.getData() + " " + returnString;
		}

		return returnString.trim();
	}

	/**
	 * 
	 * @return the size of the list
	 */
	public int getSize() {
		return this.listCount;
	}

	public boolean isEmpty() {
		return this.listCount == 0;
	}

	/**
	 * 
	 * @param data
	 *            the data to search for
	 * @return whether the list contains a node that has this data
	 */
	boolean contains(Object data) {
		// if: the list is empty
		// else: there is at least 1 element in the list

		Node current = head;

		if (this.isEmpty()) {
			// throw an exception
		} else {
			while (current.getData() != null) {
				if (current.data == data) {
					return true;
				}
				current = current.getNext();
			}
		}

		return false;
	}

	/**
	 * 
	 * @return an array of the data in each node
	 */
	public Object[] toArray() {
		Object[] array = new Object[this.getSize()];
		System.out.println("size_from toArray: "+this.getSize());
		Node current = head;
		int arrayIndex = 0;
		while (current != null) {
			array[arrayIndex] = current.getData();
		//	System.out.println("arrayIndex: "+getData(arrayIndex));
			current = current.getNext();
			arrayIndex++;
		}
		return array;
	}

	public int getCurrentIndex() {
		return this.currentIndex;
	}

	/**
	 * Utilizes basic control statement and 
	 * avoids for loops
	 * @return a String of all data stored in each node, 
	 * reversed
	 */
	public String reverseList(){
		Object[] listArray=this.toArray();
		int listArrayLength=listArray.length;
		String returnString="";
		for(int x=listArrayLength-1;x>-1;x--){
		//	System.out.println(listArray[x]);
			returnString+=listArray[x]+" ";
		}
		return returnString.trim();
	}
	/**
	 * replaces the data stored in the 
	 * node at the specified index
	 * @param data
	 * @param index
	 */
	void replace(int index, Object data){
		boolean isRange=minIndex<=index && index<listCount;
		if(isRange){
			this.getNode(index).setData(data);
		}
		
	}
	/**
	 * reverses the Node objects of the
	 * list, not just the data stored in
	 * the node
	 */
	void reverseLinkedList(){
		
	}
	public static void main(String[] args) {
		String[] names = new String[11];
		names[0] = "Abe";
		names[1] = "Alice";
		names[2] = "Amy";
		names[3] = "Ben";
		names[4] = "Branda";
		names[5] = "Brandon";
		names[6] = "Cain";
		names[7] = "Caleb";
		names[8] = "Drew";
		names[9] = "Eva";
		names[10] = "Frank";
		int minIndex = 0;
		LinkedList myList = new LinkedList(minIndex);
		int maxElements = 7;

		System.out.println("Minimum Index: " + minIndex);
		// test add(Object data), getSize(), and getData(int index)
		// add 7 elements to the list
		System.out.println("Add " + maxElements + " elements to the list");
		for (int x = minIndex; x < maxElements; x++) {
			myList.add(names[x]);
		}
		int listSize = myList.getSize();

		System.out.println("\nTest getNode()");

		// test getNode()
		for (int x = minIndex; x < listSize; x++) {
			System.out.println("Node[" + x + "]: " + myList.getNode(x));
		}

		// test getData()
		System.out.println("\nTest getData()");
		for (int x = minIndex; x < listSize; x++) {
			System.out.println("Data in Node[" + x + "]: " + myList.getData(x));
		}

		// test contains()
		System.out.println("\nTest contains()");
		for (int x = minIndex; x < listSize; x++) {
			System.out.println("List Contains " + names[x] + ": "
					+ myList.contains(myList.getData(x)));
		}

		// test currentIndex
		int currentIndex = myList.getCurrentIndex();
		System.out.println("\nList Size: " + listSize + "\nCurrent Index: "
				+ currentIndex);

		// test add(Obj data, int index)
		System.out
				.println("\nAdd \"Caleb\" to index 6 of the list using add(\"Caleb\", 6) ");
		myList.add("Caleb", 6);
		System.out.println("Data at index " + 6 + ": " + myList.getData(6));

		// Make sure the Element at index 6 was shifted to index 7
		System.out
				.println("\nMake sure the Element at index 6 was shifted to index 7");
		System.out.println("Element at 7 should be Cain: " + myList.getData(7));

		// test size and current index again
		System.out.println("\nTest size and current index again");
		System.out.println("List size: " + myList.getSize());
		System.out.println("Current Index: " + myList.getCurrentIndex());

		// print the list as a String
		String listString = myList.toString();
		System.out.println("\nThe list as a String: \n" + listString);
		
		
		// convert the list to an array
		System.out.println("\nConvert the List to an array");
		Object[] convertedList = myList.toArray();
		for (int x = 0; x < convertedList.length; x++) {
			System.out.println(x + ":" + convertedList[x]);
			}
		
		//test remove method
		currentIndex=myList.getCurrentIndex();
		System.out.println("\nTest the remove method");
		System.out.println("Current index: "+currentIndex);
		System.out.println("myList.remove("+currentIndex+")");
		System.out.println("List Size: "+myList.getSize());
		myList.remove(currentIndex);
		System.out.println("New List Size: "+myList.getSize());
		
		currentIndex=myList.getCurrentIndex();
		System.out.println("Current Index is now: "+currentIndex);
		System.out.println("Object at currentIndex: "+myList.getData(currentIndex));
		System.out.println("New List size : "+myList.size());		
		
		//test reverseString() method
		System.out.println("\nPrint the list, reversed");
		System.out.println("size_from main: "+myList.size());
		String reversedList=myList.reverseList();
		System.out.println(reversedList);
		
		//test replace()
		System.out.println("\nReplace Abe with Abraham");
		myList.replace(0,"Abraham");
		System.out.println("Node[0]: "+myList.getData(0));
	/*	*/
		

	}

	private class Node {

		Node next;
		Object data;
		private int index;

		/**
		 * next: Next node in the list data: the content stored in the node
		 * object index: index of this node in the list
		 */

		/**
		 * constructor that save the data in the node and initializes 'next' to
		 * null
		 * 
		 * @param data
		 */
		public Node(Object data) {
			this.data = data;
			next = null;
		}

		/**
		 * 
		 * @param data
		 *            data to store in the node
		 * @param next
		 *            next node in the list
		 */
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
			index = 0;
		}

		Object getData() {
			return this.data;
		}

		Node getNext() {
			return this.next;
		}

		int getIndex() {
			return this.index;
		}

		void setData(Object data) {
			this.data = data;
		}

		void setNext(Node next) {
			this.next = next;
		}

		private void setIndex(int index) {
			this.index = index;
		}

	}
}
