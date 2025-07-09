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

    private int func(TreeNode node, int[]max){

        if(node == null)
            return 0;

        int left = Math.max(0, func(node.left, max));
        int right = Math.max(0, func(node.right, max));

        max[0] = Math.max(max[0], left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        
        int[] max = {Integer.MIN_VALUE};
        func(root, max);

        return max[0];
    }
}