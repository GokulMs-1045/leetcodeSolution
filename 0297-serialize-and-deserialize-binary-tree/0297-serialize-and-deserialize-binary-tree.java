/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null)
                sb.append("#,");

            else{

                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.isEmpty())
            return null;

        if (data.equals("#,"))
            return null;
        
        StringBuilder s = new StringBuilder(data);
        Queue<TreeNode> q = new LinkedList<>();

        String str;
        int cidx = s.indexOf(",");
        str = s.substring(0, cidx);
        s.delete(0, cidx + 1);

        TreeNode root = new TreeNode(Integer.parseInt(str));
        q.offer(root);

        while(!s.isEmpty()){

            TreeNode node = q.poll(); 

            cidx = s.indexOf(",");
            str = s.substring(0, cidx);
            s.delete(0, cidx + 1);

            if(!str.equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(str));
                node.left = left;
                q.offer(left);
            }

            cidx = s.indexOf(",");
            str = s.substring(0, cidx);
            s.delete(0, cidx + 1);

            if(!str.equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(str));
                node.right = right;
                q.offer(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));