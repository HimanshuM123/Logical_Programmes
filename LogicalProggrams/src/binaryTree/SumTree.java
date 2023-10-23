package binaryTree;

public class SumTree {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private static void print(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		print(node.left);
		print(node.right);
	}

	private static int sum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int sum_left = sum(node.left);
		int sum_right = sum(node.right);
		int total_sum = sum_left + sum_right + node.data;
		return total_sum;

	}
	
	private static boolean isSumTree(TreeNode node) {

		int left_sum = sum(node.left);
		int right_sum = sum(node.right);
		boolean flag = false;
		if (left_sum + right_sum == node.data) {
			flag = true;
		}
		return flag;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(26);
		TreeNode node10 = new TreeNode(10);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node3_1 = new TreeNode(3);
		root.left = node10;
		root.right = node3;
		node10.left = node4;
		node10.right = node6;
		node3.right = node3_1;

		print(root);
		int sum = sum(root);
		System.out.println("The sum is " + sum);
		boolean flag = isSumTree(root);
		if(flag ) {
			System.out.println("The tree is sumtree");
		}

	}
}


/*

		26
	   /  \
	   10  3
      / \   \
      4  6   3


*/
