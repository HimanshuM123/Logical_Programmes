package binaryTree;

/*
The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Each node (item in the tree) has a distinct key.
 */
public class CheckForBST {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private static int maxValue(TreeNode node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int left_max = maxValue(node.left);
		int right_max = maxValue(node.right);
		return Math.max(Math.max(left_max, right_max), node.data);

	}

	private static int minValue(TreeNode node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int left_max = minValue(node.left);
		int right_max = minValue(node.right);
		return Math.min(Math.min(left_max, right_max), node.data);

	}

	private static int isBST(TreeNode node) {
		if (node == null) {
			return 1;
		}
		if (node.left != null && maxValue(node.left) > node.data) {
			return 0;
		}
		if (node.right != null && minValue(node.right) < node.data) {
			return 0;
		}

		if (isBST(node.left) != 1 || isBST(node.right) != 1) {
			return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		node4.left = node2;
		node4.right = node5;
		node2.left = node1;
		node2.right = node3;

		int result = isBST(node4);
		if (result == 1) {
			System.out.println("The BinaryTree is BST");
		} else {
			System.out.println("The BinaryTree is NOT BST");
		}

	}

}


/*
          4
         / \
        2   5
       / \
      1   3


*/