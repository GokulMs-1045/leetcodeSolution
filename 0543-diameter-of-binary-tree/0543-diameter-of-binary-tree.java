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

    private int func(TreeNode node, int[] maxi){

        if(node == null)
            return 0;

        int left = func(node.left, maxi);
        int right = func(node.right, maxi);

        maxi[0] = Math.max(maxi[0], left + right);

        return 1 + Math.max(left, right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        int[] dia = {0};
        func(root, dia);

        return dia[0];
    }
}