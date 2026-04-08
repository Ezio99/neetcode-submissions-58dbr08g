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
     public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values, k);

        return values.get(k - 1);
    }

    public void inOrder(TreeNode node, List<Integer> values, int k) {
        if (node == null) {
            return;
        }

        inOrder(node.left, values, k);
        //We are adding smallest to largest
        // Once we reach size k we can return
        if(values.size()==k){
            return;
        }
        values.add(node.val);
        inOrder(node.right, values, k);

    }
}
