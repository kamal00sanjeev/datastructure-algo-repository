package com.ds.bt;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	private static class Node {
		private Integer data;
		private Node left;
		private Node right;

		public Node(Integer value) {
			data = value;
			left = right = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	public Integer getRootData() {
		return root.data;
	}

	/**
	 * * Java function to check if binary tree is empty or not * Time Complexity of
	 * this solution is constant O(1) for * best, average and worst case. *
	 * * @return true if binary search tree is empty
	 */
	public boolean isEmpty() {
		return null == root;
	}

	private Node addNodeRecursively(Node current, Integer val) {
		if (current == null) {
			return new Node(val);
		}
		if (val < current.data) {
			current.left = addNodeRecursively(current.left, val);
		} else if (val > current.data) {
			current.right = addNodeRecursively(current.right, val);
		} else {
			return current;
		}
		return current;
	}

	// add node to binary search tree
	public void add(Integer value) {
		root = addNodeRecursively(root, value);
	}

	// check whether binary tree contains specified value or not
	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.data) {
			return true;
		}
		return value < current.data ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	// Traverse node items in binary search tree - inorder
	public void inOrderTraversal(Node currentNode) {
		if (currentNode != null) {
			inOrderTraversal(currentNode.left);
			System.out.print(currentNode.data + ", ");
			inOrderTraversal(currentNode.right);
		}
	}

	// Traverse node items in binary search tree - preorder
	public void preOrderTraversal(Node currentNode) {
		if (currentNode != null) {
			System.out.print(currentNode.data + ", ");
			inOrderTraversal(currentNode.left);
			inOrderTraversal(currentNode.right);
		}
	}

	// Traverse node items in binary search tree - postorder
	public void postOrderTraversal(Node currentNode) {
		if (currentNode != null) {
			inOrderTraversal(currentNode.left);
			inOrderTraversal(currentNode.right);
			System.out.print(currentNode.data + ", ");
		}
	}

	// Breadth search - level order traversal
	public void levelOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("BST is empty");
			return;
		}
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		while (!nodeQ.isEmpty()) {
			Node tmpNode = nodeQ.remove();
			if (tmpNode.left != null) {
				nodeQ.add(tmpNode.left);
			}
			if (tmpNode.right != null) {
				nodeQ.add(tmpNode.right);
			}
			System.out.print(tmpNode.data + ", ");
		}
	}

	public Node deleteNodeInBST(Node root, Integer item) {
		// If tree doen't have the specified value
		if (!containsNode(item)) {
			System.out.println("Binary tree doesn't contain the value: " + item);
			return root;
		}

		Node current = root;
		// if root node is null
		if (null == current) {
			return current;
		}

		if (item < current.data) {
			current.left = deleteNodeInBST(current.left, item);
		} else if (item > current.data) {
			current.right = deleteNodeInBST(current.right, item);
		} else {
			// if current node is leaf node i.e. has no child node
			if (current.left == null && current.right == null) {
				current = null;
				System.out.println("Deleting data: " + item);
				return null;
			} else if (current.left == null) {
				// node with one node (no left node)
				System.out.println("Deleting data: " + item);
				return current.right;
			} else if (current.right == null) {
				// node with one node (no right node)
				System.out.println("Deleting data: " + item);
				return current.left;
			} else {
				// node has both left and right node
				Integer minVal = getMinVal(current.right);
				current.data = minVal;
				current.right = deleteNodeInBST(current.right, minVal);
				System.out.println("Deleting data: " + item);
			}
		}
		return current;
	}

	// Find minimum element among subtree of specified node
	public Integer getMinVal(Node node) {
		if (node.left != null) {
			return getMinVal(node.left);
		}
		return node.data;
	}

	// find maximum element among subtree of specified node
	public Integer getMaxVal(Node node) {
		if (node.right != null) {
			return getMaxVal(node.right);
		}
		return node.data;
	}

	public Integer getBSTHeight(Node node) {
		if (node == null) {
			return -1;
		}
		return Math.max(getBSTHeight(node.left), getBSTHeight(node.right)) + 1;
	}

}
