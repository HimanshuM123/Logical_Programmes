package binaryTree;


public class BinaryTreeSum {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

	}

	private int size(TreeNode node) {
		if (node==null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		int ts = ls + rs + 1;
		return ts;

	}
	
	private int max (TreeNode node) {
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		int left_max = max(node.left);
		int right_max = max(node.right);
		int max = Math.max(Math.max(left_max, right_max),node.data);
		return max;
	}
	
	private int height(TreeNode node) {
		if(node== null) {
			return 0;
		}
		int left_height = height(node.left);
		int right_height = height(node.right);
		int max_height = Math.max(left_height, right_height)+1;
		return max_height;
	}

	public static void main(String[] args) {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		BinaryTreeSum bt = new BinaryTreeSum();
		int size = bt.size(rootNode);
		System.out.println("The size is "+size);
		int max = bt.max(rootNode);
		System.out.println("The maximum element is "+max);
		int height = bt.height(rootNode);
		System.out.println("The maximum height is "+height);
	}

}

/*
	  40
	/    \
	20     60
	/  \    / \
	10   30 50 70

*/
