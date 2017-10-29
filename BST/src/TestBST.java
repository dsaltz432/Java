
public class TestBST {

	public static void main(String[] args) {
		
		System.out.println("\nStarting tests\n");
		
		BST<Integer> tree = new BST<Integer>();
		
		// testing insert()
		System.out.println("Inserting integers into the tree");
		tree.insert(12);
		tree.insert(20);
		tree.insert(14);
		tree.insert(5);
		tree.insert(7);
		tree.insert(3);
		tree.insert(2);
		
		// testing printPreOrder
		System.out.println("\nPrinting pre order");
		tree.printPreOrder();
		
		// testing printInOrder
		System.out.println("\nPrinting in order");
		tree.printInOrder();
		
		// testing printPostOrder
		System.out.println("\nPrinting post order");
		tree.printPostOrder();
		
		// testing lookup()
		System.out.println("\nTesting insert()");
		System.out.println("Is 5 in the tree? " + tree.lookup(5));
		System.out.println("Is 4 in the tree? " + tree.lookup(4));
		System.out.println("Is 33 in the tree? " + tree.lookup(33));

		// testing delete()
		System.out.println("\nDeleting 3 and 20");
		tree.delete(3);	
		tree.delete(20);	
		System.out.println("\nNew Tree: ");
		tree.printInOrder();
		
		System.out.println("\nEnding tests\n");
	}

}
