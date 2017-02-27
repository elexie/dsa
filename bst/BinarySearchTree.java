package bst;

public class BinarySearchTree {
	public static Node root;
	public BinarySearchTree(){
		root=null;
	}
	
	public boolean find(int id){
		Node current=root;
		while(current!=null){
			if(current.data==id)
				return true;
			if(id>current.data)
				current=current.right;
			if(id<current.data)
				current=current.left;	
		}
	return false;	
	}

	public void insert(int data){
		if(root==null)
			root=new Node(data);
		else{
			Node current=root;
			Node parent=current;

			while(true){
				parent=current;
				if(data>current.data)
					current=current.right;
						if(current==null)
						{
						parent.right=new Node(data);
						return;	
						}
							
				if(data<current.data)
					current=current.left;
						if(current==null)
						{
						parent.left=new Node(data);
							return;	
						}			
			}
		}
		
	}
	
	public void display(Node node){
		if(node!=null){
			display(node.left);
			System.out.println(node.data);
			display(node.right);
		}
	
	}

	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public static void main(String[] args) {
	BinarySearchTree bst=new BinarySearchTree();
	bst.insert(7);
	bst.insert(5);
	bst.insert(3);
	bst.insert(12);
	bst.display(root);
	}
	

}
