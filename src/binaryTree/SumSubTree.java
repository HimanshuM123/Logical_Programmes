package binaryTree;

public class SumSubTree {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	static class INT {
		int v;

		INT(int a) {
			v = a;
		}
	}

	static boolean sumSubtree(TreeNode root, int sum) {
		INT cur_sum = new INT(0);
		return sumSubtreeUtil(root, cur_sum, sum);
	}

	static boolean sumSubtreeUtil(TreeNode tree, INT cur_sum, int sum) {
// base condition  
		if (tree == null) {
			cur_sum = new INT(0);
			return false;
		}

		INT sum_left = new INT(0);
		INT sum_right = new INT(0);
		boolean isLeftTreeSum = sumSubtreeUtil(tree.left, sum_left, sum);
		boolean isRightTreeSum = sumSubtreeUtil(tree.right, sum_right, sum);
		cur_sum.v = sum_left.v + sum_right.v + tree.data;
		return isLeftTreeSum || isRightTreeSum || (cur_sum.v == sum);
	}
	
	

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node8 = new TreeNode(8);
		node.left = node3;
		node.right = node6;
		node3.left = node5;
		node3.right = node9;
		node6.left = node8;
		 int sum = 17;  
		  
		    if (sumSubtree(node, sum))  
		        System.out.println( "Yes");  
		    else
		        System.out.println( "No"); 
	}

}

/*

				1
			  /  \
             3    6
            / \   /
            5  9  8
{3,5,9} =17

*/