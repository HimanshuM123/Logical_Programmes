package binaryTree;

import java.util.Stack;

//Flatten tree to list
public class FlattenTree {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private TreeNode flatten(TreeNode root) {
		if (root == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode current_node = null;
		while (!stack.isEmpty()) {
			current_node = stack.pop();
			if (current_node.right != null) {
				stack.push(current_node.right);
			}
			if (current_node.left != null) {
				stack.push(current_node.left);
			}
			if (!stack.isEmpty()) {
				current_node.right = stack.peek();

			}

			current_node.left = null;
		}

		return root;

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
		FlattenTree f = new FlattenTree();
		TreeNode result = f.flatten(root);
		System.out.println(result);

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