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
    private  int left(TreeNode node){

        int height = 0;

        while(node != null){

            height++;
            node = node.left;
        }

        return height;
    }

    private int right(TreeNode node){

        int height = 0;

        while(node != null){

            height++;
            node = node.right;
        }
    return height;
    }

    public int countNodes(TreeNode root) {
        
        if(root == null)
            return 0;

        int lh = left(root);
        int rh = right(root);

        if(lh == rh)
            return (1 << lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}