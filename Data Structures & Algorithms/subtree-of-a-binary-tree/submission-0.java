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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (checkIfTreeEqual(root, subRoot)) {
                return true;
            }
        }

        boolean leftc = dfs(root.left, subRoot);
        boolean rightc = dfs(root.right, subRoot);

        return leftc || rightc;

    }

    public boolean checkIfTreeEqual(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            if (root == null && subRoot == null) {
                return true;
            }
            return false;
        }

        if (root.val == subRoot.val) {
            return checkIfTreeEqual(root.left, subRoot.left) && checkIfTreeEqual(root.right, subRoot.right);
        }

        return false;
    }
}
