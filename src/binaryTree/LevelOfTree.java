package binaryTree;

public class LevelOfTree {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private static int getLevelUtil(TreeNode node, int data, int level) {
		if (node == null) {
			return 0;
		}
		if (node.data == data) {
			return level;
		}

		int downLevel = getLevelUtil(node.left, data, level + 1);
		if (downLevel != 0) {
			return downLevel;
		}
		downLevel = getLevelUtil(node.right, data, level + 1);
		return downLevel;
	}

	private static int getLevel(TreeNode node, int data) {
		return getLevelUtil(node, data, 1);
	}

	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);

		node3.left = node2;
		node3.right = node5;
		node2.left = node1;
		node2.right = node4;
		
		for(int i=1 ; i<= 5; i++) {
			int result = getLevel(node3,i);
			if(result!=0) {
				System.out.println("The level of "+i+" is "+result);
			}else {
				System.out.println("The element is NOT resent");
			}
			
		}

	}

}


/*

	   3
	  / \
	 2   5
   /  \
  1    4
  
 The level of 1 is 3
The level of 2 is 2
The level of 3 is 1
The level of 4 is 3
The level of 5 is 2


*/