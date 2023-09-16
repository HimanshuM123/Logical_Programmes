package binaryTree;

import java.util.Stack;

public class BinaryTreeMaxElement {

	private static class TreeNode {

		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

	}

	private int calculateMax(TreeNode root) {
		int max = 0;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		
		while (!st.isEmpty()) {
			TreeNode node = st.pop();
			
			if(max < node.data) {
				max = node.data;
			}
			
			if(node.left!=null) {
				st.push(node.left);
			}
			
			if (node.right!=null) {
				st.push(node.right);
			}
		}

		return max;

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

		BinaryTreeMaxElement bt = new BinaryTreeMaxElement();
		
		int max = bt.calculateMax(rootNode);
		System.out.println("The Maximum element is "+max);

	}

}
