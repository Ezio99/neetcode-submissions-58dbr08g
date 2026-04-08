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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    public TreeNode dfs(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == p || currentNode == q) {
            return currentNode;
        }

        if (p.val > currentNode.val && q.val > currentNode.val) {
            return dfs(currentNode.right, p, q);
        } else if (p.val < currentNode.val && q.val < currentNode.val) {
            return dfs(currentNode.left, p, q);
        }

        return currentNode;
    }
}
