package genericTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class HeightOfGenericTree {

	private static class Node{
		int data;
		List<Node> children = new ArrayList<>();
	}
	
	private static int height(Node node) {
		int ht =-1;
		for(Node child: node.children) {
			int ch = height(child);
			ht = Math.max(ch, ht);
		}
		ht +=1;
		return ht;
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
		System.out.println(height(root));
	}
}
