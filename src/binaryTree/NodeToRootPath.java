package binaryTree;

import java.util.ArrayList;

public class NodeToRootPath {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	static ArrayList<Integer> path = new ArrayList<>();
	private static boolean find(int data, TreeNode node) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			path.add(node.data);
			return true;
		}
		boolean left = find(data, node.left);
		if (left) {
			path.add(node.data);
			return true;
		}
		boolean right = find(data, node.right);
		if (right) {
			path.add(node.data);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(50);
		TreeNode node25 = new TreeNode(25);
		TreeNode node75 = new TreeNode(75);
		TreeNode node12 = new TreeNode(12);
		TreeNode node37 = new TreeNode(37);
		TreeNode node62 = new TreeNode(62);
		TreeNode node87 = new TreeNode(87);
		TreeNode node30 = new TreeNode(30);
		TreeNode node40 = new TreeNode(40);
		TreeNode node60 = new TreeNode(60);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node25;
		rootNode.right = node75;
		node25.left = node12;
		node25.right = node37;
		node75.left = node62;
		node75.right = node87;
		node37.left = node30;
		node37.right = node40;
		node62.left = node60;
		node62.right = node70;
		
		find(40,rootNode);
		System.out.println(path);

	}

}


/*
        50
       /  \
      25   75
     / \    / \
    12 37  62  87
      / \  / \
     30 40 60 70



*/








