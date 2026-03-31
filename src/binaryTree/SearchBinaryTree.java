package binaryTree;

public class SearchBinaryTree {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private void printTree(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printTree(node.left);
		printTree(node.right);
	}

	private TreeNode searchBST(TreeNode node, int val) {
		if (node == null) {
			return null;
		}
		if (node.data == val) {
			return node;
		}
		if (val < node.data) {
			return searchBST(node.left, val);
		} else {
			return searchBST(node.right, val);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		root.left = node2;
		root.right = node7;
		node2.left = node1;
		node2.right = node3;
		SearchBinaryTree obj = new SearchBinaryTree();
		TreeNode result = obj.searchBST(root,node2.data);
		obj.printTree(result);
	}

}


/*
          4
         / \
        2   7
       / \
      1   3

     2
    / \
    1  3

*/