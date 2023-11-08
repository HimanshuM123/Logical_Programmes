package practice2;

public class BinaryTreeTest {

	private static class TreeNode {

		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}
	
	private static void print(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data+" ");
		print(node.left);
		print(node.right);
	}
	
	private static int size(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int left_size= size(node.left);
		int right_size= size(node.right);
		int size = left_size+ right_size+1;
		return size;
	}
	
	private static int max(TreeNode node) {
		if(node==null) {
			return Integer.MIN_VALUE;
		}
		int left_max = max(node.left);
		int right_max = max(node.right);
		int max_val =  Math.max(Math.max(left_max, right_max), node.data) ;
		return max_val;
	}
	
	private static int min(TreeNode node) {
		if(node==null) {
			return Integer.MAX_VALUE;
		}
		int left_min = min(node.left);
		int right_min = min(node.right);
		int min_val =  Math.min(Math.min(left_min, right_min), node.data) ;
		return min_val;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode node20 = new TreeNode(20);
		TreeNode node30 = new TreeNode(30);
		TreeNode node40 = new TreeNode(40);
		TreeNode node50 = new TreeNode(50);
		TreeNode node60 = new TreeNode(60);
		TreeNode node70 = new TreeNode(70);
		root.left = node20;
		root.right=node30;
		node20.left =node40;
		node20.right=node50;
		node30.left=node60;
		node30.right=node70;
		
		print(root);
		
		int size = size(root);
		System.out.println();
		System.out.println("The size is "+size);
		
		int max = max(root);
		System.out.println();
		System.out.println("The Max value is "+max);
		
		int min = min(root);
		System.out.println("The Min value is "+min);
		
		
	}

}

/*
          10
         /  \
        20   30
       / \   / \
      40  50 60 70

*/