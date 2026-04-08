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

public class Codec {
   List<String> encoded;
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        encoded = new ArrayList<>();
        encodeDfs(root);

        return String.join(",", encoded);
    }

    //Pre order
    public void encodeDfs(TreeNode node) {
        if (node == null) {
            encoded.add("n");
            return;
        }

        encoded.add(String.valueOf(node.val));
        encodeDfs(node.left);
        encodeDfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        index = 0;
        return decodeDfs(tokens);
    }

    public TreeNode decodeDfs(String[] s) {
        if (index >= s.length || s[index].equals("n")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s[index++]));

        node.left = decodeDfs(s);
        node.right = decodeDfs(s);

        return node;
    }

}
