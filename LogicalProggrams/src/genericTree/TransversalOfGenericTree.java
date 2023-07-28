package genericTree;

import java.util.ArrayList;
import java.util.Stack;


public class TransversalOfGenericTree {
	private static class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	private static void transversal(Node node) {
		System.out.println("Pre "+node.data);
		for(Node child: node.children) {
			System.out.println("Edge Pre "+node.data+"--"+child.data);
			transversal( child);
			System.out.println("Edge Post "+node.data+"--"+child.data);
		}
		System.out.println("Post "+node.data);
	}
	
	public static void main(String[] args) {
		int [] arr = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
		Node root=null;
		Stack<Node> st = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==-1) {
				st.pop();
			}else {
				Node t = new Node();
				t.data= arr[i];
				if(st.size() >0) {
					st.peek().children.add(t);
				
				}else {
					root = t;
				}
				st.push(t);
			}
		}
		transversal(root);
		
	}
}
