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
  public boolean isValidBST(TreeNode root) {
        Set<Integer> values = new HashSet<>();
        if (!dfs(root, values)) return false;

        for (int i : values) {
            if (!find(root, i)) return false;
        }

        return true;
    }

    public boolean find(TreeNode node, int val) {
        if (node == null) {
            return false;
        }

        if (node.val == val) return true;
        else if (node.val < val) return find(node.right, val);
        else return find(node.left, val);

    }

    public boolean dfs(TreeNode node, Set<Integer> values) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.val <= node.left.val) {
            return false;
        }
        if (node.right != null && node.val >= node.right.val) {
            return false;
        }

        //Already contains val
        if(!values.add(node.val)) return false;


        return dfs(node.left, values) && dfs(node.right, values);
    }
}
