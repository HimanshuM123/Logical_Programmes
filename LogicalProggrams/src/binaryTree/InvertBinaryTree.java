package binaryTree;

public class InvertBinaryTree {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;

		}
	}
	
	private static TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return root;
		}
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		root.right=left;
		root.left=right;
		
		return root;
		
	}
	
	private static void printTree(TreeNode root) {
		if(root== null) {
			return;
		}
		System.out.print(root.data+"  ");
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);
		root.left = node2;
		root.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;
		printTree(root);
		invertTree(root);
		System.out.println();
		printTree(root);

	}

}

/*
			4
		  /  \
		  2    7
         / \  / \
        1   3 6  9
        
        inverted Tree ->
        	4
		  /  \
		  7    2
         / \  / \
        9   6 3  1
        

*/


