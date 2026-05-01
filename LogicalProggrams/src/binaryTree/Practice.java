package binaryTree;


public class Practice {

	private static class TreeNode {
		int data;
		TreeNode right;
		TreeNode left;

		TreeNode(int data) {
			this.data = data;
		}
	}

	
	private boolean areMirror(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2==null) {
			return true;
		}
		if(node1== null || node2== null) {
			return false;
		}
		
		boolean left_mirror= areMirror(node1.left, node2.right);
		boolean right_mirror = areMirror(node1.right, node2.left);
		
		return (left_mirror && right_mirror && node1.data == node2.data);
	}
	

	public static void main(String[] args) {
		Practice bt = new Practice();
		TreeNode a_tree1 = new TreeNode(1);
		TreeNode a_tree2 = new TreeNode(2);
		TreeNode a_tree3 = new TreeNode(3);
		TreeNode a_tree4 = new TreeNode(4);
		TreeNode a_tree5 = new TreeNode(5);

		a_tree1.left = a_tree3;
		a_tree1.right = a_tree2;
		a_tree2.left = a_tree5;
		a_tree2.right = a_tree4;

		TreeNode b_tree1 = new TreeNode(1);
		TreeNode b_tree2 = new TreeNode(2);
		TreeNode b_tree3 = new TreeNode(3);
		TreeNode b_tree4 = new TreeNode(4);
		TreeNode b_tree5 = new TreeNode(5);

		b_tree1.left = b_tree2;
		b_tree1.right = b_tree3;
		b_tree2.left = b_tree4;
		b_tree2.right = b_tree5;
		
		boolean areMirror = bt.areMirror(a_tree1,b_tree1);
		if(areMirror) {
			System.out.println("The trees are mirror images");
		}else {
			System.out.println("The trees are NOT mirror images");
		}

	}

}


/*

	 1                 
	/ \
	3   2
	   / \
	   5  4

	  1
	 / \
	 2   3
	/ \
	4  5



* */
