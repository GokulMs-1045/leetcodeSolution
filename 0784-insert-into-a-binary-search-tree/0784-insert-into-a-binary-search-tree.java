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
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
            
        TreeNode node = root;

        while(true){

            if(val < node.val){

                if(node.left == null){
                    TreeNode nnode = new TreeNode(val);
                    node.left = nnode;
                    return root;
                }
                node = node.left;
            }
            else{

                if(node.right == null){
                    TreeNode nnode = new TreeNode(val);
                    node.right = nnode;
                    return root;
                }
                node = node.right;
            }
        }
    }
}