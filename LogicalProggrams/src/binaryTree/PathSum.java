package binaryTree;

import java.util.Stack;

public class PathSum {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		Stack<TreeNode> node_stack = new Stack<>();
		Stack<Integer> sum_stack = new Stack<>();

		node_stack.add(root);
		sum_stack.add(sum - root.data);

		while (!node_stack.isEmpty()) {
			TreeNode current_node = node_stack.pop();
			int current_sum = sum_stack.pop();

			if (current_node.left == null && current_node.right == null && current_sum == 0) {
				return true;
			}
			if (current_node.left != null) {
				node_stack.add(current_node.left);
				sum_stack.add(current_sum - current_node.left.data);
			}
			if (current_node.right != null) {
				node_stack.add(current_node.right);
				sum_stack.add(current_sum - current_node.right.data);
			}

		}

		return false;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node4_ = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		root.left = node4;
		root.right = node8;
		node4.left = node11;
		node8.left = node13;
		node8.right = node4_;
		node11.left = node7;
		node11.right = node2;
		node4_.right = node1;
		
		boolean result = hasPathSum(root,22);
		//boolean result = hasPathSum(root,27);
		System.out.println(result);

	}

}


/*

					5
				   / \	
				   4  8
                  /   /\
                 11  13 4
                / \      \
                7  2      1

true ( 5+4+11+2)=22


*/