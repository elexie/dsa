package lists;
/**
 * A singly linked list is a node that has a link only
	to its successor in this sequence
 * @author Elexie
 *
 */
public class LinkedListlmplementation {

	public int data;
	public LinkedListlmplementation next;
	public LinkedListlmplementation(){
		this.data=0;
		this.next=null;
	}
	public LinkedListlmplementation(int info){
		this(info,null);
	}
	
	public LinkedListlmplementation(int data, LinkedListlmplementation next){
		this.data=data;
		this.next=next;
	}
	public void print(LinkedListlmplementation node){
		String list="";
		while(node!=null){
			System.out.println(node.data);
			node=node.next;
			}
	}
	public static void main(String args[]){
		//create a linked list of numbers from 1 to 10
		LinkedListlmplementation myList=new LinkedListlmplementation();
		myList.data=1;
		myList.next=new LinkedListlmplementation(2);
		
		/*for(int x=0;x<10;x++){
			LinkedListlmplementation tempList=new LinkedListlmplementation(x);
			myList.next=new LinkedListlmplementation(x);
		}
		*/
	}
	void createList(LinkedListlmplementation node){
		
	}
}
