package binaryTree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeftBottomElement {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}

	}
	
	private static int findLeftEle(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		while(!list.isEmpty()) {
			root = list.remove();
			if(root.right!=null) {
				list.add(root.right);
			}
			if(root.left!=null) {
				list.add(root.left);
			}
		}
		return root.data;
		
		
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node5.left = node7;
		findLeftEle(root);
		int element = findLeftEle(root);
		System.out.println("The left most element is "+element);

	}

}

/*
             1
            / \
           2   3
          /   / \
         4   5   6
            /
           7
*/ 