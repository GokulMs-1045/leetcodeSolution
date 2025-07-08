/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class bst{

    public Stack<TreeNode> st;
    public boolean isReverse;

    public bst(TreeNode root, boolean reverse){

        st = new Stack<>();
        isReverse = reverse;
        pushAll(root);
    }

    public void pushAll(TreeNode node){

        while(node != null){
            st.push(node);
            node = isReverse ? node.right : node.left;
        }
    } 

    public int next(){

        TreeNode temp = new TreeNode();
        temp = st.pop();

        if(isReverse)
            pushAll(temp.left);

        else
            pushAll(temp.right);

        return temp.val;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;

        bst l = new bst(root, false); // normal inorder
        bst r = new bst(root, true);  // reverse inorder

        int i = l.next();
        int j = r.next();

        while(i < j){

            if(i + j == k)
                return true;

            else if(i + j < k)

                i = l.next();

            else 
            
                j = r.next();
        }

        return false;
    }
}