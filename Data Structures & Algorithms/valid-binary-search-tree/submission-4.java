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
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean dfs(TreeNode node, int left, int right) {
        if (node == null) {
            return true;
        }

        if (node.val >= left) {
            return false;
        }
        if (node.val <= right) {
            return false;
        }

        return dfs(node.left, node.val, right) && dfs(node.right, left, node.val);

    }
}
