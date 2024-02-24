package binaryTree;

public class SymetricTree {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private boolean areMirror(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		boolean left_mirror = areMirror(a.left, b.right);
		boolean right_mirror = areMirror(a.right, b.left);
		boolean both_mirror = left_mirror && right_mirror && (a.data == b.data);
		return both_mirror;
	}

	private boolean isSymetric(TreeNode node) {
		return areMirror(node.left, node.right);
	}

	public static void main(String[] args) {

		SymetricTree tree = new SymetricTree();
		/*
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node_3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node_4 = new TreeNode(4);
		node.left = node2;
		node.right = node_2;
		node2.left = node3;
		node2.right = node4;
		node_2.left = node_4;
		node_2.right = node_3;
		*/
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node_3 = new TreeNode(3);
		node.left=node2;
		node.right=node_2;
		node2.right=node3;
		node_2.right=node_3;

		boolean result = tree.isSymetric(node);
		if (result) {
			System.out.println("The tree is Symetric");
		} else {
			System.out.println("The tree is NOT Symetric");
		}

	}
}

/*
 	 1
   /   \
  2     2
 / \   / \
3   4 4   3


    1
   / \
  2   2
   \   \
   3    3





*/