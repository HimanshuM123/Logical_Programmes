package practice2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import binaryTree.BinaryTreeMirror;
import binaryTree.BinaryTreeSum;



public class Practice2 {
	
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}
	
	private static void   printTree(TreeNode node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data+" ");
		printTree(node.left);
		printTree(node.right);
		
	}
	
	private static void mirror(TreeNode node) {
		if(node == null) {
			return;
		}
		TreeNode temp;
		mirror(node.left);
		mirror(node.right);
		temp = node.left;
		node.left=node.right;
		node.right=temp;
			
		
	}

	public static void main(String[] args) {
		
		TreeNode a_tree1 = new TreeNode(1);
		TreeNode a_tree2 = new TreeNode(2);
		TreeNode a_tree3 = new TreeNode(3);
		TreeNode a_tree4 = new TreeNode(4);
		TreeNode a_tree5 = new TreeNode(5);

		a_tree1.left = a_tree3;
		a_tree1.right = a_tree2;
		a_tree2.left = a_tree5;
		a_tree2.right = a_tree4;
		
		printTree(a_tree1);
      	mirror(a_tree1);
		System.out.println("");
		System.out.println("The Mirror tree is --");
		printTree(a_tree1);
		
	}

}
