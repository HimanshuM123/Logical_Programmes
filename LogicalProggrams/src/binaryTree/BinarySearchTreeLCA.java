package binaryTree;

public class BinarySearchTreeLCA {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private static int lca(TreeNode root, int v1, int v2) {
		
		if(v1 > root.data && v2 > root.data) {
			return lca(root.right,v1,v2);
		}
		
		if(v1 < root.data && v2 < root.data) {
			return lca(root.left,v1,v2);
		}
		return root.data;
	}
	
	public static void main(String[] args) {
		BinarySearchTreeLCA obj = new BinarySearchTreeLCA();
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		root.left = node1;
		root.right = node3;
		node3.left = node4;
		node3.right = node5;
		node5.right = node6;
		int result = lca(root,4,6);
		System.out.println(result);

	}
}

      /*

        2
       / \
       1  3
         / \
        4   5
             \
              6
*/