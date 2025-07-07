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

    private TreeNode func(TreeNode root, TreeNode p, TreeNode q){

        if(root == null)
            return null;

        if(root == p)
            return p;

        if(q == root)
            return q;

        if( p.val < root.val && q.val < root.val)
           return func(root.left, p, q);

        if( p.val > root.val && q.val > root.val)
           return func(root.right, p, q);

        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return func(root, p, q);
    }
}