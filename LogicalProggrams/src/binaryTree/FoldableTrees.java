package binaryTree;

public class FoldableTrees {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

	}
	
	private static boolean isFoldable(TreeNode node) {
		boolean res;
		if(node ==null) {
			return true;
		}
		
		mirror(node.left);
		res= isStructSame(node.left,node.right);
		//mirror(node.left);
		return res;
	}
	
	static void  mirror (TreeNode node) {
		if(node == null) {
			return;
		}
		
		TreeNode temp;
		mirror(node.left);
		mirror(node.right);
		temp=node.left;
		node.left = node.right;
		node.right=temp;
		
		
		
	}
	
	private static boolean isStructSame(TreeNode a, TreeNode b) {
		if(a==null && b==null) {
			return true;
		}
		if(a!=null && b!=null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode node7 = new TreeNode(7);
		TreeNode node15 = new TreeNode(15);
		TreeNode node9 = new TreeNode(9);
		TreeNode node11 = new TreeNode(11);
		root.left = node7;
		root.right = node15;
		node7.right = node9;
		node15.left = node11;
		
		  boolean flag = isFoldable(root);
		  if(flag) {
			  System.out.println("The tree is foldable");
		  }else {
			  System.out.println("The tree is NOT foldable");
		  }
		

	}
}



/* 
Given a binary tree, find out if the tree can be folded or not. A tree can be folded if the
 left and right subtrees of the tree are structure-wise mirror images of each other. 
--> foldable
    10
  /     \
 7      15
  \     /
   9  11
   
 --> Not foldable  
   
    10
   /  \
   7   15
  /    /
5   11
*/