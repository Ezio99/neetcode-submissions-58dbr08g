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
    public List<Integer> postorderTraversal(TreeNode root) {
               if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Boolean> visitedStack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        visitedStack.push(false);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean isVisited = visitedStack.pop();

            if (!isVisited) {
                stack.push(curr);
                visitedStack.push(true);

                if (curr.right != null) {
                    stack.push(curr.right);
                    visitedStack.push(false);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                    visitedStack.push(false);
                }

            } else {
                result.add(curr.val);
            }
        }

        return result;
    }
}