package binaryTree;

public class BinaryTreeMirror {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}
	
	private boolean areMirror(TreeNode a, TreeNode b) {
		if(a==null && b==null) {
			return true;
		}
		if(a==null || b==null) {
			return false;
		}
		
		boolean left_mirror = areMirror(a.left,b.right);
		boolean right_mirror = areMirror(a.right,b.left);
		boolean are_mirror = left_mirror && right_mirror && (a.data==b.data);
		
		return are_mirror;
		
	}

	public static void main(String[] args) {

		BinaryTreeMirror bt = new BinaryTreeMirror();
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






