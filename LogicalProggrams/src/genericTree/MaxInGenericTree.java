package genericTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxInGenericTree {
	
	private static class Node{
		int data;
		List<Node> children = new ArrayList<>();
	}
	
	private static int max(Node node) {
		int max = Integer.MIN_VALUE;
		for(Node child : node.children) {
			int cm= max(child);
			max= Math.max( max,cm);
		}
		max = Math.max(max, node.data);
		System.out.println(max);
		return max;
	}
	
	public static void main(String[] args) {
		int [] arr = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
		Node root = null;
		Stack<Node> st = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==-1) {
				st.pop();
			}else {
				Node t = new Node();
				t.data=arr[i];
				if(st.size()>0) {
					st.peek().children.add(t);
				}else {
					root = t;
				}
				st.push(t);
			}
		}
		System.out.println(max(root));
	}
}
