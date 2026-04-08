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
  public TreeNode deleteNode(TreeNode root, int key) {
        return findAndDelete(root, key);
    }

    public TreeNode findAndDelete(TreeNode curr, int key) {
        if (key < curr.val && curr.left != null) {
            curr.left = findAndDelete(curr.left, key);
        } else if (key > curr.val && curr.right != null) {
            curr.right = findAndDelete(curr.right, key);
        } else if (curr.val == key) {
            if (curr.right == null) return curr.left;

            if (curr.left == null) return curr.right;

            TreeNode largestLeftNode = findLargestNode(curr.left);

            curr.val = largestLeftNode.val;

            curr.left = findAndDelete(curr.left, largestLeftNode.val);

        }

        return curr;
    }

    public TreeNode findLargestNode(TreeNode curr) {
        if (curr.right != null) {
            return findLargestNode(curr.right);
        }

        return curr;
    }
}