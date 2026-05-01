package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LargestValueInRow {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private List<Integer> largestValue(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		helperMethod(root, list, 0);
		return list;
	}

	private void helperMethod(TreeNode root, List<Integer> list, int level) {
		if (root == null) {
			return;
		}
		if (level == list.size()) {
			list.add(root.data);
		} else {
			list.set(level, Math.max(list.get(level), root.data));
		}
		helperMethod(root.left, list, level + 1);
		helperMethod(root.right, list, level + 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node3_1 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);

		root.left = node3;
		root.right = node2;
		node3.left = node5;
		node3.right = node3_1;
		node2.right = node9;

		LargestValueInRow obj = new LargestValueInRow();
		List<Integer> result = obj.largestValue(root);
		System.out.println("The result is " + result);
	}
}

/*
             1
            / \
            3  2
           / \  \
           5  3  9
           The result is [1, 3, 9]

*/