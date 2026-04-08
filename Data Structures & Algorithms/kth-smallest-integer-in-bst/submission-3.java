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

    List<Integer> result;

    public int kthSmallest(TreeNode root, int k) {
        result = new ArrayList<>();
        inOrder(root);
        return result.get(k - 1);
    }


    public void inOrder(TreeNode curr) {
        if (curr == null) return;

        inOrder(curr.left);
        result.add(curr.val);
        inOrder(curr.right);

    }
}
