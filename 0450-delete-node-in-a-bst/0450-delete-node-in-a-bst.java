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

    private TreeNode func(TreeNode root){

        if(root.left == null)
            return root.right;

        if(root.right == null)
            return root.left;



        TreeNode lchild = root.left;
        TreeNode node = root.right;

        while(node.left != null){

            node = node.left;
        }

        node.left = lchild;

        return root.right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null)
            return null;

        if(root.val == key)
            return func(root);

        TreeNode node = root;

        while(node != null){

            if(node.val > key){

                if(node.left != null && node.left.val == key){
                    node.left = func(node.left);
                    break;
                }

                else
                    node = node.left;
            }
            
            else{
                if(node.right != null && node.right.val == key){
                    node.right = func(node.right);
                    break;
                }

                else
                    node = node.right;
            }    
        }

        return root;
    }
}