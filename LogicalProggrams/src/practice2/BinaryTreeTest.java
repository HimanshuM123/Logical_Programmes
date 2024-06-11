package practice2;

public class BinaryTreeTest {

	private static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
	}
	
	private static void printTree(TreeNode root) {
		if(root == null) {
			return ;
		}
		System.out.print(root.data+" ");
		printTree(root.left);
		printTree(root.right);
	}
	
	private static int size(TreeNode root) {
		if(root== null) {
			return 0;
		}
		int left_size = size(root.left);
		int right_size = size(root.right);
		return left_size+right_size+1;
		
	}
	
	private static int max(TreeNode root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		int left = max(root.left);
		int right = max(root.right);
		int max1= Math.max(left, right);
		int max = Math.max(max1, root.data);
		
		return max;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		TreeNode tree20 = new TreeNode(20);
		TreeNode tree60 = new TreeNode(60);
		TreeNode tree10 = new TreeNode(10);
		TreeNode tree30 = new TreeNode(30);
		TreeNode tree50 = new TreeNode(50);
		TreeNode tree70 = new TreeNode(70);
		root.left = tree20;
		root.right = tree60;
		tree20.left = tree10;
		tree20.right = tree30;
		tree60.left = tree50;
		tree60.right = tree70;
		printTree(root);
		int size = size(root);
		System.out.println();
		System.out.println("The size is "+size);
		int max = max(root);
		System.out.println("max value is "+max);

	}
}

/*
  40
 /    \
20     60
/  \    / \
10   30 50 70

*/