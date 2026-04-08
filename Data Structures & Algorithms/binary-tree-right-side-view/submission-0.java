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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        Queue<TreeNode> newLevel;
        TreeNode curr;
        List<Integer> result = new ArrayList<>();
        level.offer(root);

        while (!level.isEmpty()) {
            newLevel = new LinkedList<>();
            while (level.size() > 1) {
                curr = level.poll();
                if (curr.left != null) {
                    newLevel.offer(curr.left);
                }
                if (curr.right != null) {
                    newLevel.offer(curr.right);
                }
            }
            curr = level.poll();
            result.add(curr.val);
            if (curr.left != null) {
                newLevel.offer(curr.left);
            }
            if (curr.right != null) {
                newLevel.offer(curr.right);
            }
            level = newLevel;
        }


        return result;

    }
}
