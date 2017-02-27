package bst;

public class ABinarySearchTree extends BinarySearchTree{

	public static void main(String[] args) {
		ABinarySearchTree a_bst=new ABinarySearchTree();
		BinarySearchTree parent=new BinarySearchTree();

		a_bst.insert(9);
		a_bst.insert(5);
		a_bst.insert(16);
		parent.display(root);
	}

}
