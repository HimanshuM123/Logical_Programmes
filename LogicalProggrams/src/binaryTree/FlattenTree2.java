package binaryTree;

import java.util.Stack;

//Flatten tree to list
public class FlattenTree2 {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private void flatten(TreeNode root) {
		TreeNode prev = null;
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		root.left = node2;
		root.right = node5;
		node2.left = node3;
		node2.right = node4;
		node5.right = node6;
		FlattenTree2 f = new FlattenTree2();
		f.flatten(root);
		  while(root.right!=null)
		  {
		      System.out.print(root.data+"->");
		      root=root.right;
		  }
		System.out.print(root.data);

	}

}

/*

            1
          /  \
         2    5
       /  \    \
       3   4    6
       
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
                

*/