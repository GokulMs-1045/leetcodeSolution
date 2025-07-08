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

    private TreeNode func(int[] preorder, int bound, int[] ind){

        if(ind[0] == preorder.length || preorder[ind[0]] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[ind[0]++]);

        root.left = func(preorder, root.val, ind);
        root.right = func(preorder, bound, ind);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return func(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}