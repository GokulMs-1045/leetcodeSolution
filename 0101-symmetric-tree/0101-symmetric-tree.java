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

    private boolean func(TreeNode root, TreeNode p, TreeNode q){

        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return func(root, p.left, q.right) && func(root, p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {

        TreeNode p = root;
        TreeNode q = root;
        
        return func(root, p, q);
    }
}