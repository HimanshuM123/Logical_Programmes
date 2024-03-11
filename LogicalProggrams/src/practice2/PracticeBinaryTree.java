package practice2;

import binaryTree.BinaryTreeSum;


public class PracticeBinaryTree {
	
	private static class TreeNode{
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
		}
		
	}
	
	private int  size(TreeNode node) {
		if(node ==null) {
			return 0;
		}
		int left= size(node.left);
		int right= size(node.right);
		
		int size = left + right+1;
		return size;
	}
	
	private int max(TreeNode node) {
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		int left_max= max(node.left);
		int right_max =  max(node.right);
		
		return Math.max(Math.max(left_max, right_max),node.data);
		
	}
	
	private int min(TreeNode node) {
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		
		int left_min = min(node.left);
		int right_min = min(node.right);
		return Math.min(Math.min(left_min, right_min),node.data);
	}
	
	private int height(TreeNode node) {
		if(node == null ) {
			return 0;
		}
		
		int left_height = height(node.left);
		int rigth_height = height(node.right);
		
		int max_height = Math.max(left_height, rigth_height);
		
		return max_height+1;
		
		
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

		PracticeBinaryTree bt = new PracticeBinaryTree();
		int size = bt.size(rootNode);
		System.out.println("The size is "+size);
		int max = bt.max(rootNode);
		System.out.println("The maximum element is "+max);
		int min = bt.min(rootNode);
		System.out.println("The minimum element is "+min);
		int height = bt.height(rootNode);
		System.out.println("The maximum height is "+height);
//		int sum = bt.sum(rootNode);
//		System.out.println("The sum is "+sum);
	}

}
