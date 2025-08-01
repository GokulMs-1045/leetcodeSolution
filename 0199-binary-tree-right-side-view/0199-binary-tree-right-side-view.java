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

    private List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            List<Integer> temp = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){

                TreeNode node = q.poll();
                temp.add(node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }

            ans.add(temp);
        }

        return ans;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null)
            return ans;

        List<List<Integer>> level = levelOrder(root);

        for(List<Integer> temp : level){

            ans.add(temp.get(temp.size() - 1 ));
        }

        return ans;
    }
}