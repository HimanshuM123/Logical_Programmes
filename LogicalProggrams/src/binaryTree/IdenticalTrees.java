package binaryTree;

public class IdenticalTrees {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private static boolean isIdentical(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}

		if (a != null && b != null) {
			boolean flag1 = a.data == b.data;
			boolean flag2 = isIdentical(a.left, b.left);
			boolean flag3 = isIdentical(a.right, b.right);

			return (flag1 && flag2 && flag3);
		}
		return false;
	}
	
	private static boolean isIdentical2(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		
		if (a == null || b == null) {
			return true;
		}

			boolean flag1 = a.data == b.data;
			boolean flag2 = isIdentical(a.left, b.left);
			boolean flag3 = isIdentical(a.right, b.right);

			return (flag1 && flag2 && flag3);
	
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		root.left = node2;
		root.right = node3;
		node2.left = node4;

		TreeNode root_2 = new TreeNode(1);
		TreeNode node2_2 = new TreeNode(2);
		TreeNode node3_2 = new TreeNode(3);
		TreeNode node4_2 = new TreeNode(4);
		root_2.left = node2_2;
		root_2.right = node3_2;
		node2_2.left = node4_2;

		if (isIdentical2(root, root_2)) {
			System.out.println("The trees are identical");
		} else {
			System.out.println("The trees are NOT identical");
		}
	}

}
