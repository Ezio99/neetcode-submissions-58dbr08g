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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    continue;
                }
                level.add(curr.val);
                nextQueue.add(curr.left);
                nextQueue.add(curr.right);
            }
            if(!level.isEmpty()){
                result.add(level);
            }
            queue = nextQueue;
        }

        return result;
    }
}
