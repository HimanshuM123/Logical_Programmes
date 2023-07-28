package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class SizeOfGenericTree {
	private static class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	private static int  size (Node node) {
		int s=0;
		for(Node child: node.children) {
			int cs = size(child);
			s = s+cs;
			//System.out.println(child.data);
			//System.out.println("s1 "+s);
		}
		s=s+1;
		System.out.println("s2 "+s);
		
		return s;
	}
	public static void main(String[] args) {
//		int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		int [] arr = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
		Node root= null;
		Stack<Node> st = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==-1) {
				st.pop();
			}else {
				Node t = new Node();
				t.data=arr[i];
				if(st.size() >0) {
					st.peek().children.add(t);
				
				}else {
					root = t;
				}
				st.push(t);
			}
		}
		System.out.println(size(root));
	}
}

/*
 * 
       10
      / | \
     20 30 40
       / \
     50   60
 
 
 * */