package leetcode2;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.data = data;
	}
}

public class MergeBinaryTree {

	TreeNode root;

	public static TreeNode mergeTree(TreeNode t1, TreeNode t2) {
		if(t1==null) return t2;
		if(t2==null) return t1;
		t1.data=t1.data+t2.data;
		t1.left = mergeTree(t1.left,t2.left);
		t2.right= mergeTree(t1.right,t2.right);
		return t1;
	}

	public static void main(String[] args) {
		MergeBinaryTree tree1 = new MergeBinaryTree();
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(3);
		tree1.root.right = new TreeNode(2);
		tree1.root.left.left = new TreeNode(5);
		
		
		MergeBinaryTree tree2 = new MergeBinaryTree();
		tree2.root = new TreeNode(2);
		tree2.root.left = new TreeNode(1);
		tree2.root.right = new TreeNode(3);
		tree2.root.left.right = new TreeNode(4);
		tree2.root.right = new TreeNode(7);
		
		mergeTree(tree1.root,tree2.root);
	}

}

/* tree1             tree2
     1                2
   /   \            /    \
  3     2          1      3
/                    \     \
5                     4     7

result
         3
       /   \
       4    5
      / \    \
      5   4   7
*/