package com.ds.bt;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();
		
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    bt.add(45);
	    
	    System.out.println(bt.containsNode(10));
	    bt.inOrderTraversal(bt.getRoot());
	    System.out.println();
	    bt.preOrderTraversal(bt.getRoot());
	    System.out.println();
	    bt.postOrderTraversal(bt.getRoot());
	    System.out.println();
	    
	    System.out.println("Root : "+bt.getRootData());
	    System.out.println("BST height: "+bt.getBSTHeight(bt.getRoot()));
	    System.out.println("Max item in binary search tree is: "+bt.getMaxVal(bt.getRoot()));
	    System.out.println("Min item in binary search tree is: "+bt.getMinVal(bt.getRoot()));
	    bt.deleteNodeInBST(bt.getRoot(), 10);
	    bt.deleteNodeInBST(bt.getRoot(), 7);
	    bt.deleteNodeInBST(bt.getRoot(), 5);
	    bt.inOrderTraversal(bt.getRoot());
	    System.out.println();
	    
	    System.out.println("Level order traversal: ");
	    bt.levelOrderTraversal(bt.getRoot());
	}

}
