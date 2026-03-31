package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

	}
	
	private  void levelOrder(TreeNode node) {
		
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(node);
		
		while(q.size() >0) {
			int count = q.size();
			for(int i=0; i<count;i++) {
				node = q.remove();
				System.out.print(node.data+"  ");
				if(node.left!=null) {
					q.add(node.left);
				}
				if(node.right!=null) {
					q.add(node.right);
				}
			}
			System.out.println();
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
		
		LevelOrderTraversal lo = new LevelOrderTraversal();
		lo.levelOrder(rootNode);
	}
}


/*
40
/    \
20     60
/  \    / \
10   30 50 70

*/
