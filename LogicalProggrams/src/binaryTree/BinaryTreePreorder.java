package binaryTree;

import java.util.Stack;

public class BinaryTreePreorder {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

	}

	
	
	 private void preorder(TreeNode root) {
	        if(root ==  null) {
	        	return;
	        }
	            System.out.printf("%d ",root.data);
	            preorder(root.left);
	            preorder(root.right);
	       
	    }
	 
	private void preorderIterator(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> st =  new Stack<>();
		st.push(root);
		
		while(!st.isEmpty()) {
			TreeNode node = st.pop();
			System.out.print(node.data+" ");
			if(node.right!= null) {
				st.push(node.right);
			}
			if(node.left!=null) {
				st.push(node.left);
			}
		}

	}

	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;
		
		BinaryTreePreorder bt = new BinaryTreePreorder();
	//	bt.preorderIterator(rootNode);
		System.out.println();
		bt.preorder(rootNode);

	}

}




/*
      40
    /    \
  20     60
 /  \    / \
10   30 50 70

*/


//40 20 10 30 60 50 70 
