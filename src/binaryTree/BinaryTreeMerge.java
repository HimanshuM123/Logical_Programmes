package binaryTree;

public class BinaryTreeMerge {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private  TreeNode mergeTree(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}

		t1.data = t1.data + t2.data;
		t1.left = mergeTree(t1.left, t2.left);
		t1.right = mergeTree(t1.right, t2.right);
		return t1;

	}

	private static void preorder(TreeNode root) {
		if (root != null) {
			System.out.printf("%d ", root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeMerge bt = new BinaryTreeMerge();
		
		TreeNode a_tree1 = new TreeNode(1);
		TreeNode a_tree2 = new TreeNode(2);
		TreeNode a_tree3 = new TreeNode(3);
		TreeNode a_tree5 = new TreeNode(5);
		a_tree1.left = a_tree3;
		a_tree1.right = a_tree2;
		a_tree3.left = a_tree5;

		TreeNode b_tree1 = new TreeNode(1);
		TreeNode b_tree2 = new TreeNode(2);
		TreeNode b_tree3 = new TreeNode(3);
		TreeNode b_tree4 = new TreeNode(4);
		TreeNode b_tree7 = new TreeNode(7);

		b_tree2.left = b_tree1;
		b_tree2.right = b_tree3;
		b_tree1.right = b_tree4;
		b_tree3.right = b_tree7;
		
		preorder(a_tree1);
		System.out.println();
		preorder(b_tree2);
		System.out.println();
		
		TreeNode t3 = bt. mergeTree(a_tree1,b_tree2);
		preorder(t3);

	}
}

/*
 * 

    1
  /  \
  3   2
  /
 5
 
   2
 /  \
 1   3
 \    \ 
  4    7
 
 result 
      3
     / \
     4  5
    / \  \
    5  4  7



 * 
 * */









