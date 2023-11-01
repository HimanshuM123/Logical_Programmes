package binaryTree;

public class HeightBalanced {
	/*
	 * A height balanced binary tree is a binary tree in which the height of the
	 * left subtree and right subtree of any node does not differ by more than 1 and
	 * both the left and right subtree are also height balanced.
	 */
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}
	
	private boolean isBalanced(TreeNode node) {
		if(node == null) {
			return true;
		}
		int left_height=height(node.left);
		int right_height=height(node.right);
		
		if(Math.abs(left_height-right_height)<=1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		}
		return false;
		
		
	}
	private int height(TreeNode node) {
		if(node ==null) {
			return 0;
		}
		
		return 1+Math.max(height(node.right), height(node.left));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		//node4.right = node5;
		
		HeightBalanced obj = new HeightBalanced();
		boolean result = obj.isBalanced(root);
		System.out.println(result);

	}
}

/*
       1
      / \
      2  3    => False
     /
    4
     \
      5
    
    
*/