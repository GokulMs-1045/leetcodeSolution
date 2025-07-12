/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode func(TreeNode node, TreeNode p, TreeNode q){

        if(node == null || node == p || node == q)
            return node;

        TreeNode left = func(node.left, p, q);
        TreeNode right = func(node.right, p, q);

        if(left != null && right != null)
            return node;

        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return func(root, p, q);
    }
}