package bst;

public class BST {
	private class TNode{
		public int item;
		public TNode left;
		public TNode right;
		public TNode(int newItem) {
			item = newItem;
			left = null;
			right = null;
		}
	}
	
	private TNode root;
	
	public BST() {
		root = null;
	}
	
	private TNode insert(TNode curnode, int newItem) {
		if (curnode == null) {
			return new TNode(newItem);
		}
		else if (newItem < curnode.item) {
			curnode.left = insert(curnode.left, newItem);
		}
		else
			curnode.right = insert(curnode.right,newItem);
		
		return curnode;
	}
	
	
	private int findItem(TNode curnode, int gItem) {
		if(curnode == null) {
			return Integer.MIN_VALUE;	
		}
		else if(curnode.item == gItem) {
			return curnode.item;
		}
		else if(gItem < curnode.item) {
			return findItem(curnode.left, gItem);
		}
		else {
			return findItem(curnode.right, gItem);			
		}		
	}
	
	public void putItem(int newItem){
		root = insert(root, newItem);
	}
	
	public int getItem(int gItem) {
		return findItem(root, gItem);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private void printNodes(TNode curnode) {
		if (curnode != null) {
			printNodes(curnode.left);
			System.out.print(curnode.item + ", ");
			printNodes(curnode.right);
		}
	}
	
	public void printTree() {
		if (isEmpty()) {
			System.out.println("Empty Tree!");
		}
		else
			printNodes(root);
			System.out.println("\b\b");
	}
	
}
