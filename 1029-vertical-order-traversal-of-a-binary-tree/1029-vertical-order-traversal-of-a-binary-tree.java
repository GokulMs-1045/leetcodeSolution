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

    class Tuple{
        TreeNode node;
        int x;
        int y;

        Tuple(TreeNode node, int x, int y){

            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple tp = q.poll();

            TreeNode node = tp.node;
            int x = tp.x;
            int y = tp.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if(node.left != null)
                q.offer(new Tuple(node.left, x - 1, y + 1));

            
            if(node.right != null)
                q.offer(new Tuple(node.right, x + 1, y + 1));

        }

        for(TreeMap<Integer,PriorityQueue<Integer>> mp : map.values()){

            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> qu : mp.values()){

                while(!qu.isEmpty())
                    temp.add(qu.poll());
            }
            ans.add(temp);
        }

        return ans;
    }
}