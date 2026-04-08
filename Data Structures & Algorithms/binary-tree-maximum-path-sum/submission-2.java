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
    int maxVal;

    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        dfs(root);
        return maxVal;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            maxVal = Math.max(maxVal, node.val);
            return node.val;
        }

        int maxValLeft = dfs(node.left);
        int maxValRight = dfs(node.right);

        maxVal = Math.max(maxVal, Math.max(node.val, Math.max(node.val + maxValLeft,
                Math.max(node.val + maxValRight, node.val + maxValRight + maxValLeft))));

        return Math.max(node.val, Math.max(node.val + maxValLeft, node.val + maxValRight));
    }
}
