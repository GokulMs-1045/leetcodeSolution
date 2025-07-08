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

    private int func(TreeNode node){

        if(node == null)
            return 0;

        int left = func(node.left);
        if(left == - 1)
            return - 1;

        int right = func(node.right);
        if(right == - 1)
            return - 1;

        if(Math.abs(left - right) > 1)
            return - 1;

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        int ans = func(root);

        return ans == - 1? false : true;
    }
}